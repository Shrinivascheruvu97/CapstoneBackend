package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.ResultsDto;
import com.example.demo.service.ResultsService;

@RestController
@RequestMapping("/results")
@CrossOrigin(origins="http://localhost:3000/")
public class ResultsController {

	@Autowired
	ResultsService resultsService;
	
	@GetMapping("/allresults")
	public ResponseEntity<List<ResultsDto>> getAllResults()
	{
		
		List<ResultsDto> resultsDto = resultsService.declareAllResults();
		return new ResponseEntity<>(resultsDto, HttpStatus.OK);
	}
	
	@GetMapping("/oneresult/{id}")
	public ResponseEntity<List<ResultsDto>> getResultById(@PathVariable("id")int id)
	{
		List<ResultsDto> resultsDto = resultsService.declareResults(id);
		return new ResponseEntity<>(resultsDto, HttpStatus.OK);
	}
	
	@PostMapping("/fetchresults/{id}")
	public ResponseEntity<ResultsDto> fetchResults(@PathVariable("id")int id)
	{
		System.out.println("request hitted");
		resultsService.fetchData(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
