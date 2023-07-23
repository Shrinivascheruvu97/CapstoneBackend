package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Members;
import com.example.demo.repositroy.MembersRepository;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Random;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins="http://localhost:3000/")
public class PasswordResetController {

    @Autowired
    private MembersRepository memberRepository;

    @Autowired
    private JavaMailSender javaMailSender;

    @PostMapping("/reset-password")
    public ResponseEntity<String> resetPassword(@RequestBody Map<String, String> request) {
    	 String email = request.get("email");
        Members member = memberRepository.findByEmail(email);

        if (member == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User with this email not found.");
        }

        // Generate a unique password (you can use a library for this)
        String newPassword = generateUniquePassword();

        // Send an email with the unique password
        sendEmail(email, newPassword);

        // Update the user's password in the database
        member.setPassword(newPassword);
        memberRepository.save(member);

        return ResponseEntity.ok("Password reset successful. Check your email for the new password.");
    }

    // Add more methods here, such as the one to generate a unique password
    // ...

//    private String generateUniquePassword() {
//        // Generate your unique password logic here.
//        // For simplicity, let's generate a random 8-character alphanumeric password.
//
//        int length = 8;
//        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()-_=+[]{}|;:,.<>?";
//        StringBuilder password = new StringBuilder();
//        Random random = new Random();
//
//        while (password.length() < length) {
//            int index = random.nextInt(chars.length());
//            password.append(chars.charAt(index));
//        }
//
//        return password.toString();
//    }
    
    
    
    private String generateUniquePassword() {
        // Generate your unique password logic here.
        // The password should match the specified format:
        // At least one uppercase letter, one digit, and one special character.
        // Minimum length: 8 characters.

        int length = 8;
        String uppercaseChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowercaseChars = "abcdefghijklmnopqrstuvwxyz";
        String digits = "0123456789";
        String specialChars = "!@#$%^&*()-_=+[]{}|;:,.<>?";
        String allChars = uppercaseChars + lowercaseChars + digits + specialChars;
        
        StringBuilder password = new StringBuilder();
        Random random = new Random();

        // Ensure the password contains at least one uppercase letter
        password.append(uppercaseChars.charAt(random.nextInt(uppercaseChars.length())));
        
        // Ensure the password contains at least one digit
        password.append(digits.charAt(random.nextInt(digits.length())));
        
        // Ensure the password contains at least one special character
        password.append(specialChars.charAt(random.nextInt(specialChars.length())));
        
        // Generate the remaining characters to meet the desired length
        while (password.length() < length) {
            int index = random.nextInt(allChars.length());
            password.append(allChars.charAt(index));
        }

        // Shuffle the password characters to make it more random
        List<Character> passwordChars = password.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toList());
        Collections.shuffle(passwordChars, random);
        
        return passwordChars.stream()
                .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
                .toString();
    }


	private void sendEmail(String toEmail, String newPassword) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(toEmail);
        message.setSubject("Password Reset");
        message.setText("Your new password is: " + newPassword);

        javaMailSender.send(message);
    }
}
