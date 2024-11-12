package modelo;

import java.sql.SQLException;

public interface IUsuarioDAO {
	public int inserirUsuario(Usuario usuario);

	public int alterarUsuario(Usuario usuario);

	public boolean removerUsuario(String cpf);
	
	public Usuario consultarUsuarioLoginSenha(String email, String senha);
	
	public Usuario consultaUsuarioCadastrado(String cpf, String email);
	
    public boolean validarCPF(String cpf);
    
}