package com.example.demo.repositroy;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.Bills;

public interface BillsRepository extends JpaRepository<Bills, Integer>{

	@Query("SELECT billId FROM Bills ORDER BY billId DESC LIMIT 1")
	Integer findMaxBill_Id();
}
