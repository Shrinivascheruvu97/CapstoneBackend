package com.example.demo.dto;

import java.time.LocalDate;

import com.example.demo.entity.Members;

import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


public class AccountsDto {

    private Long id;

    private int month;

    private Integer userId;

    private int maintenanceBill;

    private int waterBill;

    private int eventsBill;

    private int extras;

    private int total;

    private String status;

    private LocalDate paidOn;

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

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
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

	@Override
	public String toString() {
		return "AccountsDto [id=" + id + ", month=" + month + ", userId=" + userId + ", maintenanceBill="
				+ maintenanceBill + ", waterBill=" + waterBill + ", eventsBill=" + eventsBill + ", extras=" + extras
				+ ", total=" + total + ", status=" + status + ", paidOn=" + paidOn + "]";
	}

	public AccountsDto(Long id, int month, Integer userId, int maintenanceBill, int waterBill, int eventsBill,
			int extras, int total, String status, LocalDate paidOn) {
		super();
		this.id = id;
		this.month = month;
		this.userId = userId;
		this.maintenanceBill = maintenanceBill;
		this.waterBill = waterBill;
		this.eventsBill = eventsBill;
		this.extras = extras;
		this.total = total;
		this.status = status;
		this.paidOn = paidOn;
	}

	public AccountsDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	
    
    
    
    
}
