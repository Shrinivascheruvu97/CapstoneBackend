package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.AccountsDto;
import com.example.demo.dto.RemaindersDto;
import com.example.demo.entity.Members;

import com.example.demo.entity.Remainders;
import com.example.demo.service.CommitteeMembersService;
import com.example.demo.service.EmailService;

@RestController
@RequestMapping("/committee")
@CrossOrigin(origins="http://localhost:3000")
public class CommitteeMembersController {

	@Autowired
    private CommitteeMembersService  committeeMembersService;
	
	@Autowired
    private EmailService emailService;

     public CommitteeMembersController(CommitteeMembersService committeeMembersService) {
            this.committeeMembersService = committeeMembersService;
        }

      

        //Remainders
        @GetMapping("/remainders")
        public ResponseEntity<List<RemaindersDto>> getAllRemainders() {
            List<RemaindersDto> remainders = committeeMembersService.getAllRemainders();
            return ResponseEntity.ok(remainders);
        }

        @GetMapping("/remainders/{id}")
        public ResponseEntity<RemaindersDto> getRemainderById(@PathVariable int id) {
            RemaindersDto remainder = committeeMembersService.getRemainderById(id);
            return ResponseEntity.ok(remainder);
        }

        @PostMapping("/remainders/add")
        public ResponseEntity<RemaindersDto> addRemainder(@RequestBody RemaindersDto remainderDto) {
            RemaindersDto addedRemainder = committeeMembersService.addRemainder(remainderDto);
            return new ResponseEntity<>(addedRemainder,HttpStatus.CREATED);
        }

        @PutMapping("/remainders/{id}")
        public ResponseEntity<RemaindersDto> updateRemainder(@PathVariable int id, @RequestBody RemaindersDto remainderDto) {
            RemaindersDto updatedRemainder = committeeMembersService.updateRemainder(id, remainderDto);
            return ResponseEntity.ok(updatedRemainder);
        }

        @DeleteMapping("/remainders/{id}")
        public ResponseEntity<Void> deleteRemainder(@PathVariable int id) {
            committeeMembersService.deleteRemainder(id);
            return ResponseEntity.noContent().build();
        }
        
        //Send Remainders     
        @PostMapping("/sendRemainders")
        public ResponseEntity<String> sendRemainders() {
        	
            // Get the list of remainders from the database
            List<Remainders> remaindersList = committeeMembersService.getAllRemaindersFromRemainders();

            for (Remainders remainder : remaindersList) {

                // Get the user associated with the remainder
                Members members = remainder.getMembers();

                // Get the recipient email
                String recipientEmail = members.getEmail();

                // Generate the remainder message
                String remainderMessage = generateRemainderMessage(remainder);

                // Send the remainder email
                emailService.sendRemainderEmail(recipientEmail, remainderMessage);
            }

            // Return the response
            return ResponseEntity.ok("Remainder emails sent successfully");
        }

        public String generateRemainderMessage(Remainders remainder) {

            // Generate the remainder message for the user

            // Customize the logic to generate the message according to your requirements

            StringBuilder message = new StringBuilder();
            
            message.append("Dear ").append(remainder.getMembers().getFirstName()).append(",\n");

            message.append("This is a reminder for the following task:\n");

            message.append("- Title: ").append(remainder.getTitle()).append("\n");

            message.append("- Description: ").append(remainder.getDescription()).append("\n");

            // Add more details to the message if needed
            message.append("Please take the necessary action.\n");

            message.append("Thank you.\n");

            return message.toString();
        }
        
        //Accounts
        @PostMapping("/accounts/add")

        public ResponseEntity<AccountsDto> addAccount(@RequestBody AccountsDto accountDto) {

            AccountsDto addedAccount = committeeMembersService.addAccount(accountDto);

            return ResponseEntity.ok(addedAccount);
        }

//        @GetMapping("/accounts/{id}")

//        public ResponseEntity<AccountsDto> getAccountById(@PathVariable Long id) {

//            AccountsDto accountDto = committeeMembersService.getAccountById(id);

//            return ResponseEntity.ok(accountDto);

//        }

        @GetMapping("/accounts/{id}")

        public ResponseEntity<AccountsDto> getAccountById(@PathVariable Long id) {

            AccountsDto accountDto = committeeMembersService.getAccountById(id);

            return ResponseEntity.ok(accountDto);

        }

 
//        @GetMapping("/accounts/all")
//
//        public ResponseEntity<List<AccountsDto>> getAllAccounts() {
//
//            List<AccountsDto> accountDtoList = committeeMembersService.getAllAccounts();
//
//            return ResponseEntity.ok(accountDtoList);
//
//        }

 
        @PutMapping("/accounts/update/{userId}")

        public ResponseEntity<AccountsDto> updateAccount(@RequestBody AccountsDto accountDto) {

            AccountsDto updatedAccount = committeeMembersService.updateAccount(accountDto);

            return ResponseEntity.ok(updatedAccount);

        }

        
        @DeleteMapping("/accounts/delete/{id}")

        public ResponseEntity<String> deleteAccount(@PathVariable Long id) {

            committeeMembersService.deleteAccount(id);

            return ResponseEntity.ok("Account deleted successfully");

        }

        @GetMapping("/accounts/user/{userId}")

        public ResponseEntity<List<AccountsDto>> getAccountsByUserId(@PathVariable Integer userId) {

            List<AccountsDto> accountsDtoList = committeeMembersService.getAccountsByUserId(userId);

            return ResponseEntity.ok(accountsDtoList);

        }
}
