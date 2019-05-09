package org.seskarpt.eao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.seskarpt.ejb.Customer;
import org.seskarpt.ejb.Destination;

/**
 * Session Bean implementation class DestinationEAO
 */
@Stateless
public class DestinationEAO implements DestinationEAOLocal {

	@PersistenceContext(unitName = "LabEJBSql")
	private EntityManager em;
	
	public DestinationEAO() {
	}
	
	//Query.
	public List<Destination> findAllDestinations(){
		TypedQuery<Destination> tq = em.createNamedQuery("Destination.findAll", Destination.class);
		List<Destination> allDestinations = tq.getResultList();
		return allDestinations;
	}

	public Destination findByDestinationId(int destinationId) {
		return em.find(Destination.class, destinationId);
	}

	public Destination createDestination(Destination d) {
		em.persist(d);
		return d;
	}

	public Destination updateDestination(Destination d) {
		em.merge(d);
		return d;
	}

	public void deleteDestination(int destinationId) {
		Destination d = this.findByDestinationId(destinationId);
		if (d != null) {
			em.remove(d);
		}
	}

}
