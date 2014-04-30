package com.common.hardware;

import java.io.IOException;
import java.util.Scanner;

import com.common.util.string.ConverFromGBKToUTF8;

public class Test {
	public static void main(String[] args) {
		
		long start = System.currentTimeMillis();
		Process process;
		try {
			process = Runtime.getRuntime().exec(
					new String[] { "wmic", "cpu", "get", "ProcessorId" });
			process.getOutputStream().close();
			Scanner sc = new Scanner(process.getInputStream());
			String property = sc.next();
			String serial = sc.next();
			System.out.println(property + ": " + serial);
			
			System.out.println("time:" + (System.currentTimeMillis() - start));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(System.getProperty("user.dir"));
		System.out.println("bit of JVM is "+System.getProperty("sun.arch.data.model"));
		StringBuffer msg = new StringBuffer();
		
		String batchNum = "123";
		boolean isSuccess = false;
		String reason = "单号错误";

		if (batchNum != null && !"".equals(batchNum)) {
			msg.append("11单号错误11");
//			msg.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?> \r\n");
//			msg.append("<sysRefundbillResponse  ");
//			msg.append("xmlns=\"http://www.deppon.com/custom/yq/refund\" ");
//			msg.append(">\r\n");
//			msg.append("<batchNum>" + batchNum + "</batchNum>  \r\n");
//			msg.append("<isSuccess>" + isSuccess + "</isSuccess> \r\n");
//			// 成功时没有原因
//			if (reason != null && !reason.equals("")) {
//				if (reason.length() > 200) {
//					reason.substring(0, 150);
//				}
//				if (!isSuccess) {
//					msg.append("<reason>" + reason + "</reason> \r\n");
//				} else {
//					msg.append("<reason>" + "" + "</reason> \r\n");
//				}
//			} else {
//				msg.append("<reason>" + "" + "</reason> \r\n");
//			}
//			msg.append("</sysRefundbillResponse>");
		}
		// 将字符串转换成编码转换成utf8
//		logger.error(msg.toString());
		System.out.println("msg:" + msg.toString());
		String msgStr = ConverFromGBKToUTF8.getUTF8Str(msg.toString());
//		return msgStr;
		
		System.out.println("msgStr"  + msgStr.toString());
	}
}
