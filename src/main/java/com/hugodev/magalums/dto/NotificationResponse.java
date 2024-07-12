package com.hugodev.magalums.dto;

import com.hugodev.magalums.entity.Channel;
import com.hugodev.magalums.entity.Status;

import java.time.LocalDate;

public record NotificationResponse(Long id, LocalDate dateTime, String destination, String message, Channel channel, Status status) {
}
