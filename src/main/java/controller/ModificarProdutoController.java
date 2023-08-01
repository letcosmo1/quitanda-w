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

public class ModificarProdutoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ModificarProdutoController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		if(request.getParameter("excluir") != null) {
			ProdutoDao.excluirProduto(Integer.parseInt(request.getParameter("excluir")));
			request.setAttribute("mensagem-exclusao", "Produto excluído com sucesso.");
			RequestDispatcher dispatcher = request.getRequestDispatcher("consultar-produto.jsp");
			dispatcher.forward(request, response);
		} else if(request.getParameter("mostrar-produtos-excluir") != null) {
			ProdutoDao.excluirProduto(Integer.parseInt(request.getParameter("mostrar-produtos-excluir")));
			request.setAttribute("mensagem-exclusao", "Produto excluído com sucesso.");
			RequestDispatcher dispatcher = request.getRequestDispatcher("mostrar-produtos.jsp");
			dispatcher.forward(request, response);
		} else if(request.getParameter("alterar") != null) {
			Produto produto = new Produto();
			produto = ProdutoDao.consultarProdutoPorId(Integer.parseInt(request.getParameter("alterar")));
			request.setAttribute("produto", produto);
			RequestDispatcher dispatcher = request.getRequestDispatcher("alterar-produto.jsp");
			dispatcher.forward(request, response);
		}
	}

}
