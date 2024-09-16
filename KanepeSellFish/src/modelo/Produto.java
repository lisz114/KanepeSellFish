package modelo;

import java.time.LocalDate;

public class Produto {
	
	private String codigo;
	private String nome;
	private LocalDate validade;
	private float preco;
	private int quantidadeEstoque;
	
	public Produto() {}
	
	public Produto(String codigo, String nome, LocalDate validade, float preco, int quantidadeEstoque) {
		this.codigo = codigo;
		this.nome = nome;
		this.validade = validade;
		this.preco = preco;
		this.quantidadeEstoque = quantidadeEstoque;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDate getValidade() {
		return validade;
	}

	public void setValidade(LocalDate validade) {
		this.validade = validade;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}

	public int getQuantidadeEstoque() {
		return quantidadeEstoque;
	}

	public void setQuantidadeEstoque(int quantidadeEstoque) {
		this.quantidadeEstoque = quantidadeEstoque;
	}
	 
	

}
