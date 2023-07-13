package com.example.demo.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.entity.Elections;
import com.example.demo.service.ElectionsService;

@RestController
@RequestMapping("/elections")
@CrossOrigin(origins="http://localhost:3000/")
public class ElectionsController {

	@Autowired
	ElectionsService electionsService;
	
	@PostMapping("/createelection")
	public ResponseEntity<Elections> addElection(@RequestBody Map<String, String> request) {
	    String electionDateStr = request.get("election_date");
	    LocalDate electionDate = LocalDate.parse(electionDateStr);
		Elections addelection = electionsService.addElection(electionDate);
		if(addelection.getElection_id() != null)
        {
		return new ResponseEntity<Elections>(addelection, HttpStatus.CREATED);
        }
		
		if(addelection.getElection_id() == null)
		{
    		throw new ResponseStatusException(HttpStatus.CONFLICT,"Election Date already Exist");
    	}
    	throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Unknown Error");
		
	}
	
	 @GetMapping("/allelections")
	public ResponseEntity<List<Elections>> allElections()
	{
		List<Elections> allelections = electionsService.allElections();
		return new ResponseEntity<List<Elections>>(allelections, HttpStatus.OK);
	}
	
	@GetMapping("/oneelection/{id}")
	public ResponseEntity<Elections> oneElection(@PathVariable("id")int election_id)
	{	
		Elections oneelection = electionsService.oneElectionBYId(election_id);
		return new ResponseEntity<Elections>(oneelection, HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteelection/{id}")
	public ResponseEntity<Elections> deleteElection(@PathVariable("id")int election_id)
	{
		electionsService.deleteElection(election_id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
}
