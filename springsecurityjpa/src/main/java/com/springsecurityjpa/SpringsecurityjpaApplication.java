package com.springsecurityjpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.springsecurityjpa.dao.UserRepo;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = UserRepo.class)
public class SpringsecurityjpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringsecurityjpaApplication.class, args);
	}

}
