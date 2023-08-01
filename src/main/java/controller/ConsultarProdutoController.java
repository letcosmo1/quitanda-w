package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Produto;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import dao.ProdutoDao;

public class ConsultarProdutoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ConsultarProdutoController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String nome = request.getParameter("nome");
		
		if(nome != null) {
			ArrayList<Produto> produtos = new ArrayList<Produto>();
			produtos = ProdutoDao.consultarProduto(nome);
			
			request.setAttribute("produtos", produtos);
			RequestDispatcher dispatcher = request.getRequestDispatcher("consultar-produto.jsp");
			dispatcher.forward(request, response);
		}
		
	}

}
