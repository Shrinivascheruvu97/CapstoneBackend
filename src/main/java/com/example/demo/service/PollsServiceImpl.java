package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.Ballot_BoxDto;
import com.example.demo.dto.PollsDto;
import com.example.demo.entity.Ballot_Box;
import com.example.demo.entity.Elections;
import com.example.demo.entity.Polls;
import com.example.demo.repositroy.BallotBoxRepository;
import com.example.demo.repositroy.ElectionsRepository;
import com.example.demo.repositroy.PollsRepository;
import com.example.demo.utility.PollsIDGenerator;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class PollsServiceImpl implements PollsService  {

	@Autowired
	PollsRepository pollsRepository;
	
	@Autowired
	ElectionsRepository electionsRepository;
	
	@Autowired
	BallotBoxRepository ballotBoxRepository;
	
	@Autowired
	BallotBoxService ballotBoxService;
	
	@Autowired
	PollsIDGenerator pollsIDGenerator;
	
	@Override
	public PollsDto addPoll(PollsDto poll) {
		
		Polls polls = pollsRepository.findByVoterId(poll.getVoter_id(),poll.getElection_id());
		Integer voterid  = null;
		if (polls != null) {
			voterid = polls.getVoter_id();
		}
		
		if(voterid == null || !voterid.equals(poll.getVoter_id()))
			{
		
		int sno = pollsIDGenerator.getNextSNO();
		poll.setSno(sno);
		
		Integer pollid = pollsRepository.lastElectionID();
		if(pollid == null || !pollid.equals(poll.getElection_id()))
		{
			int pollID = pollsIDGenerator.getNextId();
			poll.setPolls_id(pollID);
		}
		
		else
		{
			poll.setPolls_id(pollsRepository.lastPollID());
		}
		
		Elections election = electionsRepository.findById(poll.getElection_id()).get();
		
		Polls pollObj = new Polls();
		
		pollObj.setSno(poll.getSno());
		pollObj.setPolls_id(poll.getPolls_id());
		pollObj.setVoter_id(poll.getVoter_id());
		pollObj.setVoter_name(poll.getVoter_name());
		pollObj.setElections(election);
		pollObj.setPresident_id(poll.getPresident_id());
		pollObj.setPresident_name(poll.getPresident_name());
		pollObj.setSecretary_id(poll.getSecretary_id());
		pollObj.setSecretary_name(poll.getSecretary_name());
		pollObj.setTreasurer_id(poll.getTreasurer_id());
		pollObj.setTreasusre_name(poll.getTreasusre_name());
		
		pollsRepository.save(pollObj);
		return poll;
				}
		PollsDto pollreturn = new PollsDto(); 
		return  pollreturn;
				
	}

	@Override
	public PollsDto getOnePoll(int id) {
		
		Polls poll = pollsRepository.findById(id).get();
		
		return mapToDto(poll);
	}
	
	private PollsDto mapToDto(Polls poll)
	{	
		Elections election = poll.getElections();
		
		PollsDto pollObj = new PollsDto();
		
		pollObj.setElection_id(election.getElection_id());
		pollObj.setSno(poll.getSno());
		pollObj.setPolls_id(poll.getPolls_id());
		pollObj.setVoter_id(poll.getVoter_id());
		pollObj.setVoter_name(poll.getVoter_name());
		pollObj.setPresident_id(poll.getPresident_id());
		pollObj.setPresident_name(poll.getPresident_name());
		pollObj.setSecretary_id(poll.getSecretary_id());
		pollObj.setSecretary_name(poll.getSecretary_name());
		pollObj.setTreasurer_id(poll.getTreasurer_id());
		pollObj.setTreasusre_name(poll.getTreasusre_name());
		
		return pollObj;
	}

	@Override
	public List<PollsDto> getAllPolls() {
		
		List<Polls> allpolls = pollsRepository.findAll();
		
		return mapToDtoList(allpolls);
	}
	
	private List<PollsDto>  mapToDtoList(List<Polls> pollList)
	{
		Elections election;
		
		List<PollsDto> dtoList = new ArrayList<>();
		
		for (Polls poll : pollList) {
			
			PollsDto pollObj = new PollsDto();
	        
			election = poll.getElections();
			
			pollObj.setElection_id(election.getElection_id());
			pollObj.setSno(poll.getSno());
			pollObj.setPolls_id(poll.getPolls_id());
			pollObj.setVoter_id(poll.getVoter_id());
			pollObj.setVoter_name(poll.getVoter_name());
			pollObj.setPresident_id(poll.getPresident_id());
			pollObj.setPresident_name(poll.getPresident_name());
			pollObj.setSecretary_id(poll.getSecretary_id());
			pollObj.setSecretary_name(poll.getSecretary_name());
			pollObj.setTreasurer_id(poll.getTreasurer_id());
			pollObj.setTreasusre_name(poll.getTreasusre_name());

	        dtoList.add(pollObj);
	    }
		return dtoList;
	}

}
