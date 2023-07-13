package com.example.demo.repositroy;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Ballot_Box;
import com.example.demo.entity.Elections;
import com.example.demo.entity.Results;

import jakarta.transaction.Transactional;

public interface BallotBoxRepository extends JpaRepository<Ballot_Box, Integer> {
	
	@Transactional
    @Modifying
    @Query("DELETE FROM Ballot_Box b WHERE b.elections.election_id = :election_id")
	void deleteByElectionId(Integer election_id);
	
	@Query("SELECT ballot_id FROM Ballot_Box ORDER BY ballot_id DESC LIMIT 1")
	Integer findMax_Id();
	
	@Query("SELECT b FROM Ballot_Box b WHERE b.elections.election_id = :electionId")
	List<Ballot_Box> findByIds(Integer electionId);
	
	@Query("SELECT sno FROM Ballot_Box ORDER BY sno DESC LIMIT 1")
	Integer findMax_SNO();
	
	@Query("SELECT elections.election_id FROM Ballot_Box ORDER BY ballot_id DESC LIMIT 1")
	Integer lastElectionID();
	
	@Query("SELECT ballot_id FROM Ballot_Box ORDER BY ballot_id DESC LIMIT 1")
	Integer lastBallotID();
	
	@Query("SELECT COUNT(pres) FROM Ballot_Box pres WHERE (pres.role = 'president')AND pres.elections.election_id = :id")
    Integer countPresidents(@Param("id") int id);
	
	@Query("SELECT COUNT(srec) FROM Ballot_Box srec WHERE (srec.role = 'secretary') AND srec.elections.election_id = :id")
    Integer countSecaratary(@Param("id") int id);
	
	@Query("SELECT COUNT(tres) FROM Ballot_Box tres WHERE (tres.role = 'treasurer') AND tres.elections.election_id = :id")
    Integer countTreasurer(@Param("id") int id);
	
	@Query("SELECT bb.contestant_id FROM Ballot_Box bb WHERE bb.role = :role AND bb.elections.election_id = :electionId")
    List<Integer> findContestantIdsByElectionsElectionIdAndRole(@Param("electionId") Integer electionId, @Param("role") String role);

	@Query("SELECT p.president_id AS presidentId, COUNT(p.president_id) AS repetitionCount FROM Polls p WHERE p.president_id IN (:presidentIds) AND p.elections.election_id = :electionId GROUP BY p.president_id")
    List<Map<Integer, Integer>> getPresidentVotes(@Param("presidentIds") List<Integer> presidentIds, @Param("electionId") Integer electionId);

	@Modifying
    @Query("UPDATE Ballot_Box bb SET bb.candidate_votes = :votes WHERE bb.contestant_id IN :presidentIds")
    void updateVotesByPresidentIds(@Param("votes") List<Integer> voteCounts, @Param("presidentIds") List<Integer> presidentIds);
	
	@Query("SELECT s.secretary_id AS secretaryId, COUNT(s.secretary_id) AS repetitionCount FROM Polls s WHERE s.secretary_id IN (:secretaryIds) AND s.elections.election_id = :electionId GROUP BY s.secretary_id")
    List<Map<Integer, Integer>> getSecretaryVotes(@Param("secretaryIds") List<Integer> secretaryIds, @Param("electionId") Integer electionId);
	
	@Modifying
    @Query("UPDATE Ballot_Box bb SET bb.candidate_votes = :votes WHERE bb.contestant_id IN :secretaryIds")
    void updateVotesBySecretaryIds(@Param("votes") List<Integer> voteCounts, @Param("secretaryIds") List<Integer> secretaryIds);
	 
	@Query("SELECT t.treasurer_id AS treasurerId, COUNT(t.treasurer_id) AS repetitionCount FROM Polls t WHERE t.treasurer_id IN (:treasurerIds) AND t.elections.election_id = :electionId GROUP BY t.treasurer_id")
    List<Map<Integer, Integer>> getTreasurerVotes(@Param("treasurerIds") List<Integer> treasurerIds, @Param("electionId") Integer electionId);
	
	@Modifying
    @Query("UPDATE Ballot_Box bb SET bb.candidate_votes = :votes WHERE bb.contestant_id IN :treasurerIds")
    void updateVotesByTreasurerIds(@Param("votes") List<Integer> voteCounts, @Param("treasurerIds") List<Integer> treasurerIds);
	
	@Modifying
    @Transactional
    @Query("UPDATE Ballot_Box bb SET bb.candidate_votes = :votes WHERE bb.contestant_id = :contestantId AND bb.elections.election_id = :electionId" )
    void updateCandidateVotesByContestantId(@Param("votes") Integer votes, @Param("contestantId") Integer contestantId, @Param("electionId") Integer electionId);
	
	@Query("SELECT r FROM Ballot_Box r WHERE r.elections.election_id = :eleid AND r.role = 'president' AND r.candidate_votes = (SELECT MAX(v.candidate_votes) FROM Ballot_Box v WHERE v.elections.election_id = :eleid AND v.role = 'president')")
    List<Ballot_Box> findMaxVotesByPresident(@Param("eleid") int eleid);
    
    @Query("SELECT r FROM Ballot_Box r WHERE r.elections.election_id = :eleid AND r.role = 'secretary' AND r.candidate_votes = (SELECT MAX(v.candidate_votes) FROM Ballot_Box v WHERE v.elections.election_id = :eleid AND v.role = 'secretary')")
    List<Ballot_Box> findMaxVotesBySecretary(@Param("eleid") int eleid);
    
    @Query("SELECT r FROM Ballot_Box r WHERE r.elections.election_id = :eleid AND r.role = 'treasurer' AND r.candidate_votes = (SELECT MAX(v.candidate_votes) FROM Ballot_Box v WHERE v.elections.election_id = :eleid AND v.role = 'treasurer')")
    List<Ballot_Box> findMaxVotesByTreasurer(@Param("eleid") int eleid);


}
