package com.douzone.haru.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	
	private static final Logger log = LoggerFactory.getLogger(MainController.class);
	
	@RequestMapping("")
	public String main() {
		System.out.println("push test");
		log.error("시작로그");
		return "index";
	}
}