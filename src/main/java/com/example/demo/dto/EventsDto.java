package com.example.demo.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

public class EventsDto {

	private int  eventId;
    private String eventName;
    private LocalDate fromDate;
    private LocalDate toDate;
    private String status;
    private Integer userId;
	public int getEventId() {
		return eventId;
	}
	public void setEventId(int eventId) {
		this.eventId = eventId;
	}
	public String getEventName() {
		return eventName;
	}
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
	public LocalDate getFromDate() {
		return fromDate;
	}
	public void setFromDate(LocalDate fromDate) {
		this.fromDate = fromDate;
	}
	public LocalDate getToDate() {
		return toDate;
	}
	public void setToDate(LocalDate toDate) {
		this.toDate = toDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	@Override
	public String toString() {
		return "EventsDto [eventId=" + eventId + ", eventName=" + eventName + ", fromDate=" + fromDate + ", toDate="
				+ toDate + ", status=" + status + ", userId=" + userId + "]";
	}
	public EventsDto(int eventId, String eventName, LocalDate fromDate, LocalDate toDate, String status,
			Integer userId) {
		super();
		this.eventId = eventId;
		this.eventName = eventName;
		this.fromDate = fromDate;
		this.toDate = toDate;
		this.status = status;
		this.userId = userId;
	}
	public EventsDto() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    
    	
}
