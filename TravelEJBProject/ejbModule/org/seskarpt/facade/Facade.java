package org.seskarpt.facade;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.seskarpt.eao.BookingEAOImplLocal;
import org.seskarpt.eao.CustomerEAOImplLocal;
import org.seskarpt.eao.DestinationEAOImplLocal;
import org.seskarpt.ejb.Booking;
import org.seskarpt.ejb.BookingId;
import org.seskarpt.ejb.Customer;
import org.seskarpt.ejb.Destination;

/**
 * Session Bean implementation class Facade
 */
@Stateless
public class Facade implements FacadeLocal {

	@EJB
	CustomerEAOImplLocal customer;
	@EJB
	DestinationEAOImplLocal destination;
	@EJB
	BookingEAOImplLocal booking;
	
    public Facade() {
       
    }
    public Customer findCustomer(int customerNbr) {
    	return customer.findCustomer(customerNbr);
    }
    
    public Customer createCustomer(Customer customer) {
    	customer = this.customer.createCustomer(customer);
    	return customer;
    }
    
    public Destination findDestination(int destinationNbr) {
    	return destination.findDestination(destinationNbr);
    }
    
    public Destination createDestination(Destination destination) {
    	destination = this.destination.createDestination(destination);
    	return destination;
    }
    
    public Booking findBooking(BookingId id) {
    	return booking.findBooking(id);
    }
    
    public Booking createBooking(Booking booking) {
    	booking = this.booking.createBooking(booking);
    	return booking;
    }

    public void updateBooking(Booking b) {
    	this.booking.updateBooking(b);
    }
    
    
    

}
