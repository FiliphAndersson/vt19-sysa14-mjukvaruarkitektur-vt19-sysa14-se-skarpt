<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<script src="maxcdn.boostrapcdn.com/bootstrap/3.3.7/js.bootstrap.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js">
</script>
<script src="js/booking.js"></script>
<link rel="stylesheet" type="text/css" href="css/booking.css">
<title>Bookings</title>
</head>
<body>
<div class="header">
  <h1>SE skarpt</h1>
  <p>A <b>responsive</b> Great website!</p>
</div>

<div class="navbar">
  <a href="#" class="active">Home</a>
  <a href="#" class="left">Link</a>
  <a href="#" class="left">Link</a>
  <a href="#" class="right">Link</a>
</div>

<div class="row">
  <div class="side">

  </div>
  
  

  <div class="main">
	<div class="main">
	
	
	    <h2>Lägg till bokning</h2>
	    	<br>	
	    				<select name ="customer" id="customer" class = "form-control">
						<option value="">Select Customer</option>
						</select>
						
						<br><br>
						
						
						<select name ="destination" id="destination" class = "form-control input -lg">
						<option value="">Select Destination</option>
						</select>
	    	 			<br>
						 Departure date: <br>  <input type="date" name="departureDate" id ="departureDate" value =><br>
						 Home date: <br> <input type="date" name="homeDate" id ="homeDate"  value =>
						 	 	<br>	
						 	 	
						 	 	
	Booking Id <br> <input type="text" name="bookingId" id="bookingId" value="" readonly disabled><br>
	    
	    
			<input type="button" name="submitBtn" value="Add Booking" id="Addbooking">
			<input type="button" name="submitBtn" value="Delete Booking" id="DeleteBookingBtn"> 
			<input type="button" name="submitBtn" value="Update Booking" id="UpdateBookingBtn">
			
			<br><br>
	
	
			<table class="table table-bordered table-striped" id="booking_table">
				<tr>
					<th>Booking Id</th>
					<th>Date out</th>
					<th>Date home</th>
					<th>Customer Name</th>
					<th>Hotel Name</th>
					<th>Customer Id</th>
					<th>Destination Id</th>
				</tr>
			</table>
		</div>
		
		
		
    <br>
    <h2>TITLE HEADING</h2>
    <h5>Title description, Sep 2, 2017</h5>
    <div class="fakeimg" style="height:200px;">Image</div>
    <p>Some text..</p>
    <p>Sunt in culpa qui officia deserunt mollit anim id est laborum consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco.</p>
  </div>
  
     <div class="rightSide">
 

  </div>
  
  
</div>

<div class="footer">
  <h2>Footer</h2>
</div>

</body>
</html>