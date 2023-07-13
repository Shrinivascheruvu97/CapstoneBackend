package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.Ballot_BoxDto;
import com.example.demo.dto.SuggestandCompDto;
import com.example.demo.service.BallotBoxService;

@RestController
@RequestMapping("/ballotbox")
@CrossOrigin(origins="http://localhost:3000/")
public class BallotBoxController {

	@Autowired
	BallotBoxService ballotBoxService;
	
	@PostMapping("/addballot")
	public ResponseEntity<Ballot_BoxDto> addBallot(@RequestBody Ballot_BoxDto ballot)
	{
		Ballot_BoxDto addballot = ballotBoxService.addBallot(ballot);
		return new ResponseEntity<>(addballot,HttpStatus.CREATED);
	}
	
	@GetMapping("/allballots")
	public ResponseEntity<List<Ballot_BoxDto>> allBallots()
	{
		List<Ballot_BoxDto> allballots = ballotBoxService.getallBallots();
		return new ResponseEntity<>(allballots, HttpStatus.OK);
	}
	
	@GetMapping("/oneballot/{id}")
	public ResponseEntity<List<Ballot_BoxDto>> oneBallot(@PathVariable("id")int ballot_id)
	{	
		List<Ballot_BoxDto> oneballot = ballotBoxService.getBallotByID(ballot_id);
		return new ResponseEntity<>(oneballot, HttpStatus.OK);
	}
	
	@PostMapping("/postdata")
	public ResponseEntity<Ballot_BoxDto> postData(@RequestBody int id)
	{
		System.out.println("Request Hitted");
		ballotBoxService.postData(id);
		return new ResponseEntity<>(HttpStatus.OK);

	}
    @PostMapping("/fetchdata")
	public ResponseEntity<Ballot_BoxDto> fetchData(@RequestBody int id)
	{		
		ballotBoxService.fetchData(id);
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
}
