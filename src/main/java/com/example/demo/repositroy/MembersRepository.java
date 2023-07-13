
//package com.example.demo.repositroy;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//
//import com.example.demo.entity.Members;
//
//public interface MembersRepository extends JpaRepository<Members, Integer> {
//
//	
//	Members findByUserId(Integer userId);
//	@Query("SELECT userId FROM Members ORDER BY userId DESC LIMIT 1")
//	Integer findMax_Id();
//	
//	@Query("SELECT a FROM Members a WHERE a.email = :email")
//	public Members findByEmail(String email);
//	
//	@Query("SELECT f FROM Members f WHERE f.flatNo = :flatNo")
//	public Members findByFlatNo(Integer flatNo);
//}




package com.example.demo.repositroy;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.Admin;
import com.example.demo.entity.Members;

public interface MembersRepository extends JpaRepository<Members, Integer> {

	
	Members findByUserId(Integer userId);
	
	@Query("SELECT userId FROM Members ORDER BY userId DESC LIMIT 1")
	Integer findMax_Id();
	
	@Query("SELECT a FROM Members a WHERE a.email = :email")
	public Members findByEmail(String email);
	
	@Query("SELECT f FROM Members f WHERE f.flatNo = :flatNo")
	public Members findByFlatNo(Integer flatNo);
	
	@Modifying
    @Query("DELETE FROM Members m WHERE m.userId IN :userIds")
    void deleteByIds(@Param("userId") List<Integer> userId);
}