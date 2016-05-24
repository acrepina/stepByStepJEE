<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Step 2 : Confirmation</title>
	<jsp:useBean id="myUser" scope="session" class="step2.model.UserModelBean" />
<jsp:setProperty property="*" name="myUser"/>

</head>
<body>
	<form action="Servlet3" method="post">
	Save Data ?
	<input type="submit" value="GO !">
	</form>
</body>
</html>