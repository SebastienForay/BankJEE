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
			
			<h1>Mon tableau de bord</h1>
			
			<table class="table table-striped">
				<thead>
					<tr>
						<th>Libelé</th>
						<th>Taux d'intérêts</th>
						<th>Date de création</th>
						<th>Solde</th>
					</tr>
				</thead>
				<tbody>
				<c:forEach items="${accounts}" var="a">
					<tr>
						<th scope="row"><a href="account?id=${ a.getId() }">${ a.getLabel() }</a></th>
						<td>${ a.getInterest() }</td>
						<td>${ a.getCreationDate() }</td>
						<td>${ a.getBalance() }</td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
		</div>
		
		    		    
	    <script src="../js/jquery.js"></script>
	    <script src="../js/bootstrap.js"></script>
	</body>
</html>