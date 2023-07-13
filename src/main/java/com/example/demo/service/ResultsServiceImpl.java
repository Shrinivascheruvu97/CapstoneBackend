package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.ResultsDto;
import com.example.demo.entity.Ballot_Box;
import com.example.demo.entity.Elections;
import com.example.demo.entity.Results;
import com.example.demo.repositroy.BallotBoxRepository;
import com.example.demo.repositroy.ElectionsRepository;
import com.example.demo.repositroy.ResultsRepository;
import com.example.demo.utility.ResultsIDGenerator;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ResultsServiceImpl implements ResultsService {

	@Autowired
	ResultsRepository resultsRepository;
	
	@Autowired
	ResultsIDGenerator resultsIDGenerator;
	
	@Autowired
	BallotBoxRepository ballotBoxRepository;
	
	@Autowired
	ElectionsRepository electionsRepository;
	
	@Override
	public void fetchData(int eleid) {
		
	    Elections elections = electionsRepository.findByElectionId(eleid);

	    List<Ballot_Box> resultsList1 = ballotBoxRepository.findMaxVotesByPresident(eleid);
	    List<Ballot_Box> resultsList2 = ballotBoxRepository.findMaxVotesBySecretary(eleid);
	    List<Ballot_Box> resultsList3 = ballotBoxRepository.findMaxVotesByTreasurer(eleid);

	    List<Results> resultList = new ArrayList<>();

	    for (Ballot_Box result : resultsList1)
	    {
	        
	    	Results dto = new Results();
	        
	        dto.setSno(resultsIDGenerator.getNextSNO());
	        
	        Integer eleid1 = resultsRepository.lastElectionID();
	        
			if(eleid1 == null || !eleid1.equals(eleid))
			{
				int resultid = resultsIDGenerator.getNextId();
				dto.setResult_id(resultid);
			}
			else
			{
			dto.setResult_id(resultsRepository.findMax_Id());
			}
	        dto.setBallot_id(result.getBallot_id());
	        dto.setMember_id(result.getContestant_id());
	        dto.setMember_name(result.getContestant_name());
	        dto.setRole(result.getRole());
	        dto.setVotes(result.getCandidate_votes());
	        dto.setElections(elections);
	        dto.setElection_date(elections.getElection_date());
	        dto.setTotal_votes(elections.getVoters_count());
	        
	        resultList.add(dto);
	        
	        resultsRepository.saveAll(resultList);
	    }

	    for (Ballot_Box result : resultsList2)
	    {
	        Results dto = new Results();
	        
	        dto.setSno(resultsIDGenerator.getNextSNO());
	        
	        Integer eleid1 = resultsRepository.lastElectionID();
	        
			if(eleid1 == null || !eleid1.equals(eleid))
			{
				int resultid = resultsIDGenerator.getNextId();
				dto.setResult_id(resultid);
			}
			else
			{
			dto.setResult_id(resultsRepository.findMax_Id());
			}
	        dto.setBallot_id(result.getBallot_id());
	        dto.setMember_id(result.getContestant_id());
	        dto.setMember_name(result.getContestant_name());
	        dto.setRole(result.getRole());
	        dto.setVotes(result.getCandidate_votes());
	        dto.setElections(elections);
	        dto.setElection_date(elections.getElection_date());
	        dto.setTotal_votes(elections.getVoters_count());
	        
	        resultList.add(dto);
	        
	        resultsRepository.saveAll(resultList);
	    }

	    for (Ballot_Box result : resultsList3)
	    {
	        Results dto = new Results();
	        
	        dto.setSno(resultsIDGenerator.getNextSNO());
	        
	        Integer eleid1 = resultsRepository.lastElectionID();
	        
			if(eleid1 == null || !eleid1.equals(eleid))
			{
				int resultid = resultsIDGenerator.getNextId();
				dto.setResult_id(resultid);
			}
			else
			{
			dto.setResult_id(resultsRepository.findMax_Id());
			}
	        dto.setBallot_id(result.getBallot_id());
	        dto.setMember_id(result.getContestant_id());
	        dto.setMember_name(result.getContestant_name());
	        dto.setRole(result.getRole());
	        dto.setVotes(result.getCandidate_votes());
	        dto.setElections(elections);
	        dto.setElection_date(elections.getElection_date());
	        dto.setTotal_votes(elections.getVoters_count());
	        
	        resultList.add(dto);
	        
	        resultsRepository.saveAll(resultList);
	    }
	}		

	@Override
	public List<ResultsDto> declareResults(int eleid) {
		
		List<Results> results = resultsRepository.findByElectionID(eleid);
		
		List<ResultsDto> dtolist = new ArrayList<>();
		
		for(Results result : results)
		{
		ResultsDto dto = new ResultsDto();
		
		dto.setSno(result.getSno());
		dto.setBallot_id(result.getBallot_id());
		dto.setElection_date(result.getElection_date());
		dto.setMember_id(result.getMember_id());
		dto.setMember_name(result.getMember_name());
		dto.setResult_id(result.getResult_id());
		dto.setRole(result.getRole());
		dto.setTotal_votes(result.getTotal_votes());
		dto.setVotes(result.getVotes());
		dto.setElection_id(eleid);
		dtolist.add(dto);
		}
		return dtolist;
	}

	@Override
	public List<ResultsDto> declareAllResults() {
		
		List<Results> results = resultsRepository.findAll();
		
		Elections election;

		List<ResultsDto> dtolist = new ArrayList<>();
		
		for(Results result : results)
		{
		ResultsDto dto = new ResultsDto();
		
		election = result.getElections();
		
		dto.setSno(result.getSno());
		dto.setBallot_id(result.getBallot_id());
		dto.setElection_date(result.getElection_date());
		dto.setMember_id(result.getMember_id());
		dto.setMember_name(result.getMember_name());
		dto.setResult_id(result.getResult_id());
		dto.setRole(result.getRole());
		dto.setTotal_votes(result.getTotal_votes());
		dto.setVotes(result.getVotes());
		dto.setElection_id(election.getElection_id());
		dtolist.add(dto);
		}
		return dtolist;

	}

}
