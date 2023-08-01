<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Blinker">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Baloo">
        <link rel="stylesheet" href="css/cadastrar-produto-style.css">
        <script src="https://kit.fontawesome.com/e980253398.js" crossorigin="anonymous"></script>
        <title>Consultar Produto</title>
    </head> 
    <body>
        <header>
            <a href="index.jsp"><h1>QUITANDA W </h1></a> 
        </header>
        <main>
            <div class="cadastrar-box">
                <h2>CADASTRAR PRODUTO</h2>
                <form action="cadastrar-produto" method="post">
                    <h4>NOME</h4>
                    <input type="text" id="nome" name="nome">
                    <h4>PREÇO</h4>
                    <div class="second-row-form">
                        <input type="number" step="0.01" name="preco">
                        <button type="submit"><i class="fa-solid fa-check"></i></button>
                    </div>
                </form>
            </div>
        </main>
        <%
        if(request.getAttribute("mensagem") != null) {
        %>
        <p id="mensagem-cadastro"><%out.print(request.getAttribute("mensagem"));%></p>
        <%
         }
        %>
    </body>
</html>