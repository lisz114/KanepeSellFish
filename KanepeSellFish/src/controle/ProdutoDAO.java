package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import modelo.IProdutoDAO;
import modelo.Produto;
import modelo.Usuario;

public class ProdutoDAO implements IProdutoDAO {

	private static ProdutoDAO instancia;
	public static ArrayList<Produto> listaProdutos;

	public ProdutoDAO() {
	}

	public static ProdutoDAO getInstancia() {

		if (instancia == null) {
			instancia = new ProdutoDAO();
			listaProdutos = new ArrayList<>();
		}

		return instancia;
	}

	public boolean inserirProduto(Produto produto, Usuario u) {
		String sql = "INSERT INTO produtos (nome_Produto, quantidade, preco, Produtores_idProdutores, validade, salinidade) VALUES (?, ?, ?, ?, ?, ?)";
		try (Connection conn = ConexaoBD.getConexaoMySQL(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

			pstmt.setString(1, produto.getNome());
			pstmt.setInt(2, produto.getQuantidadeEstoque());
			pstmt.setFloat(3, produto.getPreco());
			pstmt.setInt(4, u.getIdUsuario());
			pstmt.setDate(5, (java.sql.Date.valueOf(produto.getValidade())));
			pstmt.setBoolean(6, produto.getSalinidade());

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

	public boolean removerProduto(Produto p) {
		int id = Integer.parseInt(pegarIdProduto(p));

		String sql = "DELETE FROM produtos WHERE idProdutos = ?";
		try (Connection conn = ConexaoBD.getConexaoMySQL(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

			pstmt.setInt(1, id);

			int rowsAffected = pstmt.executeUpdate();
			return rowsAffected > 0;

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public List<Produto> ordenarPorPreco(boolean crescente, List<Produto> produtos) {
		Comparator<Produto> comparador = Comparator.comparingDouble(Produto::getPreco);
		if(!crescente) {
			comparador = comparador.reversed();
		}
		produtos.sort(comparador);
		return produtos;
	}

	public List<Produto> ordenarNome(boolean crescente, List<Produto> produtos) {
		Comparator<Produto> comparador = Comparator.comparing(Produto::getNome);
		if(!crescente) {
			comparador = comparador.reversed();
		}
		produtos.sort(comparador);
		return produtos;
	}

	public ArrayList<Produto> addListaProd(Usuario u) {
		listaProdutos.clear();

		PreparedStatement stmt1 = null;

		Connection conn = ConexaoBD.getConexaoMySQL();

		try {
			stmt1 = conn.prepareStatement("SELECT * FROM kanepe.produtos where Produtores_idProdutores = ?;");
			ResultSet res1 = null;

			stmt1.setString(1, pegarIdProdutor(u));

			res1 = stmt1.executeQuery();

//			listaProdutos = null;

			while (res1.next()) {

				Produto prod = new Produto();

				prod.setNome(res1.getString("nome_Produto"));
				prod.setQuantidadeEstoque(Integer.parseInt(res1.getString("quantidade")));
				prod.setPreco(Float.parseFloat(res1.getString("preco")));
				prod.setIdProdutor(Integer.parseInt(res1.getString("Produtores_idProdutores")));
				prod.setValidade(
						LocalDate.parse(res1.getString("validade"), DateTimeFormatter.ofPattern("yyyy-MM-dd")));
				listaProdutos.add(prod);
				prod.setSalinidade(res1.getBoolean("salinidade"));
			}

			res1.close();
			stmt1.close();
			conn.close();
		} catch (Exception e) {
		}

		return listaProdutos;
	}

	public String pegarIdProdutor(Usuario u) {

		PreparedStatement stmt1 = null;

		Connection conn = ConexaoBD.getConexaoMySQL();

		try {
			stmt1 = conn.prepareStatement("SELECT * FROM kanepe.produtores where Usuarios_idUsuarios = ?;");
			ResultSet res1 = null;
			stmt1.setString(1, String.valueOf(u.getIdUsuario()));

			res1 = stmt1.executeQuery();

			while (res1.next()) {

				return res1.getString("idProdutores");
			}

			res1.close();
			stmt1.close();
			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public String pegarIdProduto(Produto p) {

		PreparedStatement stmt1 = null;

		Connection conn = ConexaoBD.getConexaoMySQL();

		try {
			stmt1 = conn.prepareStatement("SELECT * FROM produtos where nome_Produto = ?");
			ResultSet res1 = null;

			stmt1.setString(1, String.valueOf(p.getNome()));

			res1 = stmt1.executeQuery();

			while (res1.next()) {

				return res1.getString("idProdutos");
			}

			res1.close();
			stmt1.close();
			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean atualizarProduto(Produto oprod, Produto produto, Usuario u) {
		int id = Integer.parseInt(pegarIdProduto(oprod));

		String sql = "UPDATE produtos SET nome_Produto = ?, quantidade = ?, preco = ?, validade = ?, salinidade = ? WHERE idProdutos = ?";
		try (Connection conn = ConexaoBD.getConexaoMySQL(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

			pstmt.setString(1, produto.getNome());
			pstmt.setInt(2, produto.getQuantidadeEstoque());
			pstmt.setFloat(3, produto.getPreco());
			pstmt.setDate(4, (java.sql.Date.valueOf(produto.getValidade())));
			pstmt.setBoolean(5, produto.getSalinidade());
			pstmt.setInt(6, id);

			int rowsAffected = pstmt.executeUpdate();
			return rowsAffected > 0;

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
}