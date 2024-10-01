package modelo;

public interface IProdutoDAO {
	public boolean inserirProduto(Produto prod);
	
	public boolean removerProduto(int idProduto);
	
	public boolean atualizarProduto(Produto prod);
	
	public boolean listarProdutos();
}
