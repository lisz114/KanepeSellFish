package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import modelo.IProdutorDAO;
import modelo.Produtor;

public class ProdutorDAO implements IProdutorDAO {
	
	private static ProdutorDAO instancia;

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
		String sql = "INSERT INTO produtores (nomeNegocio, cnpj) VALUES (?, ?)";
		try (Connection conn = ConexaoBD.getConexaoMySQL(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

			pstmt.setString(1, produtor.getNomeComercio());
			pstmt.setString(4, produtor.getCnpj());
			System.out.println(pstmt);
			int rowsAffected = pstmt.executeUpdate();
			return rowsAffected > 0;

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
}
