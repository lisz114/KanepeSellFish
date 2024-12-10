package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import modelo.Endereco;
import modelo.IProdutorDAO;
import modelo.Produtor;
import modelo.Usuario;

public class ProdutorDAO implements IProdutorDAO {
	
	private static ProdutorDAO instancia;
	EnderecoDAO eDAO;

	private ProdutorDAO() {
	}

	public static ProdutorDAO getInstancia() {

		if (instancia == null) {
			instancia = new ProdutorDAO();
		}

		return instancia;
	}

	@Override
	public boolean inserirProdutor(Produtor produtor) {
		String sql = "INSERT INTO produtores (nomeNegocio, Usuarios_idUsuarios, Enderecos_idEnderecos, cnpj) VALUES (?, ?, ?, ?)";
		try (Connection conn = ConexaoBD.getConexaoMySQL(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

			pstmt.setString(1, produtor.getNomeComercio());
			pstmt.setInt(2, produtor.getIdUsuario());
			pstmt.setInt(3, produtor.getEndereco());
			pstmt.setString(4, produtor.getCnpj());
			System.out.println(pstmt);
			int rowsAffected = pstmt.executeUpdate();
			return rowsAffected > 0;

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public Produtor consultaProdutor(Usuario usuario) {
		PreparedStatement stmt1 = null;

		Connection conn = ConexaoBD.getConexaoMySQL();

		try {
			stmt1 = conn.prepareStatement("SELECT * FROM kanepe.produtores WHERE Usuarios_idUsuarios = ?");
			ResultSet res1 = null;
			stmt1.setLong(1, usuario.getIdUsuario());

			res1 = stmt1.executeQuery();

			while (res1.next()) {

			Produtor p = new Produtor();
			Endereco e = new Endereco();
			
			
			p.setNomeComercio(res1.getString("nomeNegocio"));
			p.setCnpj(res1.getString("cnpj"));
			e = eDAO.buscarendereco(Integer.parseInt(res1.getString("Enderecos_idEnderecos")));
			p.setEnd(e);
			return p;
			
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

