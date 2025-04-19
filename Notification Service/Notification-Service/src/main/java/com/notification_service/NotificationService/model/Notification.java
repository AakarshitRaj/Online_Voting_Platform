package com.notification_service.NotificationService.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Notification {
private String message;
private String recipient;
}
