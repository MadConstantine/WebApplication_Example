<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add item</title>
</head>
<body>
	<div>
		<h1> ADD Item </h1>
	</div>
	<form method="post">
		<label>Type
			<input type="text" name="type"><br />
		</label>

		<label>Receiver Index
			<input type="text" name="recv_index"><br />
		</label>

		<label>Receiver Adress
			<input type="text" name="recv_adr"><br />
		</label>

		<label>Receiver Name
			<input type="text" name="recv_name"><br />
		</label>

		<button type="submit">Submit</button>
	</form>
	<div>
		<% 
			String parcelInfo;
			if (( parcelInfo = (String) request.getAttribute("parcelinfo") ) != null) {
				out.println("<p>" + parcelInfo + " successfully added!</p>");
			}
		%>
	</div>
	<div>
		<button onclick="location.href='/TrackServiceAPI'">Back</button>
	</div>
</body>
</html>