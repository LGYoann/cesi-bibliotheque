<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
     <%@ page import = "java.io.*" %>
      <%@ page import = "java.util.*"%>
      <%@ page import = "fr.cesi.commerce.entity.AuteurJPA"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table>
<% List<AuteurJPA> malist = (List<AuteurJPA>)request.getAttribute("mesAuteurs");%>
<% for (AuteurJPA item : malist) { %>
<tr>
	<td></td>
	<td>
		<form method="post" action="supprimerAuteur">
			<label><%= item.getName() %> </label>
			<input type="hidden" id="value" name="value" value=<%= item.getId() %>> </>
    		<button type="submit">Supprimer</button>
		</form>
	</td>
</tr>

<% } %>
</table>
</body>
<a href="http://localhost:8080/commerce/listAuteur"></a>
</html>