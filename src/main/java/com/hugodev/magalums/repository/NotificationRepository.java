package com.hugodev.magalums.repository;

import com.hugodev.magalums.entity.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
}
