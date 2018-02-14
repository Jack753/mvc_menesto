<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<body>
	<h2>Nome ${corsi.get(0).getCdlNome()} 
	Durata	${corsi.get(0).getCdlDurata() }</h2>
	<h2></h2>
	<ul>
		<c:forEach var="col" items="${corsi}">
			<li>${col.getCdlNome()}</li>
		</c:forEach>
	</ul>

</body>
</html>
