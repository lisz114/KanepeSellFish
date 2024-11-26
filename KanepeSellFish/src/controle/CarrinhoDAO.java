package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import modelo.ICarrinhoDAO;
import modelo.Pedido;
import modelo.Produto;
import modelo.Usuario;

public class CarrinhoDAO implements ICarrinhoDAO {


	private static ProdutoDAO instancia;
	private static ArrayList<Produto> listaProdutos;
	ProdutoDAO pDAO = new ProdutoDAO();

	public CarrinhoDAO() {}

	public ProdutoDAO instancia() {

		if (instancia == null) {
			instancia = new ProdutoDAO();
			listaProdutos = new ArrayList<Produto>();
		}

		return instancia;
	}

	public boolean inserirProduto(Produto produto, int quantidade, double preco, Usuario u) {

		String sql = "INSERT INTO ItensCarrinho (Carrinho_idCarrinho, Produtos_idProdutos, quantidade, preco) VALUES (?, ?, ?, ?)";
		try (Connection conn = ConexaoBD.getConexaoMySQL(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

			pstmt.setString(1, pegarIdCarrinho(u));
			pstmt.setInt(2, Integer.parseInt(pDAO.pegarIdProduto(produto)));
			pstmt.setInt(3, quantidade);
			pstmt.setDouble(4, preco);

			int rowsAffected = pstmt.executeUpdate();
			return rowsAffected > 0;

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	private String pegarIdCarrinho(Usuario u) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean alterarQuantidade(Produto produto) {

		return false;
	}

	public boolean removerProduto(long id) {
		return false;

		
	}

	@Override
	public boolean alterarQuantidade(Pedido pedido) {
		// TODO Auto-generated method stub
		return false;
	}
}