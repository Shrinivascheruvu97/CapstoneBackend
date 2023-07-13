package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.BillsDto;
import com.example.demo.dto.SuggestandCompDto;
import com.example.demo.entity.Bills;
import com.example.demo.entity.Members;
import com.example.demo.entity.SuggestionsAndCompliants;
import com.example.demo.repositroy.MembersRepository;
import com.example.demo.repositroy.SuggestandCompRepository;
import com.example.demo.utility.SuggIDGenerator;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class SuggestAndCompServiceImpl implements SuggestAndCompService {
	
	@Autowired
	SuggestandCompRepository suggestandCompRepository;
	
	@Autowired
	SuggIDGenerator suggIDGenerator;
	
	@Autowired
	MembersRepository membersRepository;
	
	
	@Override
	public SuggestandCompDto addcomp(SuggestandCompDto comp) {
		
		int compid = suggIDGenerator.getNextCompId();
		comp.setId(compid);
		Members userid = membersRepository.findById(comp.getUserId()).get();
		SuggestionsAndCompliants suggestandComp = new SuggestionsAndCompliants();
		suggestandComp.setId(comp.getId());
		suggestandComp.setDescription(comp.getDescription());
		suggestandComp.setMessage(comp.getMessage());
		suggestandComp.setStatus(comp.getStatus());
		suggestandComp.setMembers(userid);
		suggestandCompRepository.save(suggestandComp);
		
		return comp;
	}
	
		/*
	 	@Override
		public SuggestionsAndCompliants addcomp(SuggestandCompDto comp) {
		
		int compid = suggIDGenerator.getNextCompId();
		comp.setId(compid);
		
		Members userid = membersRepository.findById(comp.getUserId()).get();
		
		SuggestionsAndCompliants suggestandComp = new SuggestionsAndCompliants();
		suggestandComp.setId(comp.getId());
		suggestandComp.setDiscrption(comp.getDiscrption());
		suggestandComp.setMessage(comp.getMessage());
		suggestandComp.setStatus(comp.getStatus());
		suggestandComp.setMembers(userid);
		suggestandCompRepository.save(suggestandComp);
		
		return suggestandComp;
	}
	*/

	@Override
	public void deletecomp(int id) {
		
		SuggestionsAndCompliants suggestandComp = suggestandCompRepository.findById(id).get();
		if(suggestandComp.getId() == id)
		{
			suggestandCompRepository.delete(suggestandComp);
		}
	}

	@Override
	public SuggestandCompDto updateComp(SuggestandCompDto comp) {
		
		SuggestionsAndCompliants suggestandComp = suggestandCompRepository.findById(comp.getId()).get();
		
		if(suggestandComp.getId() == comp.getId())
		{
			if(comp.getDescription() != null & !comp.getDescription().isEmpty())
				suggestandComp.setDescription(comp.getDescription());
			
			if(comp.getMessage() != null & !comp.getMessage().isEmpty())
				suggestandComp.setMessage(comp.getMessage());
			
			if(comp.getStatus() != null & !comp.getStatus().isEmpty())
				suggestandComp.setStatus(comp.getStatus());
				
				Object var3 = comp.getUserId();
				Integer user = null;
				if(var3 instanceof Integer)
				{
					 user = (Integer) var3;
				}
				Members members = new Members();
				members.setUserId(user);
				suggestandComp.setMembers(members);				
				
			suggestandCompRepository.save(suggestandComp);
		}
		
		return comp;
	}

	@Override
	public List<SuggestandCompDto> getAllcomp() {
		
		List<SuggestionsAndCompliants> allSugg = suggestandCompRepository.findAll();
		
		return mapToDtoList(allSugg);
	}
	
	private List<SuggestandCompDto> mapToDtoList(List<SuggestionsAndCompliants> SuggList) {
	    List<SuggestandCompDto> dtoList = new ArrayList<>();

	    Members member;
	    
	    for (SuggestionsAndCompliants sugg : SuggList) {
	    	SuggestandCompDto dto = new SuggestandCompDto();
	        
	    	member = sugg.getMembers();
	    	int usrid = member.getUserId();
	    	
	    	dto.setUserId(usrid);
	        dto.setId(sugg.getId());
	        dto.setDescription(sugg.getDescription());
	        dto.setMessage(sugg.getMessage());
	        dto.setStatus(sugg.getStatus());

	        dtoList.add(dto);
	    }

	    return dtoList;
	}

	@Override
	public SuggestandCompDto getcompbyID(int id) {
		
		SuggestionsAndCompliants oneSugg =  suggestandCompRepository.findById(id).get();
		
		return mapToDto(oneSugg);
	}
	
	private SuggestandCompDto mapToDto(SuggestionsAndCompliants oneSugg) {
		
		SuggestandCompDto dto = new SuggestandCompDto();
		
		Members member;
		
		member = oneSugg.getMembers();
    	int usrid = member.getUserId();
		
    	dto.setUserId(usrid);
		dto.setId(oneSugg.getId());
        dto.setDescription(oneSugg.getDescription());
        dto.setMessage(oneSugg.getMessage());
        dto.setStatus(oneSugg.getStatus());

	    return dto;
	}
	
	 @Override
	    public void updateStatusById(Long id, String newStatus) {
	        SuggestionsAndCompliants complaintsSuggestions = suggestandCompRepository.findById(id)
	                .orElseThrow(() -> new RuntimeException("Complaint or suggestion not found with ID: " + id));
	        
	        complaintsSuggestions.setStatus(newStatus);
	        suggestandCompRepository.save(complaintsSuggestions);
	    }
	

}
