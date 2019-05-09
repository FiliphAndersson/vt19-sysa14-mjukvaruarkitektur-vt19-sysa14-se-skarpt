package org.ics.ejb.lab.restserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.List;

import javax.ejb.EJB;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.json.JsonReader;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.seskarpt.ejb.Booking;
import org.seskarpt.ejb.Customer;
import org.seskarpt.ejb.Destination;
import org.seskarpt.facade.FacadeLocal;

/**
 * Servlet implementation class Customers
 */
@WebServlet("/Customers/*")
public class Customers extends HttpServlet {
	private static final String CONTENT_TYPE = "text/html; charset=ISO-8859-1";
	private static final long serialVersionUID = 1L;
	@EJB
	FacadeLocal facade;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Customers() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String method = request.getParameter("method");
		// Kolla först method, sen returnera customer, destination eller booking!
		System.out.println("Method: " + method);

		if (method.equals("methodA")) {
			String pathInfo = request.getPathInfo();
			String url = request.getRequestURI();
			System.out.println("Request url: " + url);

			if (pathInfo == null || pathInfo.equals("/")) {
				System.out.println("Alla");
				System.out.println(pathInfo);
				List<org.seskarpt.ejb.Customer> allCustomers = facade.findAllCustomers();
				sendAsJson(response, allCustomers);
				return;
			}
			String[] splits = pathInfo.split("/");
			if (splits.length != 2) {
				System.out.println("Alla2");
				response.sendError(HttpServletResponse.SC_BAD_REQUEST);
				return;
			}
			String id = splits[1];
			Customer customer = facade.findByCustomerId(Integer.parseInt(id));

			sendAsJson(response, customer);

		}

		else if (method.equals("findDestination")) {
			String pathInfo = request.getPathInfo();
			String url = request.getRequestURI();

			if (pathInfo == null || pathInfo.equals("/")) {
				System.out.println("Alla");
				System.out.println(pathInfo);
				List<org.seskarpt.ejb.Destination> allDestinations = facade.findAllDestinations();
				sendDestinationsAsJson(response, allDestinations);
				return;
			}
			String[] splits = pathInfo.split("/");
			if (splits.length != 2) {
				System.out.println("Alla2");
				response.sendError(HttpServletResponse.SC_BAD_REQUEST);
				return;
			}
			String id = splits[1];

			Destination destination = facade.findByDestinationId(Integer.parseInt(id));
			sendDestinationAsJson(response, destination);

		}

		else if (method.equals("findBooking")) {
			String pathInfo = request.getPathInfo();
			String url = request.getRequestURI();

			if (pathInfo == null || pathInfo.equals("/")) {
				System.out.println("Alla");
				System.out.println(pathInfo);
				List<org.seskarpt.ejb.Booking> allBookings = facade.findAllBookings();
				sendBookingsAsJson(response, allBookings);
				return;
			}
			String[] splits = pathInfo.split("/");
			if (splits.length != 2) {
				System.out.println("Alla2");
				response.sendError(HttpServletResponse.SC_BAD_REQUEST);
				return;
			}
			String id = splits[1];

			Booking booking = facade.findByBookingNbr(Integer.parseInt(id));
			sendBookingAsJson(response, booking);

		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		BufferedReader reader = request.getReader();
		String operator = parseJsonId(reader);

		System.out.println(operator + ": Id för operationen.");

	}

	private String parseJsonId(BufferedReader br) {
		// javax.json-1.0.4.jar
		JsonReader jsonReader = null;
		JsonObject jsonRoot = null;
		jsonReader = Json.createReader(br);
		jsonRoot = jsonReader.readObject();
		System.out.println("JsonRoot: " + jsonRoot);
		String inputId = jsonRoot.getString("id");

		if (inputId.equals("Add")) {
			String ssn = jsonRoot.getString("ssn");
			String name = jsonRoot.getString("name");
			String address = jsonRoot.getString("address");
			Customer customer = new Customer();
			customer.setSsn(ssn);
			customer.setName(name);
			customer.setAddress(address);
			facade.createCustomer(customer);
		}

		else if (inputId.equals("AddDestinationBtn")) {

			Destination destination = new Destination();
			destination.setCity(jsonRoot.getString("city"));
			destination.setCountry(jsonRoot.getString("country"));
			destination.setHotel(jsonRoot.getString("hotel"));
			facade.createDestination(destination);

		}
		
		else if (inputId.equals("Addbooking")) {
		
			int customerId = Integer.parseInt(jsonRoot.getString("customerId"));
			int destinationId = Integer.parseInt(jsonRoot.getString("destinationId"));
			String dateOut = jsonRoot.getString("departureDate");
			String dateHome = jsonRoot.getString("homeDate");
		
			facade.createBooking(customerId, destinationId, dateOut, dateHome);
			
			
			
		}
		return inputId;
	}

	private String parseJsonUpdate(BufferedReader br) {
		// javax.json-1.0.4.jar
		JsonReader jsonReader = null;
		JsonObject jsonRoot = null;
		jsonReader = Json.createReader(br);
		jsonRoot = jsonReader.readObject();
		System.out.println("JsonRoot: " + jsonRoot);
		String inputId = jsonRoot.getString("ajaxId");
		if (inputId.equals("Add")) {
			Customer customer = facade.findByCustomerId(Integer.parseInt(jsonRoot.getString("id")));
			customer.setSsn(jsonRoot.getString("ssn"));
			customer.setName(jsonRoot.getString("name"));
			customer.setAddress(jsonRoot.getString("address"));
			facade.updateCustomer(customer);
		} else if (inputId.equals("UpdateDestinationBtn")) {
			Destination destination = facade.findByDestinationId(Integer.parseInt(jsonRoot.getString("id")));
			destination.setCity(jsonRoot.getString("city"));
			destination.setHotel(jsonRoot.getString("hotel"));
			destination.setCountry(jsonRoot.getString("country"));
			facade.updateDestination(destination);
		}
		else if (inputId.contentEquals("UpdateBookingBtn")) {
			Booking booking = facade.findByBookingNbr(Integer.parseInt(jsonRoot.getString("bookingId")));
			booking.setCustomer(facade.findByCustomerId(Integer.parseInt(jsonRoot.getString("customerId"))));
			booking.setDestination(facade.findByDestinationId(Integer.parseInt(jsonRoot.getString("destinationId"))));
			booking.setDateHome(jsonRoot.getString("homeDate"));
			booking.setDateOut(jsonRoot.getString("departureDate"));
			facade.updateBooking(booking);
			
		}
		return inputId;

	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		BufferedReader reader = request.getReader();
		String operator = parseJsonUpdate(reader);
		System.out.println(operator + ": Id för operationen.");

		/*
		 * String pathInfo = request.getPathInfo(); if (pathInfo == null ||
		 * pathInfo.equals("/")) {
		 * response.sendError(HttpServletResponse.SC_BAD_REQUEST); return; } String[]
		 * splits = pathInfo.split("/"); if (splits.length != 2) {
		 * response.sendError(HttpServletResponse.SC_BAD_REQUEST); return; } String id =
		 * splits[1]; BufferedReader reader = request.getReader();
		 * 
		 * parseJsonUpdate(reader); // Uppdatera i db
		 * 
		 * try { c = facade.updateCustomer(c); } catch (Exception e) {
		 * System.out.println("facade Update Error"); } sendAsJson(response, c);
		 */
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		BufferedReader reader = request.getReader();
		String operator = parseJsonDelete(reader);
		System.out.println(operator + ": Id för operationen.");

		/*
		 * String pathInfo = request.getPathInfo(); if (pathInfo == null ||
		 * pathInfo.equals("/")) {
		 * response.sendError(HttpServletResponse.SC_BAD_REQUEST); return; } String[]
		 * splits = pathInfo.split("/"); if (splits.length != 2) {
		 * response.sendError(HttpServletResponse.SC_BAD_REQUEST); return; } String id =
		 * splits[1];
		 * 
		 * Customer customer = facade.findByCustomerId(Integer.parseInt(id)); if
		 * (customer != null) { facade.deleteCustomer(Integer.parseInt(id)); }
		 * sendAsJson(response, customer);
		 */
	}

	private String parseJsonDelete(BufferedReader br) {
		// javax.json-1.0.4.jar
		JsonReader jsonReader = null;
		JsonObject jsonRoot = null;
		jsonReader = Json.createReader(br);
		jsonRoot = jsonReader.readObject();
		System.out.println("JsonRoot: " + jsonRoot);
		String inputId = jsonRoot.getString("ajaxId");

		if (inputId.equals("Delete")) {
			Customer customer = facade.findByCustomerId(Integer.parseInt(jsonRoot.getString("id")));
			if (customer != null) {
				facade.deleteCustomer(customer.getId());
			}
		} else if (inputId.equals("DeleteDestinationBtn")) {
			Destination destination = facade.findByDestinationId(Integer.parseInt(jsonRoot.getString("id")));
			if (destination != null) {
				facade.deleteDestination(destination.getId());
			}
		}
		
		else if (inputId.equals("DeleteBookingBtn")) {
			Booking booking = facade.findByBookingNbr(Integer.parseInt(jsonRoot.getString("id")));
			if (booking != null) {
				facade.deleteBooking(booking.getAccountNbr());
			}
			
		}
		return inputId;

	}

	private void sendAsJson(HttpServletResponse response, Customer customer) throws IOException {

		PrintWriter out = response.getWriter();
		response.setContentType("application/json");
		if (customer != null) {
			out.print("{\"name\":");
			out.print("\"" + customer.getName() + "\"");
			out.print(",\"ssn\":");
			out.print("\"" + customer.getSsn() + "\"");
			out.print(",\"address\":");
			out.print("\"" + customer.getAddress() + "\"");
			out.print(",\"id\":");
			out.print("\"" + customer.getId() + "\"}");

		} else {
			out.print("{ }");
		}
		out.flush();
	}

	private void sendDestinationAsJson(HttpServletResponse response, Destination destination) throws IOException {

		PrintWriter out = response.getWriter();
		response.setContentType("application/json");
		if (destination != null) {
			out.print("{\"id\":");
			out.print("\"" + destination.getId() + "\"");
			out.print(",\"city\":");
			out.print("\"" + destination.getCity() + "\"");
			out.print(",\"country\":");
			out.print("\"" + destination.getCountry() + "\"");
			out.print(",\"hotel\":");
			out.print("\"" + destination.getHotel() + "\"}");

		} else {
			out.print("{ }");
		}
		out.flush();
	}
	
	
	private void sendBookingAsJson(HttpServletResponse response, Booking booking) throws IOException {

		PrintWriter out = response.getWriter();
		response.setContentType("application/json");
		if (booking != null) {
			Customer customer = booking.getCustomer();
			Destination destination = booking.getDestination();
			
			out.print("{\"id\":");
			out.print("\"" + booking.getAccountNbr() + "\"");
			out.print(",\"dateHome\":");
			out.print("\"" + booking.getDateHome() + "\"");
			out.print(",\"dateOut\":");
			out.print("\"" + booking.getDateOut() + "\"");
			out.print(",\"customerName\":");
			out.print("\"" + customer.getName() + "\"");
			out.print(",\"destinationHotel\":");
			out.print("\"" + destination.getHotel() + "\"");
			out.print(",\"customerId\":");
			out.print("\"" + customer.getId() + "\"");
			out.print(",\"destinationId\":");
			out.print("\"" + destination.getId() + "\"}");
			

		} else {
			out.print("{ }");
		}
		out.flush();
	}
	
	private void sendBookingsAsJson(HttpServletResponse response, List<Booking> bookings)
			throws IOException {

		PrintWriter out = response.getWriter();
		response.setContentType("application/json");
		if (bookings != null) {
			JsonArrayBuilder array = Json.createArrayBuilder();
			for (org.seskarpt.ejb.Booking b : bookings) {
				JsonObjectBuilder o = Json.createObjectBuilder();
				o.add("id", String.valueOf(b.getAccountNbr()));
				o.add("dateHome", b.getDateHome());
				o.add("dateOut", b.getDateOut());
	
				//Get & add customer and destination name for cleaner presentation in JSP.
				Customer customer = b.getCustomer();
				Destination destination = b.getDestination();
				
				o.add("customerName", customer.getName());
				o.add("destinationHotel", destination.getHotel());
				o.add("customerId", customer.getId());
				o.add("destinationId", destination.getId());
		
				array.add(o);
			}
			JsonArray jsonArray = array.build();
			System.out.println("Booking Rest: " + jsonArray);
			out.print(jsonArray);
		} else {
			out.print("[]");
		}
		out.flush();
	}

	private void sendDestinationsAsJson(HttpServletResponse response, List<Destination> destinations)
			throws IOException {

		PrintWriter out = response.getWriter();
		response.setContentType("application/json");
		if (destinations != null) {
			JsonArrayBuilder array = Json.createArrayBuilder();
			for (org.seskarpt.ejb.Destination d : destinations) {
				JsonObjectBuilder o = Json.createObjectBuilder();
				o.add("id", String.valueOf(d.getId()));
				o.add("city", d.getCity());
				o.add("country", d.getCountry());
				o.add("hotel", d.getHotel());
				array.add(o);
			}
			JsonArray jsonArray = array.build();
			System.out.println("Destination Rest: " + jsonArray);
			out.print(jsonArray);
		} else {
			out.print("[]");
		}
		out.flush();
	}

	private void sendAsJson(HttpServletResponse response, List<Customer> customers) throws IOException {

		PrintWriter out = response.getWriter();
		response.setContentType("application/json");
		if (customers != null) {
			JsonArrayBuilder array = Json.createArrayBuilder();
			for (org.seskarpt.ejb.Customer c : customers) {
				JsonObjectBuilder o = Json.createObjectBuilder();
				o.add("id", String.valueOf(c.getId()));
				o.add("name", c.getName());
				o.add("address", c.getAddress());
				o.add("ssn", c.getSsn());
				array.add(o);
			}
			JsonArray jsonArray = array.build();
			System.out.println("Customer Rest: " + jsonArray);
			out.print(jsonArray);
		} else {
			out.print("[]");
		}
		out.flush();
	}
}
