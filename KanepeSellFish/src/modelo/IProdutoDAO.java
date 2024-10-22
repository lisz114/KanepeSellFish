package modelo;

public interface IProdutoDAO {
	public boolean inserirProduto(Produto produto, Usuario u);
	public boolean alterarProduto(Produto produto);
	public boolean removerProduto(Produto p);	
}
