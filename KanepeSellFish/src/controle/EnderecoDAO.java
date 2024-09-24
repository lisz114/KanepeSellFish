package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import modelo.Endereco;
import modelo.IEnderecoDAO;

public class EnderecoDAO implements IEnderecoDAO {

	private static EnderecoDAO instancia;

	private EnderecoDAO() {
	}

	public static EnderecoDAO getInstancia() {

		if (instancia == null) {
			instancia = new EnderecoDAO();
		}

		return instancia;
	}

	public boolean inserirEnderecoDoComercio(Endereco endereco) {

		String sql = "INSERT INTO enderecos (Cidade, Rua, Bairro) VALUES (?, ?, ?)";

		try (Connection conn = ConexaoBD.getConexaoMySQL();
				PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

			pstmt.setString(1, endereco.getCidade());
			pstmt.setString(2, endereco.getLogradouro());
			pstmt.setString(3, endereco.getBairro());

			pstmt.executeUpdate();

			ResultSet rs = pstmt.getGeneratedKeys(); // Retrieve the automatically 2
			// generated key value in a ResultSet.
			// Only one row is returned.
			// Create ResultSet for query
			while (rs.next()) {
				java.math.BigDecimal idColVar = rs.getBigDecimal(1);
				// Get automatically generated key
				// value
			}

			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
}
