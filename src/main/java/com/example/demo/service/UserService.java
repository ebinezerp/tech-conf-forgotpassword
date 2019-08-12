package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public User save(User user) {
		try {
			return userRepository.save(user);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public User login(String username, String password) {
		try {
			return userRepository.findByUsernameAndPassword(username, password);

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public User update(User user) {
		try {
			return userRepository.saveAndFlush(user);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public User get(String username) {
		try {
			return userRepository.findByUsername(username);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	public User getByEmail(String email) {
		try {
			return userRepository.findByEmail(email);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
