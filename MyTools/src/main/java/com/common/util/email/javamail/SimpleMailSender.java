package com.common.util.email.javamail;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.mail.Address;
import javax.mail.BodyPart;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.NoSuchProviderException;
import javax.mail.Part;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;
import javax.mail.search.AndTerm;
import javax.mail.search.ComparisonTerm;
import javax.mail.search.FromStringTerm;
import javax.mail.search.ReceivedDateTerm;
import javax.mail.search.SearchTerm;
import javax.mail.search.SubjectTerm;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** */
/**
 * 简单邮件（不带附件的邮件）发送器
 */
public class SimpleMailSender {

	// 日志记录
	private static Logger logger = LoggerFactory
			.getLogger(SimpleMailSender.class);

	/**
	 * 
	 * 功能描述：实现简单的邮件发送，不含附件
	 * 
	 * @author afei
	 * @date 2013-8-19 下午4:49:00
	 * @param mailInfo
	 * @return boolean 返回true表示发送成功，false表示发送失败
	 * @see
	 */
	public boolean sendTextMail(MailSenderInfo mailInfo) {
		// 判断是否需要身份认证
		MyAuthenticator authenticator = null;
		Properties pro = mailInfo.getProperties();
		if (mailInfo.isValidate()) {
			// 如果需要身份认证，则创建一个密码验证器
			authenticator = new MyAuthenticator(mailInfo.getUserName(),
					mailInfo.getPassword());
		}
		// 根据邮件会话属性和密码验证器构造一个发送邮件的session
		Session sendMailSession = Session
				.getDefaultInstance(pro, authenticator);
		try {
			// 根据session创建一个邮件消息
			Message mailMessage = new MimeMessage(sendMailSession);
			// 创建邮件发送者地址
			Address from = new InternetAddress(mailInfo.getFromAddress());
			// 设置邮件消息的发送者
			mailMessage.setFrom(from);
			// 创建邮件的接收者地址，并设置到邮件消息中
			Address to = new InternetAddress(mailInfo.getToAddress());
			mailMessage.setRecipient(Message.RecipientType.TO, to);
			// 设置邮件消息的主题
			mailMessage.setSubject(mailInfo.getSubject());
			// 设置邮件消息发送的时间
			mailMessage.setSentDate(new Date());
			// 设置邮件消息的主要内容
			String mailContent = mailInfo.getContent();
			mailMessage.setText(mailContent);

			logger.info("开始发送邮件！", new Date());

			// 发送邮件
			Transport.send(mailMessage);

			logger.info("邮件发送结束！", new Date());
			return true;
		} catch (MessagingException ex) {
			ex.printStackTrace();
			logger.error("邮件发送异常:{}", ex);
		}
		return false;
	}

	/** */
	/**
	 * 以HTML格式发送邮件
	 * 
	 * @param mailInfo
	 *            待发送的邮件信息
	 */
	public static boolean sendHtmlMail(MailSenderInfo mailInfo) {
		// 判断是否需要身份认证
		MyAuthenticator authenticator = null;
		Properties pro = mailInfo.getProperties();
		// 如果需要身份认证，则创建一个密码验证器
		if (mailInfo.isValidate()) {
			authenticator = new MyAuthenticator(mailInfo.getUserName(),
					mailInfo.getPassword());
		}
		// 根据邮件会话属性和密码验证器构造一个发送邮件的session
		Session sendMailSession = Session
				.getDefaultInstance(pro, authenticator);
		try {
			// 根据session创建一个邮件消息
			Message mailMessage = new MimeMessage(sendMailSession);
			// 创建邮件发送者地址
			Address from = new InternetAddress(mailInfo.getFromAddress());
			// 设置邮件消息的发送者
			mailMessage.setFrom(from);
			// 创建邮件的接收者地址，并设置到邮件消息中
			Address to = new InternetAddress(mailInfo.getToAddress());
			// Message.RecipientType.TO属性表示接收者的类型为TO
			mailMessage.setRecipient(Message.RecipientType.TO, to);
			// 设置邮件消息的主题
			mailMessage.setSubject(mailInfo.getSubject());
			// 设置邮件消息发送的时间
			mailMessage.setSentDate(new Date());
			// MiniMultipart类是一个容器类，包含MimeBodyPart类型的对象
			Multipart mainPart = new MimeMultipart();
			// 创建一个包含HTML内容的MimeBodyPart
			BodyPart html = new MimeBodyPart();
			// 设置HTML内容
			html.setContent(mailInfo.getContent(), "text/html; charset=utf-8");
			mainPart.addBodyPart(html);
			// 将MiniMultipart对象设置为邮件内容
			mailMessage.setContent(mainPart);
			// 发送邮件
			Transport.send(mailMessage);
			return true;
		} catch (MessagingException ex) {
			ex.printStackTrace();
		}
		return false;
	}
	
	/**
	 * 
	* 功能：获取邮件内容
	* 作者：afei
	* 时间：2014-3-28下午8:11:14
	* 参数：
	*返回值：
	*
	 */
	public void getMailContex() {
		Properties props = new Properties();
		//存储接收邮件服务器使用的协议，这里以POP3为例
		props.setProperty("mail.store.protocol", "pop3");
		//设置接收邮件服务器的地址，这里还是以网易126为例
		props.setProperty("mail.pop3.host", "pop3.126.com");
		
		InputStream input = null;
		try {
			//根据属性新建一个邮件会话.
			Session session=Session.getInstance(props);
			//从会话对象中获得POP3协议的Store对象
			Store store = session.getStore("pop3");
			//如果需要查看接收邮件的详细信息，需要设置Debug标志
			session.setDebug(false);
			
			//连接邮件服务器
			store.connect("pop3.126.com", "hutudanvip@126.com", "qq86048800");
			
			//获取邮件服务器的收件箱
			Folder folder = store.getFolder("INBOX");
			//以只读权限打开收件箱
			folder.open(Folder.READ_ONLY);
			
			//创建搜索条件
			SearchTerm[] sts = new SearchTerm[1];
			int index = 0;
			//发件人
//			sts[index++] = new FromStringTerm("hutudanvip@126.com");
			//邮件收件时间
//			sts[index++] = new ReceivedDateTerm(ComparisonTerm.EQ,new Date());
			//邮件主题
			sts[index++] = new SubjectTerm("aaaa");
			
			SearchTerm st = new AndTerm(sts);
			//搜索邮件
			Message [] msgs = folder.search(st);
			
			//判断获取的邮件是否为空
			if(msgs != null && msgs.length > 0) {
				for(int i=0; i<msgs.length; i++) {
					Message msg = msgs[i];
					
					//解析邮件
					this.mailReceiver(msg);
					//获取邮件类型，是否有附件或者仅是文本邮件
					//判断邮件是否含有附件
//					if(msg.getContentType().startsWith("multipart/")) {
////					if("multipart/mixed".equals(msg.getContentType())) {
//						Multipart mp = (Multipart)msg.getContent();
//						for(int n=0; n<mp.getCount(); n++) {
//							BodyPart part = mp.getBodyPart(n);
//							//解析邮件内容
//							this.rePart(part);
//							String disposition = part.getDisposition();
//							
//							//判断获取的是否为附件， 是附件则将附件保存出来
//							if(disposition != null && disposition.equals(Part.ATTACHMENT)) {
//								//获取文件名称
//								String fileName = MimeUtility.decodeText(part.getFileName());
//								System.out.println(fileName);
//								DataHandler dh = part.getDataHandler();
//								input = dh.getInputStream();
//								//获取附件内容
//								this.saveFile(part.getFileName(), input);
//							} else {
//								System.out.println("该部分不是附件部分！");
//							}
//						}
//					} else {
//						System.out.println("获取的邮件未含附件！");
//					}
				}
			}
			
		/*	//获取收件箱中的邮件，也可以使用getMessage(int 邮件的编号)来获取具体某一封邮件
			Message message[] = folder.getMessages();
			for (int i=0, n=message.length; i<n; i++) {  
			       //获取邮件具体信息
			}*/
			//关闭 Folder 会真正删除邮件, false 不删除   
			folder.close(false);
			//关闭 store, 断开网络连接
			store.close();
		} catch (NoSuchProviderException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			System.out.println("连接邮件服务器异常！");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("邮件转换成Multipart类型失败");
			e.printStackTrace();
		} finally {
			if(input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	/**
	 * 
		 * 作者：afei
		 * 功能：解析邮件内容
		 * 时间：2014-3-31上午11:10:26
		 * param:
		 * return：
	 * @throws MessagingException 
	 * @throws IOException 
	 */
	private void rePart(Part part) throws MessagingException, IOException {
		//判断获取的是否为附件， 是附件则将附件保存出来
		if(part.getDisposition() != null) {
			//获取附件名称 MimeUtility.decodeText解决附件名乱码问题
			String fileName = MimeUtility.decodeText(part.getFileName());
			String savePath = "D:\\" + fileName;
			
			System.out.println("发现附件:" + fileName);
			System.out.println("附件类型:" + part.getContentType());
			System.out.println("附件内容:" + part.getContent());
			
			//打开附件输入流
			InputStream input = part.getInputStream();
			//读取附件字节并存储到文件中
			FileOutputStream fos = new FileOutputStream(savePath);
			int data;
			while((data = input.read()) != -1) {
				fos.write(data);
			}
			
			fos.flush();
			input.close();
			fos.close();
		} else {
			//判断是否为简单文本类型
			if(part.getContentType().startsWith("text/plain")) {
				System.out.println("文本内容为：" + part.getContent());
			} else {
				System.out.println("html内容为：" + part.getContent());
			}
		}
	}
	/**
		 * 作者：afei
		 * 功能：解析邮件对象
		 * 时间：2014-3-31上午11:39:49
		 * param:
		 * return：
	 * @throws MessagingException 
	 * @throws IOException 
	 */
	private void mailReceiver(Message msg) throws MessagingException, IOException {
		//获取发件人信息
		Address[] froms = msg.getFrom();
		
		if(froms != null) {
			InternetAddress addr = (InternetAddress) froms[0];
			System.out.println("发件人地址：" + addr.getAddress());
			System.out.println("发件人显示名：" + addr.getPersonal());
		}
		System.out.println("邮件主题：" + msg.getSubject());
		
		//getContent() 是获取包裹内容, Part相当于外包装
		Object o = msg.getContent();
		
		//是否为Multipart类型，如果是还需要继续拆分
		if(o instanceof Multipart) {
			Multipart multipart = (Multipart) o;
			//继续拆分邮件大包裹
			this.reMultipart(multipart);
		} 
		//是否为Part类型，如果是则不需要拆分
		else if(o instanceof Part) {
			Part part = (Part) o;
			this.rePart(part);
		} 
		//简单的文本类型邮件
		else {
			System.out.println("邮件类型：" + msg.getContentType());
			System.out.println("邮件内容：" + msg.getContent());
		}
	}
	
	/**
		 * 作者：afei
		 * 功能：解析邮件大包裹
		 * 时间：2014-3-31上午11:56:20
		 * param:
		 * return：
	 * @throws MessagingException 
	 * @throws IOException 
	 */
	private void reMultipart(Multipart multipart) throws MessagingException, IOException {
		System.out.println("邮件共有" + multipart.getCount() + "部分组成");
		for(int i=0, n = multipart.getCount(); i<n; i++) {
			/*
			 * 解包, 取出 MultiPart的各个部分, 每部分可能是邮件内容,   
             * 也可能是另一个小包裹(MultipPart)   
             * 判断此包裹内容是不是一个小包裹, 一般这一部分是 正文 Content-Type: multipart/alternative   
			 */
			Part part = multipart.getBodyPart(i);
			if(part instanceof Multipart) {
				// 转成小包裹
				Multipart p = (Multipart) part.getContent();
				//迭代拆分
				this.reMultipart(p);
			} else {
				this.rePart(part);
			}

		}
	}
	/**
	* 功能：保存成文件
	* 作者：afei
	* 时间：2014-3-28下午10:22:19
	* 参数：
	*返回值：
	 */
	private void saveFile(String fileName, InputStream input) {
		FileOutputStream fos = null;
		byte[] bytes = new byte[20480];
		StringBuffer sb = new StringBuffer();
		try {
			int i = input.read(bytes);
			//文件保存路径
			String filePath = "D:\\" + fileName;
			System.out.println(filePath);
			fos = new FileOutputStream(filePath);
			fos.write(bytes);
			//清空文件输出流
			fos.flush();
			
			System.out.println("下载完成！");
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(input != null) {
					//关闭输入流
					input.close();
				}
				if(fos != null) {
					fos.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
