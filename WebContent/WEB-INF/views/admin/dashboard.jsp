<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
    	<meta http-equiv="X-UA-Compatible" content="IE=edge">
    	<meta name="viewport" content="width=device-width, initial-scale=1">
		
		<title>Crédit Auvence - Tableau de bord</title>
		
		<link rel="stylesheet" href="../css/bootstrap.css">
		<link rel="stylesheet" href="../css/admin.css">
	</head>
	<body>
	
		<%@ include file="/WEB-INF/includes/navbar.jsp"%>
		
		<div class="container">
			
			<h1>Administration</h1>
			<br>
			<div class="col-md-12">
				<div class="bs-glyphicons col-md-4">
					<ul class="bs-glyphicons-list">
						<li><a href="admin/users"><div class="customer"><span class="glyphicon glyphicon-user" aria-hidden="true"></span><br>Gérer les clients</div></a></li>
						<li><a href="#"><div class="advisor"><span class="glyphicon glyphicon-user" aria-hidden="true"></span><br>Gérer les conseillers</div></a></li>
					</ul>
				</div>
			</div>

		    <a href="logout">Se déconnecter</a>
		    
		    <script src="../js/jquery.js"></script>
		    <script src="../js/bootstrap.js"></script>
	    
		</div>
	</body>
</html>