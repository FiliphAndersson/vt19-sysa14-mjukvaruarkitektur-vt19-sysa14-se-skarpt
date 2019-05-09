$(document).ready(function(){
	
	load_json_data('customer');
	function load_json_data(id, parent_id)
	{
		var html_code = '';
		$.getJSON("http://localhost:8080/RestServerTravelProject/Customers?method=methodA", function(data){
			html_code += '<option value=""> Select ' +id+ '</option>';
			$.each(data, function(key, value){
				if (id = 'customer')
					{
					   html_code += '<option value="'+value.id+'">' + "Id: " +  value.id + " " +value.name+ " "  + '</option>';
					   
					}
			});
			$('#'+id).html(html_code);
		});
	}
	
	
	load_json_dataDestination('destination');
	function load_json_dataDestination(id, parent_id)
	{
		var html_code = '';
		$.getJSON("http://localhost:8080/RestServerTravelProject/Customers?method=findDestination", function(data){
			html_code += '<option value=""> Select ' +id+ '</option>';
			$.each(data, function(key, value){
				if (id = 'destination')
					{
					   html_code += '<option value="'+value.id+'">'+ " Id: " + value.id + " "+ value.hotel +  '</option>';
					   
					}
			});
			$('#'+id).html(html_code);
		});
	}


	

	

	
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
	{           
		console.log("Ajax-api-stack: "+status);    
	}
	

	$("#Addbooking").click( function() {
		var strCustomerId = $("#customer").val();
		var strDestinationId =  $("#destination").val();
		var strDepartureDate = $("#departureDate").val();
		var strHomeDate = $("#homeDate").val();
		var ajaxId = this.id;
		
		//alert(strCustomerId + " " + strDestinationId + strDepartureDate + strHomeDate + ajaxId);
	
		var obj = { customerId: strCustomerId, destinationId: strDestinationId, departureDate: strDepartureDate, homeDate: strHomeDate, id: ajaxId};
		var jsonString = JSON.stringify(obj);
		if (strCustomerId!= "" && strDestinationId!="" && strDepartureDate!= "" && strHomeDate != "" ) {

			$.ajax({
				method: "POST",
				url: "http://localhost:8080/RestServerTravelProject/Customers/",
				data: jsonString,
			//	dataType:'text',
				error: ajaxAddReturnError,
				success: ajaxAddReturnSuccess
			})
			function ajaxAddReturnSuccess(result, status, xhr) {
				
			//	clearFields();
			//	$("#bookingId").attr("placeholder","Booking added" );
				location.reload()
				
			}
			function ajaxAddReturnError(result, status, xhr) {
				alert("Error Add");
				console.log("Ajax-find Booking: "+status);
			}
		}
	
	})// btnclick
	

		$("#DeleteBookingBtn").click( function() {
		var id = $("#bookingId").val();
		var ajaxId =  this.id;
		var obj = { id: id, ajaxId: ajaxId};
		var jsonString = JSON.stringify(obj);
		
		if (id!= "") {
			$.ajax({
				method: "DELETE",
				url: "http://localhost:8080/RestServerTravelProject/Customers/"+id,
				data: jsonString,
			//	dataType:'json',
				error: ajaxDelReturnError,
				success: ajaxDelReturnSuccess
			})
			function ajaxDelReturnSuccess(result, status, xhr) {
				alert(" success, raderat. ändra denna till ngt bättre.");
				// LÄGG TILL DENNA METOD clearFields();
				location.reload()
			}
			function ajaxDelReturnError(result, status, xhr) {
				alert("Error");
				console.log("Ajax-delete Booking: "+status);
			}
		}
	})// btnclick
	
	
		$("#UpdateBookingBtn").click( function() {
			var strCustomerId = $("#customer").val();
			var strDestinationId =  $("#destination").val();
			var strDepartureDate = $("#departureDate").val();
			var strHomeDate = $("#homeDate").val();
			var strBookingId = $("#bookingId").val();
			var ajaxId = this.id;
			var obj = {bookingId: strBookingId, customerId: strCustomerId, destinationId: strDestinationId, departureDate: strDepartureDate, homeDate: strHomeDate, ajaxId: ajaxId};
		var jsonString = JSON.stringify(obj);
		if (strCustomerId!= "" && strDestinationId!="" && strDepartureDate!= "" && strHomeDate != "" ) {
			$.ajax({
				method: "PUT",
				url: "http://localhost:8080/RestServerTravelProject/Customers/",
				data: jsonString,
				//dataType:'json',
				error: ajaxUpdateReturnError,
				success: ajaxUpdateReturnSuccess
			})
			function ajaxUpdateReturnSuccess(result, status, xhr) {

				updateBookingsOnClick();
				updateTest();
				
				location.reload();
				
				//alert("Update success, replace this") //ERSÄTT DETTA
			//	$("#id").attr("placeholder","Destination updated" ); //ERSÄTT DETTA.
			
			}
			function ajaxUpdateReturnError(result, status, xhr) {
				alert("Error Update");
				console.log("Ajax-find Destination: "+status);
			}
		}
	})// btnclick
	

	
	
	 $("div.booking_table table").delegate('tr', 'click', function() {
        alert("You clicked my <tr>!");
        //get <td> element values here!!??
    });
	//Dynamiskt ladda in data när man klickar på tabellen
	


	updateTest();
	updateBookings();
}); // End ready function


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

function clearBookings(){
	
	var elmtTable = document.getElementById('booking_table');
	var tableRows = elmtTable.getElementsByTagName('tr');
	var rowCount = tableRows.length;

	for (var x=rowCount-1; x>0; x--) {
	   elmtTable.removeChild(tableRows[x]);
	}
	
}
function clearBookings(){
	var booking_data = '';
	$('#booking_table').append(booking_data)
	
}

function updateTest(){
	//Lägger på clicktracker när body laddas så listan är klar.
	$('body').on({
	    click: function(){
	    	  var bid, trid;
	    	  $('#booking_table tr').click(function() {
	    		  //Get data from table
	    	       var currow = $(this).closest('tr');
	    	       var bookingId = currow. find('td:eq(0)').text();
	    	       var dateOut = currow. find('td:eq(1)').text();
	    	       var dateHome = currow. find('td:eq(2)').text();
	    	       var customerId = currow. find('td:eq(5)').text();
	    	       var destinationId = currow. find('td:eq(6)').text();
	    	       //put data in boxes
	    	       $("#bookingId").val(bookingId); 
	    	       $("#departureDate").val(dateOut); 
	    	       $("#homeDate").val(dateHome); 
	    	       $("#destination").val(destinationId);
	    	       $("#customer").val(customerId);
	    	   
	    	  });
	    	
	
	    }
	}, '#booking_table tr' ) 
	
	
	
	
}

function updateBookings(){
	
	$.getJSON("http://localhost:8080/RestServerTravelProject/Customers?method=findBooking", function(data){
		//ta bort hela tablet först för att undvika duplikater.
		
		var elmtTable = document.getElementById('booking_table');
		var tableRows = elmtTable.getElementsByTagName('tr');
		var rowCount = tableRows.length;
	
		for (var x=rowCount-1; x>0; x--) {
		   elmtTable.removeChild(tableRows[x]);
		}
		
		//$("#booking_table:not(:first)").remove();

		var booking_data = '';
		$.each(data, function(key, value){
			booking_data += '<tr id='+value.id+'>';
			booking_data += '<td><a href="#">' + value.id + '</td>';
			booking_data += '<td onclick = "content()">' + value.dateOut + '</td>';
			booking_data += '<td>' + value.dateHome + '</td>';
			booking_data += '<td>' + value.customerName + '</td>';
			booking_data += '<td>' + value.destinationHotel + '</td>';
			booking_data += '<td>' + value.customerId + '</td>';
			booking_data += '<td>' + value.destinationId + '</td>';
			booking_data += '</tr>';	
			
		
		});
		$('#booking_table').append(booking_data)
			
	
	});
	
	
	
}

function deleteBookings(){
	
}

function updateBookingsOnClick(){
	
	  
	$.getJSON("http://localhost:8080/RestServerTravelProject/Customers?method=findBooking", function(data){
		//ta bort hela tablet först för att undvika duplikater.
		
		var elmtTable = document.getElementById('booking_table');
		var tableRows = elmtTable.getElementsByTagName('tr');
		var rowCount = tableRows.length;
	
		for (var x=rowCount-1; x>0; x--) {
		   elmtTable.removeChild(tableRows[x]);
		}
		//$("#booking_table:not(:first)").remove();

		var booking_data = '';
		$.each(data, function(key, value){
			booking_data += '<tr id='+value.id+'>';
			booking_data += '<td>' + value.id + '</td>';
			booking_data += '<td>' + value.dateOut + '</td>';
			booking_data += '<td>' + value.dateHome + '</td>';
			booking_data += '<td>' + value.customerName + '</td>';
			booking_data += '<td>' + value.destinationHotel + '</td>';
			booking_data += '<td>' + value.customerId + '</td>';
			booking_data += '<td>' + value.destinationId + '</td>';
			booking_data += '</tr>';	
			
		
		});
		$('#booking_table').append(booking_data)
			
	
	});
	
	
	
}