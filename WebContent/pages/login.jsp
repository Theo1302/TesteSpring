<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="css.jsp"></jsp:include>
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/index.css" />" >

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Escola</title>
</head>
<body>
	<div class="col-md-3">
		<div class="wrapper">
			<form class="form-signin">
				<h2 class="form-signin-heading" align="center">Acesso</h2>
				<input type="text" class="form-control" name="username"
					placeholder="Nome do Usuario" required="" autofocus="" /> <input
					type="password" class="form-control" name="password"
					placeholder="Senha" required="" /> <input type="checkbox"
					value="remember-me" id="rememberMe" name="rememberMe" class="chk"><label
					for="rememberMe">Remember me </label> <label><a
					align="center" href="">Esqueceu o seu usuário ou senha?</a></label>
				<button class="btn btn-lg btn-primary btn-block" type="submit">Acesso</button>
			</form>
		</div>
	</div>
</body>
</html>