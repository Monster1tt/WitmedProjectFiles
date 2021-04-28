package com.wler.witmed.util.message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.internet.MimeMessage;

@Component("mailUtil")
public class MailUtil {
	@Autowired
	private JavaMailSender mailSender;

	public void sendMail() throws Exception {
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		mailMessage.setFrom("Monster1tt@163.com");
		mailMessage.setTo("mufengwz@163.com");
		mailMessage.setSubject("论下雨后穿外套的重要性");
		mailMessage.setText("<h1>下雨后穿外套才不会冷</h1>");
		mailSender.send(mailMessage);
	}

	public void sendMailA() throws Exception {
		MimeMessage mailMessage = mailSender.createMimeMessage();
		MimeMessageHelper messageHelper = new MimeMessageHelper(mailMessage, true);
		messageHelper.setFrom("Monster1tt@163.com");
		messageHelper.setTo("whackon_registry@163.com");
		messageHelper.setSubject("什么是快乐星球，我现在就带你研究！");
		messageHelper.setText("<h1>giao！</h1>", true);
		mailSender.send(mailMessage);

	}
}
