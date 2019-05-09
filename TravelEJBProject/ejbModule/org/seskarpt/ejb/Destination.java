package org.seskarpt.ejb;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "Destination")
@SequenceGenerator(name = "ID_SEQ", allocationSize = 1)
@NamedQueries({
	 @NamedQuery(name="Destination.findAll", query="SELECT d FROM Destination d"),
	})
public class Destination implements Serializable {

	private int id;
	private String city;
	private String country;
	private String hotel;
	private Set<Booking> bookings;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="destId")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
	
	@OneToMany(mappedBy="destination", fetch=FetchType.EAGER)
	public Set<Booking> getBookings() {
		return bookings;
	}

	public void setBookings(Set<Booking> bookings) {
		this.bookings = bookings;
	}

}
