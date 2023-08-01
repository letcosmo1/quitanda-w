package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Produto;

import java.io.IOException;

import dao.ProdutoDao;

public class CadastrarProdutoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public CadastrarProdutoController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String nome;
		float preco;
		String mensagem = "Todos os campos precisam ser preenchidos.";
		
		if(request.getParameter("nome") != null && !request.getParameter("nome").isEmpty() 
		   && request.getParameter("preco") != null && !request.getParameter("preco").isEmpty()) {
			nome = request.getParameter("nome");
			preco = Float.parseFloat(request.getParameter("preco"));
			Produto produto = new Produto(nome, preco);
			ProdutoDao.cadastrarProduto(produto);
			
			mensagem = "Produto cadastrado com sucesso.";
		}
		
		request.setAttribute("mensagem", mensagem);
		RequestDispatcher dispatcher = request.getRequestDispatcher("cadastrar-produto.jsp");
		dispatcher.forward(request, response);
	}

}
