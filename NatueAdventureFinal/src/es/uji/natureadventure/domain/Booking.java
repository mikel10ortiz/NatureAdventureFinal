package es.uji.natureadventure.domain;

import java.sql.Date;
import java.sql.Time;

public class Booking {
	 
	private int bookingId;
	private int activityId;
	private Date bookingDate;
	private Date activityDate;
	private Time hour;
	private String clientIdCard;
	private String clientName;
	private String clientPhone;
	private String clientEmail;
	private boolean status;
	private int peopleNumber;
	private String instructor;
	
	public Booking() {
		super();
	}

	public String getClientEmail() {
		return clientEmail;
	}

	public void setClientEmail(String clientEmail) {
		this.clientEmail = clientEmail;
	}

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public int getActivityId() {
		return activityId;
	}

	public void setActivityId(int activityName) {
		this.activityId = activityName;
	}

	public Date getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}

	public Date getActivityDate() {
		return activityDate;
	}

	public void setActivityDate(Date activityDate) {
		this.activityDate = activityDate;
	}

	public Time getHour() {
		return hour;
	}

	public void setHour(Time hour) {
		this.hour = hour;
	}

	public String getClientIdCard() {
		return clientIdCard;
	}

	public void setClientIdCard(String clientIdCard) {
		this.clientIdCard = clientIdCard;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public String getClientPhone() {
		return clientPhone;
	}

	public void setClientPhone(String clientPhone) {
		this.clientPhone = clientPhone;
	}

	public boolean getStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public int getPeopleNumber() {
		return peopleNumber;
	}

	public void setPeopleNumber(int peopleNumber) {
		this.peopleNumber = peopleNumber;
	}

	public String getInstructor() {
		return instructor;
	}

	public void setInstructor(String instructor) {
		this.instructor = instructor;
	}
	
	
	

}
