package com.hugodev.magalums.service;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class TwilioService {
    private final String ACCOUNT_SID = System.getenv("TWILIO_ACCOUNT_SID");
    private final String AUTH_TOKEN = System.getenv("TWILIO_AUTH_TOKEN");
    private final String NUMBER_SENDER = System.getenv("TWILIO_NUMBER_SENDER");
    private final String WPP_NUMBER_SENDER = System.getenv("TWILIO_WPP_NUMBER_SENDER");

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    public void sendSMS(String recipient, String content){
        sendToTwilio(recipient, content, NUMBER_SENDER);
    }

    public void sendWPP(String recipient, String content){
        sendToTwilio("whatsapp:"+recipient, content, WPP_NUMBER_SENDER);
    }

    private void sendToTwilio(String recipient, String content, String numberSender){
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        Message message = Message.creator(
                        new com.twilio.type.PhoneNumber(recipient),
                        new com.twilio.type.PhoneNumber(numberSender),
                        content)
                .create();

        LOGGER.info("Message sent to: "+ recipient +" content: "+message.getBody());
        LOGGER.info("Status: "+message.getStatus());
        LOGGER.info("Erro Message: "+message.getErrorMessage());
        LOGGER.info("Get Sid: "+message.getSid());
    }
}
