$(document).ready(function(){

	
	
	
	
	$.getJSON("http://localhost:8080/RestServerTravelProject/Customers?method=methodA", function(data){
		var customer_data = '';
		$.each(data, function(key, value){
			customer_data += '<tr>';
			customer_data += '<td><a href="#">' + value.id + '</td>';
			customer_data += '<td onclick = "content()">' + value.name + '</td>';
			customer_data += '<td>' + value.address + '</td>';
			customer_data += '<td>' + value.ssn + '</td>';
			customer_data += '</tr>';
			
		
		});
		$('#customer_table').append(customer_data)
			
			
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


	$("#FindBtn").click( function() {

		var strValue = $("#id").val();

		if (strValue != "") {
			$.ajax({
				method: "GET",
				url: "http://localhost:8080/RestServerTravelProject/Customers/"+strValue + "?method=methodA",
				error: ajaxFindReturnError,
				success: ajaxFindReturnSuccess

			})
			function ajaxFindReturnSuccess(result, status, xhr) {

				ParseJsonFileCustomer(result);

			}
			function ajaxFindReturnError(result, status, xhr) {
				alert("Error");
				console.log("Ajax-find customer: "+status);
				
			}
		}
	})// btnclick

	$("#AddBtn").click( function() {
		var strName = $("#customerName").val();
		var strAddress = $("#customerAddress").val();
		var strSsn = $("#customerSsn").val();
		var ajaxId =  $("#AddBtn").val();
	
		var obj = { name: strName, address: strAddress, ssn: strSsn, id: ajaxId};
		var jsonString = JSON.stringify(obj);
		if (strSsn != "") {
			$.ajax({
				method: "POST",
				url: "http://localhost:8080/RestServerTravelProject/Customers/",
				data: jsonString,
			//	dataType:'json',
				error: ajaxAddReturnError,
				success: ajaxAddReturnSuccess
			})
			function ajaxAddReturnSuccess(result, status, xhr) {
				clearFields();
				$("#id").attr("placeholder","Customer added" );
			}
			function ajaxAddReturnError(result, status, xhr) {
				alert("Error Add");
				console.log("Ajax-find Customer: "+status);
			}
		}
	})// btnclick

	$("#UpdateBtn").click( function() {
		var strId = $("#id").val();
		var strName = $("#customerName").val();
		var strAddress = $("#customerAddress").val();
		var strSsn = $("#customerSsn").val();
		var ajaxId =  $("#AddBtn").val();
		var obj = { id: strId, name: strName, ssn: strSsn, address: strAddress, ajaxId: ajaxId};
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
				$("#id").attr("placeholder","Customer updated" );
			}
			function ajaxUpdateReturnError(result, status, xhr) {
				alert("Error Update");
				console.log("Ajax-find Customer: "+status);
			}
		}
	})// btnclick


	$("#DeleteBtn").click( function() {
		var strValue = $("#id").val();
		var ajaxId =  $("#DeleteBtn").val();
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
				$("#customerName").attr("placeholder","Customer deleted" );
			}
			function ajaxDelReturnError(result, status, xhr) {
				alert("Error");
				console.log("Ajax-find Customer: "+status);
			}
		}
	})// btnclick

	$("#customer_table").on('click','tr',function(e) { 
	    alert($(this).attr('id')); 
	}); 

}); // End ready function

function ParseJsonFileCustomer(result) {

	$("#customerName").val(result.name);
	$("#id").val(result.id);
	$("#customerAddress").val(result.address);
	$("#customerSsn").val(result.ssn);
}


function clearFields() {

	$("#id").val("");
	$("#customerAddress").val("");
	$("#customerSsn").val("");
	$("#customerName").val("");
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
