package com.example.demo.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity



public class Accounts {

	    @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    private Long id;


	    private int month;

	    @ManyToOne
	    @JoinColumn(name="userId")
	    private Members members;


	    private int maintenanceBill;


	    private int waterBill;


	    private int eventsBill;


	    private int extras;


	    private int total;


	    private String status;


	    private LocalDate paidOn;
	    



		public int calculateTotal() {
		    int total = 0;
		    
		    total += maintenanceBill;
		    total += waterBill;
		    total += eventsBill;
		    total += extras;
		    
		    return total;
		    
		    
		    
		    
		    
		}




		public Accounts() {
			super();
			// TODO Auto-generated constructor stub
		}




		public Accounts(Long id, int month, Members members, int maintenanceBill, int waterBill, int eventsBill,
				int extras, int total, String status, LocalDate paidOn) {
			super();
			this.id = id;
			this.month = month;
			this.members = members;
			this.maintenanceBill = maintenanceBill;
			this.waterBill = waterBill;
			this.eventsBill = eventsBill;
			this.extras = extras;
			this.total = total;
			this.status = status;
			this.paidOn = paidOn;
		}




		@Override
		public String toString() {
			return "Accounts [id=" + id + ", month=" + month + ", members=" + members + ", maintenanceBill="
					+ maintenanceBill + ", waterBill=" + waterBill + ", eventsBill=" + eventsBill + ", extras=" + extras
					+ ", total=" + total + ", status=" + status + ", paidOn=" + paidOn + "]";
		}




		public Long getId() {
			return id;
		}




		public void setId(Long id) {
			this.id = id;
		}




		public int getMonth() {
			return month;
		}




		public void setMonth(int month) {
			this.month = month;
		}




		public Members getMembers() {
			return members;
		}




		public void setMembers(Members members) {
			this.members = members;
		}




		public int getMaintenanceBill() {
			return maintenanceBill;
		}




		public void setMaintenanceBill(int maintenanceBill) {
			this.maintenanceBill = maintenanceBill;
		}




		public int getWaterBill() {
			return waterBill;
		}




		public void setWaterBill(int waterBill) {
			this.waterBill = waterBill;
		}




		public int getEventsBill() {
			return eventsBill;
		}




		public void setEventsBill(int eventsBill) {
			this.eventsBill = eventsBill;
		}




		public int getExtras() {
			return extras;
		}




		public void setExtras(int extras) {
			this.extras = extras;
		}




		public int getTotal() {
			return total;
		}




		public void setTotal(int total) {
			this.total = total;
		}




		public String getStatus() {
			return status;
		}




		public void setStatus(String status) {
			this.status = status;
		}




		public LocalDate getPaidOn() {
			return paidOn;
		}




		public void setPaidOn(LocalDate paidOn) {
			this.paidOn = paidOn;
		}
	}
