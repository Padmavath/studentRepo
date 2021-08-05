package com.student.restcontroller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorld {
	@RequestMapping("helloworld")
	public String getmessage(){
		return "hello world";
	}
}
