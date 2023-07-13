package com.example.demo.repositroy;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.CommitteeMembers;

public interface CommitteeMembersRepository extends JpaRepository<CommitteeMembers, Integer> {

}
