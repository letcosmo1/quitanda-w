package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.Produto;

public class ProdutoDao {
	public static void cadastrarProduto(Produto produto) {
		String sql = "INSERT INTO tbl_Produtos VALUES (null, ?, ?)";
		Connection connection = null;
		PreparedStatement p_statement = null;
		
		try {
			connection = MySqlConnection.getConnection();
			p_statement = connection.prepareStatement(sql);
			p_statement.setString(1, produto.getNomeProduto());
			p_statement.setFloat(2, produto.getPrecoProduto());
			p_statement.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			MySqlConnection.closePreparedStatement(p_statement);
			MySqlConnection.closeConnection(connection);
		}
		
	}
	
	public static ArrayList<Produto> consultarProduto(String nome_produto) {
		ArrayList<Produto> produtos = new ArrayList<Produto>();
		String sql = "SELECT * FROM tbl_Produtos WHERE nome_produto LIKE '" + nome_produto + "%'";
		Connection connection = null;
		PreparedStatement p_statement = null;
		ResultSet result = null;
		Produto produto = null;
		
		try {
			connection = MySqlConnection.getConnection();
			p_statement = connection.prepareStatement(sql);
			result = p_statement.executeQuery();
			
			while(result.next()) {
				produto = new Produto();
				produto.setIdProduto(result.getInt("id_produto"));
				produto.setNomeProduto(result.getString("nome_produto"));
				produto.setPrecoProduto(result.getFloat("preco_produto"));
				produtos.add(produto);
			}
		} catch (Exception e) {
			e.getStackTrace();
		} finally {
			MySqlConnection.closePreparedStatement(p_statement);
			MySqlConnection.closeConnection(connection);
		}
		
		return produtos;
	}
	
	public static Produto consultarProdutoPorId(int id_produto) {
		Produto produto = null;
		String sql = "SELECT * FROM tbl_Produtos WHERE id_produto = " + id_produto;
		Connection connection = null;
		PreparedStatement p_statement = null;
		ResultSet result = null;
		
		try {
			connection = MySqlConnection.getConnection();
			p_statement = connection.prepareStatement(sql);
			result = p_statement.executeQuery();
			
			if(result.next()) {
				produto = new Produto();
				produto.setIdProduto(result.getInt("id_produto"));
				produto.setNomeProduto(result.getString("nome_produto"));
				produto.setPrecoProduto(result.getFloat("preco_produto"));
			}
		} catch (Exception e) {
			e.getStackTrace();
		} finally {
			MySqlConnection.closePreparedStatement(p_statement);
			MySqlConnection.closeConnection(connection);
		}
		
		return produto;
	}
	
	public static ArrayList<Produto> consultarTodosProdutos() {
		ArrayList<Produto> produtos = new ArrayList<Produto>();
		Produto produto;
		String sql = "SELECT * FROM tbl_Produtos ORDER BY nome_produto";
		Connection connection = null;
		PreparedStatement p_statement = null;
		ResultSet result = null;
		
		try {
			connection = MySqlConnection.getConnection();
			p_statement = connection.prepareStatement(sql);
			result = p_statement.executeQuery();
			
			while(result.next()) {
				produto = new Produto();
				produto.setIdProduto(result.getInt("id_produto"));
				produto.setNomeProduto(result.getString("nome_produto"));
				produto.setPrecoProduto(result.getFloat("preco_produto"));
				produtos.add(produto);
			}
		} catch (Exception e) {
			e.getStackTrace();
		} finally {
			MySqlConnection.closePreparedStatement(p_statement);
			MySqlConnection.closeConnection(connection);
		}
		
		return produtos;
	}
	
	public static void excluirProduto(int id_produto) {
		String sql = "DELETE FROM tbl_Produtos WHERE id_produto = " + id_produto;
		Connection connection = null;
		PreparedStatement p_statement = null;
		
		try {
			connection = MySqlConnection.getConnection();
			p_statement = connection.prepareStatement(sql);
			p_statement.execute();
		} catch (Exception e) {
			e.getStackTrace();
		} finally {
			MySqlConnection.closePreparedStatement(p_statement);
			MySqlConnection.closeConnection(connection);
		}
	}
	
	public static void atualizarProduto(Produto produto) {
		String sql = "UPDATE tbl_Produtos SET nome_produto = ?, preco_produto = ? WHERE id_produto = ?";
		Connection connection = null;
		PreparedStatement p_statement = null;
		
		try {
			connection = MySqlConnection.getConnection();
			p_statement = connection.prepareStatement(sql);
			p_statement.setString(1, produto.getNomeProduto());
			p_statement.setFloat(2, produto.getPrecoProduto());
			p_statement.setInt(3, produto.getIdProduto());
			p_statement.execute();
		} catch (Exception e) {
			e.getStackTrace();
		} finally {
			MySqlConnection.closePreparedStatement(p_statement);
			MySqlConnection.closeConnection(connection);
		}
	}
}
