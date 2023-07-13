//package com.example.demo.controller;
//	 
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//
//import org.springframework.http.HttpStatus;
//
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.DeleteMapping;
//
//import org.springframework.web.bind.annotation.GetMapping;
//
//import org.springframework.web.bind.annotation.PathVariable;
//
//import org.springframework.web.bind.annotation.PostMapping;
//
//import org.springframework.web.bind.annotation.PutMapping;
//
//import org.springframework.web.bind.annotation.RequestBody;
//
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import org.springframework.web.bind.annotation.RequestParam;
//
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.server.ResponseStatusException;
//
//import com.example.demo.dto.CommitteeMembersDto;
//import com.example.demo.entity.Admin;
//import com.example.demo.entity.CommitteeMembers;
//
//import com.example.demo.entity.Members;
//import com.example.demo.repositroy.AdminRepository;
//import com.example.demo.service.AdminService;
//
//	@CrossOrigin(origins="http://localhost:3000/")
//	@RestController
//	@RequestMapping("/admin")
//	public class AdminController {
//
//		@Autowired
//		AdminRepository adminRepository;
//		
//	    @Autowired
//	    private  AdminService adminService;
//	    
//	    public AdminController(AdminService adminService) {
//
//	        this.adminService = adminService;
//	    }
//
//	    @PostMapping("/members/add")
//	    public ResponseEntity<Members> addMember(@RequestBody Members members) throws Exception{
//
//	        Members addedMember = adminService.addMember(members);
//	        
//	        if(addedMember.getUserId() != null)
//	        {
//	        	return new ResponseEntity<>(addedMember, HttpStatus.CREATED);
//	        }
//	        
//	        if(addedMember.getEmail() != null) {
//	        	
//	    	        throw new ResponseStatusException(HttpStatus.CONFLICT,"Email Already Exists");
//	        } else {
//	        	
//	        	throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Flat Number Already Exists");
//	        }
//	    }
//	   
//	    @DeleteMapping("/members/delete/{id}")
//	    public ResponseEntity<Void> deleteMember(@PathVariable Integer id) throws Exception{
//
//	    	Members deleteMember =adminService.deleteMember(id);
//
//	    	if(deleteMember != null)
//	        {
//	    		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//	        }
//	    	
//	    	if(deleteMember == null)
//	    	{
//	    		throw new ResponseStatusException(HttpStatus.CONFLICT,"User Id does not Exist");
//	    	}
//	    	throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Unknown Error");
//	    }
//	    
//
//	    @PutMapping("/member/update")
//	    public ResponseEntity<Members> updateMember(@RequestBody Members members) {
//
//	        Members updatedMember = adminService.updateMember(members);
//
//	        return new ResponseEntity<>(updatedMember, HttpStatus.OK);
//	    }
//	    
//	    
//	    @PutMapping("/members/update")
//	    public ResponseEntity<List<Members>> updateMembers(@RequestBody List<Members> membersList) {
//	    	System.out.println("Hiii"+membersList);
//	        List<Members> updatedMembers = adminService.updateMembers(membersList);
//	        return new ResponseEntity<>(updatedMembers, HttpStatus.OK);
//	    }
//	    
//
//	    @GetMapping("/members")
//	    public ResponseEntity<List<Members>> getAllMembers() {
//
//	        List<Members> members = adminService.getAllMembers();
//
//	        return new ResponseEntity<>(members, HttpStatus.OK);
//	    }
//
//	    //CommitteeMembers   
//	    @PostMapping("/committeeMembers/add")
//	    public ResponseEntity<CommitteeMembersDto> addCommitteeMember(@RequestBody CommitteeMembersDto committeeMembersDto) {
//
//	        CommitteeMembersDto addedMember = adminService.addCommitteeMember(committeeMembersDto);
//
//	        return ResponseEntity.ok(addedMember);
//	    }
//
//	    @GetMapping("/committeeMembers")
//	    public ResponseEntity<List<CommitteeMembersDto>> getAllCommitteeMembers() {
//
//	        List<CommitteeMembersDto> committeeMembers = adminService.getAllCommitteeMembers();
//
//	        return ResponseEntity.ok(committeeMembers);
//	    }
//
//	    @PutMapping("/committeeMembers/update/{cmId}")
//	    public ResponseEntity<Void> updateCommitteeMember(@PathVariable Integer cmId,@RequestBody CommitteeMembersDto committeeMembersDto)
//	    {
//	        adminService.updateCommitteeMember(cmId, committeeMembersDto);
//
//	        return ResponseEntity.noContent().build();
//	    }
//
//	    @DeleteMapping("/committeeMembers/{cmId}")
//	    public ResponseEntity<Void> deleteCommitteeMember(@PathVariable Integer cmId) {
//	    	
//	        adminService.deleteCommitteeMember(cmId);
//
//	        return ResponseEntity.noContent().build();
//	    }
//	    
//	    @PostMapping("/validateadmin")
//	    public ResponseEntity<Admin> validateAdmin(@RequestBody Admin admin) throws Exception
//	    {
//	    	
//	    	System.out.println("Request Hitted!");
//	    	Admin admin1 =  adminRepository.findByEmail(admin.getEmail());
//	    	
//	    	if(admin1.getEmail()!= null && !admin1.getEmail().isEmpty())
//	    	{
//	    		
//	    		if(admin.getPassword().equalsIgnoreCase(admin1.getPassword()))
//	    		{
//	    			return new ResponseEntity<Admin>(admin1, HttpStatus.ACCEPTED);
//	    		}
//	    	}
//	    	throw new Exception("Login Failed");
//	    }
//	}


package com.example.demo.controller;
	 
import java.util.List;

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

import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.dto.CommitteeMembersDto;
import com.example.demo.entity.Admin;
import com.example.demo.entity.CommitteeMembers;

import com.example.demo.entity.Members;
import com.example.demo.repositroy.AdminRepository;
import com.example.demo.service.AdminService;

	@CrossOrigin(origins="http://localhost:3000/")
	@RestController
	@RequestMapping("/admin")
	public class AdminController {

		@Autowired
		AdminRepository adminRepository;
		
	    @Autowired
	    private  AdminService adminService;
	    
	    public AdminController(AdminService adminService) {

	        this.adminService = adminService;
	    }

	    @PostMapping("/members/add")
	    public ResponseEntity<Members> addMember(@RequestBody Members members) throws Exception{

	        Members addedMember = adminService.addMember(members);
	        
	        if(addedMember.getUserId() != null)
	        {
	        	return new ResponseEntity<>(addedMember, HttpStatus.CREATED);
	        }
	        
	        if(addedMember.getEmail() != null) {
	        	
	    	        throw new ResponseStatusException(HttpStatus.CONFLICT,"Email Already Exists");
	        } else {
	        	
	        	throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Flat Number Already Exists");
	        }
	    }
	    

	    @DeleteMapping("/members/delete/{id}")
	    public ResponseEntity<Void> deleteMember(@PathVariable Integer id) throws Exception{

	    	Members deleteMember =adminService.deleteMember(id);

	    	if(deleteMember != null)
	        {
	    		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	        }
	    	
	    	if(deleteMember == null)
	    	{
	    		throw new ResponseStatusException(HttpStatus.CONFLICT,"User Id does not Exist");
	    	}
	    	throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Unknown Error");
	    }
	    
	    @DeleteMapping("/members/delete")
	    public ResponseEntity<Void> deleteMembers(@RequestBody List<Integer> ids) throws Exception {
	    	
	    	
	        List<Members> deletedMembers = adminService.deleteMembers(ids);
	        
	        if (!deletedMembers.isEmpty()) {
	            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	        } if(deletedMembers.isEmpty()) {
	            throw new ResponseStatusException(HttpStatus.CONFLICT, "User IDs do not exist");
	        }
	        throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Unknown Error");
	    }


	    @PutMapping("/member/update")
	    public ResponseEntity<Members> updateMember( @RequestBody Members members) {

	    	int id=members.getUserId();
	        Members updatedMember = adminService.updateMember(members,id);

	        return new ResponseEntity<>(updatedMember, HttpStatus.OK);
	    }
	    
	    @PutMapping("/members/update/{userid}")
	    
	    public ResponseEntity<List<Members>> updateMembers(@RequestBody List<Members> membersList) {
	    	System.out.println("request hitted!!");
	        List<Members> updatedMembers = adminService.updateMembers(membersList);
	        System.out.println("request hitted!!");
	        return new ResponseEntity<>(updatedMembers, HttpStatus.OK);
	    }


	    @GetMapping("/members")
	    public ResponseEntity<List<Members>> getAllMembers() {

	        List<Members> members = adminService.getAllMembers();

	        return new ResponseEntity<>(members, HttpStatus.OK);
	    }

	    //CommitteeMembers   
	    @PostMapping("/committeeMembers/add")
	    public ResponseEntity<CommitteeMembersDto> addCommitteeMember(@RequestBody CommitteeMembersDto committeeMembersDto) {

	        CommitteeMembersDto addedMember = adminService.addCommitteeMember(committeeMembersDto);

	        return ResponseEntity.ok(addedMember);
	    }

	    @GetMapping("/committeeMembers")
	    public ResponseEntity<List<CommitteeMembersDto>> getAllCommitteeMembers() {

	        List<CommitteeMembersDto> committeeMembers = adminService.getAllCommitteeMembers();

	        return ResponseEntity.ok(committeeMembers);
	    }

	    @PutMapping("/committeeMembers/update/{cmId}")
	    public ResponseEntity<Void> updateCommitteeMember(@PathVariable Integer cmId,@RequestBody CommitteeMembersDto committeeMembersDto)
	    {
	        adminService.updateCommitteeMember(cmId, committeeMembersDto);

	        return ResponseEntity.noContent().build();
	    }

	    @DeleteMapping("/committeeMembers/{cmId}")
	    public ResponseEntity<Void> deleteCommitteeMember(@PathVariable Integer cmId) {
	    	
	        adminService.deleteCommitteeMember(cmId);

	        return ResponseEntity.noContent().build();
	    }
	    
	    @PostMapping("/validateadmin")
	    public ResponseEntity<Admin> validateAdmin(@RequestBody Admin admin) throws Exception
	    {
	    	Admin admindemo = adminService.validateAdmin(admin);
	    	if(admindemo.getId() !=null)
	    	{
	    	 return new ResponseEntity<Admin>(admindemo, HttpStatus.ACCEPTED);
	    	}
	    	throw new Exception("Login Failed");
	    }
	}
