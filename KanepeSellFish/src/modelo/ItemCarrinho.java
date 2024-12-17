package modelo;

public class ItemCarrinho extends Produto{
	private int produtoItemCarrinho;
	private Integer quantidade;
	private Float precoTotal;
	
	public ItemCarrinho(){}
	
	public ItemCarrinho(int produtoItemCarrinho, Integer quantidade,  Float precoTotal ) {
		this.produtoItemCarrinho = produtoItemCarrinho;
		this.quantidade = quantidade;
		this.precoTotal = precoTotal;
	}

	public int getProdutoItemCarrinho() {
		return produtoItemCarrinho;
	}

	public void setProdutoItemCarrinho(int produtoItemCarrinho) {
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
