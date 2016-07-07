<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Display Weather Data</title>
</head>
<body>
	<div class="container">
		<h2>
			Weather Details for
			<%=request.getAttribute("city")%></h2>
		<table class="table" border="2px">
			<tbody>
				<tr>
					<td>Todays Date</td>
					<td><%=request.getAttribute("date")%></td>
				</tr>
				<tr>
					<td>City</td>
					<td><%=request.getAttribute("city")%></td>
				</tr>
				<tr>
					<td>Weather Description</td>
					<td><%=request.getAttribute("desc")%></td>
				</tr>
				<tr>
					<td>Temperature in Fahrenheit</td>
					<td><%=request.getAttribute("tempF")%></td>
				</tr>
				<tr>
					<td>Temperature in Celsius</td>
					<td><%=request.getAttribute("tempC")%></td>
				</tr>
				<tr>
					<td>Sunrise</td>
					<td><%=request.getAttribute("sunrise")%></td>
				</tr>
				<tr>
					<td>Sunset</td>
					<td><%=request.getAttribute("sunset")%></td>
				</tr>
			</tbody>
		</table>
		<form action="details" method="get">
			<button type="submit" class="btn btn-primary" name=first value="back">Search Again</button>
    		</form>
	</div>


</body>
</html>