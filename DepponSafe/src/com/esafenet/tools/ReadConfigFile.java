package com.esafenet.tools;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Properties;

public class ReadConfigFile {
	
	private static String configFile = "config.cfg";
	
	private static String defaultPath = ".";
	
	private static String key = "PATH";
	
	private static ReadConfigFile rf = null;
	
	public static ReadConfigFile getInstance(){
		
		return (rf == null) ? (rf = new ReadConfigFile()) : rf;
		
	}
	
	private Properties readFile() throws IOException, ClassNotFoundException{
		String tmpdir = System.getProperty("java.io.tmpdir");
		
		File tempFile = new File(tmpdir + File.separatorChar + configFile);
		
		Properties p = new Properties();
		
		if(tempFile.isFile()){
			p.load(new InputStreamReader(new FileInputStream(tempFile),"GBK"));
		}else{
			p.load(Class.forName("com.esafenet.dll.NativeClientInterface").getClass().getResource("/" + configFile).openStream());    
		}

		return p;
		
	}
	
	public String getPathString(){
		try {
			return this.readFile().getProperty(key);
			
		} catch (IOException e) {
			JTextAreaTools.getInstance().compareToEnd(e.toString());
		} catch (ClassNotFoundException e) {
			JTextAreaTools.getInstance().compareToEnd(e.toString());
		} catch(Exception e){
			JTextAreaTools.getInstance().compareToEnd(e.getMessage());
		}
		return this.defaultPath;
	}
	
	public String getDefaultPath(){
		return this.defaultPath;
	}
	
	public void setDefaultPath(String path){
		this.defaultPath = path;
	}
	
	public void saveDefaultPath(String pathStr){
		
		OutputStreamWriter osw = null;
		try {
			
			String tmpdir = System.getProperty("java.io.tmpdir");
			
			File tempFile = new File(tmpdir + File.separatorChar + configFile);
			
			osw = new OutputStreamWriter(new FileOutputStream(tempFile, false),"GBK");
			
			String value = key+"="+pathStr.replace("\\", "\\\\");
			
			osw.write(value, 0, value.length());
			
			osw.flush();
		} catch (IOException e1) {
			JTextAreaTools.getInstance().compareToEnd(e1.toString());
		} finally{
			try {
				osw.close();
			} catch (IOException e) {
				JTextAreaTools.getInstance().compareToEnd(e.toString());
			}
		}
		
	}
	
}
