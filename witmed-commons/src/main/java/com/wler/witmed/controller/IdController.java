package com.wler.witmed.controller;

import com.wler.witmed.util.IdGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController ("idController")
@RequestMapping("/create")
public class IdController {
	@Autowired
	private IdGenerator idGenerator;
	@GetMapping("/id")
	public String createId()throws Exception{
		return idGenerator.createId();
	}
}
