<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>step2 : Display</title>
	<jsp:useBean id="myUser" scope="session" classe="step2.model.UserModelBean"/>
		<jsp:setProperty property="myUser" name="surename"/>
		<jsp:setProperty property="myUser" name="lastname"/>
		<jsp:setProperty property="myUser" name="age"/>
		<jsp:setProperty property="myUser" name="login"/>
		<jsp:setProperty property="myUser" name="pwd"/>
</head>
<body>
; TODO
</body>
</html>