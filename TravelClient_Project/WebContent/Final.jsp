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
<link rel="stylesheet" type="text/css" href="css/final.css">
<title>Home</title>
</head>
<body>
<div class="header">
 

  <div class="navbar">

  <a href="/TravelClient_Project/Final.jsp">Home</a>
  <img src="images/logga.png" alt="" class="center" />
  <a href="/TravelClient_Project/About.jsp"class="right">About us</a>
  <a href="/TravelClient_Project/Test.jsp"class="right">Test</a>
 
  <span id="degree" class="weather"></span>
  <span id="weather"class="weather"></span>
  <span id="city"class="weather"></span>
  
</div>

</div>

<div class="image">

  <img style="width: 1672px; height:1100px;" src="images/backgroundnew.jpg" alt="" />

      		<div class="customer-box">
     	 	<select name ="customer" id="customer" class = "form-control-customer">
			<option value="">Select Customer</option>
			</select>
			</div>
			
			<div class="destination-box">
     	 	<select name ="destination" id="destination" class = "form-control-customer">
			<option value="">Select Destination</option>
			</select>
			</div>
      
            <div class ="datePickerOutDiv">
            <p>  &nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Select departure date </p>
            <input type="date" name="departureDate" class = "datePicker" id ="departureDate" value =>
            
            </div>
            
 			<div class ="datePickerHomeDiv">
            <p> &nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Select home date </p>
            <input type="date" name="homeDate" id ="homeDate"  value =>
            
            </div>
            
            <div class ="main">
        
          
             &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
             	Booking Id <br> 
             	<div class ="bookingId">
             	<input type="text" name="bookingId" id="bookingId" value="" readonly disabled >  <br>
             	
	  		  </div>
	  		  
	  		  <br> <br>
	  		  
	    <div class ="crudButtonDiv">
			<input type="button" name="submitBtn" value="Add Booking" id="Addbooking" class="crudButton">
			<input type="button" name="submitBtn" value="Delete Booking" id="DeleteBookingBtn"class="crudButton"> 
			<input type="button" name="submitBtn" value="Update Booking" id="UpdateBookingBtn"class="crudButton">
			<p id="pText" style="color:red;"></p>
			<br>
			</div>
			<br><br>
            <br>  <br> 
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
            
            
            
            <br> <br> <br> <br>
            </div>



</div>

<div class="footer">
  <h1>Se-Skarpt</h1>
</div>
</body>
</html>