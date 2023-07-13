package com.example.demo.utility;

import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repositroy.BallotBoxRepository;

@Service
public class BallotIDGenerator {

	@Autowired
	BallotBoxRepository ballotBoxRepository;
	
	public int getNextId()
	{
		Integer lastId = ballotBoxRepository.findMax_Id();
		AtomicInteger counter = new AtomicInteger(lastId != null ? lastId : 0);
		return counter.incrementAndGet();
	}
	
	public int getNextSNO()
	{
		Integer lastId = ballotBoxRepository.findMax_SNO();
		AtomicInteger counter = new AtomicInteger(lastId != null ? lastId : 0);
		return counter.incrementAndGet();
	}
}
