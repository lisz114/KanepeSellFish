package modelo;

public class ItemCarrinho extends Produto {
	private Produto produtoItemCarrinho;
	private Integer quantidade;
	private Float precoTotal;
	
	public ItemCarrinho(){}
	
	public ItemCarrinho(Produto produtoItemCarrinho, Integer quantidade,  Float precoTotal ) {
		this.produtoItemCarrinho = produtoItemCarrinho;
		this.quantidade = quantidade;
		this.precoTotal = precoTotal;
	}

	public Produto getProdutoItemCarrinho() {
		return produtoItemCarrinho;
	}

	public void setProdutoItemCarrinho(Produto produtoItemCarrinho) {
		this.produtoItemCarrinho = produtoItemCarrinho;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Float getPrecoTotal() {
		return precoTotal;
	}

	public void setPrecoTotal(Float precoTotal) {
		this.precoTotal = precoTotal;
	}


}
