<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
    	<meta http-equiv="X-UA-Compatible" content="IE=edge">
    	<meta name="viewport" content="width=device-width, initial-scale=1">
		
		<title>LOGIN</title>
		
		<link rel="stylesheet" href="css/bootstrap.css">
		<link rel="stylesheet" href="css/login.css">
	</head>
	<body>
		<div class="container">
	        <div class="card card-container">
	            <!-- <img class="profile-img-card" src="//lh3.googleusercontent.com/-6V8xOA6M7BA/AAAAAAAAAAI/AAAAAAAAAAA/rzlHcD0KYwo/photo.jpg?sz=120" alt="" /> -->
	            <img id="profile-img" class="profile-img-card" src="https://ssl.gstatic.com/accounts/ui/avatar_2x.png" />
	            <p id="profile-name" class="profile-name-card"></p>
				<h1>Se connecter</h1>
				
				<p style="color : #FF0000;"><%= (String) request.getAttribute("errorMsg") != null ? (String) request.getAttribute("errorMsg") : "" %></p>
	            
	            <form method="POST" action="login" id="formLogin" class="form-signin">
	                <span id="reauth-email" class="reauth-email"></span>
	                <input type="email" id="email" name="email" class="form-control" placeholder="Identifiant" required autofocus>
	                <input type="password" id="password" name="password" class="form-control" placeholder="Mot de passe" required>
	                <div id="rememberMe" class="checkbox">
	                    <label>
	                        <input type="checkbox" value="remember-me" name="remember-me" form="formLogin"> Se souvenir de moi
	                    </label>
	                </div>
	                <button class="btn btn-lg btn-primary btn-block btn-signin" type="submit" form="formLogin">Connexion</button>
	            </form>
	            
	            <a href="register" class="forgot-password">
	                Créer un compte
	            </a><br>
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