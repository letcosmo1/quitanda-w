package model;

public class Produto {
	private int id_produto;
	private String nome_produto;
	private float preco_produto;
	
	public Produto() {
		
	}
	
	public Produto(int id_produto, String nome_produto, float preco_produto) {
		super();
		this.id_produto = id_produto;
		this.nome_produto = nome_produto;
		this.preco_produto = preco_produto;
	}

	public Produto(String nome_produto, float preco_produto) {
		super();
		this.nome_produto = nome_produto;
		this.preco_produto = preco_produto;
	}

	public int getIdProduto() {
		return id_produto;
	}

	public void setIdProduto(int id_produto) {
		this.id_produto = id_produto;
	}

	public String getNomeProduto() {
		return nome_produto;
	}

	public void setNomeProduto(String nome_produto) {
		this.nome_produto = nome_produto;
	}

	public float getPrecoProduto() {
		return preco_produto;
	}

	public void setPrecoProduto(float preco_produto) {
		this.preco_produto = preco_produto;
	}
	
}
