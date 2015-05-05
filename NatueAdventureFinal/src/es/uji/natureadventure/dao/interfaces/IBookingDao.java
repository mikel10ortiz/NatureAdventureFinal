package es.uji.natureadventure.dao.interfaces;

import java.util.List;

import es.uji.natureadventure.domain.Booking;

public interface IBookingDao {

	public void saveBooking(Booking b);
	public void updateBooking(Booking b);
	public Booking getBooking(int id);
	public List<Booking> getBookings();
}
