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
Place or Cuisine<input type="text" name="search">

<br>
<br>
<input type="submit" value="Search by place">
<input type="hidden" name="hidden" value="SearchByPlace"/>
<input type="submit" value="Search by cuisine">
<input type="hidden" name="SearchByCuisine" value="SearchByCuisine"/>
</form>
</body>
</html>