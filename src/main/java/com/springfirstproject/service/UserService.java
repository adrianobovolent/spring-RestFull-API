package com.springfirstproject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springfirstproject.domain.User;
import com.springfirstproject.repository.UserRepository;
import com.springfirstproject.service.util.HashUtil;

@Service
public class UserService {
	
	@Autowired private UserRepository userRepository;
	
	public User save(User user) {
		
		String hash = HashUtil.getSecureHash(user.getPassword());
		user.setPassword(hash);
		
		User createdUser = userRepository.save(user);
		return createdUser;				
	}
	
	public User update(User user) {
		
		String hash = HashUtil.getSecureHash(user.getPassword());
		user.setPassword(hash);
		
		User updatedUser = userRepository.save(user);
		return updatedUser;
	}
	
	public User getById(Long id) {
		Optional<User> result = userRepository.findById(id);
		return result.get();
	}
	
	public List<User> listAll() {
		List<User> users = userRepository.findAll();
		return users;
	}
	
	public User login(String email, String password) {
		
		String hash = HashUtil.getSecureHash(password);
		
		Optional<User> result = userRepository.login(email, hash);
		return result.get();
	}

}
