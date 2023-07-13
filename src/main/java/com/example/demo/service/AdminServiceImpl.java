//package com.example.demo.service;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.stream.Collectors;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.ApplicationContextException;
//import org.springframework.stereotype.Service;
//
//import com.example.demo.dto.CommitteeMembersDto;
//import com.example.demo.entity.CommitteeMembers;
//import com.example.demo.entity.Members;
//import com.example.demo.repositroy.AdminRepository;
//import com.example.demo.repositroy.CommitteeMembersRepository;
//import com.example.demo.repositroy.MembersRepository;
//import com.example.demo.utility.MemberIDGenerator;
//
//@Service
//public class AdminServiceImpl implements AdminService {
//
//	@Autowired
//    private AdminRepository adminRepository;
//
//    @Autowired
//    private MembersRepository membersRepository;
//
//    @Autowired
//    private CommitteeMembersRepository committeeMembersRepository;
//    @Autowired
//    MemberIDGenerator membersIDGenerator;
//
//
// 
//
//    public AdminServiceImpl(AdminRepository adminRepository, MembersRepository memberRepository, CommitteeMembersRepository committeMembersRepository) {
//        this.adminRepository = adminRepository;
//        this.membersRepository = membersRepository;
//       this.committeeMembersRepository = committeeMembersRepository;
//    }
//
// 
//
//    @Override
//    public Members addMember(Members members) {
//    	
//    	Members member = new Members();
//    	Members mail = membersRepository.findByEmail(members.getEmail());
//    	
//    	Members flatno = membersRepository.findByFlatNo(members.getFlatNo());
//    	
//    	if(mail == null && flatno == null)
//    	{
//    	int usrid = membersIDGenerator.getNextId();
//    	members.setUserId(usrid);
//        return membersRepository.save(members);
//    	} else if(mail != null)
//    	{
//    		member.setEmail(mail.getEmail());
//    	} else
//    	{
//    		member.setFlatNo(flatno.getFlatNo());
//    	}    	
//    	 
//    	 return member;
//    }
//
// 
//
//    @Override
//    public Members deleteMember(Integer userId) {
//        Members mem = membersRepository.findByUserId(userId);
//        Members mem1 = mem;
//        if(mem != null)
//        {
//        	membersRepository.deleteById(userId);
//        	return mem1;
//        } 
//        	
//        return mem;
//        
//    }
//
// 
//
//    @Override
//    public Members updateMember(Members members) {
//        return membersRepository.save(members);
//    }
//    
//    @Override
//    public List<Members> updateMembers(List<Members> membersList) {
//        List<Members> updatedMembers = new ArrayList<>();
//        for (Members member : membersList) {
//            Members existingMember = membersRepository.findByUserId(member.getUserId());
//            if (existingMember != null) {
//                if (member.getFirstName() != null) {
//                    existingMember.setFirstName(member.getFirstName());
//                }
//                if (member.getLastName() != null) {
//                    existingMember.setLastName(member.getLastName());
//                }
//                if (member.getEmail() != null) {
//                    existingMember.setEmail(member.getEmail());
//                }
//                if (member.getPassword() != null) {
//                    existingMember.setPassword(member.getPassword());
//                }
//                if (member.getMobileNo() != null) {
//                    existingMember.setMobileNo(member.getMobileNo());
//                }
//                if (member.getFlatNo() != null) {
//                    existingMember.setFlatNo(member.getFlatNo());
//                }
//                if (member.getRole() != null) {
//                    existingMember.setRole(member.getRole());
//                }
//                System.out.println("Hiiii-->"+existingMember);
//                updatedMembers.add(membersRepository.save(existingMember));
//            }
//        }
//        return updatedMembers;
//    }
//
// 
//
//    @Override
//    public List<Members> getAllMembers() {
//        return membersRepository.findAll();
//    }
//// committee members 
//    @Override
//    public List<CommitteeMembersDto> getAllCommitteeMembers() {
//        List<CommitteeMembers> committeeMembersList = committeeMembersRepository.findAll();
//        return mapToDtoList(committeeMembersList);
//    }
//
// 
//
//    @Override
//    public CommitteeMembersDto addCommitteeMember(CommitteeMembersDto committeeMembersDto) {
//        Members members = membersRepository.findById(committeeMembersDto.getUserId())
//                .orElseThrow(() -> new ApplicationContextException("Incorrect userId"));
//
// 
//
//        CommitteeMembers committeeMember = new CommitteeMembers();
//        committeeMember.setCmId(committeeMembersDto.getCmId());
//        committeeMember.setRole(committeeMembersDto.getRole());
//        committeeMember.setMembers(members);
//
// 
//
//        CommitteeMembers savedMember = committeeMembersRepository.save(committeeMember);
//
// 
//
//        return mapToDto(savedMember);
//    }
//
//    @Override
//    public void updateCommitteeMember(Integer cmId, CommitteeMembersDto committeeMembersDto) {
//        CommitteeMembers committeeMember = committeeMembersRepository.findById(cmId)
//                .orElseThrow(() -> new ApplicationContextException("Committee member not found"));
//
// 
//
//        Members members = membersRepository.findById(committeeMembersDto.getUserId())
//                .orElseThrow(() -> new ApplicationContextException("Incorrect userId"));
//
// 
//
//        committeeMember.setCmId(committeeMembersDto.getCmId());
//        committeeMember.setRole(committeeMembersDto.getRole());
//        committeeMember.setMembers(members);
//
// 
//
//        committeeMembersRepository.save(committeeMember);
//    }
//
//    @Override
//    public void deleteCommitteeMember(Integer cmId) {
//        committeeMembersRepository.deleteById(cmId);
//    }
//
// 
//
//    private CommitteeMembersDto mapToDto(CommitteeMembers committeeMembers) {
//        CommitteeMembersDto dto = new CommitteeMembersDto();
//        dto.setCmId(committeeMembers.getCmId());
//        dto.setRole(committeeMembers.getRole());
//        dto.setUserId(committeeMembers.getMembers().getUserId());
//        return dto;
//    }
//
// 
//
//    private List<CommitteeMembersDto> mapToDtoList(List<CommitteeMembers> committeeMembersList) {
//        return committeeMembersList.stream()
//                .map(this::mapToDto)
//                .collect(Collectors.toList());
//    }
//	
//}



package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContextException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.dto.CommitteeMembersDto;
import com.example.demo.entity.Admin;
import com.example.demo.entity.CommitteeMembers;
import com.example.demo.entity.Members;
import com.example.demo.entity.Remainders;
import com.example.demo.repositroy.AdminRepository;
import com.example.demo.repositroy.CommitteeMembersRepository;
import com.example.demo.repositroy.MembersRepository;
import com.example.demo.utility.MemberIDGenerator;

import jakarta.transaction.Transactional;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
    private AdminRepository adminRepository;

    @Autowired
    private MembersRepository membersRepository;

    @Autowired
    private CommitteeMembersRepository committeeMembersRepository;
    
    @Autowired
    MemberIDGenerator membersIDGenerator;


 

    public AdminServiceImpl(AdminRepository adminRepository, MembersRepository memberRepository, CommitteeMembersRepository committeMembersRepository) {
        this.adminRepository = adminRepository;
        this.membersRepository = membersRepository;
       this.committeeMembersRepository = committeeMembersRepository;
    }

 

    @Override
    public Members addMember(Members members) {
    	
    	Members member = new Members();
    	Members mail = membersRepository.findByEmail(members.getEmail());
    	
    	Members flatno = membersRepository.findByFlatNo(members.getFlatNo());
    	
    	if(mail == null && flatno == null)
    	{
    	int usrid = membersIDGenerator.getNextId();
    	members.setUserId(usrid);
        return membersRepository.save(members);
    	} else if(mail != null)
    	{
    		member.setEmail(mail.getEmail());
    	} else
    	{
    		member.setFlatNo(flatno.getFlatNo());
    	}    	
    	 
    	 return member;
    }
 

    @Override
    public Members deleteMember(Integer userId) {
        Members mem = membersRepository.findByUserId(userId);
        Members mem1 = mem;
        if(mem != null)
        {
        	membersRepository.deleteById(userId);
        	return mem1;
        } 
        	
        return mem;   
    }

    @Override
    public List<Members> deleteMembers(List<Integer> ids) {
        List<Members> deletedMembers = new ArrayList<>();
        
        for (Integer id : ids) {
            Optional<Members> memberOptional = membersRepository.findById(id);
            
            memberOptional.ifPresent(member -> {
            	deletedMembers.add(member);
                membersRepository.delete(member);
            });
        }
        return deletedMembers;
    }

   

    @Override
    public Members updateMember(Members members1 , int id) {
    	Members members=membersRepository.findById(id).get();
    	if(members1.getFirstName() != null    || !members1.getFirstName().isEmpty())
        members.setFirstName(members1.getFirstName());
    	if(members1.getLastName() != null    || !members1.getLastName().isEmpty())
            members.setLastName(members1.getLastName());
    	if(members1.getEmail() != null    || !members1.getEmail().isEmpty())
            members.setEmail(members1.getEmail());
    	if(members1.getPassword() != null    || !members1.getPassword().isEmpty())
            members.setPassword(members1.getPassword());
    	Object var1 = members1.getMobileNo();

        if(var1 instanceof Long)

        members.setMobileNo(members1.getMobileNo());
        if(members1.getRole() != null    || !members1.getRole().isEmpty())
            members.setRole(members1.getRole());
        Object var2 = members1.getFlatNo();

        if(var2 instanceof Integer)

        members.setFlatNo(members1.getFlatNo());
    	
    	
    	return membersRepository.save(members);
    }
    
    @Override
    @Transactional
    public List<Members> updateMembers(List<Members> membersList) {
        List<Members> updatedMembers = new ArrayList<>();
        for (Members member : membersList) {
            Members existingMember = membersRepository.findByUserId(member.getUserId());
            if (existingMember != null) {
                if (member.getFirstName() != null) {
                    existingMember.setFirstName(member.getFirstName());
                }
                if (member.getLastName() != null) {
                    existingMember.setLastName(member.getLastName());
                }
                if (member.getEmail() != null) {
                    existingMember.setEmail(member.getEmail());
                }
                if (member.getPassword() != null) {
                    existingMember.setPassword(member.getPassword());
                }
                if (member.getMobileNo() != null) {
                    existingMember.setMobileNo(member.getMobileNo());
                }
                if (member.getFlatNo() != null) {
                    existingMember.setFlatNo(member.getFlatNo());
                }
                if (member.getRole() != null) {
                    existingMember.setRole(member.getRole());
                }
                updatedMembers.add(membersRepository.save(existingMember));
            }
        }
        return membersRepository.saveAll(updatedMembers);
    }



 

    @Override
    public List<Members> getAllMembers() {
        return membersRepository.findAll();
    }
// committee members 
    @Override
    public List<CommitteeMembersDto> getAllCommitteeMembers() {
        List<CommitteeMembers> committeeMembersList = committeeMembersRepository.findAll();
        return mapToDtoList(committeeMembersList);
    }

 

    @Override
    public CommitteeMembersDto addCommitteeMember(CommitteeMembersDto committeeMembersDto) {

    	Members members = membersRepository.findById(committeeMembersDto.getUserId())
				.orElseThrow(() -> new IllegalArgumentException("Invalid remainder ID"));
    	
        CommitteeMembers committeeMember = new CommitteeMembers();
        committeeMember.setCmId(committeeMembersDto.getCmId());
        committeeMember.setRole(committeeMembersDto.getRole());
        committeeMember.setMembers(members);

        CommitteeMembers savedMember = committeeMembersRepository.save(committeeMember);

 

        return mapToDto(savedMember);
    }

    @Override
    public void updateCommitteeMember(Integer cmId, CommitteeMembersDto committeeMembersDto) {
        CommitteeMembers committeeMember = committeeMembersRepository.findById(cmId)
                .orElseThrow(() -> new ApplicationContextException("Committee member not found"));

 

        Members members = membersRepository.findById(committeeMembersDto.getUserId())
                .orElseThrow(() -> new ApplicationContextException("Incorrect userId"));

 

        committeeMember.setCmId(committeeMembersDto.getCmId());
        committeeMember.setRole(committeeMembersDto.getRole());
        committeeMember.setMembers(members);

 

        committeeMembersRepository.save(committeeMember);
    }

    @Override
    public void deleteCommitteeMember(Integer cmId) {
        committeeMembersRepository.deleteById(cmId);
    }

 

    private CommitteeMembersDto mapToDto(CommitteeMembers committeeMembers) {
        CommitteeMembersDto dto = new CommitteeMembersDto();
        dto.setCmId(committeeMembers.getCmId());
        dto.setRole(committeeMembers.getRole());
        dto.setUserId(committeeMembers.getMembers().getUserId());
        return dto;
    }

 

    private List<CommitteeMembersDto> mapToDtoList(List<CommitteeMembers> committeeMembersList) {
        return committeeMembersList.stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }
    
    public Admin validateAdmin(Admin admin)
    {
    	Admin admin1 =  adminRepository.findByEmail(admin.getEmail());
    	
    	if(admin1.getEmail()!= null && !admin1.getEmail().isEmpty())
    	{  		
    		if(admin.getPassword().equalsIgnoreCase(admin1.getPassword()))
    		{
    			return admin1;
    		}
    	}
    	
    	Admin demo = new Admin();
    	
    	return demo;
    }
	
}
