package controle;

import java.util.ArrayList;

import modelo.ICarrinhoDAO;
import modelo.Pedido;
import modelo.Produto;

public class CarrinhoDAO implements ICarrinhoDAO {


	private static ProdutoDAO instancia;
	private static ArrayList<Produto> listaProdutos;

	public CarrinhoDAO() {}

	public ProdutoDAO instancia() {

		if (instancia == null) {
			instancia = new ProdutoDAO();
			listaProdutos = new ArrayList<Produto>();
		}

		return instancia;
	}

	public boolean inserirProduto(Produto produto) {
		listaProdutos.add(produto);

		return false;
	}

	public boolean alterarQuantidade(Produto produto) {

		return false;
	}

	public boolean removerProduto(long id) {
		return false;

		
	}

	@Override
	public boolean inserirProduto(Pedido pedido) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean alterarQuantidade(Pedido pedido) {
		// TODO Auto-generated method stub
		return false;
	}
}