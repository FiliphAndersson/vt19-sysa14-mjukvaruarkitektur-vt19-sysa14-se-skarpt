package org.seskarpt.ejb;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

@Embeddable
public class BookingId implements Serializable {
	private int customerNbr;
	private int destinationNbr;

	public BookingId() {
	}

	public BookingId(int customerNbr, int destinationNbr) {
		this.customerNbr = customerNbr;
		this.destinationNbr = destinationNbr;
	}

	@Column(name = "Customer_Nbr", nullable = false)
	@NotNull
	public int getCustomerNbr() {
		return customerNbr;
	}

	public void setCustomerNbr(int customerNbr) {
		this.customerNbr = customerNbr;
	}

	@Column(name = "Destination_Nbr", nullable = false)
	@NotNull
	public int getDestinationNbr() {
		return destinationNbr;
	}

	public void setDestinationNbr(int destinationNbr) {
		this.destinationNbr = destinationNbr;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof BookingId))
			return false;

		BookingId castOther = (BookingId) other;

		return ((this.getCustomerNbr() == castOther.getCustomerNbr()) || (this.getCustomerNbr() != 0
				&& castOther.getCustomerNbr() != 0 && this.getCustomerNbr() == (castOther.getCustomerNbr())))

				&&

				((this.getDestinationNbr() == castOther.getDestinationNbr()
						|| (this.getDestinationNbr() != 0 && castOther.getDestinationNbr() != 0
								&& this.getDestinationNbr() == (castOther.getDestinationNbr()))));
	}

	public int hashCode() {
		return super.hashCode();
	}

}
