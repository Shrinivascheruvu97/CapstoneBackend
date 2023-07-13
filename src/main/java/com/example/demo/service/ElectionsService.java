package com.example.demo.service;

import java.time.LocalDate;
import java.util.List;

import com.example.demo.entity.Elections;

public interface ElectionsService {

	Elections addElection(LocalDate election);
	void deleteElection(int election_id);
	List<Elections> allElections();
	Elections oneElectionBYId(int election_id);
	void updateElection(int eleid,int pres, int srec, int tres);
}
