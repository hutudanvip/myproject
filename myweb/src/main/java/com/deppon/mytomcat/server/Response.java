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
		 * ���ߣ�����
		 * ���ܣ�������Ӧ��Ϣ
		 * ʱ�䣺2014-3-27����11:36:55
		 * param:
		 * return��
	 */
	public void sendStaticResource() throws IOException {
		byte[] bytes = new byte[BUFFER_SIZE];
		FileInputStream fis = null;
		
		//�����ļ�·����ȡ�ļ�
		File file = new File(HttpServer.WEB_ROOT, request.getUri());
		try {
			//�ж��ļ��Ƿ���ڣ����ȡ�ļ�
			if(file.exists()) {
				fis = new FileInputStream(file);
				
				//�Ӵ��������н���� len ���ֽڵ����ݶ���һ���ֽ�������
				int ch = fis.read(bytes, 0, BUFFER_SIZE);
				

//				int ch = str.length();
				
				//��ȡ��Ӧ�ļ���body�е�����
//				String bodyStr = this.getBody(str);
//				String bodyStr = str;
				
				while(ch != -1) {
					//���ֽ�д��������
//					output.write(bodyStr.getBytes(), 0, bodyStr.length() -1);
					output.write(bytes, 0, ch);
					//�Ӵ��������н���� BUFFER_SIZE ���ֽڵ����ݶ���һ���ֽ�������
					ch = fis.read(bytes, 0, BUFFER_SIZE);
				}
				//ˢ�´��������ǿ��д�����л��������ֽ�
				output.flush();
				System.out.println("----------------------------------------------");
				String str = new String(bytes);
				System.out.println(str);
				System.out.println("----------------------------------------------");
			}
			//���ļ������ڣ�����404
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
		 * ���ߣ�����
		 * ���ܣ���ȡ��Ӧ�е�body����
		 * ʱ�䣺2014-3-27����11:52:19
		 * param:
		 * return��
	 */
	private String getBody(String str){
		int startNum = str.indexOf("<body>")  + 6;
		int endNum = str.indexOf("</body>",  startNum);
		
		String strBody = str.substring(startNum, endNum);
		return strBody;
	}
}
