package com.example.demo.service;

import com.example.demo.dto.EventsDto;
import com.example.demo.dto.RemaindersDto;
import com.example.demo.entity.Events;
import com.example.demo.entity.Members;
import com.example.demo.entity.Remainders;
import com.example.demo.repositroy.EventsRepository;
import com.example.demo.repositroy.MembersRepository;
import com.example.demo.repositroy.RemaindersRepository;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContextException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MembersServiceImpl implements MembersService {
	@Autowired
	private MembersRepository membersRepository;
	
	@Autowired
	private EventsRepository eventsRepository;
	
	@Autowired
	private RemaindersRepository remaindersRepository;
	
	public MembersServiceImpl(MembersRepository membersRepository) {
        this.membersRepository = membersRepository;
    }

	 @Override
	    public Members getMemberById(Integer userId) {
	        return membersRepository.findByUserId(userId);
	    }


	 @Override
	    public Members updateMemberDetails(Integer userId, Members updatedMember) {
	        Members existingMember = membersRepository.findByUserId(userId);
	        if (existingMember == null) {
	            throw new IllegalArgumentException("Member with ID " + userId + " does not exist.");
	        }

	        // Only update allowed fields
	        existingMember.setFirstName(updatedMember.getFirstName());
	        existingMember.setLastName(updatedMember.getLastName());
	        existingMember.setEmail(updatedMember.getEmail());
	        existingMember.setPassword(updatedMember.getPassword());

	        return membersRepository.save(existingMember);
	    }

	@Override
	public long membersCount() {
		
		return membersRepository.count();
	}
	
	@Override

    public List<EventsDto> getAllEvents() {

        List<Events> eventsList = eventsRepository.findAll();

        return mapToDtoList(eventsList);

    }


//    @Override
//
//    public EventsDto addEvent(EventsDto eventsDto) {
//
//        Members members = membersRepository.findById(eventsDto.getUserId())
//
//                .orElseThrow(() -> new ApplicationContextException("Incorrect userId"));
//
//     // Check if any events already exist within the given date range
//
//        List<Events> existingEvents = eventsRepository.findByFromDateAndToDate(
//
//                eventsDto.getFromDate(), eventsDto.getToDate());
//
//        if (!existingEvents.isEmpty()) {
//
//            throw new IllegalArgumentException("Dates are already booked");
//
//        }
//
//        Events event = new Events();
//
//        event.setEventId(eventsDto.getEventId());
//
//        event.setEventName(eventsDto.getEventName());
//
//        event.setFromDate(eventsDto.getFromDate());
//
//        event.setToDate(eventsDto.getToDate());
//
//        
//       
//        
//       
//
//       
//        event.setStatus(eventsDto.getStatus());
//
//        event.setMembers(members);
//
//        Events savedEvent = eventsRepository.save(event);
//
//        return mapToDto(savedEvent);
//
//    }
	
	
	
	@Transactional
	@Override
	public EventsDto addEvent(EventsDto eventsDto) {
	    Members members = membersRepository.findById(eventsDto.getUserId())
	            .orElseThrow(() -> new ApplicationContextException("Incorrect userId"));

	    // Check if any events already exist with the same fromDate and conflicting time slot
	    List<Events> existingEvents = eventsRepository.findByFromDate(eventsDto.getFromDate());

	    for (Events existingEvent : existingEvents) {
	        if (eventsOverlap(existingEvent.getFromDate(), existingEvent.getToDate(),
	                eventsDto.getFromDate(), eventsDto.getToDate())) {
	            throw new IllegalArgumentException("The selected time slot is already booked.");
	        }
	    }

	    Events event = new Events();
	    event.setEventId(eventsDto.getEventId());
	    event.setEventName(eventsDto.getEventName());
	    event.setFromDate(eventsDto.getFromDate());
	    event.setToDate(eventsDto.getToDate());
	    event.setStatus(eventsDto.getStatus());
	    event.setMembers(members);

	    Events savedEvent = eventsRepository.save(event);

	    return mapToDto(savedEvent);
	}

	// Helper method to check if two events overlap
	private boolean eventsOverlap(LocalDateTime localDateTime, LocalDateTime localDateTime2, LocalDateTime localDateTime3, LocalDateTime localDateTime4) {
	    return localDateTime.isBefore(localDateTime4) && localDateTime2.isAfter(localDateTime3);
	}


     @Override

        public void updateEvent(Integer eventId, EventsDto eventsDto) {

            Events event = eventsRepository.findById(eventId)

                    .orElseThrow(() -> new ApplicationContextException("Event not found"));



            Members members = membersRepository.findById(eventsDto.getUserId())

                    .orElseThrow(() -> new ApplicationContextException("Incorrect userId"));


            event.setEventId(eventsDto.getEventId());

            event.setEventName(eventsDto.getEventName());

            event.setFromDate(eventsDto.getFromDate());

            event.setToDate(eventsDto.getToDate());

            event.setStatus(eventsDto.getStatus());

            event.setMembers(members);

            eventsRepository.save(event);

        }

     
     @Override

        public void deleteEvent(Integer eventId) {

            eventsRepository.deleteById(eventId);

        }


        private EventsDto mapToDto(Events event) {

            EventsDto dto = new EventsDto();

            dto.setEventId(event.getEventId());

            dto.setEventName(event.getEventName());

            dto.setFromDate(event.getFromDate());

            dto.setToDate(event.getToDate());

            dto.setStatus(event.getStatus());

            dto.setUserId(event.getMembers().getUserId());

            return dto;

        }


        private List<EventsDto> mapToDtoList(List<Events> eventsList) {

            return eventsList.stream()

                    .map(this::mapToDto)

                    .collect(Collectors.toList());
        }
        public List<EventsDto> getEventsByUserId(int userId) {
        	
        	List<Events> eventsList = eventsRepository.findByMembersUserId(userId);
        	return eventsList.stream().map(this::convertToDto).collect(Collectors.toList());
        }
        
        private EventsDto convertToDto(Events event) {
        	EventsDto eventsDto =new EventsDto();
        	BeanUtils.copyProperties(event, eventsDto);

            eventsDto.setUserId(event.getMembers().getUserId());

            return eventsDto;
        }

        //Remainders      
        @Override

        public List<RemaindersDto> getRemaindersByUserId(int userId) {

            List<Remainders> remaindersList = remaindersRepository.findByMembersUserId(userId);

            return remaindersList.stream()

                    .map(this::convertToDto)

                    .collect(Collectors.toList());
        }

        private RemaindersDto convertToDto(Remainders remainder) {

            RemaindersDto remainderDto = new RemaindersDto();

            BeanUtils.copyProperties(remainder, remainderDto);

            remainderDto.setUserId(remainder.getMembers().getUserId());

            return remainderDto;

        }
        
        
        @Override
		public Members validateMembers(Members member) {
			
			Members member1 =  membersRepository.findByEmail(member.getEmail());
	    	if(member1.getEmail()!= null && !member1.getEmail().isEmpty())
	    	{  		
	    		if(member.getPassword().equals(member1.getPassword()))
	    		{
	    			return member1;
	    		}
	    	}
	    	
	    	Members demo = new Members();
	    	return demo;
			
		}
}
