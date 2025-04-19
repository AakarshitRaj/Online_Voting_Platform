package com.notification_service.NotificationService.kafka;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.notification_service.NotificationService.model.Notification;

import org.springframework.kafka.annotation.KafkaListener;
@Component
public class NotificationConsumer {

	@KafkaListener(topics="vote-topic",groupId="notification-group")
	public void consume(String message) {
		try {
            ObjectMapper mapper = new ObjectMapper();
            Notification notification = mapper.readValue(message, Notification.class);
            System.out.println("Notification Received: " + notification.getMessage() + " for " + notification.getRecipient());
        } catch (Exception e) {
            System.err.println("Error processing message: " + e.getMessage());
        }
	}
}
