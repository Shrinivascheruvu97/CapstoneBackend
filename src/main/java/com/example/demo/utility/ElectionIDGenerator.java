package com.example.demo.utility;

import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repositroy.ElectionsRepository;

@Service
public class ElectionIDGenerator {

	@Autowired
	ElectionsRepository electionsRepository;
	
	public int getNextId()
	{
		Integer lastId = electionsRepository.findMax_Id();
		AtomicInteger counter = new AtomicInteger(lastId != null ? lastId : 0);
		return counter.incrementAndGet();
	}
}
