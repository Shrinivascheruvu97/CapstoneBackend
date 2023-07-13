package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.AccountsDto;

public interface AccountsServiceInt {
	
	
	 List<AccountsDto> getAllAccounts();

	void updateAccountStatusAndPaidOn(Integer userId);

}
