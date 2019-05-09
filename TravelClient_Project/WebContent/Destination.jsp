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
<script src="js/destination.js"></script>
<title>Se-Skarpt Destinations</title>
</head>
<body>
	<header>
		<p>Se-skarpt consulting</p>
	</header>	
	<section id="row">
	

    <input type="hidden" name="operation" id="operation"/>
		<nav>
			<ul id = mainMenu>
				<li> <a href = "crud.jsp">Customer</a></li>
				<li class="active" value = "destinations"><a> Destinations</a></li>
				<li>  <a href = "Bookings.jsp">Bookings</a></li>
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
					
						<legend>Destination:</legend>
						Id:<br> <input type="text" name="destinationId" id="destinationId" value=""><br>
						City:<br> <input type="text" name="destinationCity" id="destinationCity" value=""> <br> 
						 Country:<br> <input type="text" name="destinationCountry" id="destinationCountry" value=""><br>
						 Hotel: <br> <input type="text" name="destinationHotel" id="destinationHotel" value=""> <br> <br>
						<input type="button" name="submitBtn" value="Find" id="FindDestinationBtn">
						<input type="button" name="submitBtn" value="AddDestinationBtn" id="AddDestinationBtn">
						<input type="button" name="submitBtn" value="DeleteDestinationBtn" id="DeleteDestinationBtn"> 
						<input type="button" name="submitBtn" value="UpdateDestinationBtn" id="UpdateDestinationBtn">
						
						
					</fieldset>
					<h1> Destination table:</h1>
					<br />
					<table class = "table table-bordered table-striped" id="destination_table">
					<tr>
						<th> Id </th>
						<th> City </th>	
						<th> Country </th>
						<th> Hotel </th>
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