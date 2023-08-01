<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Blinker">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Baloo">
        <link rel="stylesheet" href="css/index-style.css">
        <title>Home</title>
    </head> 
    <body>
        <header>
            <a href="index.jsp"><h1>QUITANDA <span>W</span></h1></a> 
        </header>
        <main>
            <section class="index-banner">
            </section>
            <section class="cards-container">
                <div class="card">
                    <a href="mostrar-produtos.jsp"><button>Mostrar produtos</button></a> 
                    <div class="icon-container">
                        <img src="img/tabela-icon.png" alt="">
                    </div>
                </div>
                <div class="card">
                    <a href="consultar-produto.jsp"><button>Consultar produtos</button></a> 
                    <div class="icon-container">
                        <img src="img/lupa-icon.png" alt="">
                    </div>
                </div>
                <div class="card" id="last-card">
                    <a href="cadastrar-produto.jsp"><button>Cadastrar produtos</button></a> 
                    <div class="icon-container">
                        <img src="img/mais-icon.png" alt="">
                    </div>
                </div>
            </section>
        </main>
        <footer>

        </footer>
    </body>
</html>