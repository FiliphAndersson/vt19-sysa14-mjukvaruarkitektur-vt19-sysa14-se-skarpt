<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

<meta name="viewport" content="width=device-width, initial-scale=1">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js">
	
</script>
<script src="maxcdn.boostrapcdn.com/bootstrap/3.3.7/js.bootstrap.min.js"></script>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/customer.css">
<script src="js/booking.js"></script>

<title>Se-Skarpt Destinations</title>
</head>
<body>
	<header>
		<p>Se-skarpt consulting</p>
	</header>	

<div class="navbar">
  <a href="crud.jsp">Customers</a>
  <a href="Destination.jsp">Destinations</a>
  <a href="#" class="active">Bookings</a>
</div>
  

	
	
	<section id="row">
    <input type="hidden" name="operation" id="operation"/>
		<nav>
			<ul id = mainMenu>
				<li> <a href = "crud.jsp">Customer</a></li>
				<li> <a href = "Destination.jsp"> Destinations</a></li>
				<li class="active" value = "Destination.jsp"><a>Bookings</a></li>
			</ul>
		</nav>
		
		<aside>
			<table id="asideTable">
				<tr>
					<th><span id="city"></span></th>
					<th><span></span></th>
					<th><span></span></th>
					<th><span id="ipNbr"></span></th>
				</tr>
				<tr>
					<td><span id="degree"></span></td>
					<td><span id="weather"></span></td>
					<td><span></span></td>
					<td><span></span></td>
				</tr>
				<tr>
					<td colspan="4"><span id="sunrise"></span></td>
				</tr>
				<tr>
					<td colspan="4"><span id="sunset"></span></td>
				</tr>
			</table>
		</aside>

		<section id="main">
			<section id="content">
				<article>
					<fieldset id="PersonalFS">
					 
					 	<h3> Create Booking:</h3>
						<legend>Booking:</legend>
						
						<select name ="customer" id="customer" class = "form-control input -lg">
						<option value="">Select Customer</option>
						</select>
						
						<br><br>
						
						
						<select name ="destination" id="destination" class = "form-control input -lg" >
						<option value="">Select Destination</option>
						</select>
								
						<br>	
						 Departure date: <br>  <input type="date" name="departureDate" id ="departureDate" value =><br>
						 Home date: <br> <input type="date" name="homeDate" id ="homeDate"  value =>
						 	 	<br>	<br>	
						Booking Id :<br> <input type="text" name="bookingId" id="bookingId" value=""><br>


						<input type="button" name="submitBtn" value="Add Booking" id="Addbooking">
						<input type="button" name="submitBtn" value="Delete Booking" id="DeleteBookingBtn"> 
						<input type="button" name="submitBtn" value="Update Booking" id="UpdateBookingBtn">
				
						
						
					</fieldset>
						<h1> Booking table:</h1>
					<br />
					<table class = "table table-bordered table-striped" id="booking_table">
					<tr>
						<th> Booking Id </th>
						<th> Date out</th>	
						<th> Date home </th>
						<th> Customer Name </th>
						<th> Hotel Name  </th>
						<th> Customer Id </th>
						<th> Destination Id </th>
					</tr>
					</table>
				</article>
			</section>
		</section>
	</section>
	<footer>
		<p>&copy; Se-Skarpt Consulting</p>
	</footer>
</body>
</html>