package com.example.demo.repositroy;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.dto.AccountsDto;
import com.example.demo.entity.Accounts;

public interface AccountsRepository extends JpaRepository<Accounts, Long>{

	List<Accounts> findByMembers_UserId(Integer userId);
	
	Optional<Accounts> findById(Long id);
	
	void deleteById(Long id);

	void save(AccountsDto accounts);

	Accounts findByMembers_userId(Integer userId);

	//List<Accounts> findByStatusNotAndMonthAndPaidOnIsNull(String string, int monthValue);

//	@Query("SELECT DISTINCT FROM Accounts  WHERE status is null")
//	List<Accounts> findByStatusNot();

	
	@Query("SELECT a FROM Accounts a WHERE a.status is null")

	List<Accounts> findByStatusNull();

//	@Query("SELECT user FROM Accounts  WHERE status is null")
//    List<Accounts> findUnpaidAccounts();


}
