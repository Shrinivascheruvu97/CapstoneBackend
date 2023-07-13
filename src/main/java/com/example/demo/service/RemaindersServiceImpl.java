package com.example.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.demo.dto.RemaindersDto;
import com.example.demo.entity.Members;
import com.example.demo.entity.Remainders;
import com.example.demo.repositroy.MembersRepository;
import com.example.demo.repositroy.RemaindersRepository;

import ch.qos.logback.core.net.SyslogOutputStream;
@Configuration
@Component
@Service
public class RemaindersServiceImpl implements RemaindersService {
	
	
	@Autowired
    private RemaindersRepository remaindersRepository;
	@Autowired
	MembersRepository membersRepository;

    @Override
    public void saveReminder(RemaindersDto remainderDto) {
    	System.out.println(" request hitted");
        Remainders remainder = new Remainders();
        remainder.setTitle(remainderDto.getTitle());
        remainder.setDescription(remainderDto.getDescription());

        Members members = new Members();
        members.setUserId(remainderDto.getUserId());

        remainder.setMembers(members);

        remaindersRepository.save(remainder);
        
    }
    
//    @Override
//    public List<Remainders> getAllRemainders() {
//      return remaindersRepository.findAll();
//    }
//
//    @Override
//    public Remainders addRemainder(Remainders remainder) {
//      return remaindersRepository.save(remainder);
//    }
    
    
    @Override
    public List<RemaindersDto> getAllRemainders() {
      return remaindersRepository.findAll().stream()
          .map(this::convertToDto)
          .collect(Collectors.toList());
    }

    @Override
    public RemaindersDto addRemainder(RemaindersDto remainderDto) {
      Remainders remainder = convertToEntity(remainderDto);
      Remainders savedRemainder = remaindersRepository.save(remainder);
      return convertToDto(savedRemainder);
    }
    
    
    
    private RemaindersDto convertToDto(Remainders remainder) {
        RemaindersDto remainderDto = new RemaindersDto();
        remainderDto.setRemainderId(remainder.getRemainderId());
        remainderDto.setTitle(remainder.getTitle());
        remainderDto.setDescription(remainder.getDescription());
        remainderDto.setUserId(remainder.getMembers().getUserId());
        return remainderDto;
      }

      private Remainders convertToEntity(RemaindersDto remainderDto) {
        Remainders remainder = new Remainders();
        remainder.setRemainderId(remainderDto.getRemainderId());
        remainder.setTitle(remainderDto.getTitle());
        remainder.setDescription(remainderDto.getDescription());
        remainder.setMembers(membersRepository.findById(remainderDto.getUserId()).orElse(null));
        return remainder;
      }
  

}
