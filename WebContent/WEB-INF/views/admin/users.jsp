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
						<td>${ user.getFirstname() }</td>
						<td>${ user.getLastname() }</td>
						<td>${ user.getEmail() }</td>
						<td>
							<form method="POST" name="userTypeForm">
								<input type="hidden" name="userId" value="${ user.getId() }">
								<input type="hidden" name="userEmail" value="${ user.getEmail() }">
								<c:set var="userType" value="${ user.getType() }"/>
								<c:choose> 
									<c:when test="${userType == 2}">
									<select name="type" id="type" onchange="this.form.submit();">
									</c:when>
									<c:otherwise>
									<select name="type" id="type" onchange="this.form.submit();">
									</c:otherwise>
								</c:choose> 
									<c:set var="val" value="${ user.getType() }"/>
									<c:forEach var="i" begin="0" end="2">
										<c:choose> 
											<c:when test="${val == i}">
											<option value="${i}" selected onchange="return setValue();"><c:out value="${i}"/></option>
											</c:when>
											<c:otherwise>
											<option value="${i}" onchange="return setValue();"><c:out value="${i}"/></option>
											</c:otherwise>
										</c:choose>
									</c:forEach>
								</select>
							</form>
						</td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
			
			<button type="button" class="btn btn-default" id="btnGoBack" onClick="window.location='../dashboard'"><span class="glyphicon glyphicon-menu-left"></span>Retour</button>
		</div>
		
	    <script src="../../js/jquery.js"></script>
	    <script src="../../js/bootstrap.js"></script>
	</body>
</html>