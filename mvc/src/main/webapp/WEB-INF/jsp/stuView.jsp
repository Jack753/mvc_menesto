<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<style>
table, th, td {
	border: 1px solid black;
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

	<table id="t01" style="width: 50%">
		<tr>
			<th>Firstname</th>
			<th>Lastname</th>
			<th>Matricola</th>
		</tr>

		<c:forEach var="col" items="${stu}">
			<tr>
				<td>${col.getStuCognome()}</td>
				<td>${col.getStuNome()}</td>
				<td>${col.getStuMatricola()}</td>

			</tr>
		</c:forEach>


	</table>


</body>
</html>
