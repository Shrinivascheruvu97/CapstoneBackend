package com.example.demo.utility;

import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repositroy.ResultsRepository;

@Service
public class ResultsIDGenerator {

	@Autowired
	ResultsRepository resultsRepository;
	
	public int getNextId()
	{
		Integer lastId = resultsRepository.findMax_Id();
		AtomicInteger counter = new AtomicInteger(lastId != null ? lastId : 0);
		return counter.incrementAndGet();
	}
	
	public int getNextSNO()
	{
		Integer lastId = resultsRepository.findMax_SNO();
		AtomicInteger counter = new AtomicInteger(lastId != null ? lastId : 0);
		return counter.incrementAndGet();
	}
}
