package modelo;

public interface IUsuarioDAO {
	public boolean inserirUsuario(Usuario usuario);

	public boolean alterarUsuario(Usuario usuario);

	public boolean removerUsuario(String cpf);
	
	public Usuario consultarUsuarioLoginSenha(String email, String senha);
	
	public Usuario consultaUsuarioCPF(String cpf);

}