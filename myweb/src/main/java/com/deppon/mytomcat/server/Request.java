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
			//����ǿ��ת��Ϊchar���ͣ������ȡ�Ķ�Ϊ����
			request.append((char)buffer[j]);
		}
		
		System.out.println(request.toString());
		uri = parseUri(request.toString());
		
	}
	/**
	 * 
		 * ���ߣ�����
		 * ���ܣ�������ȡ �������Դ·��  
		 * 		���磺GET /index.html HTTP/1.1��Ҫ�ǻ�ȡ/index.html����ȡ��һ���ո�͵ڶ����ո���/index.html
		 * ʱ�䣺2014-3-27����11:37:15
		 * param:
		 * return��
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
