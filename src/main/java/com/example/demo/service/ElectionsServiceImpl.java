package com.example.demo.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Ballot_Box;
import com.example.demo.entity.Bills;
import com.example.demo.entity.Elections;
import com.example.demo.entity.Members;
import com.example.demo.repositroy.BallotBoxRepository;
import com.example.demo.repositroy.ElectionsRepository;
import com.example.demo.repositroy.PollsRepository;
import com.example.demo.repositroy.ResultsRepository;
import com.example.demo.utility.ElectionIDGenerator;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ElectionsServiceImpl implements ElectionsService {

	@Autowired
	ElectionsRepository electionsRepository;
	
	@Autowired
	BallotBoxRepository ballotBoxRepository;
	
	@Autowired
	PollsRepository pollsRepository;
	
	@Autowired
	ResultsRepository resultsRepository;
	
	@Autowired
	ElectionIDGenerator electionIDGenerator;
	
	@Autowired
	MembersService memberService;
	
	@Override
	public Elections addElection(LocalDate election) {
		
		Elections elections1 = new Elections();
		int count = electionsRepository.countByElectionDate(election);
		
		if(count < 1) {
			
		int electionid = electionIDGenerator.getNextId();
		elections1.setElection_id(electionid);
		elections1.setElection_date(election);
		long voterscount = memberService.membersCount();
		elections1.setVoters_count((int)voterscount);
		electionsRepository.save(elections1);
		return elections1;
		}
		
		return elections1;
		}
		
		
	

	@Override
	public void deleteElection(int election_id) {
		
		Elections election = electionsRepository.findById(election_id).get();
		if(election.getElection_id() == election_id)
		{
			electionsRepository.deleteById(election_id);
			ballotBoxRepository.deleteByElectionId(election_id);
			pollsRepository.deleteByElectionId(election_id);
			resultsRepository.deleteByElectionId(election_id);			
		}	
	}
	
	@Override
	public void updateElection(int eleid,int president, int srecaratary, int treasurer)
	{
		
		
		Elections election = electionsRepository.findById(eleid).get();
		if(election.getElection_id() == eleid)
		{
			election.setPresident_contestants_count(president);
			election.setSecretary_contestants_count(srecaratary);
			election.setTreasurer_contestants_count(treasurer);
		}
	}

	@Override
	public List<Elections> allElections() {
		
		List<Elections> allelections = electionsRepository.findAll();
		
		return allelections;
	}

	@Override
	public Elections oneElectionBYId(int election_id) {
		
		Elections oneelection = electionsRepository.findById(election_id).get();
		
		return oneelection;
	}

}
