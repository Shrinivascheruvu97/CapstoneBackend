package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Members {
 
	
	@Id
	private Integer userId;
	
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private Long mobileNo;
	private Integer flatNo;
	private String role;
	
	@Override
	public String toString() {
		return "Members [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", password=" + password + ", mobileNo=" + mobileNo + ", flatNo=" + flatNo + ", role=" + role + "]";
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Long getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(Long mobileNo) {
		this.mobileNo = mobileNo;
	}
	public Integer getFlatNo() {
		return flatNo;
	}
	public void setFlatNo(Integer flatNo) {
		this.flatNo = flatNo;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public Members(Integer userId, String firstName, String lastName, String email, String password, Long mobileNo,
			Integer flatNo, String role) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.mobileNo = mobileNo;
		this.flatNo = flatNo;
		this.role = role;
	}
	public Members() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
}