<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

<meta name="viewport" content="width=device-width, initial-scale=1"> 
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="maxcdn.boostrapcdn.com/bootstrap/3.3.7/js.bootstrap.min.js"></script>

	

<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/customer.css">
<script src="js/customer.js"></script>
<title>Se-Skarpt Bookings</title>
</head>
<body>
	<header>
		<p>Se-skarpt consulting</p>
	</header>	
	<section id="row">
	

    <input type="hidden" name="operation" id="operation"/>
		<nav>
			<ul id = mainMenu>
				<li  class="active" value = "customers"><a>Customer</a></li>
				<li> <a href = "Destination.jsp">Destinations</a></li>
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
					
						<legend>Customer:</legend>
						Id:<br> <input type="text" name="id" id="id" value=""><br>
						Name:<br> <input type="text" name="customerName" id="customerName" value=""> <br> 
						 Address:<br> <input type="text" name="customerAddress" id="customerAddress" value=""><br>
						 Ssn: <br> <input type="text" name="customerSsn" id="customerSsn" value=""> <br> <br>
						<input type="button" name="submitBtn" value="Find" id="FindBtn">
						<input type="button" name="submitBtn" value="Add" id="AddBtn">
						<input type="button" name="submitBtn" value="Delete" id="DeleteBtn"> 
						<input type="button" name="submitBtn" value="Update" id="UpdateBtn">
						
						
					</fieldset>
					<h1> Customer table:</h1>
					<br />
					<table class = "table table-bordered table-striped" id="customer_table">
					<tr>
						<th> Id </th>
						<th> Name </th>
						<th> Address </th>
						<th> Ssn </th>
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