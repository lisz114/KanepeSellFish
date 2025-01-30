package modelo;

import java.util.ArrayList;

public interface ICarrinhoDAO {

	boolean alterarQuantidade(Pedido pedido);
	public boolean inserirProduto(Produto produto, int quantidade, Float preco, CarrinhoCompras c);
	public CarrinhoCompras criarCarrinho(Usuario u);
	public ArrayList<ItemCarrinho> addProdCarrinho(CarrinhoCompras c);
	public boolean removerProduto(CarrinhoCompras carrinho, Produto produto);

}
