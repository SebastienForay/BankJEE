<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
    	<meta http-equiv="X-UA-Compatible" content="IE=edge">
    	<meta name="viewport" content="width=device-width, initial-scale=1">
		
		<title>DASHBOARD</title>
		
		<link rel="stylesheet" href="css/bootstrap.css">
	</head>
	<body>
		<div class="container">
			<table class="table">
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
					<td>(String) ((Account) request.getAttribute("checkingAccount").label)</td>
					<td>(String) ((Account) request.getAttribute("checkingAccount").label)</td>
					<td>(String) ((Account) request.getAttribute("checkingAccount").label)</td>
					<td>(String) ((Account) request.getAttribute("checkingAccount").label)</td>
					<td>(String) ((Account) request.getAttribute("checkingAccount").label)</td>
				</tr>
				<tr>
					<td>(String) ((Account) request.getAttribute("checkingAccount").label)</td>
					<td>(String) ((Account) request.getAttribute("checkingAccount").label)</td>
					<td>(String) ((Account) request.getAttribute("checkingAccount").label)</td>
					<td>(String) ((Account) request.getAttribute("checkingAccount").label)</td>
				</tr>
				</tbody>
			</table>
			
			<h1>DashBoard</h1>
			
		    <p>Bonjour <%= (String) request.getAttribute("firstname") %> <%= (String) request.getAttribute("lastname") %></p>
		    <p>Email : <%= (String) request.getAttribute("email") %></p>
		    
		    <a href="logout">Se déconnecter</a>
		    
		    <script src="js/jquery.js"></script>
		    <script src="js/bootstrap.js"></script>
	    
		</div>
	</body>
</html>