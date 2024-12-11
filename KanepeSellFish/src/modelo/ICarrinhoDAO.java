package modelo;

import java.util.ArrayList;

public interface ICarrinhoDAO {

	public boolean removerProduto(long id);
	boolean alterarQuantidade(Pedido pedido);
	public boolean inserirProduto(Produto produto, int quantidade, Float preco, CarrinhoCompras c);
	public CarrinhoCompras criarCarrinho(Usuario u);
	public ArrayList<Produto> addProdCarrinho(CarrinhoCompras c);

}
