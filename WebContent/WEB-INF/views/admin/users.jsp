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
	</head>
	<body>
	
		<%@ include file="/WEB-INF/includes/navbar.jsp"%>
		
		<div class="container">
			
			<h1>Administration des utilisateurs</h1>
			
			<table class="table table-striped">
				<thead>
					<tr>
						<th>Prénom</th>
						<th>Nom</th>
						<th>Email</th>
						<th>Type</th>
					</tr>
				</thead>
				<tbody>
				<c:forEach items="${users}" var="user">
					<tr>
						<th scope="row">${ user.getFirstname() }</a></th>
						<td>${ user.getLastname() }</td>
						<td>${ user.getEmail() }</td>
						<td>${ user.getType() }</td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
		    
		    <a href="logout">Se déconnecter</a>
		    
		    <script src="../js/jquery.js"></script>
		    <script src="../js/bootstrap.js"></script>
	    
		</div>
	</body>
</html>