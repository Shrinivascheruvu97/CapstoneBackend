package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
public class Bills {

	@Id
	@Column(name="billid",nullable=false,unique=true)
	private Integer billId;
	private String eventName;
	private Integer noOfDays;
	private Integer billAmount;
	
	@ManyToOne
	@JoinColumn(name="userId")
	private Members members;

	public Integer getBillId() {
		return billId;
	}

	public void setBillId(Integer billId) {
		this.billId = billId;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public Integer getNoOfDays() {
		return noOfDays;
	}

	public void setNoOfDays(Integer noOfDays) {
		this.noOfDays = noOfDays;
	}

	public Integer getBillAmount() {
		return billAmount;
	}

	public void setBillAmount(Integer billAmount) {
		this.billAmount = billAmount;
	}

	public Members getMembers() {
		return members;
	}

	public void setMembers(Members members) {
		this.members = members;
	}

	@Override
	public String toString() {
		return "Bills [billId=" + billId + ", eventName=" + eventName + ", noOfDays=" + noOfDays + ", billAmount="
				+ billAmount + ", members=" + members + "]";
	}

	public Bills(Integer billId, String eventName, Integer noOfDays, Integer billAmount, Members members) {
		super();
		this.billId = billId;
		this.eventName = eventName;
		this.noOfDays = noOfDays;
		this.billAmount = billAmount;
		this.members = members;
	}

	public Bills() {
		super();
		// TODO Auto-generated constructor stub
	}	
	
	
	
	
	
	
	
	
	
}
