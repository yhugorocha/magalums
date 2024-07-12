package com.hugodev.magalums.controller;

import com.hugodev.magalums.dto.NotificationRequest;
import com.hugodev.magalums.dto.NotificationResponse;
import com.hugodev.magalums.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/notification")
public class NotificationController {

    @Autowired
    NotificationService notificationService;

    @PostMapping
    public ResponseEntity<NotificationResponse> createNotification(@RequestBody NotificationRequest notification) {
        return ResponseEntity.accepted().body(this.notificationService.createNotification(notification));
    }

    @GetMapping("/{id}")
    public ResponseEntity<NotificationResponse> getNotificationService(@PathVariable Long id) {
        return this.notificationService.getNotification(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity canceledNotification(@PathVariable Long id){
        this.notificationService.canceledNotification(id);
        return ResponseEntity.accepted().build();
    }
}