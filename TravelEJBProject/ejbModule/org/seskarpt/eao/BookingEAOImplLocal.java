package org.seskarpt.eao;

import javax.ejb.Local;

import org.seskarpt.ejb.Booking;
import org.seskarpt.ejb.BookingId;

@Local
public interface BookingEAOImplLocal {
	
	public void updateBooking(Booking booking);
	public Booking createBooking(Booking booking);
	public Booking findBooking(BookingId id);

}
