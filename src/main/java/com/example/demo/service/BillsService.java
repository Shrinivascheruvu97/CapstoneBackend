package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.BillsDto;
import com.example.demo.entity.Bills;

public interface BillsService {

	BillsDto addBill(BillsDto bill);
	//Bills addBill(BillsDto bill);
	void deleteBill(int billId);
	BillsDto updateBill(BillsDto bill);
	List<BillsDto> getAllBills();
	BillsDto getBillbyID(int billId);
}
