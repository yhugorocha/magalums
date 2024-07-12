package com.hugodev.magalums.entity;

import com.hugodev.magalums.dto.NotificationRequest;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private LocalDate dateTime;

    private String destination;

    private String message;

    @ManyToOne
    @JoinColumn(name = "channel_id")
    private Channel channel;

    @ManyToOne
    @JoinColumn(name = "status_id")
    private Status status;

    public Notification (NotificationRequest notificationRequest){
        this.dateTime = notificationRequest.dateTime();
        this.destination = notificationRequest.destination();
        this.message = notificationRequest.message();
        this.channel = notificationRequest.channel().toChannel();
        this.status = Status.Values.PENDING.toStatus();
    }

}
