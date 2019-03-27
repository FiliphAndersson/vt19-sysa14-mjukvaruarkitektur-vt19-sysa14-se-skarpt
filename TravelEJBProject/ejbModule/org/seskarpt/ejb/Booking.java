package org.seskarpt.ejb;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;

@Entity
@Table(name = "Booking")
public class Booking implements Serializable {
	private int bookingNbr;
	private BookingId bookingId;
	
	private Timestamp dateOut;
	private Timestamp dateHome;

	private Customer customer;
	private Destination destination;

	@EmbeddedId
	public BookingId getBookingId() {
		return bookingId;
	}
	
	public void setBookingId(BookingId id) {
		this.bookingId = id;
	}
	

	public int getBookingNbr() {
		return bookingNbr;
	}

	public void setBookingNbr(int bookingNbr) {
		this.bookingNbr = bookingNbr;
	}

	@Column(name = "dateOut")
	public Timestamp getDateOut() {
		return dateOut;
	}

	public void setDateOut(Timestamp dateOut) {
		this.dateOut = dateOut;
	}

	@Column(name="dateHome")
	public Timestamp getDateHome() {
		return dateHome;
	}

	public void setDateHome(Timestamp dateHome) {
		this.dateHome = dateHome;
	}

	
	@ManyToOne
	@JoinColumn(name = "Customer_Nbr", referencedColumnName = "customerNbr", nullable = false, insertable = false, updatable = false)
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	
	@ManyToOne
	@JoinColumn(name = "Destination_Nbr", referencedColumnName="destinationNbr",
	 nullable = false, insertable = false, updatable = false)
	public Destination getDestination() {
		return destination;
	}

	public void setDestination(Destination destination) {
		this.destination = destination;
	}

}
