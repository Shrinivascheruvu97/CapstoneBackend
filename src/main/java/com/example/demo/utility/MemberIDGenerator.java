package com.example.demo.utility;

import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repositroy.MembersRepository;

@Service
public class MemberIDGenerator {

	@Autowired
	MembersRepository membersRepository;
	
	public int getNextId()
	{
		Integer lastId = membersRepository.findMax_Id();
		AtomicInteger counter = new AtomicInteger(lastId != null ? lastId : 0);
		return counter.incrementAndGet();
	}
}
