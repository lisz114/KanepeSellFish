package modelo;

import java.util.ArrayList;

public interface IUsuarioDAO {
	public boolean inserirUsuario(Usuario usuario);

	public boolean alterarUsuario(Usuario usuario);

	public boolean removerUsuario(String cpf);
	
	public Usuario consultarUsuarioLoginSenha(String email, String senha);

	public boolean atualizarUsuario(Usuario usuario);
}