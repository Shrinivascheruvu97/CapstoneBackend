package com.example.demo.controller;

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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.BillsDto;
import com.example.demo.dto.SuggestandCompDto;
import com.example.demo.entity.Bills;
import com.example.demo.entity.SuggestionsAndCompliants;
import com.example.demo.service.SuggestAndCompService;

@RestController
@RequestMapping("/sugg")
@CrossOrigin(origins="http://localhost:3000/")
public class SuggestAndCompController {

	@Autowired
	SuggestAndCompService suggestAndCompService;
	
	@PostMapping("/addsugg")
	public ResponseEntity<SuggestandCompDto> addSugg(@RequestBody SuggestandCompDto sugg)
	{
		SuggestandCompDto addsugg = suggestAndCompService.addcomp(sugg);
		return new ResponseEntity<>(addsugg, HttpStatus.CREATED);
	}
	
	/*
	@PostMapping("/addsugg")
	public ResponseEntity<SuggestionsAndCompliants> addSugg(@RequestBody SuggestandCompDto sugg)
	{
		SuggestionsAndCompliants addsugg = suggestAndCompService.addcomp(sugg);
		return new ResponseEntity<SuggestionsAndCompliants>(addsugg, HttpStatus.CREATED);
	}
	*/
	
	@DeleteMapping("/deletesugg/{id}")
	public ResponseEntity<SuggestionsAndCompliants> deleteSugg(@PathVariable("id")int id)
	{
		suggestAndCompService.deletecomp(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@PutMapping("/updatesugg")
	public ResponseEntity<SuggestandCompDto> updateSugg(@RequestBody SuggestandCompDto sugg)
	{
		SuggestandCompDto suggreturn = suggestAndCompService.updateComp(sugg);
		return new ResponseEntity<>(suggreturn, HttpStatus.OK);
	}
	
	@GetMapping("/allsugg")
	public ResponseEntity<List<SuggestandCompDto>> allSugg()
	{
		List<SuggestandCompDto> allsugg = suggestAndCompService.getAllcomp();
		return new ResponseEntity<>(allsugg, HttpStatus.OK);
	}
	
	@GetMapping("/onesugg/{id}")
	public ResponseEntity<SuggestandCompDto> oneSugg(@PathVariable("id")int id)
	{	
		SuggestandCompDto sugg = suggestAndCompService.getcompbyID(id);
		return new ResponseEntity<>(sugg, HttpStatus.OK);
	}
	
	@PutMapping("/updatesugg/{id}")
	public void updateStatusById(@PathVariable Long id, @RequestBody Map<String, String> requestBody) {
	    String newStatus = requestBody.get("status");
	    suggestAndCompService.updateStatusById(id, newStatus);
	}
	
}
