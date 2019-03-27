package org.seskarpt.eao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.seskarpt.ejb.Destination;

/**
 * Session Bean implementation class DestinationEAOImpl
 */
@Stateless
public class DestinationEAOImpl implements DestinationEAOImplLocal {

	@PersistenceContext(unitName = "LabEJBSql")
	private EntityManager em;

	public DestinationEAOImpl() {

	}

	public Destination findDestination(int destinationNbr) {
		return em.find(Destination.class, destinationNbr);
	}

	public Destination createDestination(Destination destination) {
		em.persist(destination);
		return destination;
	}

}
