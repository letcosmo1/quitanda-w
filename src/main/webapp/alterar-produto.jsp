<%@ page import="model.Produto" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Blinker">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Baloo">
        <link rel="stylesheet" href="css/alterar-produto-style.css">
        <script src="https://kit.fontawesome.com/e980253398.js" crossorigin="anonymous"></script>
        <title>Modificar Produto</title>
    </head> 
    <body>
        <header>
            <a href="index.jsp"><h1>QUITANDA W </h1></a> 
        </header>
        <main>
        <%
		Produto produto = (Produto) request.getAttribute("produto");
		if(produto != null) {
		%>
            <div class="cadastrar-box">
                <h2>ALTERAR PRODUTO</h2>
                <form action="atualizar-produto" method="post">
                	<input type="hidden" name="id" value="<%out.print(produto.getIdProduto());%>">
                    <h4>NOME</h4>
                    <input type="text" id="nome" name="nome" value="<%out.print(produto.getNomeProduto());%>">
                    <h4>PREÇO</h4>
                    <div class="second-row-form">
                        <input type="number" step="0.01" name="preco" value="<%out.print(produto.getPrecoProduto());%>">
                        <button type="submit"><i class="fa-solid fa-check"></i></button>
                    </div>
                </form>
            </div>
        <%
		}
		%>
        </main>
        <%
        if(request.getAttribute("mensagem") != null) {
        %>
        <p id="mensagem-alteracao"><%out.print(request.getAttribute("mensagem"));%></p>
        <%
         }
        %>
    </body>
</html>