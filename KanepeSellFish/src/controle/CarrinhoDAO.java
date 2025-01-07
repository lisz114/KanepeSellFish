package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import modelo.CarrinhoCompras;
import modelo.ICarrinhoDAO;
import modelo.ItemCarrinho;
import modelo.Pedido;
import modelo.Produto;
import modelo.Usuario;

public class CarrinhoDAO implements ICarrinhoDAO {

	private static ProdutoDAO instancia;
	private static ArrayList<Produto> listaProdutos;
	ProdutoDAO pDAO = new ProdutoDAO();
	UsuarioDAO uDAO = new UsuarioDAO();

	public CarrinhoDAO() {
	}

	public ProdutoDAO instancia() {

		if (instancia == null) {
			instancia = new ProdutoDAO();
			listaProdutos = new ArrayList<Produto>();
		}

		return instancia;
	}

	public boolean inserirProduto(Produto produto, int quantidade, Float preco, CarrinhoCompras c) {
		String sql = "INSERT INTO ItensCarrinho (Carrinho_idCarrinho, Produtos_idProdutos, quantidade, preco) VALUES (?, ?, ?, ?)";
		try (Connection conn = ConexaoBD.getConexaoMySQL(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

			pstmt.setString(1, c.getCodigoCarrinho());
			pstmt.setInt(2, Integer.parseInt(pDAO.pegarIdProduto(produto)));
			pstmt.setInt(3, quantidade);

			// Converter o preco para double e arredondá-lo para 2 casas decimais
			pstmt.setDouble(4, preco);

			int rowsAffected = pstmt.executeUpdate();
			return rowsAffected > 0;

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public CarrinhoCompras verificarSeExisteCarrinho(Usuario u) {
		// Usar try-with-resources para garantir o fechamento adequado dos recursos
		String sql = "SELECT * FROM kanepe.carrinho where Usuarios_idUsuarios = ?";
		try (Connection conn = ConexaoBD.getConexaoMySQL(); PreparedStatement stmt1 = conn.prepareStatement(sql)) {

			stmt1.setString(1, String.valueOf(u.getIdUsuario()));

			try (ResultSet res1 = stmt1.executeQuery()) {
				// Verifica se a consulta retornou resultados
				if (!res1.next()) {
					// Caso não exista carrinho, cria um novo
					return criarCarrinho(u);
				} else {
					// Existe um carrinho, cria um objeto CarrinhoCompras
					CarrinhoCompras c = new CarrinhoCompras();
					c.setCodigoCarrinho(res1.getString("idCarrinho"));
					return c;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null; // Retorna null em caso de erro
	}

	public CarrinhoCompras criarCarrinho(Usuario u) {
		PreparedStatement stmt1 = null;
		Connection conn = ConexaoBD.getConexaoMySQL();

		try {
			// Usando o INSERT para criar um novo carrinho
			stmt1 = conn.prepareStatement("INSERT INTO carrinho (Usuarios_idUsuarios) VALUES (?)",
					PreparedStatement.RETURN_GENERATED_KEYS // Habilita a recuperação do ID gerado
			);

			// Definindo o ID do usuário
			stmt1.setInt(1, u.getIdUsuario());

			// Executando o INSERT, mas agora usando executeUpdate()
			int affectedRows = stmt1.executeUpdate(); // Retorna o número de linhas afetadas

			if (affectedRows > 0) {
				// Recuperando a chave gerada (ID do novo carrinho)
				ResultSet generatedKeys = stmt1.getGeneratedKeys();
				if (generatedKeys.next()) {
					String idCarrinho = generatedKeys.getString(1); // ID gerado pelo banco
					CarrinhoCompras c = new CarrinhoCompras();
					c.setCodigoCarrinho(idCarrinho); // Definindo o ID do carrinho
					return c;
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			// Fechar os recursos
			try {
				if (stmt1 != null)
					stmt1.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return null; // Se não for possível criar o carrinho, retorna null
	}

	@Override
	public boolean removerProduto(long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean alterarQuantidade(Pedido pedido) {
		// TODO Auto-generated method stub
		return false;
	}

	public ArrayList<ItemCarrinho> addProdCarrinho(CarrinhoCompras c) {
		ArrayList<ItemCarrinho> listaDeProdutos = new ArrayList<ItemCarrinho>();

		PreparedStatement stmt1 = null;

		Connection conn = ConexaoBD.getConexaoMySQL();

		try {
			stmt1 = conn.prepareStatement("SELECT * FROM kanepe.itenscarrinho where Carrinho_idCarrinho = ?;");
			ResultSet res1 = null;

			stmt1.setString(1, c.getCodigoCarrinho());

			res1 = stmt1.executeQuery();

//			listaProdutos = null;

			while (res1.next()) {

				pDAO.pegarIdProduto(null);

				ItemCarrinho prod = new ItemCarrinho();
				
				
				prod.setProdutoItemCarrinho(Integer.parseInt(res1.getString("Produtos_idProdutos")));
				prod.setPrecoTotal(Float.parseFloat(res1.getString("preco")));
				prod.setQuantidade(Integer.parseInt(res1.getString("quantidade")));
				listaDeProdutos.add(prod);
			}

			res1.close();
			stmt1.close();
			conn.close();
		} catch (Exception e) {
			System.out.println(e);
		}

		return listaDeProdutos;
	}

}