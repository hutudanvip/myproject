package com.common.util.mail;

import com.common.util.email.javamail.MailSenderInfo;
import com.common.util.email.javamail.SimpleMailSender;

public class MailDemo {
	public static void main(String[] args) {
		// 这个类主要是设置邮件
		MailSenderInfo mailInfo = new MailSenderInfo();
		mailInfo.setMailServerHost("smtp.126.com");
		mailInfo.setMailServerPort("25");
		mailInfo.setValidate(true);
		mailInfo.setUserName("hutudanvip@126.com");
		mailInfo.setPassword("qq86048800");// 您的邮箱密码
		mailInfo.setFromAddress("hutudanvip@126.com");
		mailInfo.setToAddress("450156605@qq.com");
		mailInfo.setSubject("JAVAMAIL测试");
		mailInfo.setContent("helloword!");
		// 这个类主要来发送邮件
		SimpleMailSender sms = new SimpleMailSender();
//		sms.sendTextMail(mailInfo);// 发送文体格式
//		sms.sendHtmlMail(mailInfo);// 发送html格式
		sms.getMailContex();
	}
}
