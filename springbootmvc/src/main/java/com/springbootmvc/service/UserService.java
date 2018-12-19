package com.springbootmvc.service;

import org.springframework.stereotype.Service;

import com.springbootmvc.repository.RoleRepository;
import com.springbootmvc.repository.UserRepository;

import java.util.Arrays;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.springbootmvc.login.model.*;

@Service("userService")
public class UserService {


	private UserRepository userRepository;	
	private RoleRepository roleRepository;
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	public UserService(UserRepository userRepository,RoleRepository roleRepository,BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.userRepository = userRepository;
		this.roleRepository = roleRepository;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}
	
	public User findUserByEmail(String email) {
		return userRepository.findByEmail(email);
	}
	
	public User addUser(User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		user.setActive(1);
		Role userRole = roleRepository.findByRole("ADMIN");
		user.setRole(new HashSet<Role>(Arrays.asList(userRole)));
		return userRepository.save(user);
	}
	
}
