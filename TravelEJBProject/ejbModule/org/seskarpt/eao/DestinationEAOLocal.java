package org.seskarpt.eao;

import java.util.List;

import javax.ejb.Local;

import org.seskarpt.ejb.Customer;
import org.seskarpt.ejb.Destination;

@Local
public interface DestinationEAOLocal {
	public Destination findByDestinationId(int destinationId);
	public Destination createDestination(Destination d);
	public Destination updateDestination(Destination d);
	public void deleteDestination(int destinationId);
	public List<Destination> findAllDestinations();

}
