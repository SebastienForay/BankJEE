<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
    	<meta http-equiv="X-UA-Compatible" content="IE=edge">
    	<meta name="viewport" content="width=device-width, initial-scale=1">
		
		<title>Crédit Auvence - Virement</title>
		
		<link rel="stylesheet" href="../css/bootstrap.css">
		<link rel="stylesheet" href="../css/transaction.css">
	</head>
	<body>
	
		<%@ include file="/WEB-INF/includes/navbar.jsp"%>
	
		<div class="container">	
			<div class="col-lg-12">
				<div class="col-lg-4"></div>
				<div class="col-lg-4">
					<form method="POST" name="transactionForm">
						<div class="accounts-list">
							<div class="accounts-list-title">Compte débiteur :</div>
							<select name="debitAccountId" id="debitAccountId">
								<option value="0">Choisissez un compte</option>
								<c:forEach items="${accounts}" var="a">
									<option value="${ a.getId() }">
										${ a.getLabel() } - 
										${ a.getBalance() }
									</option>
								</c:forEach>
							</select>
							
							<br><br>
							
							<div class="accounts-list-title">Compte créditeur :</div>
							<select name="creditAccountId" id="creditAccountId">
								<option value="0">Choisissez un compte</option>
								<c:forEach items="${accounts}" var="a">
									<option value="${ a.getId() }">
										${ a.getLabel() } - 
										${ a.getBalance() }
									</option>
								</c:forEach>
							</select>
							
							<br><br>
							
							<div class="input-group">
								<input type="text" id="transactionAmount" name="transactionAmount" class="form-control" placeholder="0.0" aria-describedby="glyph-addon">
								<span class="input-group-addon" id="glyph-addon"><span class="glyphicon glyphicon-eur"></span></span>
							</div>
							<br>
							<div class="input-group">
								<input type="text" id="transactionReason" name="transactionReason" class="form-control" placeholder="Motif" aria-describedby="glyph-addon">
								<span class="input-group-addon" id="glyph-addon"><span class="glyphicon glyphicon-info-sign"></span></span>
							</div>
							
							<br>
							
		    				<button type="button" class="btn btn-warning" id="btnGoBack" onClick="window.location='dashboard'"><span class="glyphicon glyphicon-remove"></span> Annuler</button>
						    <button type="button" class="btn btn-success" onClick="this.form.submit();" style="float: right;">Valider <span class="glyphicon glyphicon-ok"></span></button>
						</div>
					</form>
				</div>
				<div class="col-lg-4"></div>
			</div>
		</div>
		
	    <script src="../js/jquery.js"></script>
	    <script src="../js/bootstrap.js"></script>
	</body>
</html>