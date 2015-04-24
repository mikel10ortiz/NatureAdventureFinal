package es.uji.natureadventure.dao.interfaces;

import java.util.List;

import es.uji.natureadventure.domain.Booking;

public interface IBookingDao {

	public boolean saveBooking(Booking b);
	public Booking updateBooking(Booking b);
	public Booking getBooking(int id);
	public List<Booking> getBookings();
}
