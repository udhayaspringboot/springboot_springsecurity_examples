package com.springsecurityjpa.userdetails;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.springsecurityjpa.dao.UserRepo;
import com.springsecurityjpa.model.User;
@Service
public class UserDetailsServices implements UserDetailsService {

	
@Autowired
	UserRepo userRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
	Optional<User> user = userRepo.findByUserName(username);
	
	user.orElseThrow(()-> new UsernameNotFoundException("User not found"+username));
	System.out.println("user name "+user.get().getUserName()+"pass word "+user.get().getPassword());
		return user.map(UserDetailss::new).get();
	}

}
