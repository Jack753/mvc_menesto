<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<html>
<style>
#error{
	color: red;
}
</style>
<!-- stuCognome == null || stuNome == null || stuSesso == null || stuIscrizione == null
				|| stuCorsoDiLaurea == null -->
<body>
	<form:form method="POST" action="insertStudente"
		modelAttribute="iscrizione">
		<table>
			<tr>
				<td><form:label path="stu.stuCognome">
				<spring:message code="label.cognome"/>
				</form:label></td>
				<td><form:input path="stu.stuCognome" /></td>
				<td><form:errors path="stu.stuCognome" cssClass="error" />
			</tr>
			<tr>
				<td><form:label path="stu.stuNome">
				<spring:message code="label.nome"/>
				</form:label></td>
				
				<td><form:input path="stu.stuNome" /></td>
				<td><form:errors path="stu.stuNome" cssClass="error" />
			</tr>
			<tr>
				<td>
				<spring:message code="label.maschio"/>:<form:radiobutton path="stu.stuSesso" value="M"></form:radiobutton><br />
				<spring:message code="label.femmina"/>:<form:radiobutton path="stu.stuSesso" value="F"></form:radiobutton>
				</td>
				<td><form:errors path="stu.stuSesso" cssClass="error" />
			</tr>

			<tr>
				<td><form:select path="id">
						<form:option value="-" label="please select" />
						<form:options items="${iscrizione.cdl}" itemValue="cdlId"
							itemLabel="cdlNome" />
					</form:select></td>
			</tr>

			<tr>
			<spring:message code="label.invia" var="btnsubmit"/>
				<td><input type="submit" value="${btnsubmit}" /></td>
			</tr>
		</table>
	</form:form>

	<table>
		<tr>
			<td>${iscrizione.stu.getStuMatricola()}</td>
			<td>${iscrizione.stu.getStuCognome()}</td>
			<td>${iscrizione.stu.getStuNome()}</td>
			<td>${iscrizione.stu.getStuSesso()}</td>
			<td>${iscrizione.stu.getStuIscrizione()}</td>
			<td>${iscrizione.stu.getStuCorsoDiLaurea().getCdlNome()}</td>
		</tr>
	</table>
	<%-- 	${iscrizione.cdl.get(0).getCdlNome()} 
 --%>
</body>
</html>


