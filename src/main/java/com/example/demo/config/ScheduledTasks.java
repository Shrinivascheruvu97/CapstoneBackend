package com.example.demo.config;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import com.example.demo.entity.Accounts;
import com.example.demo.entity.Members;
import com.example.demo.repositroy.AccountsRepository;
import com.example.demo.service.AccountsService;
import com.example.demo.service.EmailService;

@Configuration
@EnableScheduling
public class ScheduledTasks {
	
	 @Autowired
	  private AccountsService accountsService;
	 @Autowired
     EmailService mailService;
	 @Autowired
	 AccountsRepository accountsRepository;
	  
	  @Scheduled(cron = "0 21 15 11 * ?") 
	  public void addBillsToAccountsJob() {
	    accountsService.addBillsToAccounts();
	  }
	  
	  
//	  @Scheduled(cron = "0 50 18 10 * ?")
//	  public void addUnPaidToRemainders1()
//	  {
//		  accountsService.addUnPaidToRemainders();
//	  }
	  
	  
	 

	    

	  
	  

}
