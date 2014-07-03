package com.esafenet.dll;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import com.esafenet.tools.JTextAreaTools;

public class FileExt {
	
	//解密目录
	private String filePath = "";
	
	//保存目录
	private String savePath = "";
	
	//文件记数器
	private int size = 0;
	
	//文件目录记数器
	private int dirSize = 0;
	
	//所有文件数
	private int count = 0;
	
	private final static String key = "GCUI0106CUIY0722";
	
	private static long startTime = System.currentTimeMillis();
	/**
	 * 构造函数
	 * @param filePath：初始化解密目录
	 * @param savePath：初始化保存目录
	 */
	public FileExt(String filePath,String savePath){
		this.filePath = filePath;
		
		this.savePath = savePath;
	}
	
	public void decryptionFileDir() throws IOException{
		File file = new File(this.filePath);
		
		if(file.exists()){
			String firstSavePath = this.createFileDir(this.savePath);
					
			this.disListFiles(file.listFiles(),firstSavePath);
		}
		
	}
	/**
	 * 递归算法，循环找出所有目录下的文件。
	 * @param files：文件对象数组
	 * @param savefile：保存存的目标地址
	 * @throws IOException 
	 */
	private void disListFiles(File[] files,String savefile) throws IOException{
		//创建目录后的全路径
		String outSavePath = null;
				
		for(int i = 0 ; i < files.length ; i++){
			//SVN文件目录则不进行解密扫描
			if(!files[i].getName().contains(".svn")){
				if(files[i].isFile()){
					//如果是文件则进行解密
					this.decryption(files[i].getAbsolutePath(), savefile + File.separatorChar + files[i].getName());
				
					this.count++;
				}else{
					//如果是目录，则在保存的根目录下创建新目录并返回全路径
					outSavePath = this.createFileDir(savefile + File.separatorChar + files[i].getName());
					//递归目录，调用本身方法
					this.disListFiles(files[i].listFiles(), outSavePath);
					outSavePath = null;
					this.dirSize++;
				}
//			}else{
//				if(files[i].isDirectory())files[i].mkdirs();
			}
		}
	}
	/**
	 * 文件解密方法：注意，解密前请关闭DLP文档安全软件，否则解密失败。
	 * @param fileName：需要解密的文件
	 * @param fileType：文件的后缀名
	 * @return
	 * @throws IOException 
	 */
	private boolean decryption(String fileName ,String savefile) throws IOException{
		
		// 判断是否为加密文件
		boolean decryptFile = false;
		
		if (NativeClientInterface.isDynamicDecrypt(fileName)) {
			
			// 解密文件
			decryptFile = NativeClientInterface.DecryptFile(fileName, savefile, key);
			
			this.size++;
			
			JTextAreaTools.getInstance().compareToEnd(this.size + "、" +savefile );
			
		}else{
//			
//			this.copyFile(fileName, savefile);
			
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

}
