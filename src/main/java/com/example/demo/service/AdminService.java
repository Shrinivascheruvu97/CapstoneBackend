//package com.example.demo.service;
//
//import java.util.List;
//
//import com.example.demo.dto.CommitteeMembersDto;
//import com.example.demo.entity.Members;
//
//public interface AdminService {
//
//	// Adding members and updating members
//    Members addMember(Members members);
//    Members deleteMember(Integer userId);
//    Members updateMember(Members members);
//    List<Members> updateMembers(List<Members> membersList);
//    List<Members> getAllMembers();
//
//   // Adding committee members 
//    List<CommitteeMembersDto> getAllCommitteeMembers();
//    CommitteeMembersDto addCommitteeMember(CommitteeMembersDto committeeMembersDto);
//    void updateCommitteeMember(Integer cmId, CommitteeMembersDto committeeMembersDto);
//    void deleteCommitteeMember(Integer cmId);
//}

package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.CommitteeMembersDto;
import com.example.demo.entity.Admin;
import com.example.demo.entity.Members;

public interface AdminService {

	// Adding members and updating members
    Members addMember(Members members);
    Members deleteMember(Integer userId);
    List<Members> deleteMembers(List<Integer> ids);
    Members updateMember(Members members,int id);
    List<Members> updateMembers(List<Members> membersList);
    List<Members> getAllMembers();

   // Adding committee members 
    List<CommitteeMembersDto> getAllCommitteeMembers();
    CommitteeMembersDto addCommitteeMember(CommitteeMembersDto committeeMembersDto);
    void updateCommitteeMember(Integer cmId, CommitteeMembersDto committeeMembersDto);
    void deleteCommitteeMember(Integer cmId);
    Admin validateAdmin(Admin admin);
}