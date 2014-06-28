package com.deppon.mytomcat.server;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;

public class Response {
	private static final int BUFFER_SIZE = 2048;
	Request request;
	OutputStream output;
	
	public Response(OutputStream output){
		this.output = output;
	}

	public void setRequest(Request request) {
		this.request = request;
	}
	
	/**
	 * 
		 * 作者：刘飞
		 * 功能：发送响应信息
		 * 时间：2014-3-27上午11:36:55
		 * param:
		 * return：
	 */
	public void sendStaticResource() throws IOException {
		byte[] bytes = new byte[BUFFER_SIZE];
		FileInputStream fis = null;
		
		//根据文件路径获取文件
		File file = new File(HttpServer.WEB_ROOT, request.getUri());
		try {
			//判断文件是否存在，则读取文件
			if(file.exists()) {
				fis = new FileInputStream(file);
				
				//从此输入流中将最多 len 个字节的数据读入一个字节数组中
				int ch = fis.read(bytes, 0, BUFFER_SIZE);
				

//				int ch = str.length();
				
				//获取响应文件中body中的内容
//				String bodyStr = this.getBody(str);
//				String bodyStr = str;
				
				while(ch != -1) {
					//将字节写入此输出流
//					output.write(bodyStr.getBytes(), 0, bodyStr.length() -1);
					output.write(bytes, 0, ch);
					//从此输入流中将最多 BUFFER_SIZE 个字节的数据读入一个字节数组中
					ch = fis.read(bytes, 0, BUFFER_SIZE);
				}
				//刷新此输出流并强制写出所有缓冲的输出字节
				output.flush();
				System.out.println("----------------------------------------------");
				String str = new String(bytes);
				System.out.println(str);
				System.out.println("----------------------------------------------");
			}
			//若文件不存在，返回404
			else {
				String errorMessage = "HTTP/1.1 404 File Not Found\r\n" +
						"Content-Type: text/html\r\n" +
						"Content-Length: 23\r\n" +
						"\r\n" + 
						"<h1>File Not Found</h1>";
				output.write(errorMessage.getBytes());
				output.flush();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			if(fis != null){
				fis.close();
			}
		}
	}
	
	/**
	 * 
		 * 作者：刘飞
		 * 功能：获取响应中的body内容
		 * 时间：2014-3-27上午11:52:19
		 * param:
		 * return：
	 */
	private String getBody(String str){
		int startNum = str.indexOf("<body>")  + 6;
		int endNum = str.indexOf("</body>",  startNum);
		
		String strBody = str.substring(startNum, endNum);
		return strBody;
	}
}
