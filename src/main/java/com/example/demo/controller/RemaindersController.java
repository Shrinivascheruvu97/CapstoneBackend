package com.example.demo.controller;

import com.example.demo.dto.RemaindersDto;
import com.example.demo.entity.Remainders;
import com.example.demo.service.RemaindersService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/remainders")
@CrossOrigin(origins="http://localhost:3000")
public class RemaindersController {
	
	
	@Autowired
   RemaindersService remaindersService;

 
  public RemaindersController(RemaindersService remaindersService) {
    this.remaindersService = remaindersService;
  }

//  @GetMapping("/getall")
//  public List<Remainders> getAllRemainders() {
//    return remaindersService.getAllRemainders();
//  }
//
//  @PostMapping("/add")
//  public Remainders addRemainder(@RequestBody Remainders remainder) {
//    return remaindersService.addRemainder(remainder);
//  }
  
  
  @GetMapping("/getall")
  public List<RemaindersDto> getAllRemainders() {
    return remaindersService.getAllRemainders();
  }

  @PostMapping("/add")
  public RemaindersDto addRemainder(@RequestBody RemaindersDto remainderDto) {
    return remaindersService.addRemainder(remainderDto);
  }
  
  
  
  
  
}

