package com.springsecurityjpa.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.springsecurityjpa.model.User;

public interface UserRepo extends JpaRepository<User, Integer> {

	
	Optional<User> findByUserName(String username); 
	
}
