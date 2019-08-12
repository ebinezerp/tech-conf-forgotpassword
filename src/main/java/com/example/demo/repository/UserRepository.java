package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

	public User findByUsernameAndPassword(String username, String password);

	public User findByEmail(String email);
	
	public User findByUsername(String username);

}
