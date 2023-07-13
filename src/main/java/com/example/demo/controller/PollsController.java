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
import com.example.demo.dto.PollsDto;
import com.example.demo.service.PollsService;

@RestController
@RequestMapping("/polls")
@CrossOrigin(origins="http://localhost:3000/")
public class PollsController {

	@Autowired
	PollsService pollsService;
	
	@PostMapping("/addpoll")
	public ResponseEntity<PollsDto> addPolls(@RequestBody PollsDto poll) throws Exception
	{
		PollsDto addpoll = pollsService.addPoll(poll);
		if(addpoll.getSno() !=null)
		{
		return new ResponseEntity<>(addpoll, HttpStatus.CREATED);
		}
		
		throw new Exception("Vote is Already Casted!");
	}
	
	@GetMapping("/allpolls")
	public ResponseEntity<List<PollsDto>> allPolls()
	{
		List<PollsDto> allpolls = pollsService.getAllPolls();
		
		return new ResponseEntity<>(allpolls, HttpStatus.OK);
	}
	
	@GetMapping("/onepoll/{id}")
	public ResponseEntity<PollsDto> onePoll(@PathVariable("id") int id)
	{
		PollsDto onepoll = pollsService.getOnePoll(id);
		
		return new ResponseEntity<>(onepoll, HttpStatus.OK);
	}
}
