package com.example.demo.service;

import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.BillsDto;
import com.example.demo.entity.Bills;
import com.example.demo.entity.Elections;
import com.example.demo.entity.Members;
import com.example.demo.repositroy.BillsRepository;
import com.example.demo.repositroy.MembersRepository;
import com.example.demo.utility.BillIDGenerator;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class BillsServiceImpl implements BillsService {
	
	@Autowired
	BillsRepository billsRepository;
	
	@Autowired
	MembersRepository membersRepository;
	
	@Autowired
	BillIDGenerator billIDGenerator;

	
	@Override
	public BillsDto addBill(BillsDto bill) {
		
		int billid = billIDGenerator.getNextBillId();
		bill.setBillId(billid);
		
		Members userid = membersRepository.findById(bill.getUserId()).get();
		
		Bills billsdemo = new Bills();
		
		billsdemo.setBillId(bill.getBillId());
		billsdemo.setBillAmount(bill.getBillAmount());
		billsdemo.setEventName(bill.getEventName());
		billsdemo.setNoOfDays(bill.getNoOfDays());
		billsdemo.setMembers(userid);
		billsRepository.save(billsdemo);
		return bill;
	}
	
	
	 /*
	 @Override
	 public Bills addBill(BillsDto bill) {
		
		int billid = billIDGenerator.getNextBillId();
		bill.setBillId(billid);
		
		Members userid = membersRepository.findById(bill.getUserId()).get();
		
		Bills billsdemo = new Bills();
		
		billsdemo.setBillId(bill.getBillId());
		billsdemo.setBillAmount(bill.getBillAmount());
		billsdemo.setEventName(bill.getEventName());
		billsdemo.setNoOfDays(bill.getNoOfDays());
		billsdemo.setMembers(userid);
		billsRepository.save(billsdemo);
		return billsdemo;
	}
	*/

	@Override
	public BillsDto updateBill(BillsDto bill) {
		
		Bills billone = billsRepository.findById(bill.getBillId()).get();
		
		if(billone.getBillId() == bill.getBillId())
		{
			if(bill.getEventName() != null & !bill.getEventName().isEmpty())
			billone.setEventName(bill.getEventName());
			
			Object var3 = bill.getUserId();
			Integer user = null;
			if(var3 instanceof Integer)
			{
				 user = (Integer) var3;
			}
			Members members = new Members();
			members.setUserId(user);
			billone.setMembers(members);
			
			Object var1 = bill.getNoOfDays();
			if(var1 instanceof Integer)
				billone.setNoOfDays(bill.getNoOfDays());
			
			Object var2 = bill.getBillAmount();
			if(var2 instanceof Integer)
				billone.setBillAmount(bill.getBillAmount());
			
			billsRepository.save(billone);
		}
		return bill;
	}
	
	@Override
	public void deleteBill(int billId) {
	
		Bills bill = billsRepository.findById(billId).get();
		if(bill.getBillId() == billId)
		{
			billsRepository.delete(bill);
		}
	}

	@Override
	public List<BillsDto> getAllBills() {
		
		List<Bills> allbills = billsRepository.findAll();
		return mapToDtoList(allbills);
	}
	
	private List<BillsDto> mapToDtoList(List<Bills> billsList) {
	    List<BillsDto> dtoList = new ArrayList<>();
	    
	    Members member;

	    for (Bills bill : billsList) {
	        BillsDto dto = new BillsDto();
	        member = bill.getMembers();
	        int usrid = member.getUserId();
	        dto.setUserId(usrid);
	        dto.setBillId(bill.getBillId());
	        dto.setBillAmount(bill.getBillAmount());
	        dto.setEventName(bill.getEventName());
	        dto.setNoOfDays(bill.getNoOfDays());
	        dtoList.add(dto);
	    }

	    return dtoList;
	}

	@Override
	public BillsDto getBillbyID(int billId) {
		
		Bills bill = billsRepository.findById(billId).get();
		
		return mapToDto(bill);
	}
	
	private BillsDto mapToDto(Bills bill) {
		
		Members member = bill.getMembers();
		int usrid = member.getUserId();
		
	    BillsDto dto = new BillsDto();
	    
	    dto.setUserId(usrid);
	    dto.setBillId(bill.getBillId());
	    dto.setBillAmount(bill.getBillAmount());
	    dto.setEventName(bill.getEventName());
	    dto.setNoOfDays(bill.getNoOfDays());

	    return dto;
	}

}
