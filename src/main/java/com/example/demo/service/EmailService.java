package com.example.demo.service;

public interface EmailService {

	void sendOtpVerificationEmail(String recipientEmail, String otp);
    void sendRemainderEmail(String recipientEmail, String remainderMessage);
	void sendEmail(String email, String subject, String message);
}
