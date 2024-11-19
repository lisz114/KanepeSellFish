package modelo;

public interface ICarrinhoDAO {

	public boolean inserirProduto(Produto produto);
	public boolean alterarQuantidade(Produto produto);
	public boolean removerProduto(long id);
	boolean alterarQuantidade(Pedido pedido);
	boolean inserirProduto(Pedido pedido);

}
