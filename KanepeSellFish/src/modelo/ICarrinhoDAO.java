package modelo;

public interface ICarrinhoDAO {

	public boolean inserirProduto(Pedido pedido);
	public boolean alterarQuantidade(Pedido pedido);
	public boolean removerProduto(long id);

}
