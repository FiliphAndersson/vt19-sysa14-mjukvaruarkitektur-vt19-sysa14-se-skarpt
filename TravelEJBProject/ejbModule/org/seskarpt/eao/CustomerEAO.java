package org.seskarpt.eao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.seskarpt.ejb.Customer;

/**
 * Session Bean implementation class CustomerEAO
 */
@Stateless
public class CustomerEAO implements CustomerEAOLocal {
	 @PersistenceContext(unitName="LabEJBSql")
	 private EntityManager em;

	/**
	 * Default constructor.
	 */
	public CustomerEAO() {
		// TODO Auto-generated constructor stub
	}
	
	//Query.
	public List<Customer> findAllCustomers(){
		TypedQuery<Customer> tq = em.createNamedQuery("Customer.findAll", Customer.class);
		List<Customer> allCustomers = tq.getResultList();
		return allCustomers;
	}

	public Customer findByCustomerId(int customerId) {
		return em.find(Customer.class, customerId);
	}

	public Customer createCustomer(Customer c) {
		em.persist(c);
		return c;
	}

	public Customer updateCustomer(Customer c) {
		em.merge(c);
		return c;
	}

	public void deleteCustomer(int customerId) {
		Customer c = this.findByCustomerId(customerId);
		if (c != null) {
			em.remove(c);
		}
	}
}
