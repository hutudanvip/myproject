package com.deppon.mytomcat.server;

import java.io.IOException;
import java.io.InputStream;

public class Request {
	private InputStream input;
	private String uri;
	
	public String getUri() {
		return uri;
	}

	public Request(InputStream input){
		this.input = input;
	}
	
	public void parse() {
		StringBuffer request = new StringBuffer(2048);
		int i;
		byte[] buffer = new byte[2048];
		
		try {
			i= input.read(buffer);
			
		} catch (IOException e) {
			e.printStackTrace();
			i = -1;
		}
		for(int j=0; j<i; j++){
			//必须强制转换为char类型，否则获取的都为数字
			request.append((char)buffer[j]);
		}
		
		System.out.println(request.toString());
		uri = parseUri(request.toString());
		
	}
	/**
	 * 
		 * 作者：刘飞
		 * 功能：解析获取 请求的资源路径  
		 * 		例如：GET /index.html HTTP/1.1主要是获取/index.html，获取第一个空格和第二个空格间的/index.html
		 * 时间：2014-3-27上午11:37:15
		 * param:
		 * return：
	 */
	private String parseUri(String requestString){
		int index1, index2;
		index1 = requestString.indexOf(' ');
		if(index1 != -1) {
			index2 = requestString.indexOf(' ', index1 + 1);
			if(index2 > index1) {
				return requestString.substring(index1 + 1, index2);
			}
		}
		return null;
	}
}
