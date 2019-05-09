$(document).ready(function(){

	
	$.getJSON("http://localhost:8080/RestServerTravelProject/Customers?method=findDestination", function(data){
		var destination_data = '';
		$.each(data, function(key, value){
			destination_data += '<tr>';
			destination_data += '<td><a href="#">' + value.id + '</td>';
			destination_data += '<td onclick = "content()">' + value.city + '</td>';
			destination_data += '<td>' + value.country + '</td>';
			destination_data += '<td>' + value.hotel + '</td>';
			destination_data += '</tr>';
			
		
		});
		$('#destination_table').append(destination_data)
			
			
	});
	
	$.ajax({        
		method: "GET", 
		url: "http://api.ipstack.com/check?access_key=2e612010180d557488a2448eea30fe23",
		error: ajaxReturn_Error,     
		success: ajaxReturn_Success         }) 

		function ajaxReturn_Success(result, status, xhr)
	{   
		ParseJsonFile(result);
	}

	function ajaxReturn_Error(result, status, xhr)
	{           console.log("Ajax-api-stack: "+status);    

	}
	
	$("#FindDestinationBtn").click( function() {

		var strValue = $("#destinationId").val();

		if (strValue != "") {
			$.ajax({
				method: "GET",
				url: "http://localhost:8080/RestServerTravelProject/Customers/"+strValue + "?method=findDestination",
				error: ajaxFindReturnError,
				success: ajaxFindReturnSuccess

			})
			function ajaxFindReturnSuccess(result, status, xhr) {

				ParseJsonFileDestination(result);

			}
			function ajaxFindReturnError(result, status, xhr) {
				alert("Error");
				console.log("Ajax-find destination: "+status);
				
			}
		}
	})
	
	$("#AddDestinationBtn").click( function() {
		var strId = $("#destinationId").val();
		var strCountry = $("#destinationCountry").val();
		var strCity = $("#destinationCity").val();
		var strHotel = $("#destinationHotel").val();
		var ajaxId =  $("#AddDestinationBtn").val();
	
		var obj = { hotel: strHotel, city: strCity, country: strCountry, id: ajaxId};
		var jsonString = JSON.stringify(obj);
		if (strHotel!= "") {
			$.ajax({
				method: "POST",
				url: "http://localhost:8080/RestServerTravelProject/Customers/",
				data: jsonString,
				// dataType:'json',
				error: ajaxAddReturnError,
				success: ajaxAddReturnSuccess
			})
			function ajaxAddReturnSuccess(result, status, xhr) {
				clearFields();
				$("#destinationId").attr("placeholder","Destination added" );
			}
			function ajaxAddReturnError(result, status, xhr) {
				alert("Error Add");
				console.log("Ajax-find Destination: "+status);
			}
		}
	})// btnclick
	
		$("#UpdateDestinationBtn").click( function() {
			var strId = $("#destinationId").val();
			var strCountry = $("#destinationCountry").val();
			var strCity = $("#destinationCity").val();
			var strHotel = $("#destinationHotel").val();
			var ajaxId =  $("#UpdateDestinationBtn").val();
			var obj = { id: strId, hotel: strHotel, city: strCity, country: strCountry, ajaxId: ajaxId};
		var jsonString = JSON.stringify(obj);
		if (strId != "") {
			$.ajax({
				method: "PUT",
				url: "http://localhost:8080/RestServerTravelProject/Customers/"+strId,
				data: jsonString,
				dataType:'json',
				error: ajaxUpdateReturnError,
				success: ajaxUpdateReturnSuccess
			})
			function ajaxUpdateReturnSuccess(result, status, xhr) {
				clearFields();
				$("#id").attr("placeholder","Destination updated" );
			}
			function ajaxUpdateReturnError(result, status, xhr) {
				alert("Error Update");
				console.log("Ajax-find Destination: "+status);
			}
		}
	})// btnclick
	
	
	$("#DeleteDestinationBtn").click( function() {
		var strValue = $("#destinationId").val();
		var ajaxId =  $("#DeleteDestinationBtn").val();
		var obj = { id: strValue, ajaxId: ajaxId};
		var jsonString = JSON.stringify(obj);
		
		if (strValue != "") {
			$.ajax({
				method: "DELETE",
				url: "http://localhost:8080/RestServerTravelProject/Customers/"+strValue,
				data: jsonString,
				dataType:'json',
				error: ajaxDelReturnError,
				success: ajaxDelReturnSuccess
			})
			function ajaxDelReturnSuccess(result, status, xhr) {
				clearFields();
				$("#destinationId").attr("placeholder","Destination deleted" );
			}
			function ajaxDelReturnError(result, status, xhr) {
				alert("Error");
				console.log("Ajax-delete Destination: "+status);
			}
		}
	})// btnclick
}); // End ready function

function ParseJsonFileDestination(result) {
	$("#destinationCity").val(result.city);
	$("#destinationCountry").val(result.country);
	$("#destinationHotel").val(result.hotel);
}




function clearFields() {

	$("#destinationId").val("");
	$("#destinationCity").val("");
	$("#destinationCountry").val("");
	$("#destinationHotel").val("");
}

function ParseJsonFile(result) 
{    
	var lat = result.latitude;
	var long = result.longitude;  
	var city = result.city;   
	var ipNbr = result.ip 
	$("#city").text(city); 
	$("#ipNbr").text(ipNbr);   

	$.ajax({     
		method: "GET",   
		url: "http://api.openweathermap.org/data/2.5/weather?lat="+lat+"&lon="+long+"&units= metric"+ "&APPID=aa9b5a1458c308a6aa531443956114e4", 
		error: ajaxWeatherReturn_Error,     
		success: ajaxWeatherReturn_Success      
	}) 

	function ajaxWeatherReturn_Success(result, status, xhr) { 
		var sunrise = result.sys.sunrise;   
		var sunset = result.sys.sunset; 
		var sunriseDate = new Date(sunrise*1000);  
		var timeStrSunrise = sunriseDate.toLocaleTimeString();    
		var sunsetDate = new Date(sunset*1000);  
		var timeStrSunset = sunsetDate.toLocaleTimeString(); 

		$("#sunrise").text("Sunrise: "+timeStrSunrise);  
		$("#sunset").text("Sunset: "+timeStrSunset); 
		$("#weather").text(result.weather[0].main);     
		$("#degree").text((result.main.temp-273.15).toFixed(0)+" \u2103");       }// convert

	function ajaxWeatherReturn_Error(result, status, xhr) {   
		alert("Error i OpenWeaterMap Ajax");  
		console.log("Ajax-find movie: "+status);      } 





	

} 
