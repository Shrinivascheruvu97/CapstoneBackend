package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.ResultsDto;

public interface ResultsService {

	void fetchData(int eleid);
	List<ResultsDto> declareResults(int eleid);
	List<ResultsDto> declareAllResults();
}
