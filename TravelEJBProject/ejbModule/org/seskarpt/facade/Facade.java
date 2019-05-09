package org.seskarpt.facade;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.seskarpt.eao.BookingEAOLocal;
import org.seskarpt.eao.CustomerEAOLocal;
import org.seskarpt.eao.DestinationEAOLocal;
import org.seskarpt.ejb.Booking;
import org.seskarpt.ejb.Customer;
import org.seskarpt.ejb.Destination;

/**
 * Session Bean implementation class Facade
 */
@Stateless
public class Facade implements FacadeLocal {
	@EJB
	CustomerEAOLocal customerEAO;
	@EJB
	DestinationEAOLocal destinationEAO;
	@EJB
	BookingEAOLocal bookingEAO;

	public Facade() {

	}
	public List<Booking> findAllBookings() {
		return bookingEAO.findAllBookings();
	}
	
	public List<Customer> findAllCustomers() {
		return customerEAO.findAllCustomers();
	}

	public List<Destination> findAllDestinations() {
		return destinationEAO.findAllDestinations();
	}

	public Booking findByBookingNbr(int bookingNbr) {
		return bookingEAO.findByBookingNbr(bookingNbr);
	}

	public Booking createBooking(int customerId, int destinationId, String dateOut, String dateHome) {
		
    	Booking newBooking = null;
    	Customer customer = this.findByCustomerId(customerId);
    	Destination destination = this.findByDestinationId(destinationId);
    	
    	newBooking = new Booking();
    	newBooking.setDateOut(dateOut);
    	newBooking.setDateHome(dateHome);
    	newBooking = bookingEAO.createBooking(newBooking);
    	
    	//Kan bli fel här? Booking skapas utan fk...
    	
    	newBooking.setCustomer(customer);
    	customerEAO.updateCustomer(customer);
    	newBooking.setDestination(destination);
    	destinationEAO.updateDestination(destination);
    	
    	
    	return newBooking;
    	
    }

	public Booking updateBooking(Booking booking) {
		return bookingEAO.updateBooking(booking);
	}

	public void deleteBooking(int bookingNbr) {
		bookingEAO.deleteBooking(bookingNbr);
	}

	public Customer findByCustomerId(int customerId) {
		return customerEAO.findByCustomerId(customerId);
	}

	public Customer createCustomer(Customer customer) {
		return customerEAO.createCustomer(customer);
	}

	public Customer updateCustomer(Customer customer) {
		return customerEAO.updateCustomer(customer);
	}

	public void deleteCustomer(int customerId) {
		customerEAO.deleteCustomer(customerId);
	}

	public Destination findByDestinationId(int destinationId) {
		return destinationEAO.findByDestinationId(destinationId);
	}

	public Destination createDestination(Destination destination) {
		return destinationEAO.createDestination(destination);
	}

	public Destination updateDestination(Destination destination) {
		return destinationEAO.updateDestination(destination);
	}

	public void deleteDestination(int destinationId) {
		destinationEAO.deleteDestination(destinationId);
	}

}
