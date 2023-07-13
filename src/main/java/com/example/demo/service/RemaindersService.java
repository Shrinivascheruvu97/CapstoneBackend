package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.RemaindersDto;
import com.example.demo.entity.Remainders;

public interface RemaindersService {
	 void saveReminder(RemaindersDto remainderDto);
	 
	 //List<Remainders> getAllRemainders();
	  //Remainders addRemainder(Remainders remainder);
	  
	  List<RemaindersDto> getAllRemainders();
	  RemaindersDto addRemainder(RemaindersDto remainderDto);
}
