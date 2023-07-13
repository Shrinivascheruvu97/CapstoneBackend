package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


public class RemaindersDto {

	private int remainderId;

    private String title;

    private String description;

    private Integer userId;

	public int getRemainderId() {
		return remainderId;
	}

	public void setRemainderId(int remainderId) {
		this.remainderId = remainderId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "RemaindersDto [remainderId=" + remainderId + ", title=" + title + ", description=" + description
				+ ", userId=" + userId + "]";
	}

	public RemaindersDto(int remainderId, String title, String description, Integer userId) {
		super();
		this.remainderId = remainderId;
		this.title = title;
		this.description = description;
		this.userId = userId;
	}

	public RemaindersDto() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    
    
    
    
    
    
	
}
