package com.esafenet.dll;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import com.esafenet.tools.JTextAreaTools;

public class NativeClientInterface {
	
	private static final String libName_64 = "CdgControl64";
	
	private static final String libName_32 = "CdgControl";

	static {
		
		try {
			
			String libName = "";
			
			String systemType = System.getProperty("os.name");//操作系统名称
			
			String arch = System.getProperty("os.arch");//操作系统位数
			
			libName =("amd64".equals(arch)) ? libName_64 : libName_32;
			
			String libExtension = (systemType.toLowerCase().indexOf("win")!=-1) ? ".dll" : ".so";
			
			String libFullName = libName + libExtension;
			
			String tmpdir = System.getProperty("java.io.tmpdir");
			InputStream in = Class.forName("com.esafenet.dll.NativeClientInterface").getClass().getResource("/" + libFullName).openStream();
			
			File dll = new File(tmpdir + File.separatorChar + libFullName);
			
	//		File dll = File.createTempFile(libName, libExtension);
			
			if(!dll.isFile()){
				FileOutputStream out = new FileOutputStream(dll);
				int i;
				byte[] buf = new byte[1024];
				while ((i = in.read(buf)) != -1) {
					out.write(buf, 0, i);
				}
				out.flush();
				in.close();
				out.close();
			}
			System.load(dll.getPath());
		} catch (ClassNotFoundException e) {
			JTextAreaTools.getInstance().compareToEnd(e.getMessage());
		} catch (IOException e) {
			JTextAreaTools.getInstance().compareToEnd(e.getMessage());
		} catch (Exception e){
			JTextAreaTools.getInstance().compareToEnd(e.getMessage());
		}
	}
	
	public static native String getCDGFileId(String path);
	
	public static native String getCDGFileVersion(String path);
	
	public static native boolean isDynamicDecrypt(String path);
	
	public static native boolean makeCDG(String srcFile, String destFile,String fileId, String passwd);
	
	public static native boolean removeCDG(String srcFile, String destDir,String passwd);
	
	public static native String buildSerialNumber(String code);
	
	// add by songyan 2009-07-06 解密文件
	public static native boolean DecryptFile(String sourcePath,String targetPath, String cypherKey);
	
	public static native boolean EncryptFile(String sourcePath,String targetPath, String cypherKey);
	// end add by songyan 2009-07-06 解密文件
	
}
