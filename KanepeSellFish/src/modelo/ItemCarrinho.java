package modelo;

public class ItemCarrinho {
	private Produto produtoItemCarrinho;
	private Integer quantidade;
	private Float preco;
	private CarrinhoCompras carrinhoItemCarrinho;
	
	public ItemCarrinho(){}
	
	public ItemCarrinho(Produto produtoItemCarrinho, Integer quantidade,  Float preco, CarrinhoCompras carrinhoItemCarrinho) {
		this.produtoItemCarrinho = produtoItemCarrinho;
		this.quantidade = quantidade;
		this.preco = preco;
		this.carrinhoItemCarrinho = carrinhoItemCarrinho;
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

	public Float getPreco() {
		return preco;
	}

	public void setPreco(Float preco) {
		this.preco = preco;
	}

	public CarrinhoCompras getCarrinhoItemCarrinho() {
		return carrinhoItemCarrinho;
	}

	public void setCarrinhoItemCarrinho(CarrinhoCompras carrinhoItemCarrinho) {
		this.carrinhoItemCarrinho = carrinhoItemCarrinho;
	}

}
