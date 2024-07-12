package com.hugodev.magalums.service;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class SMSService {
    private final String ACCOUNT_SID = System.getenv("TWILIO_ACCOUNT_SID");
    private final String AUTH_TOKEN = System.getenv("TWILIO_AUTH_TOKEN");
    private final String NUMBER_SENDER = System.getenv("TWILIO_NUMBER_SENDER");

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    public void sendSMS(String recipient, String content){
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        Message message = Message.creator(
                        new com.twilio.type.PhoneNumber(recipient),
                        new com.twilio.type.PhoneNumber(NUMBER_SENDER),
                        content)
                .create();


        LOGGER.info("Message sent to: "+ recipient +" content: "+message.getBody());
    }
}
