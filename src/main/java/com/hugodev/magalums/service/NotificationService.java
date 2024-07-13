package com.hugodev.magalums.service;

import com.hugodev.magalums.dto.NotificationRequest;
import com.hugodev.magalums.dto.NotificationResponse;
import com.hugodev.magalums.entity.Notification;
import com.hugodev.magalums.entity.Status;
import com.hugodev.magalums.repository.NotificationRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

@Service
public class NotificationService {

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Autowired
    NotificationRepository notificationRepository;

    @Autowired
    TwilioService twilioService;

    public NotificationResponse createNotification(NotificationRequest notification){
       Notification newNotification = this.notificationRepository.save(new Notification(notification));
       return new NotificationResponse(newNotification.getId(), newNotification.getDateTime(), newNotification.getDestination(), newNotification.getMessage(), newNotification.getChannel(), newNotification.getStatus());
    }

    public Optional<NotificationResponse> getNotification(Long id) {
        return this.notificationRepository.findById(id).map(n -> new NotificationResponse(n.getId(), n.getDateTime(), n.getDestination(),n.getMessage(), n.getChannel(), n.getStatus()));
    }

    public void canceledNotification(Long id) {
        this.notificationRepository.findById(id).map(n -> {
            n.setStatus(Status.Values.CANCELED.toStatus());
            return this.notificationRepository.save(n);
        });
    }

    public void runningTask(LocalDateTime date) {

        List<Notification> notifications = this.notificationRepository.findByStatusInAndDateTimeBefore(List.of(Status.Values.ERROR.toStatus(), Status.Values.PENDING.toStatus()), date.toLocalDate());
        notifications.forEach(sendNotification());

    }

    private Consumer<Notification> sendNotification(){

        return n -> {
            try {
                switch (n.getChannel().getDescription()) {
                    case "sms":
                        this.twilioService.sendSMS(n.getDestination(), n.getMessage());
                        break;
                    case "email":
                        //TODO Create email send
                        break;
                    case "whatsapp":
                        this.twilioService.sendWPP(n.getDestination(), n.getMessage());
                        break;
                    case "push":
                        //TODO Create push send
                        break;
                }

                n.setStatus(Status.Values.SUCESS.toStatus());
                this.notificationRepository.save(n);

            }catch (Exception e){
                LOGGER.info("ERROR: "+ e.getMessage());
                n.setStatus(Status.Values.ERROR.toStatus());
                this.notificationRepository.save(n);
            }
        };
    }
}
