package com.example.demo.repositroy;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Events;
import com.example.demo.entity.Remainders;

public interface EventsRepository extends JpaRepository<Events, Integer> {

	List<Events> findByFromDateAndToDate(LocalDateTime localDateTime, LocalDateTime localDateTime2);
	
	List<Events> findByMembersUserId(int userId);

	List<Events> findByFromDate(LocalDateTime fromDate);
	
}
