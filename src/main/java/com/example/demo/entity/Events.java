package com.example.demo.entity;

 

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

 

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

 

@Entity
public class Events {
	
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="eventId",nullable=false,unique=true)
    private int  eventId;
    private String eventName;
    private LocalDateTime fromDate;
    private LocalDateTime toDate;
    private String status;

    @ManyToOne
    @JoinColumn(name="userId")
    private Members members;

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

	public LocalDateTime getFromDate() {
		return fromDate;
	}

	public void setFromDate(LocalDateTime fromDate) {
		this.fromDate = fromDate;
	}

	public LocalDateTime getToDate() {
		return toDate;
	}

	public void setToDate(LocalDateTime toDate) {
		this.toDate = toDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Members getMembers() {
		return members;
	}

	public void setMembers(Members members) {
		this.members = members;
	}

	@Override
	public String toString() {
		return "Events [eventId=" + eventId + ", eventName=" + eventName + ", fromDate=" + fromDate + ", toDate="
				+ toDate + ", status=" + status + ", members=" + members + "]";
	}

	public Events(int eventId, String eventName, LocalDateTime fromDate, LocalDateTime toDate, String status, Members members) {
		super();
		this.eventId = eventId;
		this.eventName = eventName;
		this.fromDate = fromDate;
		this.toDate = toDate;
		this.status = status;
		this.members = members;
	}

	public Events() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    
    
    
    
    
    
    
    
    
    
    

}