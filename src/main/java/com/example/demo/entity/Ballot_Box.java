package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity

public class Ballot_Box {
	
	@Id
	private Integer sno;

	private Integer ballot_id;
	
	@ManyToOne
	@JoinColumn(name="election_id")
	private Elections elections;
	
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

	public Elections getElections() {
		return elections;
	}

	public void setElections(Elections elections) {
		this.elections = elections;
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
		return "Ballot_Box [sno=" + sno + ", ballot_id=" + ballot_id + ", elections=" + elections + ", contestant_id="
				+ contestant_id + ", contestant_name=" + contestant_name + ", role=" + role + ", candidate_votes="
				+ candidate_votes + "]";
	}

	public Ballot_Box(Integer sno, Integer ballot_id, Elections elections, Integer contestant_id,
			String contestant_name, String role, Integer candidate_votes) {
		super();
		this.sno = sno;
		this.ballot_id = ballot_id;
		this.elections = elections;
		this.contestant_id = contestant_id;
		this.contestant_name = contestant_name;
		this.role = role;
		this.candidate_votes = candidate_votes;
	}

	public Ballot_Box() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
