package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import modelo.IProdutoDAO;
import modelo.Produto;
import modelo.Usuario;

public class ProdutoDAO implements IProdutoDAO {

	private static ProdutoDAO instancia;
	public static ArrayList<Produto> listaProdutos;

	private ProdutoDAO() {
	}

	public static ProdutoDAO getInstancia() {

		if (instancia == null) {
			instancia = new ProdutoDAO();
			listaProdutos = new ArrayList<>();
		}

		return instancia;
	}

	public boolean inserirProduto(Produto produto, Usuario u) {
		String sql = "INSERT INTO produtos (nome_Produto, produtoCod, quantidade, preco, Produtores_idProdutores, validade) VALUES (?, ?, ?, ?, ?, ?)";
		try (Connection conn = ConexaoBD.getConexaoMySQL(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

			pstmt.setString(1, produto.getNome());
			pstmt.setInt(2, produto.getCodigo());
			pstmt.setInt(3, produto.getQuantidadeEstoque());
			pstmt.setFloat(4, produto.getPreco());
			pstmt.setInt(5, u.getIdUsuario());
			pstmt.setDate(6, (java.sql.Date.valueOf(produto.getValidade())));

			int rowsAffected = pstmt.executeUpdate();
			return rowsAffected > 0;

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		
	}

	public boolean alterarProduto(Produto produto) {
		return false;
	}

	public boolean removerProduto(long codigo) {

		return false;
	}

	public List<Produto> ordenarPorPreco(boolean crescente, List<Produto> produtos) {
		produtos.sort(Comparator.comparingDouble(Produto::getPreco));
		if (!crescente) {
			Collections.reverse(produtos);
		}
		return produtos;
	}

	public List<Produto> ordenarNome(boolean crescente, List<Produto> produtos) {

		produtos.sort(Comparator.comparing(Produto::getNome));
		if (!crescente) {
			Collections.reverse(produtos);
		}
		return produtos;
	}
	
	public ArrayList<Produto> addListaProd(Usuario u) {
		
		PreparedStatement stmt1 = null;

		Connection conn = ConexaoBD.getConexaoMySQL();
		
		try {
			stmt1 = conn
					.prepareStatement("SELECT * FROM kanepe.produtos where Produtores_idProdutores = ?;");
			ResultSet res1 = null;
			
			stmt1.setString(1, pegarIdProdutor(u));
			
			res1 = stmt1.executeQuery();

			while (res1.next()) {

				Produto prod = new Produto();

				prod.setNome(res1.getString("nome_Produto"));
				prod.setCodigo(Integer.parseInt(res1.getString("produtoCod")));
				prod.setQuantidadeEstoque(Integer.parseInt(res1.getString("quantidade")));
				prod.setPreco(Float.parseFloat(res1.getString("preco")));
				listaProdutos.add(prod);
			}

			res1.close();
			stmt1.close();
			conn.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return listaProdutos;
	}
	
	public String pegarIdProdutor(Usuario u) {
		
		PreparedStatement stmt1 = null;

		Connection conn = ConexaoBD.getConexaoMySQL();

		try {
			stmt1 = conn
					.prepareStatement("SELECT * FROM kanepe.produtores where Usuarios_idUsuarios = ?;");
			ResultSet res1 = null;
			stmt1.setString(1, String.valueOf(u.getIdUsuario()));

			res1 = stmt1.executeQuery();

			while (res1.next()) {
				
				return res1.getString("idProdutor");
			}

			res1.close();
			stmt1.close();
			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}