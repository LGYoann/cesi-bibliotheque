<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page import = "java.io.*" %>
      <%@ page import = "java.util.*"%>
      <%@ page import = "fr.cesi.commerce.entity.LivreJPA"%>
       <%@ page import = "fr.cesi.commerce.operations.OperationAuteur"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table>
<% List<LivreJPA> malist = (List<LivreJPA>)request.getAttribute("mesLivres");%>
<% for (LivreJPA item : malist) { %>
<tr>
	<td>
		<form method="post" action="supprimerLivre">
			<label> <%= item.getTitre() %> </label>
			<label> Ecrit par : <%= item.getAuteur().getName() %> </label>
			<input type="hidden" id="value" name="value" value=<%= item.getId() %>> </>
    		<button type="submit">Supprimer</button>
		</form>
	</td>	
</tr>


</table>
<% } %>
</body>
<a href="http://localhost:8080/commerce/listLivre"></a>
</html>