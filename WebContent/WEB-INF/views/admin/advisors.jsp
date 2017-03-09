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
			
			<h1>Administration des conseillers</h1>
			
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
				<c:forEach items="${users}" var="user">
					<tr>
						<td>${ user.getFirstname() }</td>
						<td>${ user.getLastname() }</td>
						<td>${ user.getEmail() }</td>
						<td><button type="button" class="btn btn-default" id="btnAdvDetails" style="float: right;" onClick="window.location='advisors?id=${ user.getId() }'"><span class="glyphicon glyphicon-info-sign"></span> Détails</button></td>
					</tr>
				</c:forEach>
					<tr>
						<td>${ advisor.getFirstname() }</td>
						<td>${ advisor.getLastname() }</td>
						<td>${ advisor.getEmail() }</td>
						<td></td>
					</tr>
					<c:if test="${!empty customers}">
						<tr>
							<table class="table table-striped">
								<tbody>
									<h3>Clients associés :</h3>
									<c:forEach items="${customers}" var="customer">
										<tr>
											<td>${ customer.getFirstname() }</td>
											<td>${ customer.getLastname() }</td>
											<td>${ customer.getEmail() }</td>
											<td><button type="button" class="btn btn-danger" id="btnAdvDetails" style="float: right;" onClick="window.location='advisors?id=${ advisor.getId() }&unAssignUser=${ customer.getId() }'"><span class="glyphicon glyphicon-remove"></span> Retirer</button></td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</tr>
					</c:if>
					<c:if test="${!empty customersNotAssigned}">
						<tr>
							<table class="table table-striped">
								<tbody>
									<h3>Clients non associés :</h3>
									<c:forEach items="${customersNotAssigned}" var="customerNA">
										<tr>
											<td>${ customerNA.getFirstname() }</td>
											<td>${ customerNA.getLastname() }</td>
											<td>${ customerNA.getEmail() }</td>
											<td><button type="button" class="btn btn-success" id="btnAdvDetails" style="float: right;" onClick="window.location='advisors?id=${ advisor.getId() }&assignUser=${ customerNA.getId() }'"><span class="glyphicon glyphicon-ok"></span> Assigner</button></td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</tr>
					</c:if>
				</tbody>
			</table>
			
			<button type="button" class="btn btn-default" id="btnGoBack" onClick="window.location='../dashboard'"><span class="glyphicon glyphicon-menu-left"></span> Retour</button>
			<button type="button" class="btn btn-success" id="btnNewAdvisor" style="float: right;" onClick="window.location='advisors/create'">Créer un conseiller <span class="glyphicon glyphicon-menu-right"></span></button>
		</div>
		
	    <script src="../../js/jquery.js"></script>
	    <script src="../../js/bootstrap.js"></script>
	</body>
</html>