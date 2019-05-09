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
@Table(name = "Customer")
@SequenceGenerator(name = "ID_SEQ", allocationSize = 1)

@NamedQueries({
	 @NamedQuery(name="Customer.findAll", query="SELECT c FROM Customer c"),
	})
public class Customer implements Serializable {

	private int id;
	private String name;
	private String address;
	private String ssn;
	private Set<Booking> Bookings;

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="custId")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name="name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name="address")
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name="ssn")
	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	@OneToMany(mappedBy="customer", fetch=FetchType.EAGER)
	public Set<Booking> getBookings() {
		return Bookings;
	}

	public void setBookings(Set<Booking> bookings) {
		Bookings = bookings;
	}

}