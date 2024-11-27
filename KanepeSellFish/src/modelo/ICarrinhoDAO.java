package modelo;

public interface ICarrinhoDAO {

	public boolean alterarQuantidade(Produto produto);
	public boolean removerProduto(long id);
	boolean alterarQuantidade(Pedido pedido);
	public boolean inserirProduto(Produto produto, int quantidade, String preco, CarrinhoCompras c);
	public CarrinhoCompras criarCarrinho(Usuario u);

}
