<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@include file="./base.jsp"%>
</head>
<body>


	<div class="container mt-3">

		<h1>Cadastrar Gerente</h1>
		<form action="criarGerente" method="post">

			<div class="row">
				<div class="col">
					<div class="form-group">
						<label for="nomeGerente">Nome Gerente</label> <input type="text"
							class="form-control" id="nomeGerente" name="nomeGerente"
							placeholder="Informe o nome do Gerênte">
					</div>
				</div>
			</div>

			<a href="${pageContext.request.contextPath }/"
				class="btn btn-warning"> Back </a>
			<button type="submit" class="btn btn-primary">Cadastrar</button>
		</form>

	</div>

</body>
</html>