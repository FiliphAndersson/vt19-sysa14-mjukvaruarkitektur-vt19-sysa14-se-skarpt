package org.seskarpt.facade;

import java.util.List;

import javax.ejb.Local;

import org.seskarpt.ejb.Booking;
import org.seskarpt.ejb.Customer;
import org.seskarpt.ejb.Destination;

@Local
public interface FacadeLocal {
	public Booking findByBookingNbr(int bookingNbr);
	public Booking createBooking(int customerId, int destinationId, String dateOut, String dateHome);
	public Booking updateBooking(Booking booking);
	public void deleteBooking(int bookingNbr);
	public Customer findByCustomerId(int customerId);
	public Customer createCustomer(Customer customer);
	public Customer updateCustomer(Customer customer);
	public void deleteCustomer(int customerId);
	public Destination findByDestinationId(int destinationId);
	public Destination createDestination(Destination destination);
	public Destination updateDestination(Destination destination);
	public void deleteDestination(int destinationId);
	public List<Customer> findAllCustomers();
	public List<Destination> findAllDestinations();
	public List<Booking> findAllBookings();
}
