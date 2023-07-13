package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.SuggestandCompDto;
import com.example.demo.entity.SuggestionsAndCompliants;

public interface SuggestAndCompService {

	SuggestandCompDto addcomp(SuggestandCompDto comp);
	//SuggestionsAndCompliants addcomp(SuggestandCompDto comp);
	void deletecomp(int id);
	SuggestandCompDto updateComp(SuggestandCompDto comp);
	List<SuggestandCompDto>getAllcomp();
	SuggestandCompDto getcompbyID(int id);
	
	 void updateStatusById(Long id, String newStatus);
}
