<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form name="form" action="<%=request.getContextPath() %>/" method="post">
<%= session.getAttribute("username") %>
<a href ="search.jsp">Search Restaurant</a>
<br>
<br>
<input type="Submit" name="reservation" value="Reservation">
<br>
<br>
<input type="Submit" name="favourite" value="Favourite">
<select name="resturants"> 
<option value="mcd">
mcd
</option>

<option value="qdoba">
qdoba
</option>
<option value="wollaston">
wollaston
</option>
</select>
<br>
<br>
<input type="Submit" name="logout" value="LogOut">
<input type="hidden" name="hidden" value="LogOut"/>
</form>
</body>
</html>