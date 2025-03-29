package com.user_service.userservice.service;

import java.util.*;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.user_service.userservice.dto.LoginDTO;
import com.user_service.userservice.dto.UserDTO;
import com.user_service.userservice.model.User;
import com.user_service.userservice.model.User.Role;
import com.user_service.userservice.repository.UserRepository;
import com.user_service.userservice.security.JwtUtil;


@Service
public class UserService {
	private final UserRepository userRepository;
	private final JwtUtil jwtUtil;
	private final BCryptPasswordEncoder passwordEncoder= new BCryptPasswordEncoder();
	
	public UserService(UserRepository userRepository, JwtUtil jwtUtil) {
		this.userRepository = userRepository;
		this.jwtUtil = jwtUtil;
	}

	public String loginUser(LoginDTO loginDTO) {
		Optional<User> userOpt = userRepository.findByEmail(loginDTO.getEmail());
		if(userOpt.isPresent() && passwordEncoder.matches(loginDTO.getPassword(),userOpt.get().getPassword())) {
			return jwtUtil.generateToken(loginDTO.getEmail());
		}

	    if (userOpt.isEmpty()) {
	        throw new RuntimeException("User does not exist");
	    }

	    User user = userOpt.get();

	    if (!passwordEncoder.matches(loginDTO.getPassword(), user.getPassword())) {
	        throw new RuntimeException("Invalid email or password");
	    }

	    String token = jwtUtil.generateToken(user.getEmail());
	    
	    return "Login successful! Token: " + token;
	}

	public String registerUser(UserDTO userDTO) {
		if(userRepository.findByEmail(userDTO.getEmail()).isPresent()){
			throw new RuntimeException("Email already in use");
		}
		
		 Role role = (userDTO.getRole() != null) ? userDTO.getRole() : Role.VOTER;
		 
		User user = new User();
		user.setName(userDTO.getName());
		user.setEmail(userDTO.getEmail());
		user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
		user.setRole(role);
		
		userRepository.save(user);
		return "User registered successfully";
	}

}
