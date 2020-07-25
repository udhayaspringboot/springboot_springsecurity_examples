package com.springsecurityjwt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Conditional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springsecurityjwt.model.AuthenticationRequest;
import com.springsecurityjwt.model.AuthenticationResponse;
import com.springsecurityjwt.services.UserDetailServices;
import com.springsecurityjwt.util.Util;

@RestController
public class HomeJwtController {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	Util jwUtil;
	
	@Autowired
	UserDetailServices userDetailServices;
	
	@RequestMapping("/hello")
	public String hello()
	{
		return "hi Admin";
	}

	@RequestMapping(value = "/authenticate",method=RequestMethod.POST)
	
	public ResponseEntity<?> createAuthenticateToken(@RequestBody AuthenticationRequest authenticationRequest)throws Exception
	
	{
		
		try {
		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUserName(), authenticationRequest.getPassword()));
		}catch (BadCredentialsException e) {
			throw new Exception("Username password invalid "+e);
		}
		
		
		UserDetails userDetails = userDetailServices.loadUserByUsername(authenticationRequest.getUserName());
		
		String jwUtilVal = jwUtil.generateToken(userDetails);
		
		
		return new ResponseEntity<>(new AuthenticationResponse(jwUtilVal), HttpStatus.OK);
	}
}
