package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JLabel;

import modelo.IUsuarioDAO;
import modelo.Usuario;

public class UsuarioDAO implements IUsuarioDAO {

	private static ArrayList<Usuario> listaUsuarios;

	private static UsuarioDAO instancia;

	private UsuarioDAO() {
	}

	public static UsuarioDAO getInstancia() {

		if (instancia == null) {
			instancia = new UsuarioDAO();
			listaUsuarios = new ArrayList<>();
		}

		return instancia;
	}

	@Override
	public boolean inserirUsuario(Usuario usuario) {
		
		listaUsuarios.add(usuario);
		
		return false;
	}
	public boolean atualizarUsuario(Usuario usuario) {
		/* Statement stmt1 = null;

		Connection conn = ConexaoBD.getConexaoMySQL();

		try {
			stmt1 = (Statement) conn.createStatement();
			ResultSet res1 = null;
			res1 = stmt1.executeQuery("Select * from kanepe.usuarios where email_Usuario like '" + usuario.getEmail() + "';");

			
			//Conta o numero de registros do ResultSet no BD
			int count = 0;
			while (res1.next()) {
				System.out.println(
						res1.getInt("id") + "   " + res1.getString("nome") + "    " + res1.getString("email"));
				count++;
			}
			System.out.println("Número de registros: " + count);
			

			res1.close();
			stmt1.close();
			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}*/

		return false;
	}

	@Override
	public boolean alterarUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removerUsuario(String cpf) {
		for (Usuario usuario : listaUsuarios) {
			if(usuario.getCpf()==cpf) {
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
			stmt1 = conn.prepareStatement("SELECT * FROM kanepe.usuarios where email_Usuario = ? and senha_Usuario = ?;");
			ResultSet res1 = null;
			stmt1.setString(1, email);
			stmt1.setString(2, senha);
			
			res1 = stmt1.executeQuery();

			
			while (res1.next()) {
				
				Usuario u= new Usuario();
				
				u.setNome(res1.getString("nome_Usuario"));
				u.setCpf(res1.getString("idUsuarios"));
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