package com.example.demo.entity;

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
public class Remainders {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int remainderId;
    private String title;
    private String description;

    @ManyToOne
    @JoinColumn(name="userId")
    private Members members;

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

	public Members getMembers() {
		return members;
	}

	public void setMembers(Members members) {
		this.members = members;
	}

	@Override
	public String toString() {
		return "Remainders [remainderId=" + remainderId + ", title=" + title + ", description=" + description
				+ ", members=" + members + "]";
	}

	public Remainders(int remainderId, String title, String description, Members members) {
		super();
		this.remainderId = remainderId;
		this.title = title;
		this.description = description;
		this.members = members;
	}

	public Remainders() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    

	
    
    
    
    
   
}