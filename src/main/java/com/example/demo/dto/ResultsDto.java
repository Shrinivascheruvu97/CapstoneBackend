package com.example.demo.dto;

import java.time.LocalDate;

import com.example.demo.entity.Ballot_Box;
import com.example.demo.entity.Elections;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


public class ResultsDto {

	private Integer sno;
	
	private Integer result_id;
	
	private Integer election_id;
	
	private LocalDate election_date;
	
	private Integer ballot_id;
	
	private Integer member_id;
	
	private String member_name;
	
	private String role;
	
	private Integer votes;
	
	private Integer total_votes;

	public Integer getSno() {
		return sno;
	}

	public void setSno(Integer sno) {
		this.sno = sno;
	}

	public Integer getResult_id() {
		return result_id;
	}

	public void setResult_id(Integer result_id) {
		this.result_id = result_id;
	}

	public Integer getElection_id() {
		return election_id;
	}

	public void setElection_id(Integer election_id) {
		this.election_id = election_id;
	}

	public LocalDate getElection_date() {
		return election_date;
	}

	public void setElection_date(LocalDate election_date) {
		this.election_date = election_date;
	}

	public Integer getBallot_id() {
		return ballot_id;
	}

	public void setBallot_id(Integer ballot_id) {
		this.ballot_id = ballot_id;
	}

	public Integer getMember_id() {
		return member_id;
	}

	public void setMember_id(Integer member_id) {
		this.member_id = member_id;
	}

	public String getMember_name() {
		return member_name;
	}

	public void setMember_name(String member_name) {
		this.member_name = member_name;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Integer getVotes() {
		return votes;
	}

	public void setVotes(Integer votes) {
		this.votes = votes;
	}

	public Integer getTotal_votes() {
		return total_votes;
	}

	public void setTotal_votes(Integer total_votes) {
		this.total_votes = total_votes;
	}

	@Override
	public String toString() {
		return "ResultsDto [sno=" + sno + ", result_id=" + result_id + ", election_id=" + election_id
				+ ", election_date=" + election_date + ", ballot_id=" + ballot_id + ", member_id=" + member_id
				+ ", member_name=" + member_name + ", role=" + role + ", votes=" + votes + ", total_votes="
				+ total_votes + "]";
	}

	public ResultsDto(Integer sno, Integer result_id, Integer election_id, LocalDate election_date, Integer ballot_id,
			Integer member_id, String member_name, String role, Integer votes, Integer total_votes) {
		super();
		this.sno = sno;
		this.result_id = result_id;
		this.election_id = election_id;
		this.election_date = election_date;
		this.ballot_id = ballot_id;
		this.member_id = member_id;
		this.member_name = member_name;
		this.role = role;
		this.votes = votes;
		this.total_votes = total_votes;
	}

	public ResultsDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
