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
<title>About us</title>
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

      <img style="width: 1672px; height: 945px;" src="images/backgroundnew.jpg" alt="" />

   
            <div class ="main-About">



			<h2>Test</h2>
			<p>
			<br> Välj test att utföra:<br>
			</p>
			<form action="TestServlet" method="get" name="youPickItForm">
				<select name="suite" size="1" multiple>
					<option value="ics.junit.ejb.FacadeTest">
						ics.junit.ejb.EmployeeBeanTest</option>
					
				</select> <br><input type="submit" value="Run" />
			</form>


			<br> <br> <br> <br> <br> <br>
            </div>



</div>

<div class="footer">
  <h1>Se-Skarpt</h1>
</div>
</body>
</html>