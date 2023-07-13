package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


public class Ballot_BoxDto {

	private Integer sno;
	
	private Integer ballot_id;
	
	private Integer election_id;
	
	private Integer contestant_id;
	
	private String contestant_name;
	
	private String role;
	
	private Integer candidate_votes;

	public Integer getSno() {
		return sno;
	}

	public void setSno(Integer sno) {
		this.sno = sno;
	}

	public Integer getBallot_id() {
		return ballot_id;
	}

	public void setBallot_id(Integer ballot_id) {
		this.ballot_id = ballot_id;
	}

	public Integer getElection_id() {
		return election_id;
	}

	public void setElection_id(Integer election_id) {
		this.election_id = election_id;
	}

	public Integer getContestant_id() {
		return contestant_id;
	}

	public void setContestant_id(Integer contestant_id) {
		this.contestant_id = contestant_id;
	}

	public String getContestant_name() {
		return contestant_name;
	}

	public void setContestant_name(String contestant_name) {
		this.contestant_name = contestant_name;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Integer getCandidate_votes() {
		return candidate_votes;
	}

	public void setCandidate_votes(Integer candidate_votes) {
		this.candidate_votes = candidate_votes;
	}

	@Override
	public String toString() {
		return "Ballot_BoxDto [sno=" + sno + ", ballot_id=" + ballot_id + ", election_id=" + election_id
				+ ", contestant_id=" + contestant_id + ", contestant_name=" + contestant_name + ", role=" + role
				+ ", candidate_votes=" + candidate_votes + "]";
	}

	public Ballot_BoxDto(Integer sno, Integer ballot_id, Integer election_id, Integer contestant_id,
			String contestant_name, String role, Integer candidate_votes) {
		super();
		this.sno = sno;
		this.ballot_id = ballot_id;
		this.election_id = election_id;
		this.contestant_id = contestant_id;
		this.contestant_name = contestant_name;
		this.role = role;
		this.candidate_votes = candidate_votes;
	}

	public Ballot_BoxDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
