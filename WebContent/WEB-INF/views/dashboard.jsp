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
		<div class="container">
			
			<h1>Mon tableau de bord</h1>
			
		    <p>Bonjour <%= (String) request.getAttribute("firstname") %> <%= (String) request.getAttribute("lastname") %></p>
		    <p>Email : <%= (String) request.getAttribute("email") %></p>
		    
			<table class="table table-striped">
				<thead>
					<tr>
						<th>Libelé</th>
						<th>Solde</th>
						<th>Date de création</th>
						<th>Taux d'intérêts</th>
					</tr>
				</thead>
				<tbody>
				<c:forEach items="${accounts}" var="a">
					<tr>
						<th scope="row">${ a.label }</th>
						<td>${ a.balance }</td>
						<td>${ a.creationDate }</td>
						<td>${ a.interest }</td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
		    
		    <a href="logout">Se déconnecter</a>
		    
		    <script src="js/jquery.js"></script>
		    <script src="js/bootstrap.js"></script>
	    
		</div>
	</body>
</html>