<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %> 
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<body>
	<form:form action="selectCorso" method="POST" modelAttribute="corso">
	
		<form:label path="cdlId">ID corso</form:label>
		<form:input path="cdlId"  name="id" type="text" value=""/><br/>
		<form:errors path="cdlId" cssClass="error"/>
		<h2>${corso.cdlNome}</h2>
		<input type="submit" value="Cerca"/>
    
	</form:form>  
	<h2>${select.cdlNome}</h2>
</body>
</html>
