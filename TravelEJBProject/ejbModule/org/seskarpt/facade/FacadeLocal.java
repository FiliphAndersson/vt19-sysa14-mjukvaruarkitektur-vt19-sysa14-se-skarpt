package org.seskarpt.facade;

import javax.ejb.Local;

import org.seskarpt.ejb.Booking;
import org.seskarpt.ejb.BookingId;
import org.seskarpt.ejb.Customer;
import org.seskarpt.ejb.Destination;

@Local
public interface FacadeLocal {
	  public Customer findCustomer(int customerNbr);
	  public Customer createCustomer(Customer customer);
	  public Destination findDestination(int destinationNbr);
	  public Destination createDestination(Destination destination);
	  public Booking findBooking(BookingId id);
	  public Booking createBooking(Booking booking);
	  public void updateBooking(Booking b);
	    
}
