package com.springsecurityjdbc.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	
	
	@RequestMapping("/home")
	public String home()
	{
		return "Hi Home";
	}
	
	@RequestMapping("/")
	public String homed()
	{
		return "Hi Home";
	}
	
	@RequestMapping("/user")
	public String usesr()
	{
		return "Hi user";
	}
	@RequestMapping("/admin")
	public String admin()
	{
		return "Hi admin";
	}

}
