<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>

<body>
	<form:form method="POST" action="selectCorso" modelAttribute="corso">
		<table>
			<tr>
				<td><form:label path="cdlId">ID Corso</form:label></td>
				<td><form:input path="cdlId" /></td>
				<td><form:errors path="cdlId" cssClass="error"/>
				<td>${corso.cdlNome}</td>

			</tr>
			<tr>
				<td><input type="submit" value="Submit" /></td>
			</tr>
		</table>
	</form:form>


</body>
</html>


