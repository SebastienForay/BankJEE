<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
    	<meta http-equiv="X-UA-Compatible" content="IE=edge">
    	<meta name="viewport" content="width=device-width, initial-scale=1">
		
		<title>Crédit Auvence - Accès aux comptes</title>
		
		<link rel="stylesheet" href="css/bootstrap.css">
		<link rel="stylesheet" href="css/login.css">
	</head>
	<body>
	
		<%@ include file="/WEB-INF/includes/navbar.jsp"%>
		
		<div class="container">
	        <div class="card card-container">
	            <img id="profile-img" class="profile-img-card" src="img/avatar.png" />
	            
	            <br>
	            
	            <form method="POST" action="login" id="formLogin" class="form-signin">
	            	<div class="form-group <%= request.getAttribute("errorMsg") != null ? "has-error" : "" %>">
						<div class="input-group">
							<span id="sizing-addon2" class="input-group-addon" id="basic-addon1">@</span>
		                	<input type="email" id="email" name="email" class="form-control" placeholder="Identifiant" value="sebastien.foray@ynov.com" aria-describedby="sizing-addon2" required autofocus>
						</div>
					</div>
	            	<div class="form-group <%= request.getAttribute("errorMsg") != null ? "has-error" : "" %>">
						<div class="input-group">
							<span id="sizing-addon2" class="input-group-addon" aria-hidden="true"><span class="glyphicon glyphicon-lock"></span></span>
		                	<input type="password" id="password" name="password" class="form-control" placeholder="Mot de passe" value="azerty" aria-describedby="sizing-addon2" required>
						</div>
					</div>
					<p style="color: #a94442;"><%= request.getAttribute("errorMsg") != null ? (String) request.getAttribute("errorMsg") : "" %></p>
	                <!-- <div id="rememberMe" class="checkbox">
	                    <label>
	                        <input type="checkbox" value="remember-me" name="remember-me" form="formLogin"> Se souvenir de moi
	                    </label>
	                </div> -->
	                <button class="btn btn-lg btn-primary btn-block btn-signin" type="submit" form="formLogin">Connexion</button>
	            </form>
	            
	            <br>
	            <a href="#" class="forgot-password">Mot de passe oublié ?</a>
	            
	        </div>
	    </div>
	    
	    
	    <script src="js/jquery.js"></script>
	    <script src="js/bootstrap.js"></script>
	    <script src="js/login.js"></script>
	</body>
</html>