package controle;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import modelo.IProdutoDAO;
import modelo.Produto;

public class ProdutoDAO implements IProdutoDAO {

	private static ProdutoDAO instancia;
	private static ArrayList<Produto> listaProdutos;

	public ProdutoDAO() {}

	public static ProdutoDAO getInstancia() {

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
	
	public List<Produto> ordenarPorPreco(boolean crescente, List<Produto> produtos){
		produtos.sort(Comparator.comparingDouble(Produto::getPreco));
		if(!crescente) {
			Collections.reverse(produtos);
		}
		return produtos;
	}
	
	public List<Produto> ordenarNome(boolean crescente, List<Produto> produtos){
		
		produtos.sort(Comparator.comparing(Produto::getNome));
		if(!crescente) {
			Collections.reverse(produtos);
		}
		return produtos;
	}
}