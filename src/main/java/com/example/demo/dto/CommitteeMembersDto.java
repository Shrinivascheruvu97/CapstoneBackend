package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


public class CommitteeMembersDto {

	  private Integer cmId;

	    private String role;

	    private Integer userId;

		public Integer getCmId() {
			return cmId;
		}

		public void setCmId(Integer cmId) {
			this.cmId = cmId;
		}

		public String getRole() {
			return role;
		}

		public void setRole(String role) {
			this.role = role;
		}

		public Integer getUserId() {
			return userId;
		}

		public void setUserId(Integer userId) {
			this.userId = userId;
		}

		@Override
		public String toString() {
			return "CommitteeMembersDto [cmId=" + cmId + ", role=" + role + ", userId=" + userId + "]";
		}

		public CommitteeMembersDto(Integer cmId, String role, Integer userId) {
			super();
			this.cmId = cmId;
			this.role = role;
			this.userId = userId;
		}

		public CommitteeMembersDto() {
			super();
			// TODO Auto-generated constructor stub
		}	 
	    
	    
	    
	    
	    
}
