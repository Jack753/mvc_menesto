<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %> 
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<style>
table, th, td {
    border: 1px solid black;
    color: blue;
    text-align: center;
}
table#t01 tr:nth-child(even) {
    background-color: #eee;
}
table#t01 tr:nth-child(odd) {
    background-color: #fff;
}
table#t01 th {
    color: white;
    background-color: black;
}
</style>
<body>
<table align="center" id="t01" style="width:80%">
  <tr>
    <th>Firstname</th>
    <th>Lastname</th> 
    <th>Age</th>
  </tr>
  <c:forEach var="s" items="${stu}">
  <tr>
    <td>${s.getStuNome()}</td>
    <td>${s.getStuCognome()}</td> 
    <td>${s.stuDataNascita}</td>
  </tr>
  </c:forEach>
  </table>
<%-- <ul>
	<c:forEach var="s" items="${stu}">
	<li> ${s.getStuNome()} </li>
	<li> ${s.getStuCognome()} </li>
	</c:forEach>
</ul>
 --%></body>
</html>
