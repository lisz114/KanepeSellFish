package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import modelo.IUsuarioDAO;
import modelo.Usuario;

public class UsuarioDAO implements IUsuarioDAO {

	private static ArrayList<Usuario> listaUsuarios;

	private static UsuarioDAO instancia;

	private UsuarioDAO() {}

	public static UsuarioDAO getInstancia() {

		if (instancia == null) {
			instancia = new UsuarioDAO();
			listaUsuarios = new ArrayList<>();
		}

		return instancia;
	}

	@Override
	public boolean inserirUsuario(Usuario usuario) {
		String sql = "INSERT INTO usuarios (email_Usuario, senha_Usuario, cpf_Usuario, nome_Usuario) VALUES (?, ?, ?, ?)";
		try (Connection conn = ConexaoBD.getConexaoMySQL();
				PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

			pstmt.setString(1, usuario.getEmail());
			pstmt.setString(2, usuario.getSenha());
			pstmt.setString(3, usuario.getCpf());
			pstmt.setString(4, usuario.getNome());

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

	@Override
	public boolean alterarUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean atualizarUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		//String buscar = "select * from Kanepe.Usuarios where cpf_Usuario = ?";
		
		return false;
	}

	@Override
	public boolean removerUsuario(String cpf) {
		for (Usuario usuario : listaUsuarios) {
			if(usuario.getCpf().equals(cpf)) {
				listaUsuarios.remove(usuario);
			}
		}

		return false;
	}

	@Override
	public Usuario consultarUsuarioLoginSenha(String email, String senha) {
		PreparedStatement stmt1 = null;

		Connection conn = ConexaoBD.getConexaoMySQL();

		try {
			stmt1 = conn
					.prepareStatement("SELECT * FROM kanepe.usuarios where email_Usuario = ? and senha_Usuario = ?;");
			ResultSet res1 = null;
			stmt1.setString(1, email);
			stmt1.setString(2, senha);

			res1 = stmt1.executeQuery();

			while (res1.next()) {

				Usuario u = new Usuario();

				u.setNome(res1.getString("nome_Usuario"));
				u.setCpf(res1.getString("cpf_Usuario"));
				u.setEmail(res1.getString("email_Usuario"));
				u.setSenha(res1.getString("senha_Usuario"));

				return u;
			}

			res1.close();
			stmt1.close();
			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Usuario consultaUsuarioCadastrado(String cpf, String email) {
		PreparedStatement stmt1 = null;

		Connection conn = ConexaoBD.getConexaoMySQL();

		try {
			stmt1 = conn.prepareStatement("SELECT * FROM kanepe.usuarios where cpf_Usuario = ? OR email_Usuario=?;");
			ResultSet res1 = null;
			stmt1.setString(1, cpf);
			stmt1.setString(2, email);

			res1 = stmt1.executeQuery();

			while (res1.next()) {

				Usuario u = new Usuario();

				u.setNome(res1.getString("nome_Usuario"));
				u.setCpf(res1.getString("cpf_Usuario"));
				u.setEmail(res1.getString("email_Usuario"));
				u.setSenha(res1.getString("senha_Usuario"));

				return u;
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