package com.example.demo.entity;

import java.time.LocalDateTime;
import java.util.Arrays;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;

@Entity
@Table(name = "notices")
public class Notice {
	
	
	 @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    private Long id;

	    private String heading;

	    private String notice;

	    

	    @Column(name = "date_issued")
	    private LocalDateTime dateIssued;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getHeading() {
			return heading;
		}

		public void setHeading(String heading) {
			this.heading = heading;
		}

		public String getNotice() {
			return notice;
		}

		public void setNotice(String notice) {
			this.notice = notice;
		}

		

		

		public LocalDateTime getDateIssued() {
			return dateIssued;
		}

		public void setDateIssued(LocalDateTime dateIssued) {
			this.dateIssued = dateIssued;
		}

		@Override
		public String toString() {
			return "Notice [id=" + id + ", heading=" + heading + ", notice=" + notice + ", document="
					 + ", dateIssued=" + dateIssued + "]";
		}

		public Notice(Long id, String heading, String notice, LocalDateTime dateIssued) {
			super();
			this.id = id;
			this.heading = heading;
			this.notice = notice;
			
			this.dateIssued = dateIssued;
		}

		public Notice() {
			super();
			// TODO Auto-generated constructor stub
		}

		
	    
	    
	    
	    

}
