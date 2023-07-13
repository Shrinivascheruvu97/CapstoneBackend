package com.example.demo.repositroy;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.Elections;

public interface ElectionsRepository extends JpaRepository<Elections, Integer> {
	
	@Query("SELECT election_id FROM Elections ORDER BY election_id DESC LIMIT 1")
	Integer findMax_Id();
	
	@Query("SELECT e FROM Elections e WHERE e.election_id = :electionId")
    Elections findByElectionId(@Param("electionId") Integer electionId);

	@Query("SELECT COUNT(e) FROM Elections e WHERE e.election_date = :electionDate")
    Integer countByElectionDate(LocalDate electionDate);
	
}
