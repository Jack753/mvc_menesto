<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %> 
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<html>
<body>
	<form:form action="studenteCreato" method="POST" modelAttribute="studente">
	<td>
		<tr>
		<form:label path="stu.stuNome">
			<spring:message code="label.nome"/>
		</form:label>
		<form:input path="stu.stuNome"  name="id" type="text" value=""/><br/></tr>
		<tr>
		<form:label path="stu.stuCognome">
			<spring:message code="label.cognome"/>
		</form:label>
		<form:input path="stu.stuCognome"  name="id" type="text" value=""/><br/>
		<form:errors path="stu.stuCognome">cognome troppo corto!</form:errors>
		</tr>
		<tr>
		<form:label path="stu.stuCorsoDiLaurea">Corso Di Laurea</form:label><br/>
		
		<%-- <c:forEach var="cdl" items="${studente.cdl}">
			${cdl.getCdlNome()}<form:input path="stu.stuCorsoDiLaurea"  name="id" type="text" value=""/><br/>
			<h2>${cdl.getCdlNome()}</h2>
		</c:forEach> --%>
		<form:select path="id">
			<form:option value="-" label="please select"></form:option>
			<form:options items="${studente.cdl}" itemValue="cdlId" itemLabel="cdlNome"/>
		</form:select>
		<br/>
		</tr>
		<tr>
		<spring:message code="label.maschio"/> <form:radiobutton path="stu.stuSesso" value="M"/><br/>
		<spring:message code="label.femmina"/> <form:radiobutton path="stu.stuSesso" value="F"/><br/>
		</tr>
	</td>
		<%-- <form:label path="stuIscrizione">Anno Iscrizione</form:label>
		<form:input path="stuIscrizione"  name="id" type="text" value=""/><br/> --%>
		<spring:message code="label.invia" var="btnsubmit"/>
		<input type="submit" value="${btnsubmit}"/>
		
	</form:form>  
 	<h2>${studente.stu.getStuMatricola()}</h2>
	<h2>${studente.stu.stuNome}</h2>
	<h2>${studente.stu.stuCognome}</h2>
	<h2>${studente.stu.stuSesso}</h2>
</body>
</html>
