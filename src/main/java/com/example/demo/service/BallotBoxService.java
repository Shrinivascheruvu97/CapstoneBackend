package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.Ballot_BoxDto;

public interface BallotBoxService {
	
	Ballot_BoxDto addBallot(Ballot_BoxDto ballotbox);
	List<Ballot_BoxDto> getallBallots();
	List<Ballot_BoxDto> getBallotByID(int ballot_id);
	void postData(int eleid);
	void fetchData(int ele_id);
}
