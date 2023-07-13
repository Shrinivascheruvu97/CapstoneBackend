package com.example.demo.controller;

import com.example.demo.dto.EventsDto;
import com.example.demo.dto.RemaindersDto;
import com.example.demo.entity.Members;
import com.example.demo.service.MembersService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/members")
@CrossOrigin(origins="http://localhost:3000/")
public class MembersController {
	@Autowired
    private  MembersService membersService;

    public MembersController(MembersService membersService) {
        this.membersService = membersService;
    }

    @GetMapping("/{userId}")
    public ResponseEntity<Members> getMemberById(@PathVariable Integer userId) {
        Members member = membersService.getMemberById(userId);
        if (member == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(member, HttpStatus.OK);
    }

    @PutMapping("/{userId}")
    public ResponseEntity<Members> updateMemberDetails(@PathVariable Integer userId,
                                                       @RequestBody Members updatedMember) {
        Members member = membersService.updateMemberDetails(userId, updatedMember);
        return new ResponseEntity<>(member, HttpStatus.OK);
    }
    
  //Events

    @PostMapping("/events/add")
    public ResponseEntity<EventsDto> addEvent(@RequestBody EventsDto eventsDto) {

        EventsDto addedEvent = membersService.addEvent(eventsDto);

        return ResponseEntity.ok(addedEvent);
    	}

    @GetMapping("/events")
    public ResponseEntity<List<EventsDto>> getAllEvents() {

        List<EventsDto> events = membersService.getAllEvents();
        return ResponseEntity.ok(events);
    	}

    @PutMapping("/events/{eventId}")
    public ResponseEntity<Void> updateEvent(@PathVariable Integer eventId,@RequestBody EventsDto eventsDto) {

        membersService.updateEvent(eventId, eventsDto);
        return ResponseEntity.noContent().build();
    	}

    @DeleteMapping("/delete/events/{eventId}")
    public ResponseEntity<Void> deleteEvent(@PathVariable Integer eventId) {

        membersService.deleteEvent(eventId);
        return ResponseEntity.noContent().build();
    	}
    
    @GetMapping("/events/user/{userId}")
    public ResponseEntity<List<EventsDto>> getEventsByUserId(@PathVariable int userId) {

        List<EventsDto> events = membersService.getEventsByUserId(userId);
        return ResponseEntity.ok(events);
    }
    
    

    //Remainders
    @GetMapping("/remainders/{userId}")
    public ResponseEntity<List<RemaindersDto>> getRemaindersByUserId(@PathVariable int userId) {

        List<RemaindersDto> remainders = membersService.getRemaindersByUserId(userId);
        return ResponseEntity.ok(remainders);
    }
    
    @PostMapping("/validatemember")
    public ResponseEntity<Members> validateMember(@RequestBody Members member) throws Exception
    {
    	//System.out.println("Request hitted");
    	Members memberdemo = membersService.validateMembers(member);
    	
    	
    	if(memberdemo.getUserId() !=null)
    	{
    	return new ResponseEntity<Members>(memberdemo, HttpStatus.ACCEPTED);
    	}
    	throw new Exception("In valid Credentials!");
    }
}
