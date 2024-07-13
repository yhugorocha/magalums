package com.hugodev.magalums.service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;

@Service
public class EmailService {

    private final String FROM_ADDRES = System.getenv("EMAIL_FROM_ADDRES");

    @Autowired
    private JavaMailSender javaMailSender;

    public void sendEmail(String recipient, String content) throws MessagingException, UnsupportedEncodingException {

        String senderName = "Notification Service";
        String subject = "Notification sending service";

        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);

        helper.setFrom(FROM_ADDRES, senderName);
        helper.setSubject(subject);
        helper.setTo(recipient);
        helper.setText(content, false);

        javaMailSender.send(mimeMessage);
    }
}
