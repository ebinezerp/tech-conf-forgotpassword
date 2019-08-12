<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form"
	prefix="springform"%>


<c:set var="contextPath" value="${request.pageContext.contextPath}"></c:set>
<c:set var="styles" value="/resources/style"></c:set>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
	integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
	integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
	crossorigin="anonymous"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
	integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
	crossorigin="anonymous"></script>

<link rel="stylesheet" href="${styles}/style.css">
</head>
<body>
	<div class="container">
		<header>
			<div class="logo">
				<h1>Logo</h1>
			</div>
			<nav>
				<ul>
					<li><a href="${contextPath}/">Regisgter</a>
				</ul>
			</nav>
		</header>

		<section>
			<div class="row d-flex justify-content-center h-100">
				<div
					class="col col-md-6 col-lg-5 offset-md-3 offset-lg-3 align-self-center">
					<form method="post" action="${contextPath}/register">

						<div class="form-group">
							<label for="username">Username</label> <input type="text" name="username"
								class="form-control" />
						</div>
						<div class="form-group">
							<label for="password">password</label> <input type="password" name="password"
								path="password" class="form-control" />
						</div>

						<input type="submit" value="Login">
						<a href="${contextPath}/forgetpassword">Forgot Password</a>

					</form>
				</div>
			</div>
		</section>
	</div>
</body>
</html>