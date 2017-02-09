<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
    	<meta http-equiv="X-UA-Compatible" content="IE=edge">
    	<meta name="viewport" content="width=device-width, initial-scale=1">
		
		<title>DASHBOARD</title>
		
		<link rel="stylesheet" href="css/bootstrap.css">
	</head>
	<body>
		<h1>DashBoard</h1>   
	    <p>Bonjour <%= (String) request.getSession().getAttribute("firstname") %> <%= (String) request.getSession().getAttribute("lastname") %> !</p>
	    <p>Ton mail : <%= (String) request.getSession().getAttribute("email") %></p>
	    <p>Ton userId : <%= (int) request.getSession().getAttribute("id") %></p>
	    
	    <a href="logout">Se déconnecter</a>
	    
	    <script src="js/jquery.js"></script>
	    <script src="js/bootstrap.js"></script>
	</body>
</html>