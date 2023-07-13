package com.example.demo.repositroy;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.dto.RemaindersDto;
import com.example.demo.entity.Remainders;

public interface RemaindersRepository extends JpaRepository<Remainders, Integer>{

	List<Remainders> findByMembersUserId(int userId);
	
	 
}
