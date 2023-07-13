package com.example.demo.repositroy;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.Results;

import jakarta.transaction.Transactional;

public interface ResultsRepository extends JpaRepository<Results, Integer> {

	@Transactional
    @Modifying
    @Query("DELETE FROM Results r WHERE r.elections.election_id = :election_id")
	void deleteByElectionId(Integer election_id);
	
	@Query("SELECT result_id FROM Results ORDER BY result_id DESC LIMIT 1")
	Integer findMax_Id();
	
	@Query("SELECT sno FROM Results ORDER BY sno DESC LIMIT 1")
	Integer findMax_SNO();
	
	@Query("SELECT elections.election_id FROM Results ORDER BY result_id DESC LIMIT 1")
	Integer lastElectionID();
	
	 @Query("SELECT r FROM Results r WHERE r.elections.election_id = :electionId")
	    List<Results> findByElectionID(@Param("electionId") Integer electionId);

}
