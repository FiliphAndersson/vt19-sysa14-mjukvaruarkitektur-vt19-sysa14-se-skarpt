package org.seskarpt.ejb;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="Booking")
@SequenceGenerator(name="ID_SEQ", allocationSize=1)

@NamedQueries({
	 @NamedQuery(name="Booking.findAll", query="SELECT b FROM Booking b")
	
	})
public class Booking implements Serializable {
	
private int bookingNbr;
private String dateOut;
private String dateHome;
private Customer customer;
private Destination destination;

@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
@Column(name="bookingNbr")
public int getAccountNbr() {
	return bookingNbr;
}
public void setAccountNbr(int bookingNbr) {
	this.bookingNbr = bookingNbr;
}

@Column(name="dateOut")
public String getDateOut() {
	return dateOut;
}
public void setDateOut(String dateOut) {
	this.dateOut = dateOut;
}

@Column(name="dateHome")
public String getDateHome() {
	return dateHome;
}
public void setDateHome(String dateHome) {
	this.dateHome = dateHome;
}

@ManyToOne
@JoinColumn(name ="cId", referencedColumnName ="custId")
public Customer getCustomer() {
	return customer;
}

public void setCustomer(Customer customer) {
	this.customer = customer;
}

@ManyToOne
@JoinColumn(name ="dId", referencedColumnName ="destId")
public Destination getDestination() {
	return destination;
}
public void setDestination(Destination destination) {
	this.destination = destination;
}





}
