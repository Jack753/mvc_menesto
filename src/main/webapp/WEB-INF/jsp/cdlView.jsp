<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %> 
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<body>
<h2>Nome Corso di Laurea: ${corsi.get(0).getCdlNome()}</h2>
<h2>Durata: ${corsi.get(0).getCdlDurata()}</h2>
<ul>
	<c:forEach var="col" items="${corsi}">
	<li> <a href="http://localhost:8080/corso/uni/listastudenti/${col.getCdlId()}">${col.getCdlNome()}</a> </li>
	<a id="myButton" href="http://localhost:8080/corso/uni/cancellaCorso/${col.getCdlId()}" >Cancella</a>
	</c:forEach>
</ul>
<!-- <script type="text/javascript">
    document.getElementById("myButton").onclick = function () {
        location.href = "http://localhost:8080/corso/uni/cancellaCorso/${col.getCdlId()}";
    };
</script> -->
	
</body>
</html>
