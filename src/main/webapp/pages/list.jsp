<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List items</title>
</head>
<body>
	<div>
		<h1> LIST of Items </h1>
	</div>
	
	<table>
	<tr>
		<th>ID</th>
		<th>TYPE</th>
		<th>INDEX</th>
		<th>ADRESS</th>
		<th>NAME</th>
	</tr>
	<tr>
		<td>
			<ul>
				<%
					List<Long> idList = (List<Long>) request.getAttribute("idlist");
				
					if ( idList != null && !idList.isEmpty() ) {
						for (Long id : idList) {
							out.println("<li>" + id + "</li>");
						}
					}
					else {
						out.println("<p>No parcels to display!</p>");
					}
				%>
			</ul>
		</td>
		<td>
			<ul>
				<%
					List<String> typeList = (List<String>) request.getAttribute("typelist");
					
					if ( typeList != null && !typeList.isEmpty() ) {
						for (String type : typeList) {
							out.println("<li>" + type + "</li>");
						}
					}
				%>
			</ul>
		</td>
		<td>
			<ul>
				<%
					List<String> indexList = (List<String>) request.getAttribute("indexlist");
					
					if ( indexList != null && !indexList.isEmpty() ) {
						for (String index : indexList) {
							out.println("<li>" + index + "</li>");
						}
					}
				%>
			</ul>
		</td>
		<td>
			<ul>
				<%
					List<String> adrList = (List<String>) request.getAttribute("adrlist");
					
					if ( adrList != null && !adrList.isEmpty() ) {
						for (String adr : adrList) {
							out.println("<li>" + adr + "</li>");
						}
					}
				%>
			</ul>
		</td>
		<td>
			<ul>
				<%
					List<String> nameList = (List<String>) request.getAttribute("namelist");
					
					if ( nameList != null && !nameList.isEmpty() ) {
						for (String name : nameList) {
							out.println("<li>" + name + "</li>");
						}
					}
				%>
			</ul>
		</td>
	</tr>
	</table>
	<div>
		<button onclick="location.href='/TrackServiceAPI'">Back</button>
	</div>
</body>
</html>