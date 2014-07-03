package com.esafenet.dll;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import com.esafenet.tools.JTextAreaTools;


public class DepponFileSafe {

	//解密目录
	private String filePath = "";
		
	//文件记数器
	private int size = 0;
	
	//文件目录记数器
	private int dirSize = 0;
	
	//所有文件数
	private int count = 0;
	
	private final static String key = "GCUI0106CUIY0722";
	
	/**
	 * 构造函数
	 * @param filePath：初始化解密目录
	 */
	public DepponFileSafe(String filePath){
		this.filePath = filePath;
		
	}
	
	public void decryptionFileDir() throws IOException{
		File file = new File(this.filePath);
		if(file.exists()){
			this.disListFiles(file.listFiles());
		}
		
	}
	/**
	 * 递归算法，循环找出所有目录下的文件。
	 * @param files：文件对象数组
	 * @param savefile：保存存的目标地址
	 * @throws IOException 
	 */
	private void disListFiles(File[] files) throws IOException{
	
		for(int i = 0 ; i < files.length ; i++){
			//SVN文件目录则不进行解密扫描
			if(!files[i].getName().contains(".svn")){
				if(files[i].isFile()){
					//如果是文件则进行解密
					this.decryption( files[i]);
					this.count++;
				}else{
					//如果是目录，则在保存的根目录下创建新目录并返回全路径
				//	outSavePath = this.createFileDir(savefile + File.separatorChar + files[i].getName());
					//递归目录，调用本身方法
					this.disListFiles(files[i].listFiles());
					this.dirSize++;
				}
			}
		}
	}
	/**
	 * 文件解密方法：注意，解密前请关闭DLP文档安全软件，否则解密失败。
	 * @param file：需要解密的文件
	 * @return
	 * @throws IOException 
	 */
	private boolean decryption(File file) throws IOException{
		
		// 判断是否为加密文件
		boolean decryptFile = false;
				
		if (NativeClientInterface.isDynamicDecrypt(file.getAbsolutePath())) {
			
			File f = new File(file.getParent() + File.separatorChar + "bak_"+ file.getName());
			
			file.renameTo(f);
			
			// 解密文件
			decryptFile = NativeClientInterface.DecryptFile(f.getAbsolutePath(), file.getAbsolutePath(), key);
			
			f.delete();
			
			this.size++;
			
			JTextAreaTools.getInstance().compareToEnd(this.size + "、" +file.getAbsolutePath() );
			
		}
		return decryptFile;
	}
	/**
	 * 新建目录名，当目录名不存在时创建
	 * @param dirName：目录名称（不包含路径）
	 * @return 返回已创建目录的绝对路径
	 */
	private String createFileDir(String dirName){
		File file = new File(dirName);
		
		if(!file.exists()){//是否是目录
			file.mkdir();//是，则创建
		}
		return file.getPath();
	}
	
	/**
	 * 文件复制--安装好加密软件的复制出来的文档会自动加密
	 * @param initFile：源始文件
	 * @param toFile：目标文件
	 * @throws IOException
	 */
	private void copyFile(String initFile ,String toFile) throws IOException{
		FileInputStream fin = new FileInputStream(new File(initFile));
		java.io.FileOutputStream out = new FileOutputStream(new File(toFile));
		byte[] b=new byte[1024 * 1024];
		
		int c = 0;
		while((c=fin.read(b))!=-1){
			out.write(c);
		}
		fin.close();
		out.flush();
		out.close();
	}
	
	public int getFileSize(){
		return this.size;
	}
	
	public int getDirSize(){
		return this.dirSize;
	}
	
	public int getAllFileCount(){
		
		return this.count;
		
	}
	
	public static void main(String[] args) {
		DepponFileSafe ext = new DepponFileSafe("D:\\FTP\\未解密");
		try {
			ext.decryptionFileDir();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			JTextAreaTools.getInstance().compareToEnd(e.getLocalizedMessage());
		}
	}
		
}
