package es.uji.natureadventure.auxiliars;

import java.util.Date;

public class BookingActivityName {

	private int bookingId;
	private String activityName;
	private String clientName;
	private Date activityDate;
	
	
	public BookingActivityName() {
	}
	
	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public String getActivityName() {
		return activityName;
	}
	
	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}


	public String getClientName() {
		return clientName;
	}


	public void setClientName(String clientName) {
		this.clientName = clientName;
	}


	public Date getActivityDate() {
		return activityDate;
	}


	public void setActivityDate(Date activityDate) {
		this.activityDate = activityDate;
	}
	
	
	
}
