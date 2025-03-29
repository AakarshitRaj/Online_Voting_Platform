package com.user_service.userservice.controller;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import java.util.Collections;

import org.springframework.web.bind.annotation.*;

import com.user_service.userservice.dto.LoginDTO;
import com.user_service.userservice.dto.UserDTO;
import com.user_service.userservice.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/users")

public class UserController {
	private final UserService userService;
	
	public UserController(UserService userService) {
		this.userService=userService;
	}
	
	@PostMapping("/register")
	public String registerUser(@RequestBody @Valid UserDTO userDTO)
	{
		return userService.registerUser(userDTO);
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> loginUser(@RequestBody LoginDTO loginDTO) {
	    try {
	        String token = userService.loginUser(loginDTO);
	        return ResponseEntity.ok(Collections.singletonMap("token", token));
	    } catch (RuntimeException e) {
	        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Collections.singletonMap("error", e.getMessage()));
	    }
	}
}
