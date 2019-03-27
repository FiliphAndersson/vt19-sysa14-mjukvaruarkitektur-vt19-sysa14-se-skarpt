package org.seskarpt.eao;

import javax.ejb.Local;

import org.seskarpt.ejb.Destination;

@Local
public interface DestinationEAOImplLocal {
	public Destination findDestination(int destinationNbr);
	public Destination createDestination(Destination destination);
}
