<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div>
	<form  method="post" action="login">
	    <div>
	        <label for="name">User :</label>
	        <input type="text" id="user" name="user">
	    </div>	   
	    <div>
	        <label for="pass">Pass :</label>
	        <input type="password" id="pass" name="pass">
	    </div>	   
	
	<div class="button">
        <button type="submit">Envoyer le message</button>
    </div>
    </form>
</body>
</html>