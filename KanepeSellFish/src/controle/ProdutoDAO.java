package controle;

import modelo.IProdutoDAO;
import modelo.Produto;

public class ProdutoDAO implements IProdutoDAO{
	private static ProdutoDAO instancia;

	private ProdutoDAO() {
	}

	public static ProdutoDAO getInstancia() {

		if (instancia == null) {
			instancia = new ProdutoDAO();
		}

		return instancia;
	}

	@Override
	public boolean inserirProduto(Produto prod) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removerProduto(int idProduto) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean atualizarProduto(Produto prod) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean listarProdutos() {
		// TODO Auto-generated method stub
		return false;
	}
}
