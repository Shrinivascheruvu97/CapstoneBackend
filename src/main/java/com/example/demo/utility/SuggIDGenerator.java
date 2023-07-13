package com.example.demo.utility;

import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repositroy.SuggestandCompRepository;

@Service
public class SuggIDGenerator {

	@Autowired
	SuggestandCompRepository suggestandCompRepository;
	
	public int getNextCompId()
	{
		Integer lastId = suggestandCompRepository.findMax_Id();
		AtomicInteger counter = new AtomicInteger(lastId != null ? lastId : 0);
		return counter.incrementAndGet();
	}
}
