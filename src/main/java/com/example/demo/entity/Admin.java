package com.example.demo.entity;

import jakarta.persistence.Column;

import jakarta.persistence.Entity;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Entity
public class Admin {

    @Id
    @Column(name="id",nullable=false,unique=true)
    private Integer id;
    
    @Column(name="email",nullable=false,unique = true)
    private String email;

    @Column(name="password",nullable=false)
    private String password;

    @Column(name="role",nullable=false)
    private String role;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "Admin [id=" + id + ", email=" + email + ", password=" + password + ", role=" + role + "]";
	}

	public Admin(Integer id, String email, String password, String role) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.role = role;
	}

	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    
    
    
    
}
