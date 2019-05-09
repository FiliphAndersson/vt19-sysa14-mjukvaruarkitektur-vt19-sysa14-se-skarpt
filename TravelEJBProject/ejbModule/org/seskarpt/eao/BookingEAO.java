package org.seskarpt.eao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.seskarpt.ejb.Booking;
import org.seskarpt.ejb.Customer;

/**
 * Session Bean implementation class BookingEAO
 */
@Stateless
public class BookingEAO implements BookingEAOLocal {

	@PersistenceContext(unitName = "LabEJBSql")
	private EntityManager em;

	public BookingEAO() {

	}
	
	public List<Booking> findAllBookings(){
		TypedQuery<Booking> tq = em.createNamedQuery("Booking.findAll", Booking.class);
		List<Booking> bookings = tq.getResultList();
		return bookings;
	}

	public Booking findByBookingNbr(int bookingNbr) {
		return em.find(Booking.class, bookingNbr);
	}

	public Booking createBooking(Booking booking) {
		em.persist(booking);
		return booking;
	}

	public Booking updateBooking(Booking booking) {
		em.merge(booking);
		return booking;
	}

	public void deleteBooking(int bookingNbr) {
		Booking b = this.findByBookingNbr(bookingNbr);
		if (b != null) {
			em.remove(b);
		}

	}
}
