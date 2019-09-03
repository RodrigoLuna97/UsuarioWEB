	<!DOCTYPE html>
	<%@page import="persistencia.entidade.Usuario"%>
<html>
	<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	
	<script>
		function excluir(){
			if (window.confirm("Tem certezar que deseja excluir?")){
				//Acessando o id preenchido no campo
				idDigitado = document.getElementById("id").value;
				//Request GET
				location.href = "usucontroller.do?id="+idDigitado;
			}
		}
	</script>
	</head>
	<body>
	<%@ include file="menu.jsp" %>
	<%
		 Usuario usu= (Usuario)	request.getAttribute("usu");
	%>
	<form action="usucontroller.do" method="POST">
		ID : <input type="number" name="id" id="id" value="<%=usu.getId()%>">
		Login: <input type="text" name="login" id="login" value="<%=usu.getLogin()%>">
		Nome: <input type="text" name="nome" id="nome" value="<%=usu.getNome()%>">
		Email: <input type="text" name="email" id="email" value="<%=usu.getEmail()%>">
		Senha:<input type="password" name="senha" value="<%=usu.getSenha()%>">
		Telefone:<input type="text" name="telefone" value="<%=usu.getTelefone()%>">
		<input type="submit" value="Salvar">		
		<input type="button" value="Excluir" onclick="javascript:excluir()"/>
	</form>
	
	</body>
	</html>