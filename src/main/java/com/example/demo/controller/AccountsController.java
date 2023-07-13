package com.example.demo.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.AccountsDto;
import com.example.demo.service.AccountsServiceInt;

@RestController
@RequestMapping("/accounts")
@CrossOrigin(origins="http://localhost:3000/")
public class AccountsController {

    private final AccountsServiceInt accountsService;

    public AccountsController(AccountsServiceInt accountsService) {
        this.accountsService = accountsService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<AccountsDto>> getAllAccounts() {
        List<AccountsDto> accountDtoList = accountsService.getAllAccounts();
        return ResponseEntity.ok(accountDtoList);
    }
    
    @PutMapping("/update/{userId}")
    public ResponseEntity<String> updateAccountStatusAndPaidOn(@PathVariable Integer userId) {
        accountsService.updateAccountStatusAndPaidOn(userId);
        return ResponseEntity.ok("Account updated successfully");
    }
    
    
}
