package org.seskarpt.eao;

import java.util.List;

import javax.ejb.Local;

import org.seskarpt.ejb.Booking;

@Local
public interface BookingEAOLocal {
	public Booking findByBookingNbr(int bookingNbr);
	public Booking createBooking(Booking booking);
	public Booking updateBooking(Booking booking);
	public void deleteBooking(int bookingNbr);
	public List<Booking> findAllBookings();
}
