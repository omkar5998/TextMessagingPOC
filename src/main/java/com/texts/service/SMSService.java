package com.texts.service;

import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import com.texts.mapper.SMS;
import com.twilio.Twilio;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;

import java.net.URI;

@Component
public class SMSService {

	@Value("${twilio.sid}")
	private String ACCOUNT_SID;

	@Value("${twilio.auth.token}")
	private String AUTH_TOKEN;

	@Value("${twilio.phone.number}")
	private String FROM_NUMBER;
	
	@Value("${messaging.service.sid}")
	private String MESSAGING_SERVICE_SID;

	public void send(SMS sms) {
		Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

		Message message = Message
				.creator(new PhoneNumber(sms.getSendTo()), new PhoneNumber(FROM_NUMBER), sms.getMessage()).create();
		System.out.println("here is my id:" + message.getSid());// Unique resource ID created to manage this transaction

	}

	public void receive(MultiValueMap<String, String> smscallback) {
	}

	public void sendSMS(SMS sms) {
		Twilio.init(ACCOUNT_SID, AUTH_TOKEN); 
        Message message = Message.creator( 
                new com.twilio.type.PhoneNumber(sms.getSendTo()),   
                MESSAGING_SERVICE_SID,sms.getMessage())      
            .create(); 
	}
}
