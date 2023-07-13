package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


public class BillsDto {

	private Integer billId;
	private String eventName;
	private Integer noOfDays;
	private Integer billAmount;
	private Integer userId;
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
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	@Override
	public String toString() {
		return "BillsDto [billId=" + billId + ", eventName=" + eventName + ", noOfDays=" + noOfDays + ", billAmount="
				+ billAmount + ", userId=" + userId + "]";
	}
	public BillsDto(Integer billId, String eventName, Integer noOfDays, Integer billAmount, Integer userId) {
		super();
		this.billId = billId;
		this.eventName = eventName;
		this.noOfDays = noOfDays;
		this.billAmount = billAmount;
		this.userId = userId;
	}
	public BillsDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
