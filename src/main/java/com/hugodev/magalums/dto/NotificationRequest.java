package com.hugodev.magalums.dto;

import com.hugodev.magalums.entity.Channel;

import java.time.LocalDate;

public record NotificationRequest(LocalDate dateTime, String destination, String message, Channel.Values channel) {
}
