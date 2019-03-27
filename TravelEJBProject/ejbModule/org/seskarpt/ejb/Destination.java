package org.seskarpt.ejb;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Destination")
public class Destination implements Serializable{
	private int destinationNbr;
	private String city;
	private String country;
	private String hotel;
	private Set<Booking> bookings;

	@Id
	@Column(name="destinationNbr")
	public int getDestinationNbr() {
		return destinationNbr;
	}

	public void setDestinationNbr(int destinationNbr) {
		this.destinationNbr = destinationNbr;
	}

	@Column(name="city")
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Column(name="country")
	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Column(name="hotel")
	public String getHotel() {
		return hotel;
	}

	public void setHotel(String hotel) {
		this.hotel = hotel;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "destination")
	public Set<Booking> getBookings() {
		return bookings;
	}

	public void setBookings(Set<Booking> bookings) {
		this.bookings = bookings;
	}

	
}
