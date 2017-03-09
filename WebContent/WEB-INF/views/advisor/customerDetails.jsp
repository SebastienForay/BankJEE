<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
    	<meta http-equiv="X-UA-Compatible" content="IE=edge">
    	<meta name="viewport" content="width=device-width, initial-scale=1">
		
		<title>Crédit Auvence - Détail du client</title>
		
		<link rel="stylesheet" href="../../../css/bootstrap.css">
	</head>
	<body>
	
		<%@ include file="/WEB-INF/includes/navbar.jsp"%>
		
		<div class="container">
			
			<table class="table table-striped">
				<thead>
					<tr>
						<th>Prénom</th>
						<th>Nom</th>
						<th>Email</th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>${ customer.getFirstname() }</td>
						<td>${ customer.getLastname() }</td>
						<td>${ customer.getEmail() }</td>
					</tr>
				</tbody>
			</table>
			
			<button type="button" class="btn btn-default" id="btnGoBack" onClick="window.location='../customers'"><span class="glyphicon glyphicon-menu-left"></span> Retour</button>
		</div>
		    
	    <script src="../../../js/jquery.js"></script>
	    <script src="../../../js/bootstrap.js"></script>
	</body>
</html>