<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<nav class="navbar navbar-default">
	<div class="container-fluid">
	
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
				<span class="sr-only">Navigation</span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="#">Crédit Auvence</a>
		</div>
		
		<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">
				<!-- <li class="active"><a href="#">Link <span class="sr-only">(current)</span></a></li> -->
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<c:set var="user" value="<%= request.getSession().getAttribute(\"user\") %>"/>
				<c:choose> 
					<c:when test="${user == null}"> <!-- User is not connected -->
						<li><a href="/BankJEE/login">Accès aux comptes</a></li>
						<li class="dropdown">
							<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Autres actions <span class="caret"></span></a>
							<ul class="dropdown-menu">
								<li><a href="/BankJEE/register">Créer un compte</a></bnli>
								<li><a href="#">Accès perdu ?</a></li>
								<li role="separator" class="divider"></li>
								<li><a href="#">Accès Administrateur</a></li>
							</ul>
						</li>
					</c:when>
					<c:otherwise> <!-- User is connected -->
						<li><a href="/BankJEE/auth/dashboard">Tableau de bord</a></li>
						<li class="dropdown">
							<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Autres actions <span class="caret"></span></a>
							<ul class="dropdown-menu">
								<li><a href="/BankJEE/auth/logout">Déconnexion</a></bnli>
								<!-- <li><a href="#">Accès perdu ?</a></li>
								<li role="separator" class="divider"></li>
								<li><a href="#">Accès Administrateur</a></li> -->
							</ul>
						</li>
					</c:otherwise>
				</c:choose>
			</ul>
		</div><!-- /.navbar-collapse -->
	</div><!-- /.container-fluid -->
</nav>