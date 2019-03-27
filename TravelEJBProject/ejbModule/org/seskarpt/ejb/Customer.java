package org.seskarpt.ejb;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Customer")
public class Customer implements Serializable {
	private int customerNbr;
	private String name;
	private String address;
	private String ssn;
	
	private Set<Booking> bookings;
	
	@Id
	@Column(name="customerNbr")
	public int getCustomerNbr() {
		return customerNbr;
	}
	public void setCustomerNbr(int customerNbr) {
		this.customerNbr = customerNbr;
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
	
	@OneToMany (fetch = FetchType.EAGER, mappedBy = "customer")
	public Set<Booking> getBookings() {
		return bookings;
	}
	
	public void setBookings(Set<Booking> bookings) {
		this.bookings = bookings;
	}

}
