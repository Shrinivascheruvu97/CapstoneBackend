package com.example.demo.repositroy;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Events;
import com.example.demo.entity.Remainders;

public interface EventsRepository extends JpaRepository<Events, Integer> {

	List<Events> findByFromDateAndToDate(LocalDate fromDate, LocalDate toDate);
	
	List<Events> findByMembersUserId(int userId);
	
}
