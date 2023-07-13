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

public class Polls {
	
	@Id
	private Integer sno;

	private Integer polls_id;
	
	@ManyToOne
	@JoinColumn(name="election_id")
	private Elections elections;
	
	private Integer voter_id;
	
	private String voter_name;
	
	private Integer president_id;
	
	private String president_name;
	
	private Integer secretary_id;
	
	private String secretary_name;
	
	private Integer treasurer_id;
	
	private String treasusre_name;

	public Integer getSno() {
		return sno;
	}

	public void setSno(Integer sno) {
		this.sno = sno;
	}

	public Integer getPolls_id() {
		return polls_id;
	}

	public void setPolls_id(Integer polls_id) {
		this.polls_id = polls_id;
	}

	public Elections getElections() {
		return elections;
	}

	public void setElections(Elections elections) {
		this.elections = elections;
	}

	public Integer getVoter_id() {
		return voter_id;
	}

	public void setVoter_id(Integer voter_id) {
		this.voter_id = voter_id;
	}

	public String getVoter_name() {
		return voter_name;
	}

	public void setVoter_name(String voter_name) {
		this.voter_name = voter_name;
	}

	public Integer getPresident_id() {
		return president_id;
	}

	public void setPresident_id(Integer president_id) {
		this.president_id = president_id;
	}

	public String getPresident_name() {
		return president_name;
	}

	public void setPresident_name(String president_name) {
		this.president_name = president_name;
	}

	public Integer getSecretary_id() {
		return secretary_id;
	}

	public void setSecretary_id(Integer secretary_id) {
		this.secretary_id = secretary_id;
	}

	public String getSecretary_name() {
		return secretary_name;
	}

	public void setSecretary_name(String secretary_name) {
		this.secretary_name = secretary_name;
	}

	public Integer getTreasurer_id() {
		return treasurer_id;
	}

	public void setTreasurer_id(Integer treasurer_id) {
		this.treasurer_id = treasurer_id;
	}

	public String getTreasusre_name() {
		return treasusre_name;
	}

	public void setTreasusre_name(String treasusre_name) {
		this.treasusre_name = treasusre_name;
	}

	@Override
	public String toString() {
		return "Polls [sno=" + sno + ", polls_id=" + polls_id + ", elections=" + elections + ", voter_id=" + voter_id
				+ ", voter_name=" + voter_name + ", president_id=" + president_id + ", president_name=" + president_name
				+ ", secretary_id=" + secretary_id + ", secretary_name=" + secretary_name + ", treasurer_id="
				+ treasurer_id + ", treasusre_name=" + treasusre_name + "]";
	}

	public Polls(Integer sno, Integer polls_id, Elections elections, Integer voter_id, String voter_name,
			Integer president_id, String president_name, Integer secretary_id, String secretary_name,
			Integer treasurer_id, String treasusre_name) {
		super();
		this.sno = sno;
		this.polls_id = polls_id;
		this.elections = elections;
		this.voter_id = voter_id;
		this.voter_name = voter_name;
		this.president_id = president_id;
		this.president_name = president_name;
		this.secretary_id = secretary_id;
		this.secretary_name = secretary_name;
		this.treasurer_id = treasurer_id;
		this.treasusre_name = treasusre_name;
	}

	public Polls() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	
	
	
	
	
	
}
