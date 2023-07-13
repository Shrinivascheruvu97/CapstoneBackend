package com.example.demo.repositroy;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.Members;
import com.example.demo.entity.SuggestionsAndCompliants;

public interface SuggestandCompRepository extends JpaRepository<SuggestionsAndCompliants, Integer> {

	@Query("SELECT id FROM SuggestionsAndCompliants ORDER BY id DESC LIMIT 1")
	Integer findMax_Id();

	Optional<SuggestionsAndCompliants> findById(Long id);
}
