package modelo;

public interface IUsuarioDAO {
	public boolean inserirUsuario(Usuario usuario);

	public boolean alterarUsuario(Usuario usuario);

	public boolean removerUsuario(String cpf);
	
	public boolean atualizarUsuario(Usuario usuario);
	
	public Usuario consultarUsuarioLoginSenha(String email, String senha);
	
	public Usuario consultaUsuarioCadastrado(String cpf, String email);

}