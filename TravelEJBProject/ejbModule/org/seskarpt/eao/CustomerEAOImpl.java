package org.seskarpt.eao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.seskarpt.ejb.Customer;

/**
 * Session Bean implementation class CustomerEAOImpl
 */
@Stateless
public class CustomerEAOImpl implements CustomerEAOImplLocal {

	@PersistenceContext(unitName = "LabEJBSql")
	private EntityManager em;
	
   
    public CustomerEAOImpl() {
    }
    
    public Customer findCustomer(int customerNbr) {
    	return em.find(Customer.class, customerNbr);
    }
    
    public Customer createCustomer(Customer customer) {
    	em.persist(customer);
    	return customer;
    	}

    

}
