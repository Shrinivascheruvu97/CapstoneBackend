package com.example.demo.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.Ballot_BoxDto;
import com.example.demo.dto.PollsDto;
import com.example.demo.dto.SuggestandCompDto;
import com.example.demo.entity.Ballot_Box;
import com.example.demo.entity.Elections;
import com.example.demo.entity.SuggestionsAndCompliants;
import com.example.demo.repositroy.BallotBoxRepository;
import com.example.demo.repositroy.ElectionsRepository;
import com.example.demo.repositroy.PollsRepository;
import com.example.demo.utility.BallotIDGenerator;

import jakarta.transaction.Transactional;

@Transactional
@Service
public class BallotBoxServiceImpl implements BallotBoxService {

	@Autowired
	BallotBoxRepository ballotBoxRepository;
	
	@Autowired
	ElectionsRepository electionRepository;
	
	@Autowired
	BallotIDGenerator ballotIDGenerator;
	
	@Autowired
	ElectionsService electionService;
	
	@Autowired
	PollsRepository pollsRepository;
	
	@Override
	public Ballot_BoxDto addBallot(Ballot_BoxDto ballotbox) {
		
		int sno = ballotIDGenerator.getNextSNO();
		ballotbox.setSno(sno);
		
		Integer eleid = ballotBoxRepository.lastElectionID();
		if(eleid == null || !eleid.equals(ballotbox.getElection_id()))
		{
			int ballotid = ballotIDGenerator.getNextId();
			ballotbox.setBallot_id(ballotid);
		}
		else
		{
		ballotbox.setBallot_id(ballotBoxRepository.lastBallotID());
		}
		
		Elections election = electionRepository.findById(ballotbox.getElection_id()).get();
		
		Ballot_Box ballot_Box = new Ballot_Box();
		
		ballot_Box.setSno(ballotbox.getSno());
		ballot_Box.setBallot_id(ballotbox.getBallot_id());
		ballot_Box.setContestant_id(ballotbox.getContestant_id());
		ballot_Box.setContestant_name(ballotbox.getContestant_name());
		ballot_Box.setRole(ballotbox.getRole());
		ballot_Box.setElections(election);
		
		ballotBoxRepository.save(ballot_Box);
		
		return ballotbox;
	}

	@Override
	public List<Ballot_BoxDto> getBallotByID(int ballot_id) {
		
		List<Ballot_Box> oneballot =  ballotBoxRepository.findByIds(ballot_id);
		return mapToDto(oneballot);
	}
	
	private List<Ballot_BoxDto> mapToDto(List<Ballot_Box> ballotList) {
		
		Elections election;
	    List<Ballot_BoxDto> dtoList = new ArrayList<>();

	    for (Ballot_Box bltlist : ballotList)
	    {
	    	Ballot_BoxDto dto = new Ballot_BoxDto();
	    	
	    	election = bltlist.getElections();
	    	
	    	dto.setElection_id(election.getElection_id());
	        dto.setBallot_id(bltlist.getBallot_id());
	        dto.setCandidate_votes(bltlist.getCandidate_votes());
	        dto.setContestant_id(bltlist.getContestant_id());
	        dto.setContestant_name(bltlist.getContestant_name());
	        dto.setRole(bltlist.getRole());
	        dto.setSno(bltlist.getSno());

	        dtoList.add(dto);
	    }

	    return dtoList;
	}
	@Override
	public List<Ballot_BoxDto> getallBallots() {
		
		List<Ballot_Box> allballot = ballotBoxRepository.findAll();
		return mapToDtoList(allballot);
	}
	
	private List<Ballot_BoxDto> mapToDtoList(List<Ballot_Box> ballotList)
	{
		
		Elections election;
	    List<Ballot_BoxDto> dtoList = new ArrayList<>();

	    for (Ballot_Box bltlist : ballotList)
	    {
	    	Ballot_BoxDto dto = new Ballot_BoxDto();
	    	
	    	election = bltlist.getElections();
	    	
	    	dto.setElection_id(election.getElection_id());
	        dto.setBallot_id(bltlist.getBallot_id());
	        dto.setCandidate_votes(bltlist.getCandidate_votes());
	        dto.setContestant_id(bltlist.getContestant_id());
	        dto.setContestant_name(bltlist.getContestant_name());
	        dto.setRole(bltlist.getRole());
	        dto.setSno(bltlist.getSno());

	        dtoList.add(dto);
	    }

	    return dtoList;
	}

	@Override
	public void postData(int eleid) {
		
		int president=0, secaratary=0, treasurer=0;
		
		president = ballotBoxRepository.countPresidents(eleid);
		
		secaratary = ballotBoxRepository.countSecaratary(eleid);
		
		treasurer = ballotBoxRepository.countTreasurer(eleid);
		
		
		int eleID = eleid;
		
		electionService.updateElection( eleID, president, secaratary, treasurer);
	}

	@Override
	public void fetchData(int ele_id) {
	    List<Integer> presidentlist = ballotBoxRepository.findContestantIdsByElectionsElectionIdAndRole(ele_id, "president");
	    List<Integer> secretarylist = ballotBoxRepository.findContestantIdsByElectionsElectionIdAndRole(ele_id, "secretary");
	    List<Integer> treasurerlist = ballotBoxRepository.findContestantIdsByElectionsElectionIdAndRole(ele_id, "treasurer");

	    List<List<Integer>> presidentVotes = new ArrayList<>();
	    for (Integer presidentId : presidentlist)
	    {
	        List<Object[]> presidentVoteCounts = pollsRepository.getPresidentVoteCounts(Collections.singletonList(presidentId), ele_id);
	        for (Object[] result : presidentVoteCounts)
	        {
	            Integer id = (Integer) result[0];
	            Long repetitionCount = (Long) result[1];
	            List<Integer> presidentVote = new ArrayList<>();
	            presidentVote.add(id);
	            presidentVote.add(repetitionCount.intValue());
	            presidentVotes.add(presidentVote);
	        }
	    }

	    for (List<Integer> vote : presidentVotes)
	    {
	        Integer contestantId = vote.get(0);
	        Integer voteCount = vote.get(1);
	        ballotBoxRepository.updateCandidateVotesByContestantId(voteCount, contestantId, ele_id);
	    }
	    
	     List<List<Integer>> secretaryVotes = new ArrayList<>();
	    for (Integer secretaryId : secretarylist)
	    {
	        List<Object[]> secretaryVoteCounts = pollsRepository.getSecretaryVoteCounts(Collections.singletonList(secretaryId), ele_id);
	        for (Object[] result : secretaryVoteCounts)
	        {
	            Integer id = (Integer) result[0];
	            Long repetitionCount = (Long) result[1];
	            List<Integer> secretaryVote = new ArrayList<>();
	            secretaryVote.add(id);
	            secretaryVote.add(repetitionCount.intValue());
	            secretaryVotes.add(secretaryVote);
	        }
	    }

	    for (List<Integer> vote : secretaryVotes)
	    {
	        Integer contestantId = vote.get(0);
	        Integer voteCount = vote.get(1);
	        ballotBoxRepository.updateCandidateVotesByContestantId(voteCount, contestantId, ele_id);
	    }
	    
	     List<List<Integer>> treasurerVotes = new ArrayList<>();
	    for (Integer treasurerId : treasurerlist)
	    {
	        List<Object[]> treasurerVoteCounts = pollsRepository.getTreasurerVoteCounts(Collections.singletonList(treasurerId), ele_id);
	        for (Object[] result : treasurerVoteCounts)
	        {
	            Integer id = (Integer) result[0];
	            Long repetitionCount = (Long) result[1];
	            List<Integer> treasurerVote = new ArrayList<>();
	            treasurerVote.add(id);
	            treasurerVote.add(repetitionCount.intValue());
	            treasurerVotes.add(treasurerVote);
	        }
	    }

	    for (List<Integer> vote : treasurerVotes)
	    {
	        Integer contestantId = vote.get(0);
	        Integer voteCount = vote.get(1);
	        ballotBoxRepository.updateCandidateVotesByContestantId(voteCount, contestantId, ele_id);
	    }
	    
	    
	}
}
