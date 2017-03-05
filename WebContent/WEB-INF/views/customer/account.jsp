<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
    	<meta http-equiv="X-UA-Compatible" content="IE=edge">
    	<meta name="viewport" content="width=device-width, initial-scale=1">
		
		<title>Crédit Auvence - Détail du compte</title>
		
		<link rel="stylesheet" href="../css/bootstrap.css">
	</head>
	<body>
	
		<%@ include file="/WEB-INF/includes/navbar.jsp"%>
	
		<div class="container">
			<h3>Récapitulatif de votre compte</h3>
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
					<tr>
						<th scope="row">${ account.getLabel() }</a></th>
						<td>${ account.getBalance() } <span class ="glyphicon glyphicon-eur" style="font-size: 11px;"></span></td>
						<td>${ account.getCreationDate() }</td>
						<td>${ account.getInterest() } %</td>
					</tr>
				</tbody>
			</table>
			<br><br>
			<h3>Vos virements</h3>
			<table class="table table-striped">
				<thead>
					<tr>
						<th>Date</th>
						<th>Commentaire</th>
						<th>Crédit</th>
						<th>Débit</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${transactions}" var="t">
						<c:if test="${ t.getAmount() < 0 && t.getCreditAccount().getId() == account.getId() || t.getAmount() > 0 && t.getCreditAccount().getId() == account.getId() }">
							<c:set var="idTransactionHeader" value="heading${ t.getId() }"/>
							<c:set var="idTransactionCollapse" value="collapse${ t.getId() }"/>
							<c:set var="transactionCollapseHref" value="#collapse${ t.getId() }"/>
							<tr>
								<td>
									<div id="accordion" role="tablist" aria-multiselectable="true">
										<div class="card">
											<div class="card-header" role="tab" id="${ idTransactionHeader }">
												<h5 class="mb-0">
													<a class="collapsed" data-toggle="collapse" data-parent="#accordion" href="${ transactionCollapseHref }" aria-expanded="false" aria-controls="${ idTransactionCollapse }">									
														<span class="glyphicon glyphicon-chevron-down"></span> ${ t.getDate() }
													</a>
												</h5>
											</div>
										</div>
										
										<div id="${ idTransactionCollapse }" class="collapse" role="tabpanel" aria-labelledby="${ idTransactionHeader }">
											<div class="card-block">
												Compte bénéficiaire : ${ t.getAmount() > 0 ? t.getCreditAccount().getLabel() : t.getDebitAccount().getLabel() }
											</div>
										</div>
									</div>
								</td>
								<td>${ t.getComment() }</td>
								<td>${ t.getAmount() > 0 ? t.getAmount() : '' }</td>
								<td>${ t.getAmount() < 0 ? t.getAmount() : '' }</td>
							</tr>
						</c:if>
					</c:forEach>
				</tbody>
			</table>

		    <button type="button" class="btn btn-default" id="btnGoBack" onClick="window.location='dashboard'"><span class="glyphicon glyphicon-menu-left"></span>Retour</button>
		</div>
		
	    <script src="../js/jquery.js"></script>
	    <script src="../js/bootstrap.js"></script>
	</body>
</html>