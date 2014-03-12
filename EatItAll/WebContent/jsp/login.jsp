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
Username<input type="text" name="username"/>
<br>
Password<input type="password" name="password"/>
<br>
<input type="submit" value="Login">
<br>
<a href ="newuser.jsp">Create new user</a>
<input type="hidden" name="hidden" value="Login"/>

</form>
</body>
</html>