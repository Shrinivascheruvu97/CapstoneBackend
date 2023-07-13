package com.example.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.AccountsDto;
import com.example.demo.dto.RemaindersDto;
import com.example.demo.entity.Accounts;
import com.example.demo.entity.Members;

import com.example.demo.entity.Remainders;
import com.example.demo.repositroy.AccountsRepository;
import com.example.demo.repositroy.MembersRepository;

import com.example.demo.repositroy.RemaindersRepository;

@Service
public class CommitteeMembersServiceImpl implements CommitteeMembersService {

	

	@Autowired
	private RemaindersRepository remaindersRepository;

	@Autowired
	MembersRepository membersRepository;

	@Autowired
	AccountsRepository accountsRepository;

	@Autowired
	private EmailService emailService;
	
	@Autowired
	ModelMapper modelMapper;

	public CommitteeMembersServiceImpl(
			RemaindersRepository remaindersRepository) {

		

		this.remaindersRepository = remaindersRepository;
	}

	

	// REmainders

	@Override
	public List<RemaindersDto> getAllRemainders() {

		List<Remainders> remaindersList = remaindersRepository.findAll();

		return remaindersList.stream().map(this::convertToDto).collect(Collectors.toList());
	}

	@Override
	public RemaindersDto getRemainderById(int remainderId) {

		Remainders remainder = remaindersRepository.findById(remainderId)
				.orElseThrow(() -> new IllegalArgumentException("Invalid remainder ID"));

		return convertToDto(remainder);
	}

	@Override
	public RemaindersDto addRemainder(RemaindersDto remainderDto) {

		Remainders remainder = convertToEntity(remainderDto);

		Remainders savedRemainder = remaindersRepository.save(remainder);

		return convertToDto(savedRemainder);
	}

	@Override
	public RemaindersDto updateRemainder(int remainderId, RemaindersDto remainderDto) {

		Remainders existingRemainder = remaindersRepository.findById(remainderId)
				.orElseThrow(() -> new IllegalArgumentException("Invalid remainder ID"));

		// Update the existing remainder entity with the new data
		existingRemainder.setTitle(remainderDto.getTitle());

		existingRemainder.setDescription(remainderDto.getDescription());

		Remainders updatedRemainder = remaindersRepository.save(existingRemainder);

		return convertToDto(updatedRemainder);
	}

	@Override
	public void deleteRemainder(int remainderId) {

		remaindersRepository.deleteById(remainderId);
	}

	// Helper method to convert Remainders entity to RemaindersDto
	private RemaindersDto convertToDto(Remainders remainder) {

		RemaindersDto remainderDto = new RemaindersDto();

		BeanUtils.copyProperties(remainder, remainderDto);

		remainderDto.setUserId(remainder.getMembers().getUserId());

		return remainderDto;
	}

	// Helper method to convert RemaindersDto to Remainders entity
	private Remainders convertToEntity(RemaindersDto remainderDto) {

		Remainders remainder = new Remainders();

		BeanUtils.copyProperties(remainderDto, remainder);

		// Set the Members entity based on the userId in the remainderDto

		// You may need to fetch the Members entity from the database using the userId

		// and set it to the remainder entity.

		return remainder;
	}

	@Override

	public List<Remainders> getAllRemaindersFromRemainders() {

		return remaindersRepository.findAll();

	}

	// Accounts
	@Override
	public AccountsDto addAccount(AccountsDto accountDto) {

		Members members = membersRepository.findById(accountDto.getUserId())

				.orElseThrow(() -> new IllegalArgumentException("Member not found with ID: " + accountDto.getUserId()));

		Accounts account = convertToEntity(accountDto);

		account.setMembers(members);

		int total = account.calculateTotal();

		account.setTotal(total);

		Accounts savedAccount = accountsRepository.save(account);

		return convertToDto(savedAccount);

	}

	@Override

	public AccountsDto getAccountById(Long id) {

		Accounts account = accountsRepository.findById(id)

				.orElseThrow(() -> new IllegalArgumentException("Account not found with ID: " + id));

		return convertToDto(account);

	}

//	@Override
//
//	public List<AccountsDto> getAllAccounts() {
//
//		List<Accounts> accountsList = accountsRepository.findAll();
//
//		// Calculate the total for each account
//
//		for (Accounts account : accountsList) {
//
//			int total = account.calculateTotal();
//
//			account.setTotal(total);
//
//		}
//
//		// Convert the entities to DTOs
//
//		List<AccountsDto> accountDtoList = convertToDtoList(accountsList);
//
//		return accountDtoList;
//
//	}
	
	
	
	

	@Override

	public AccountsDto updateAccount(AccountsDto accountDto) {

		Members members = membersRepository.findById(accountDto.getUserId())

				.orElseThrow(() -> new IllegalArgumentException("Member not found with ID: " + accountDto.getUserId()));

		Accounts existingAccount = accountsRepository.findById(accountDto.getId())

				.orElseThrow(() -> new IllegalArgumentException("Account not found with ID: " + accountDto.getId()));

		Accounts account = convertToEntity(accountDto);

		account.setMembers(members);

		account.setTotal(account.calculateTotal());

		account.setPaidOn(existingAccount.getPaidOn()); // Retain the existing paidOn value

		Accounts updatedAccount = accountsRepository.save(account);

		return convertToDto(updatedAccount);

	}

	@Override

	public void deleteAccount(Long id) {

		accountsRepository.deleteById(id);

	}

//          @Override

//          public List<AccountsDto> getAccountsByUserId(Integer userId) {

//              List<Accounts> accounts = accountsRepository.findByMembersId(userId);

//              return convertToDtoList(accounts);

//          }

	@Override

	public List<AccountsDto> getAccountsByUserId(Integer userId) {

		List<Accounts> accountsList = accountsRepository.findByMembers_UserId(userId);

		return convertToDtoList(accountsList);

	}

	// Helper methods for converting between entity and DTO

	private AccountsDto convertToDto(Accounts account) {

		AccountsDto accountDto = new AccountsDto();

		accountDto.setId(account.getId());

		accountDto.setMonth(account.getMonth());

		accountDto.setUserId(account.getMembers().getUserId());

		accountDto.setMaintenanceBill(account.getMaintenanceBill());

		accountDto.setWaterBill(account.getWaterBill());

		accountDto.setEventsBill(account.getEventsBill());

		accountDto.setExtras(account.getExtras());

		accountDto.setTotal(account.getTotal());

		accountDto.setStatus(account.getStatus());

		accountDto.setPaidOn(account.getPaidOn());

		return accountDto;

	}

	private List<AccountsDto> convertToDtoList(List<Accounts> accounts) {

		return accounts.stream()

				.map(this::convertToDto)

				.collect(Collectors.toList());

	}

	private Accounts convertToEntity(AccountsDto accountDto) {

		Accounts account = new Accounts();

		account.setId(accountDto.getId());

		account.setMonth(accountDto.getMonth());

		account.setMaintenanceBill(accountDto.getMaintenanceBill());

		account.setWaterBill(accountDto.getWaterBill());

		account.setEventsBill(accountDto.getEventsBill());

		account.setExtras(accountDto.getExtras());

		account.setTotal(accountDto.getTotal());

		account.setStatus(accountDto.getStatus());

		account.setPaidOn(accountDto.getPaidOn());

		return account;

	}

}
