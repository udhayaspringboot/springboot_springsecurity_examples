package com.springsecurityjwt.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.springsecurityjwt.filter.JwtFilter;
import com.springsecurityjwt.services.UserDetailServices;

@EnableWebSecurity
public class SpringConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	UserDetailServices userDetailServices;
	
	@Autowired
	
	JwtFilter jwtRequestFilter;
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	auth.userDetailsService(userDetailServices);
	}
	
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	
	  @Override protected void configure(HttpSecurity http) throws Exception {
	  http.csrf().disable()
	  .authorizeRequests().antMatchers("/authenticate").permitAll().
	  anyRequest().authenticated().and().
	sessionManagement()
.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class)
; }
	 
	/*
	 * @Override protected void configure(HttpSecurity httpSecurity) throws
	 * Exception { httpSecurity.csrf().disable()
	 * .authorizeRequests().antMatchers("/authenticate").permitAll().
	 * anyRequest().authenticated().and().
	 * exceptionHandling().and().sessionManagement()
	 * .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	 * httpSecurity.addFilterBefore(jwtRequestFilter,
	 * UsernamePasswordAuthenticationFilter.class);
	 * 
	 * }
	 */
	
	@Bean
	public PasswordEncoder passwordEncoder()
	{
		return NoOpPasswordEncoder.getInstance();
	}

}
