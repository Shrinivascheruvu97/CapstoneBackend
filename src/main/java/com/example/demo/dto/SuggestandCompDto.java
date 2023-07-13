package com.example.demo.dto;

import com.example.demo.entity.Members;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


public class SuggestandCompDto {

	private Integer id;	
	private String description;
	private String message;
	private String status;
	private Integer userId;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
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
		return "SuggestandCompDto [id=" + id + ", description=" + description + ", message=" + message + ", status="
				+ status + ", userId=" + userId + "]";
	}
	public SuggestandCompDto(Integer id, String description, String message, String status, Integer userId) {
		super();
		this.id = id;
		this.description = description;
		this.message = message;
		this.status = status;
		this.userId = userId;
	}
	public SuggestandCompDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	
	
	
}
