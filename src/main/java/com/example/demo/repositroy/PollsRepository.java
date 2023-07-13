package com.example.demo.repositroy;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.Polls;

import jakarta.persistence.Column;
import jakarta.transaction.Transactional;

public interface PollsRepository extends JpaRepository<Polls, Integer>{
	
	@Transactional
    @Modifying
    @Query("DELETE FROM Polls p WHERE p.elections.election_id = :election_id")
	void deleteByElectionId(Integer election_id);
	
	@Query("SELECT polls_id FROM Polls ORDER BY polls_id DESC LIMIT 1")
	Integer findMax_Id();
	
	@Query("SELECT p FROM Polls p WHERE p.voter_id = :voter_id AND p.elections.election_id = :election_id")
	Polls findByVoterId(Integer voter_id, Integer election_id);
	
	@Query("SELECT sno FROM Polls ORDER BY sno DESC LIMIT 1")
	Integer findMax_SNO();
	
	@Query("SELECT elections.election_id FROM Polls ORDER BY polls_id DESC LIMIT 1")
	Integer lastElectionID();
	
	@Query("SELECT polls_id FROM Polls ORDER BY polls_id DESC LIMIT 1")
	Integer lastPollID();
	
//	@Query("SELECT COUNT(p) FROM Polls p WHERE p.president_id = :president_id AND p.elections.election_id = :election_id")
//    Integer countByPresidendId(Integer president_id, Integer election_id);
//
//	@Query("SELECT COUNT(s) FROM Polls s WHERE s.secretary_id = :secretary_id AND s.elections.election_id = :election_id")
//    Integer countBySecretaryID(Integer secretary_id, Integer election_id);
//	
//	@Query("SELECT COUNT(t) FROM Polls t WHERE t.treasurer_id = :treasurer_id AND t.elections.election_id = :election_id")
//    Integer countByTreasurerID(Integer treasurer_id, Integer election_id);
	
	@Query("SELECT p.president_id, COUNT(p.president_id) FROM Polls p WHERE p.president_id IN :presidentIds AND p.elections.election_id = :electionId GROUP BY p.president_id")
    List<Object[]> getPresidentVoteCounts(@Param("presidentIds") List<Integer> presidentIds, @Param("electionId") Integer electionId);

    @Query("SELECT s.secretary_id, COUNT(s.secretary_id) FROM Polls s WHERE s.secretary_id IN :secretaryIds AND s.elections.election_id = :electionId GROUP BY s.secretary_id")
    List<Object[]> getSecretaryVoteCounts(@Param("secretaryIds") List<Integer> secretaryIds, @Param("electionId") Integer electionId);
    
    @Query("SELECT t.treasurer_id, COUNT(t.treasurer_id) FROM Polls t WHERE t.treasurer_id IN :treasurerIds AND t.elections.election_id = :electionId GROUP BY t.treasurer_id")
    List<Object[]> getTreasurerVoteCounts(@Param("treasurerIds") List<Integer> treasurerIds, @Param("electionId") Integer electionId);
     
}
