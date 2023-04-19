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

		<h1>Lista</h1>
		<a href="cadastrarGerente" class="btn btn-primary"> Cadastrar Gerênte </a>
		<div class="row">

			<table class="table table-hover">
				<thead>
					<tr>
						<th scope="col">ID</th>
						<th scope="col">Nome</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="gerente" items="${gerente}">
						<tr>
							<td class="table-plus">${gerente.id}</td>

						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>

</body>
</html>