package com.example.demo.config;

import com.example.demo.dto.RemaindersDto;
import com.example.demo.entity.Accounts;
import com.example.demo.entity.Members;
import com.example.demo.entity.Remainders;
import com.example.demo.repositroy.AccountsRepository;
import com.example.demo.repositroy.RemaindersRepository;
import com.example.demo.service.EmailService;
import com.example.demo.service.RemaindersService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Component
@EnableScheduling
public class AccountRemainderScheduler {

	
	@Autowired
     AccountsRepository accountsRepository;
	@Autowired
      EmailService emailService;
	@Autowired
	RemaindersRepository remaindersRepository;
	@Autowired
	RemaindersService remaindersService;

    @Autowired
    public AccountRemainderScheduler(AccountsRepository accountsRepository, EmailService mailService) {
        this.accountsRepository = accountsRepository;
        this.emailService = emailService;
    }
    

//    @Scheduled(cron = "0 49 17 10 * ?") // Execute on the 10th of every month
//    public void sendAccountReminders() {
//        LocalDate currentDate = LocalDate.now();
//
//        List<Accounts> unpaidAccounts = accountsRepository.findUnpaidAccounts();
//
//        for (Accounts account : unpaidAccounts) {
//            Remainders reminder = new Remainders();
//            reminder.setTitle("Bill Due");
//            reminder.setDescription("Maintenance and water bill of this month is not paid yet");
//            //reminder.setMembers(account.getMembers());
//            Members member = account.getMembers();
//            reminder.setMembers(member);
//
//            remaindersRepository.save(reminder);
//        }
//    }
    
    
//    @Scheduled(cron = "0 29 18 10 * ?") // Execute on the 10th of every month
//    public void sendAccountReminders() {
//        LocalDate currentDate = LocalDate.now();
//
//        List<Accounts> unpaidAccounts = accountsRepository.findUnpaidAccounts();
//
//        for (Accounts account : unpaidAccounts) {
//            RemaindersDto remainderDto = new RemaindersDto();
//            remainderDto.setTitle("Bill Due");
//            remainderDto.setDescription("Maintenance and water bill of this month is not paid yet");
//            remainderDto.setUserId(account.getMembers().getUserId());
//
//            remaindersService.saveReminder(remainderDto);
//        }
//        System.out.println("updation done");
//    }

    
    @Scheduled(cron = "0 40 16 11 * ?") // Triggered at 12:00 AM on the 11th day of each month
    public void sendReminderEmails() {
        LocalDate today = LocalDate.now();
        int currentMonth = today.getMonthValue();
        int currentYear = today.getYear();
        LocalDate dueDate = today.plusDays(5); // Assuming due date is 15th of the month

        List<Accounts> accounts = accountsRepository.findByStatusNull();
        for (Accounts account : accounts) {
            // Prepare the email content
            String recipient = account.getMembers().getEmail();
            String subject = "Reminder: Your bill is due";
            String body = //"Dear member,\n\n"
            		"Dear " +account. getMembers().getFirstName() + " " + account. getMembers().getLastName() + ",\n\n"
                    + "Your bill for the month of " + Month.of(currentMonth) + " " + currentYear + " is due.\n"
                    + "Please make the payment by.\n\n"
                    + dueDate.format(DateTimeFormatter.ofPattern("dd MMMM")) + ".\n\n"
                    + "Thank you.";

            // Send the email
            emailService.sendEmail(recipient, subject, body);
        }
    }
    
    
}

