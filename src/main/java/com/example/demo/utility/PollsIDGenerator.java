package com.example.demo.utility;

import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repositroy.PollsRepository;

@Service
public class PollsIDGenerator {

	@Autowired
	PollsRepository pollsRepository;
	
	public int getNextId()
	{
		Integer lastId = pollsRepository.findMax_Id();
		AtomicInteger counter = new AtomicInteger(lastId != null ? lastId : 0);
		return counter.incrementAndGet();
	}
	
	public int getNextSNO()
	{
		Integer lastId = pollsRepository.findMax_SNO();
		AtomicInteger counter = new AtomicInteger(lastId != null ? lastId : 0);
		return counter.incrementAndGet();
	}
}
