<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Error Page</title>
</head>
<body>
	<h2>Errore</h2>

	<h3>Debug Information:</h3>

	Requested URL= ${url}
	<br>
	<br> Exception class   = ${exception.getClass()} ${exception.message}
	<br> Exception message = ${exception.message}
	<br>
	<br>

	<strong>Exception Stack Trace</strong>
	<br>
	<c:forEach items="${exception.stackTrace}" var="ste">
	${ste}
</c:forEach>

</body>
</html>