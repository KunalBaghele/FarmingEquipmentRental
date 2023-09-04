package com.farmequipmentrental.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Booking {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int advance;
	@JsonFormat(pattern="yyyy-MM-dd")
	private LocalDate fromdate;
	@JsonFormat(pattern="yyyy-MM-dd")
	private LocalDate todate;
	private String message;
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private LocalDateTime bookingdate;
	private String status;
	private int billamount;
	@ManyToOne
	@JoinColumn(name="variant_id")
	private Variant variant;
	@ManyToOne
	@JoinColumn(name="customer_id")
	private Customer customer;
	@ManyToOne
	@JoinColumn(name="equipment_id")
	private Equipment equipment;
	public Booking() {
		this.status="Pending";
		this.bookingdate=LocalDateTime.now();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAdvance() {
		return advance;
	}
	public void setAdvance(int advance) {
		this.advance = advance;
	}
	public LocalDate getFromdate() {
		return fromdate;
	}
	public void setFromdate(LocalDate fromdate) {
		this.fromdate = fromdate;
	}
	public LocalDate getTodate() {
		return todate;
	}
	public void setTodate(LocalDate todate) {
		this.todate = todate;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public LocalDateTime getBookingdate() {
		return bookingdate;
	}
	public void setBookingdate(LocalDateTime bookingdate) {
		this.bookingdate = bookingdate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getBillamount() {
		return billamount;
	}
	public void setBillamount(int billamount) {
		this.billamount = billamount;
	}
	public Variant getVariant() {
		return variant;
	}
	public void setVariant(Variant variant) {
		this.variant = variant;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Equipment getEquipment() {
		return equipment;
	}
	public void setEquipment(Equipment equipment) {
		this.equipment = equipment;
	}
	@Override
	public String toString() {
		return "Booking [id=" + id + ", advance=" + advance + ", fromdate=" + fromdate + ", todate=" + todate
				+ ", message=" + message + ", bookingdate=" + bookingdate + ", status=" + status + ", billamount="
				+ billamount + ", variant=" + variant + ", customer=" + customer + ", bike=" + equipment + "]";
	}
	
	
}
