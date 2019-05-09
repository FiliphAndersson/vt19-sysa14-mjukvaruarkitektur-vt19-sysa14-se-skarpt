package org.seskarpt.eao;

import java.util.List;

import javax.ejb.Local;

import org.seskarpt.ejb.Customer;

@Local
public interface CustomerEAOLocal {
	public Customer findByCustomerId(int customerId);
	public Customer createCustomer(Customer c);
	public Customer updateCustomer(Customer c);
	public void deleteCustomer(int customerId);
	public List<Customer> findAllCustomers();
	
}
