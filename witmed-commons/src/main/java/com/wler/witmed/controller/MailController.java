package com.wler.witmed.controller;

import com.wler.witmed.util.message.MailUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("mailController")
public class MailController {
	@Autowired
	private MailUtil mailUtil;
	@GetMapping("/send")
	public String sendMail()throws Exception{
		mailUtil.sendMail();
		return "1111111";
	}
	@GetMapping("/send1")
	public String sendMailA()throws Exception{
		mailUtil.sendMailA();
		return "1111211";
	}

}
