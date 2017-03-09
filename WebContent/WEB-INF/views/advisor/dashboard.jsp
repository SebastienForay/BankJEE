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
		
		<link rel="stylesheet" href="../../css/bootstrap.css">
	</head>
	<body>
	
		<%@ include file="/WEB-INF/includes/navbar.jsp"%>
		
		<div class="container">
			
			<h1>Mes clients</h1>
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
					<c:forEach items="${customers}" var="user">
						<tr>
							<td>${ user.getFirstname() }</td>
							<td>${ user.getLastname() }</td>
							<td>${ user.getEmail() }</td>
							<td><button type="button" class="btn btn-default" id="btnAdvDetails" style="float: right;" onClick="window.location='customers/details?userId=${ user.getId() }'"><span class="glyphicon glyphicon-info-sign"></span> Détails</button></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		    
	    <script src="../../js/jquery.js"></script>
	    <script src="../../js/bootstrap.js"></script>
	</body>
</html>