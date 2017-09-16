/**
 *	Copyright (C) 2014-2015 hst Software. All rights reserved. 
 *
 *	Author: weiwzhou
 *
 *	CreatedAt: 2016年7月14日
 *  
 *	Description: ...
 */
package com.jianan.software.util;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;
public class MailUtil {
	private MimeMessage message;
	private Session session;
	private Transport transport;
	//服务器
	private String mailHost = "";
	//接收者
	private String receiver = "";
	//用户
	private String sender_username = "";
	//password
	private String sender_password = "";
	
	private Properties properties = new Properties();
	/**
	 * 进行初始化
	 * @param debug
	 */
	public MailUtil(boolean debug) {
		InputStream in = MailUtil.class.getResourceAsStream("/mail.properties");
		try {
			properties.load(in);
			//发送邮件的主机
			this.mailHost = properties.getProperty("mail.smtp.host");
			this.sender_username = properties.getProperty("mail.smtp.username");
			this.sender_password = properties.getProperty("mail.smtp.password");
			this.receiver = properties.getProperty("mail.smtp.receiver");
		} catch (IOException e) {
			e.printStackTrace();
		}
		session = Session.getInstance(properties);
		session.setDebug(debug);//开启后有调试信息
		message = new MimeMessage(session);	
	}
	
	/**
	 * 
	 * @param subject
	 * @param sendhtml
	 * @param receiver
	 * @param attachment
	 */
	
	public void doSendMail(String subject,String sendhtml,File attachment) {
	
		try {
			//发件人地址
			InternetAddress from = new InternetAddress(sender_username);
			message.setFrom(from);
			
			//收件人地址
			/*InternetAddress to = new InternetAddress(receiver);
			message.setRecipient(Message.RecipientType.TO, to);*/
			
			message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(receiver));
			
			
			//邮件主题
			message.setSubject(subject);
			
			//向multipart对象中添加各个内容，包括文件的内容和和附件
			Multipart multipart = new MimeMultipart();
			
			//添加邮件正文
			BodyPart contentPart = new MimeBodyPart();
			contentPart.setContent(sendhtml, "text/html; charset=UTF-8");
			multipart.addBodyPart(contentPart);
			
			//添加附件内容
			if(attachment != null) {
				BodyPart attachmentBodyPart = new MimeBodyPart();
				DataSource dataSource = new FileDataSource(attachment);
				attachmentBodyPart.setDataHandler(new DataHandler(dataSource));
				//解决文件名乱码的问题
				attachmentBodyPart.setFileName(MimeUtility.encodeWord(attachment.getName()));
				multipart.addBodyPart(attachmentBodyPart);
			}
			
			//将附件内容添加到message中
			message.setContent(multipart);
			
			//保存邮件
			message.saveChanges();
			transport = session.getTransport("smtp");
			//smtp进行验证，就是用用户名和密码进行验证
			System.out.println(sender_username);
			System.out.println(sender_password);
			transport.connect(mailHost, sender_username, sender_password);
			//发送
			transport.sendMessage(message, message.getAllRecipients());
			System.out.println("发送成功");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(transport != null) {
				try {
					transport.close();
				} catch (MessagingException e) {
					e.printStackTrace();
				}
			}
		}
			
	}	
	
	public static void main(String[] args) {
		MailUtil mailUtil = new MailUtil(true);
		File file = new File("D:\\ceshi.txt");
		mailUtil.doSendMail("邮件主题", "邮件内容", file);
	}
	
	
	
}

