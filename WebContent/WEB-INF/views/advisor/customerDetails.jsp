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
			<div class="col-lg-12">
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
				
				<c:forEach items="${accounts}" var="account">
					<c:set var="formName" value="formAccount${ account.getId() }"/>
					<form method="POST" id="${ formName }" name="${ formName }" class="col-lg-6">
						<p>${ account.getLabel() }</p>
						<p>Montant actuel : ${ account.getBalance() }</p>
						
						<input type="hidden" name="userId" value="${ customer.getId() }">
						<input type="hidden" name="userEmail" value="${ customer.getEmail() }">
						<input type="hidden" name="accountId" value="${ account.getId() }">
						<div class="form-group <%= request.getAttribute("errorMsg") != null ? "has-error" : "" %>">
							<div class="input-group">
								<span id="sizing-addon2" class="input-group-addon" aria-hidden="true"><span class="glyphicon glyphicon-euro"></span></span>
			                	<input type="text" name="newBalance" class="form-control" placeholder="0.0" aria-describedby="sizing-addon2" required>
							</div>
						</div>
						<p style="color: #a94442;"><%= request.getAttribute("errorMsg") != null ? (String) request.getAttribute("errorMsg") : "" %></p>
		                <button class="btn btn-lg btn-primary btn-block btn-signin" type="submit" form="${ formName }">Ajouter</button>
					</form>
				</c:forEach>
				<button type="button" class="btn btn-default" id="btnGoBack" onClick="window.location='../customers'" style="margin-top: 25px;" ><span class="glyphicon glyphicon-menu-left"></span> Retour</button>
			</div>
		</div>
		    
	    <script src="../../../js/jquery.js"></script>
	    <script src="../../../js/bootstrap.js"></script>
	</body>
</html>