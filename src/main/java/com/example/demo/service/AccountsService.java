package com.example.demo.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.example.demo.dto.AccountsDto;
import com.example.demo.entity.Accounts;
import com.example.demo.entity.Members;
import com.example.demo.entity.Remainders;
import com.example.demo.repositroy.AccountsRepository;
import com.example.demo.repositroy.MembersRepository;
import com.example.demo.repositroy.RemaindersRepository;

@Service
public class AccountsService implements AccountsServiceInt {
	@Autowired
	AccountsRepository accountsRepository;
	
	@Autowired
	MembersRepository membersRepository;
	@Autowired
	ModelMapper modelMapper;
	@Autowired
	EmailService mailService;
	@Autowired
	RemaindersRepository remaindersRepository;
	
	
	
	
//	public void addBillsToAccounts() {
//	    List<Members> members = membersRepository.findAll();
//	    for (Members member : members) {
//	      Accounts accounts = new Accounts();
//	      //accounts.setUserId(member.getUserId());
//	      accounts.setMaintenanceBill(3000);
//	      accounts.setWaterBill(2000);
//	      // Set other properties as needed
//	      accounts.setTotal(accounts.calculateTotal());
//	      accountsRepository.save(accounts);
//	    }
//	  }
	public void addBillsToAccounts() {
	    List<Members> members = membersRepository.findAll();
	    for (Members member : members) {
	        Accounts accounts = new Accounts();
	        accounts.setMembers(member);
	        accounts.setMonth(LocalDate.now().getMonthValue()); // Set the current month
	        accounts.setMaintenanceBill(3000);
	        accounts.setWaterBill(2000);
	        // Set other properties as needed
	        accounts.setTotal(accounts.calculateTotal());
	        accountsRepository.save(accounts);
	    }
	}
	
	
//	public void addUnPaidToRemainders()
//	{
//		List<Accounts> unPaidAccounts=accountsRepository.findUnpaidAccounts();
//		 for (Accounts account : unPaidAccounts) {
//		        Remainders remainder = new Remainders();
//		        remainder.setTitle("Bill Due");
//		        remainder.setDescription("Current month bill is due. Please pay within 5 days.");
//
//		        Members member = account.getMembers();
//		        remainder.setMembers(member);
//
//		        remaindersRepository.save(remainder);
//		    }
//		
//	}




	@Override
    public List<AccountsDto> getAllAccounts() {
        List<Accounts> accountsList = accountsRepository.findAll();
        return accountsList.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

//    private AccountsDto convertToDto(Accounts accounts) {
//        //return modelMapper.map(accounts, AccountsDto.class);
//    	List<Members> members = membersRepository.findAll();
//    	AccountsDto accountsDto = modelMapper.map(accounts, AccountsDto.class);
//    	for (Members member : members) {
//    	
//        accountsDto.setUserId(accounts.getMembers().);
//        
//    }
//    	return accountsDto;
//    }
	
	private AccountsDto convertToDto(Accounts accounts) {
	    return modelMapper.map(accounts, AccountsDto.class);
	}
//	
//	public void addBillsToAccounts() {
//	    List<Members> members = membersRepository.findAll();
//	    for (Members member : members) {
//	        AccountsDto accountsDTO = new AccountsDto();
//	        accountsDTO.setUserId(member.getUserId());
//	        accountsDTO.setMonth(LocalDate.now().getMonthValue()); // Set the current month
//	        accountsDTO.setMaintenanceBill(3000);
//	        accountsDTO.setWaterBill(2000);
//	        // Set other properties as needed
//	        Accounts accounts = accountsMapper.mapToEntity(accountsDTO);
//	        accounts.setTotal(accounts.calculateTotal());
//	        accountsRepository.save(accounts);
//	    }
//	}
	
	
//	public void addBillsToAccounts() {
//	    List<Members> members = membersRepository.findAll();
//	    for (Members member : members) {
//	        AccountsDto accountsDTO = new AccountsDto();
//	        accountsDTO.setUserId(member.getUserId());
//	        accountsDTO.setMaintenanceBill(3000);
//	        accountsDTO.setWaterBill(2000);
//	        // Set other properties as needed
//
//	        Accounts accounts = convertToAccounts(accountsDTO);
//	        accounts.setTotal(accounts.calculateTotal());
//	        accountsRepository.save(accounts);
//	    }
//	}
//
//	private Accounts convertToAccounts(AccountsDto accountsDTO) {
//	    Accounts accounts = new Accounts();
//	    accounts.setUserId(accountsDTO.getUserId());
//	    accounts.setMaintenanceBill(accountsDTO.getMaintenanceBill());
//	    accounts.setWaterBill(accountsDTO.getWaterBill());
//	    // Set other properties as needed
//
//	    return accounts;
//	}



	

  // Inject necessary dependencies

//  @Scheduled(cron ="0 9 18 9 * ?")
//  public void addMonthlyBillsToAccounts() {
//    try {
//      // Get the current month and year
//      LocalDate currentDate = LocalDate.now();
//      int month = currentDate.getMonthValue();
//      int year = currentDate.getYear();
//
//      // Create an Account object for the maintenance bill
//      Accounts maintenanceBillAccount = new Accounts();
//      maintenanceBillAccount.setMonth(month);
//     
//      maintenanceBillAccount.setMaintenanceBill(3000);
//
//      // Create an Account object for the water bill
//      Accounts waterBillAccount = new Accounts();
//      waterBillAccount.setMonth(month);
//     
//      waterBillAccount.setWaterBill(2000);
//
//      // Save the account objects to the accounts table
//      accountsRepository.save(maintenanceBillAccount);
//      accountsRepository.save(waterBillAccount);
//
//      System.out.println("Maintenance bill and water bill added to the accounts table.");
//    } catch (Exception e) {
//      System.err.println("Failed to add bills to the accounts table: " + e.getMessage());
//    }
//  }
	public void updateAccountStatusAndPaidOn(Integer userId) {
        Accounts account = accountsRepository.findByMembers_userId(userId);
        if (account != null) {
            account.setStatus("Paid");
            account.setPaidOn(LocalDate.now());
            accountsRepository.save(account);
        }
    }
	
	
//	@Scheduled(cron = "0 03 16 11 * ?") // Execute on the 10th of every month
//    public void sendAccountReminders() {
//        LocalDate currentDate = LocalDate.now();
//        LocalDate dueDate = currentDate.plusDays(5); // Assuming due date is 15th of the month
//
//        List<Accounts> unpaidAccounts = accountsRepository.findByStatusNot();
//
//        List<Members> unpaidMembers = unpaidAccounts.stream()
//                .map(Accounts::getMembers)
//                .distinct()
//                .collect(Collectors.toList());
//
//        for (Members member : unpaidMembers) {
//            String recipientEmail = member.getEmail();
//            String subject = "Account Payment Reminder";
//            String message = "Dear " + member.getFirstName() + " " + member.getLastName() + ",\n\n"
//                    + "This is a reminder that your account payment for the month of " + currentDate.getMonth()
//                    + " is due.\n"
//                    + "Please pay the maintenance bill and water bill before "
//                    + dueDate.format(DateTimeFormatter.ofPattern("dd MMMM")) + ".\n\n"
//                    + "Thank you.\n";
//
//            mailService.sendEmail(recipientEmail, subject, message);
//        }
//    }
	
	
}

