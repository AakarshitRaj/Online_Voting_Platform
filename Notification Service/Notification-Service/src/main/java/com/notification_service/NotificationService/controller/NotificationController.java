package com.notification_service.NotificationService.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NotificationController {

	@GetMapping("/health")
	public String checkService(){
		return "Notification Service is running!";
	}
	
}
