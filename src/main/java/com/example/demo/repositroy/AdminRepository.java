package com.example.demo.repositroy;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.Admin;

public interface AdminRepository extends JpaRepository<Admin, Integer>{

	@Query("SELECT a FROM Admin a WHERE a.email = :email")
	public Admin findByEmail(String email);
	
}
