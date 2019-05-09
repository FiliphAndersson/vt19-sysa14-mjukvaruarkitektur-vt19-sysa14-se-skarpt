package ics.junit.ejb;

import javax.naming.Context;
import javax.naming.InitialContext;

import org.seskarpt.ejb.Customer;
import org.seskarpt.ejb.Destination;
import org.seskarpt.facade.FacadeLocal;

import junit.framework.TestCase;

public class FacadeTest extends TestCase {
	
	FacadeLocal facade;

	public FacadeTest(String name) {
		super(name);
	}

	protected void setUp() throws Exception {
		super.setUp();
		Context context = new InitialContext();
		facade=(FacadeLocal)context.lookup("java:app/TravelEJBProject/Facade!org.seskarpt.facade.FacadeLocal");
	}

	protected void tearDown() throws Exception {
		super.tearDown();
		facade=null;
	}
	
	public void testFacadeMethodFindCustomer() throws Exception {
		Customer c= facade.findByCustomerId(5);
		c.setName("Jon");
		c.setAddress("Norrköping");
		assertEquals(c.getName(), "Jon");
		assertEquals(c.getAddress(), "Norrköping");
		}
	
	public void testFacadeMethodFindDestination() throws Exception {
		Destination d = facade.findByDestinationId(8);
		d.setHotel("Hilton");
		assertEquals(d.getHotel(), "Hilton");
		}


}
