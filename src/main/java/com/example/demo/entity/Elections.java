package com.example.demo.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity

public class Elections {

	@Id
	@Column(nullable=false,unique=true)
	private Integer election_id;
	
	@Column(name="event_date")
	private LocalDate election_date;
	
	private Integer voters_count;
	
	private Integer president_contestants_count;
	
	private Integer secretary_contestants_count;
	
	private Integer treasurer_contestants_count;

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

	public Integer getVoters_count() {
		return voters_count;
	}

	public void setVoters_count(Integer voters_count) {
		this.voters_count = voters_count;
	}

	public Integer getPresident_contestants_count() {
		return president_contestants_count;
	}

	public void setPresident_contestants_count(Integer president_contestants_count) {
		this.president_contestants_count = president_contestants_count;
	}

	public Integer getSecretary_contestants_count() {
		return secretary_contestants_count;
	}

	public void setSecretary_contestants_count(Integer secretary_contestants_count) {
		this.secretary_contestants_count = secretary_contestants_count;
	}

	public Integer getTreasurer_contestants_count() {
		return treasurer_contestants_count;
	}

	public void setTreasurer_contestants_count(Integer treasurer_contestants_count) {
		this.treasurer_contestants_count = treasurer_contestants_count;
	}

	@Override
	public String toString() {
		return "Elections [election_id=" + election_id + ", election_date=" + election_date + ", voters_count="
				+ voters_count + ", president_contestants_count=" + president_contestants_count
				+ ", secretary_contestants_count=" + secretary_contestants_count + ", treasurer_contestants_count="
				+ treasurer_contestants_count + "]";
	}

	public Elections(Integer election_id, LocalDate election_date, Integer voters_count,
			Integer president_contestants_count, Integer secretary_contestants_count,
			Integer treasurer_contestants_count) {
		super();
		this.election_id = election_id;
		this.election_date = election_date;
		this.voters_count = voters_count;
		this.president_contestants_count = president_contestants_count;
		this.secretary_contestants_count = secretary_contestants_count;
		this.treasurer_contestants_count = treasurer_contestants_count;
	}

	public Elections() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
}
