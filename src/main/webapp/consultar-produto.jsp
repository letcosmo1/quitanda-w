<%@ page import="java.util.List"%>
<%@ page import="model.Produto"%>
<%@ page import="dao.ProdutoDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Blinker">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Baloo">
        <link rel="stylesheet" href="css/consultar-produto-style.css">
        <script src="https://kit.fontawesome.com/e980253398.js" crossorigin="anonymous"></script>
        <title>Consultar Produto</title>
    </head> 
    <body>
        <header>
            <a href="index.jsp"><h1>QUITANDA W </h1></a> 
        </header>
        <main>
            <div class="main-box">
            	<form action="consultar-produto" method="post">
                    <input type="text" name="nome" placeholder="Nome do produto">
                    <button type="submit"><i class="fa-solid fa-magnifying-glass"></i></button>
                </form>
                <%
                if(request.getAttribute("mensagem-exclusao") != null) {
                %>
                <p id="mensagem-exclusao"><%out.print(request.getAttribute("mensagem-exclusao"));%></p>
                <%
                }
                %>
                
                <%
            	if(request.getAttribute("produtos") != null) {
				List<?> produtos = (List<?>) request.getAttribute("produtos");
				for(int i = 0; i < produtos.size(); i++) {
				Produto produto = (Produto) produtos.get(i);
				%>
                <div class="produto-container">
                    <div class="id">
                        <h4>ID</h4>
                        <p><%out.print(produto.getIdProduto());%></p>
                    </div>
                    <div class="nome">
                        <h4>NOME</h4>
                        <p><%out.print(produto.getNomeProduto());%></p>
                    </div>
                    <div class="preco">
                        <h4>PREÇO</h4>
                        <p>R$<%out.print(produto.getPrecoProduto());%>/kg</p>
                    </div>
                    <form action="modificar-produto" method="post">
                    	<button name="alterar" value="<%out.print(produto.getIdProduto());%>"><i class="fa-solid fa-wrench"></i></button>
                    	<button name="excluir" value="<%out.print(produto.getIdProduto());%>"><i class="fa-solid fa-x"></i></button>
                    </form>
                </div>
                <%
					}
				}
				%>
            </div>
        </main>
        <footer>

        </footer>
    </body>
</html>