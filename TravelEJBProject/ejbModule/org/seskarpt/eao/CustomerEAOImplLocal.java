package org.seskarpt.eao;

import javax.ejb.Local;

import org.seskarpt.ejb.Customer;

@Local
public interface CustomerEAOImplLocal {
	 public Customer createCustomer(Customer customer);
	 public Customer findCustomer(int customerNbr);
}
