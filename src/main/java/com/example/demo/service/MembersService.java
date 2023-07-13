package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.EventsDto;
import com.example.demo.dto.RemaindersDto;
import com.example.demo.entity.Members;

public interface MembersService  {

	 Members getMemberById(Integer userId);
	 Members updateMemberDetails(Integer userId, Members updatedMember);
	 long membersCount();
	 
     List<EventsDto> getAllEvents();

     EventsDto addEvent(EventsDto eventsDto);

     void updateEvent(Integer eventId, EventsDto eventsDto);

     void deleteEvent(Integer eventId);
     List<EventsDto> getEventsByUserId(int UserId);

     // fetching remainders based on userid
     List<RemaindersDto> getRemaindersByUserId(int userId);
     
     Members validateMembers(Members member);
}
