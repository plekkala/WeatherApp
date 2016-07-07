<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	<script>  
function validateform(){  
var cityVal=document.form.city.value;  
  
if (cityVal==null || cityVal==""||cityVal.trim().length<=0){  
  alert("City can't be blank");  
  return false;  
}
}  
</script>  
</head>
<body>
	

	<div class="container">
		<h2>Weather App</h2>
		<form name="form" action="details" method="get" onsubmit="return validateform()" >
			<div class="form-group">
				<label for="email">City:</label> <input type="text" name="city" id="city"
					value="" />
			</div>
			<button type="submit" class="btn btn-primary" name=first value="search">Submit</button>
		</form>
	</div>
</body>
</html>
