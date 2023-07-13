package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.PollsDto;

public interface PollsService {

	PollsDto addPoll(PollsDto poll);
	
	PollsDto getOnePoll(int id);
	
	List<PollsDto> getAllPolls();
}
