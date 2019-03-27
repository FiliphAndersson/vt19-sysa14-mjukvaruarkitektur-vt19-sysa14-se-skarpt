package org.seskarpt.eao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.seskarpt.ejb.Booking;
import org.seskarpt.ejb.BookingId;

/**
 * Session Bean implementation class BookingEAOImpl
 */
@Stateless
public class BookingEAOImpl implements BookingEAOImplLocal {

	@PersistenceContext(unitName = "LabEJBSql")
	private EntityManager em;

	public BookingEAOImpl() {

	}

	public Booking findBooking(BookingId id) {
		return em.find(Booking.class, id);
	}

	public Booking createBooking(Booking booking) {
		em.persist(booking);
		return booking;
	}

	public void updateBooking(Booking booking) {
		em.merge(booking);
	}

}
