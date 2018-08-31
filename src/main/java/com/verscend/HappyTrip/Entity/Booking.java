package com.verscend.HappyTrip.Entity;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
@Table(name = "booking")
public class Booking {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int bookId;
	
	@Column(name = "bookedDate")
	@Temporal(TemporalType.DATE)
	private Date bookedDate;
	
	@Column(name = "startDate")
	@Temporal(TemporalType.DATE)
	private Date startDate;
	
	@Column(name = "endDate")
	@Temporal(TemporalType.DATE)
	private Date endDate;
	
	@Column(name = "bookedStatus")
	private boolean bookedStatus;
	
	@Column(name = "packageName")
	private String packageName;
	
	public Booking() {
		
	}
	
	public Booking(int bookId, Date bookedDate, Date startDate, Date endDate, boolean bookedStatus,
			String packageName) {
		super();
		this.bookId = bookId;
		this.bookedDate = bookedDate;
		this.startDate = startDate;
		this.endDate = endDate;
		this.bookedStatus = bookedStatus;
		this.packageName = packageName;
	}

	public Date getBookedDate() {
		return bookedDate;
	}
	public void setBookedDate(Date bookedDate) {
		this.bookedDate = bookedDate;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public boolean isBookedStatus() {
		return bookedStatus;
	}
	public void setBookedStatus(boolean bookedStatus) {
		this.bookedStatus = bookedStatus;
	}
	public String getPackageName() {
		return packageName;
	}
	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}
	
	
}
