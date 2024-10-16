package modelo;

import java.time.LocalDate;
import java.util.Objects;

public class Produto {
	
	private int codigo;
	private String nome;
	private LocalDate validade;
	private float preco;
	private int quantidadeEstoque;
	private int idProdutor;
	
	public Produto() {}
	
	public Produto(int codigo, String nome, LocalDate validade, float preco, int quantidadeEstoque) {
		this.codigo = codigo;
		this.nome = nome;
		this.validade = validade;
		this.preco = preco;
		this.quantidadeEstoque = quantidadeEstoque;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
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
	
	public int getIdProdutor() {
		return idProdutor;
	}

	public void setIdProdutor(int idProdutor) {
		this.idProdutor = idProdutor;
	}

	public boolean equals(Object obj) {
		if(this == obj) return true;
		if(obj == null || getClass() != obj.getClass()) return false;
		Produto produto = (Produto) obj;
		return Double.compare(produto.preco, preco) == 0 &&
				nome.equals(produto.nome);
	}
	
	public int hashCode() {
		return Objects.hash(nome, preco);
	}

}