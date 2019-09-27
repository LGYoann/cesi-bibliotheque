<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page import = "java.io.*" %>
      <%@ page import = "java.util.*"%>
      <%@ page import = "fr.cesi.commerce.entity.AuteurJPA"%>
       <%@ page import = "fr.cesi.commerce.operations.OperationAuteur"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% OperationAuteur OA = new OperationAuteur(); %>
<form  method="post" action="insertLivre">
	    <div>
	     	<label for="name">titre:</label>
	        <input type="text" id="titre" name="titre">
		<select id="auteurs" name="auteurs">
			<% for (AuteurJPA item : OA.getAllAuteurs() ){ %>
			
		  <option value="<%= item.getName() %>"> <%= item.getName() %></option>
		  <% } %>
		</select>
	    </div>	  
	
	<div class="button">
        <button type="submit">Sauvegarder</button>
    </div>
    </form>
</body>
</html>