package com.example.demo.utility;

import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repositroy.BillsRepository;

@Service
public class BillIDGenerator {
	
	@Autowired
	BillsRepository billsRepository;
	
	public int getNextBillId()
	{
		Integer lastBillId = billsRepository.findMaxBill_Id();
		AtomicInteger counter = new AtomicInteger(lastBillId != null ? lastBillId : 0);
	return counter.incrementAndGet();
	}

}
