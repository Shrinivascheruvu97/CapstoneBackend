package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.internet.MimeMessage;

@Service
public class EmailServiceImpl implements EmailService {

	
	@Autowired
    private JavaMailSender javaMailSender;

    @Override
    public void sendOtpVerificationEmail(String recipientEmail, String otp) {

        try {

            MimeMessage message = javaMailSender.createMimeMessage();

            MimeMessageHelper helper = new MimeMessageHelper(message, true);

            helper.setFrom("your_email_address");

            helper.setTo(recipientEmail);

            helper.setSubject("OTP Verification");

            String emailContent = "Your OTP: " + otp;

            helper.setText(emailContent, false);
           
            javaMailSender.send(message);

        }catch (Exception e) {

            // Handle email sending exception
        }
    }    

    @Override
    public void sendRemainderEmail(String recipientEmail, String remainderMessage) {

        try{
        	
            MimeMessage message = javaMailSender.createMimeMessage();

            MimeMessageHelper helper = new MimeMessageHelper(message, true);

            helper.setFrom("your_email_address");

            helper.setTo(recipientEmail);

            helper.setSubject("Reminder");

            helper.setText(remainderMessage, false);

            javaMailSender.send(message);

        	} catch(Exception e) {

            // Handle email sending exception
        }
    }
//    @Override
//    public void sendEmail(String recipientEmail, String subject, String message) {
//    try {
//    	MimeMessage message1 = javaMailSender.createMimeMessage();
//    	MimeMessageHelper helper = new MimeMessageHelper(message1, true);
//    	helper.setFrom("your_email_address");
//    	helper.setTo(recipientEmail);
//    	 helper.setSubject(subject);
//    	 helper.setText(message, false);
//    	 javaMailSender.send(message1);
//    }   catch(Exception e) {
//
//        // Handle email sending exception mail couldnt send 
//    }
//    	
//    	
//    	
//    	
//    }
    
    @Value("${spring.mail.username}")
    private String fromAddress;

    // Rest of the code

    @Override
    public void sendEmail(String recipientEmail, String subject, String message) {
        try {
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);

            // Set the 'from' address from the configured property value
            helper.setFrom(fromAddress);

            helper.setTo(recipientEmail);
            helper.setSubject(subject);
            helper.setText(message, false);

            javaMailSender.send(mimeMessage);
        } catch (Exception e) {
            // Handle email sending exception
        }
    }
//    
//    
//    
    
    
    
    
    
    
    
    
    
}
