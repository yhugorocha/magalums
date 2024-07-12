package com.hugodev.magalums.scheduler;

import com.hugodev.magalums.service.NotificationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

@Component
public class MagaluTaskScheduler {

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Autowired
    NotificationService notificationService;

    @Scheduled(fixedDelay = 1, timeUnit = TimeUnit.MINUTES)
    public void checkTask(){
        var dateTime = LocalDateTime.now();
        LOGGER.info("Running at {}", dateTime);

        this.notificationService.runningTask(dateTime);
    }
}
