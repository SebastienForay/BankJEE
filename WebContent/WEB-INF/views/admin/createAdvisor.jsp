<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
    	<meta http-equiv="X-UA-Compatible" content="IE=edge">
    	<meta name="viewport" content="width=device-width, initial-scale=1">
		
		<title>Crédit Auvence - Créer un compte</title>
		
		<link rel="stylesheet" href="../../../css/bootstrap.css">
		<link rel="stylesheet" href="../../../css/login.css">
	</head>
	<body>
	
		<%@ include file="/WEB-INF/includes/navbar.jsp"%>
	
		<div class="container">
	        <div class="card card-container">
	            <form method="POST" id="formCreateAdvisor" class="form-signin">
	            	<div class="input-group">
						<span id="sizing-addon2" class="input-group-addon" id="basic-addon1"><span class="glyphicon glyphicon-user"></span></span>
	                	<input type="text" id="firstname" name="firstname" class="form-control" placeholder="Prénom" aria-describedby="sizing-addon2" required autofocus>
					</div>
					<br>
	            	<div class="input-group">
						<span id="sizing-addon2" class="input-group-addon" id="basic-addon1"><span class="glyphicon glyphicon-user"></span></span>
	                	<input type="text" id="lastname" name="lastname" class="form-control" placeholder="Nom" aria-describedby="sizing-addon2" required autofocus>
					</div>
					<br>
	            	<div class="input-group">
						<span id="sizing-addon2" class="input-group-addon" id="basic-addon1"><span class="glyphicon glyphicon-envelope"></span></span>
	                	<input type="email" id="email" name="email" class="form-control" placeholder="Email" aria-describedby="sizing-addon2" required autofocus>
					</div>
					<br>
	            	<div class="input-group">
						<span id="sizing-addon2" class="input-group-addon" id="basic-addon1"><span class="glyphicon glyphicon-lock"></span></span>
	                	<input type="password" id="password" name="password" class="form-control" placeholder="Mot de passe" aria-describedby="sizing-addon2" required autofocus>
					</div>
					<br>
	            	<div class="input-group">
						<span id="sizing-addon2" class="input-group-addon" id="basic-addon1"><span class="glyphicon glyphicon-lock"></span></span>
	                	<input type="password" id="confirm" name="confirm" class="form-control" placeholder="Confirmation" aria-describedby="sizing-addon2" required autofocus>
					</div>
					<br>
	                <button class="btn btn-lg btn-primary btn-block btn-signin" type="submit" form="formCreateAdvisor">Créer le conseiller</button>
	            </form>
	        </div>
	    </div>
	    
	    
	    <script src="../../../js/jquery.js"></script>
	    <script src="../../../js/bootstrap.js"></script>
	</body>
</html>