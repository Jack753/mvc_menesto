<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %> 
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<body>
<h2>Nome Corso di Laurea: ${corso.getCdlNome()}</h2>
<h2>Durata: ${corso.getCdlDurata()}</h2>

</body>
</html>
