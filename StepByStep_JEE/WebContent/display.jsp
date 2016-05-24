<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<jsp:useBean id="myUser" scope="session" class="step2.model.UserModelBean"/>
<jsp:setProperty property="*" name="myUser"/>

</head>
<body>
<h5> lastname : <jsp:getProperty name="myUser" property="lastname"/> </h5>
<h5> surname : <jsp:getProperty name="myUser" property="surname"/> </h5>
<h5> age : <jsp:getProperty name="myUser" property="age"/> </h5>
<h5> login : <jsp:getProperty name="myUser" property="login"/> </h5>
<h5> pwd : <jsp:getProperty name="myUser" property="pwd"/> </h5>

</body>
</html>