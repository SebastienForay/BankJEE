<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
    	<meta http-equiv="X-UA-Compatible" content="IE=edge">
    	<meta name="viewport" content="width=device-width, initial-scale=1">
		
		<title>BankJEE - Register</title>
		
		<link rel="stylesheet" href="css/bootstrap.css">
		<link rel="stylesheet" href="css/login.css">
	</head>
	<body>
		<div class="container">
	        <div class="card card-container">
	            <img id="profile-img" class="profile-img-card" src="img/avatar.png" />
				<h1>Créer un compte</h1>
	            
	            <form method="POST" action="register" id="formRegister" class="form-signin">
	                <span id="reauth-email" class="reauth-email"></span>
	                <input type="text" id="firstname" name="firstname" class="form-control" placeholder="Prénom" required autofocus>
	                <input type="text" id="lastname" name="lastname" class="form-control" placeholder="Nom" required>
	                <input type="email" id="email" name="email" class="form-control" placeholder="Email" required>
	                <input type="password" id="password" name="password" class="form-control" placeholder="Mot de passe" required>
	                <input type="password" id="confirm" name="confirm" class="form-control" placeholder="Confirmation" required>
	                <!-- <div id="remember" class="checkbox">
	                    <label>
	                        <input type="checkbox" value="remember-me"> Remember me
	                    </label>
	                </div>-->
	                <button class="btn btn-lg btn-primary btn-block btn-signin" type="submit" form="formRegister">Créer un compte</button>
	            </form>
	            
	            <a href="login" class="forgot-password">
	                Se connecter
	            </a><br>
	            
	        </div>
	    </div>
	    
	    
	    <script src="js/jquery.js"></script>
	    <script src="js/bootstrap.js"></script>
	    <script src="js/login.js"></script>
	</body>
</html>