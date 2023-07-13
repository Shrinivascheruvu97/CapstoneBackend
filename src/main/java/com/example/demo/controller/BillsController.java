package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.BillsDto;
import com.example.demo.entity.Bills;
import com.example.demo.service.BillsService;

@RestController
@RequestMapping("/bills")
public class BillsController {

	@Autowired
	BillsService billsService;
	
	@PostMapping("/addbill")
	public ResponseEntity<BillsDto> addBill(@RequestBody BillsDto bill)
	{
		BillsDto addbill = billsService.addBill(bill);
		return new ResponseEntity<BillsDto>(addbill, HttpStatus.CREATED);
	}
	
	
	/*
	@PostMapping("/addbill")
	public ResponseEntity<Bills> addBill(@RequestBody BillsDto bill)
	{
		Bills addbill = billsService.addBill(bill);
		return new ResponseEntity<Bills>(addbill, HttpStatus.CREATED);
	}
	*/
	
	@DeleteMapping("/deletebill/{id}")
	public ResponseEntity<Bills> deleteBill(@PathVariable("id")int id)
	{
		billsService.deleteBill(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@PutMapping("/updatebill")
	public ResponseEntity<BillsDto> updateBill(@RequestBody BillsDto bill)
	{
		BillsDto billreturn = billsService.updateBill(bill);
		return new ResponseEntity<>(billreturn, HttpStatus.OK);
	}
	
	@GetMapping("/allbills")
	public ResponseEntity<List<BillsDto>> allBills()
	{
		List<BillsDto> bills = billsService.getAllBills();
		return new ResponseEntity<>(bills, HttpStatus.OK);
	}
	
	@GetMapping("/onebill/{id}")
	public ResponseEntity<BillsDto> oneBill(@PathVariable("id")int billid)
	{	
		BillsDto bill = billsService.getBillbyID(billid);
		return new ResponseEntity<>(bill, HttpStatus.OK);
	}
}
