package com.springsecurityspbexample.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class HomeController {
	
	
	@RequestMapping("/home")
	public String home()
	{
		return "Hi Udhay";
	}
	
	@RequestMapping("/users")
	public String users()
	{
		return "hi User";
		
	}

	
	@RequestMapping("/admin")
	
	public String admin()
	{
		return "Admin";
	}
}
