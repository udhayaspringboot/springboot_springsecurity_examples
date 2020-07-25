package com.springsecurityldap.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeLdapController {
	
	
	@RequestMapping("/home")
	public String home()
	{
		return "Hi Home";
	}

}
