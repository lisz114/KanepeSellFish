package modelo;

public interface IProdutoDAO {

	public boolean inserirProduto(Produto produto);
	public boolean alterarProduto(Produto produto);
	public boolean removerProduto(long codigo);	
}
