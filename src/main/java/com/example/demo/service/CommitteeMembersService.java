package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.AccountsDto;
import com.example.demo.dto.RemaindersDto;

import com.example.demo.entity.Remainders;

public interface CommitteeMembersService {

	

    //Remainders
    List<RemaindersDto> getAllRemainders();

    RemaindersDto getRemainderById(int remainderId);

    RemaindersDto addRemainder(RemaindersDto remainderDto);

    RemaindersDto updateRemainder(int remainderId, RemaindersDto remainderDto);

    void deleteRemainder(int remainderId);
    
    //send remainders
    List<Remainders> getAllRemaindersFromRemainders();
    
    //Accounts
    AccountsDto addAccount(AccountsDto accountDto);

    AccountsDto getAccountById(Long id);

   // List<AccountsDto> getAllAccounts();

    AccountsDto updateAccount(AccountsDto accountDto);

    void deleteAccount(Long id);

    List<AccountsDto> getAccountsByUserId(Integer userId);
	
 }
