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
	            <p id="profile-name" class="profile-name-card"></p>
				<h1>Se connecter</h1>
	            
	            <form method="POST" action="login" id="formLogin" class="form-signin">
	                <input type="email" id="email" name="email" class="form-control" placeholder="Identifiant" value="sebastien.foray@ynov.com" required autofocus>
	                <input type="password" id="password" name="password" class="form-control" placeholder="Mot de passe" value="azerty" required>
	                <!-- <div id="rememberMe" class="checkbox">
	                    <label>
	                        <input type="checkbox" value="remember-me" name="remember-me" form="formLogin"> Se souvenir de moi
	                    </label>
	                </div> -->
	                <button class="btn btn-lg btn-primary btn-block btn-signin" type="submit" form="formLogin">Connexion</button>
	            </form>
	            
	            <a href="#" class="forgot-password">
	                Mot de passe oublié ?
	            </a>
	            
	        </div>
	    </div>
	    
	    
	    <script src="js/jquery.js"></script>
	    <script src="js/bootstrap.js"></script>
	    <script src="js/login.js"></script>
	</body>
</html>