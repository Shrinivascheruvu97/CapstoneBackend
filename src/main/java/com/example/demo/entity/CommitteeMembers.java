package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Entity
public class CommitteeMembers {
    @Id
    @Column(name="cmId",nullable=false,unique=true)
    private Integer cmId;

    private String role;

    @ManyToOne
    @JoinColumn(name="userId")
    @JsonBackReference
    private Members members;

	public Integer getCmId() {
		return cmId;
	}

	public void setCmId(Integer cmId) {
		this.cmId = cmId;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Members getMembers() {
		return members;
	}

	public void setMembers(Members members) {
		this.members = members;
	}

	@Override
	public String toString() {
		return "CommitteeMembers [cmId=" + cmId + ", role=" + role + ", members=" + members + "]";
	}

	public CommitteeMembers(Integer cmId, String role, Members members) {
		super();
		this.cmId = cmId;
		this.role = role;
		this.members = members;
	}

	public CommitteeMembers() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    
    

}