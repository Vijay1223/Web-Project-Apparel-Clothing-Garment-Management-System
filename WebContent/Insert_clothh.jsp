<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor=#eb984e>
	<%@ page import="java.io.*"%>
	<%@ page import="java.sql.*"%>
	<form action="Insert_cloth" method="post">
		<%! String driverName = "com.mysql.jdbc.Driver";%>
		<%!String url = "jdbc:mysql://localhost:3306/apparel_management";%>
		<%!String user = "root";%>
		<%!String paassword = "root";%>

		<%
try
{
	Class.forName(driverName);
	Connection con = DriverManager.getConnection(url, user, paassword);

	String queryString22 = "SELECT * FROM Brand";
	String queryString33 = "SELECT * FROM Material_type";



PreparedStatement pss2 = con.prepareStatement(queryString22);
PreparedStatement pss3 = con.prepareStatement(queryString33);

ResultSet rsss = pss2.executeQuery();
ResultSet rssss = pss3.executeQuery();
%>

		<p>
			Select Brand name : <select name="Brand_nameee">

				<%  while(rsss.next()){ %>
				<option><%= rsss.getString(1)%></option>
				<% } %>
			</select>

		</p>
		<p>
			Select Material ID : <select name="Material_typeiddd">

				<%  while(rssss.next()){ %>
				<option><%= rssss.getString(1)%></option>
				<% } %>
			</select>

		</p>
		<%
}
catch (ClassNotFoundException | SQLException e) {

	e.printStackTrace();
}
%>



		<p>
			ClothID<input type="text" placeholder="enter Cloth_id"
				name="Cloth_iddd">
		<p>
		<p>
			TypeName:- <input type="text" placeholder="Enter the type name"
				name="Type_nameee">
		</p>
		<p>
			Color:- <input type="text" placeholder="Enter the color"
				name="Colorrr">
		</p>
		<p>
			Size:- <input type="text" placeholder="Enter the size" name="Sizeee">
		</p>
		<p>
			<button type="submit">Insert</button>
		</p>
	</form>

</body>
</html>