package controle;

import java.util.ArrayList;

import modelo.IProdutoDAO;
import modelo.Produto;

public class ProdutoDAO implements IProdutoDAO {

	private static ProdutoDAO instancia;
	private static ArrayList<Produto> listaProdutos;

	private ProdutoDAO() {}

	public ProdutoDAO getInstancia() {

		if (instancia == null) {
			instancia = new ProdutoDAO();
			listaProdutos = new ArrayList<>();
		}

		return instancia;
	}

	public boolean inserirProduto(Produto produto) {

		listaProdutos.add(produto);

		return false;
	}

	public boolean alterarProduto(Produto produto) {
		return false;
	}

	public boolean removerProduto(long codigo) {

		for (Produto produto : listaProdutos) {
			if (produto.getCodigo().equals(produto.getCodigo())) {
				listaProdutos.remove(produto);
			}
		}
		return false;
	}
}
