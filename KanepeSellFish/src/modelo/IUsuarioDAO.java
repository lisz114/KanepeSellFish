package modelo;

public interface IUsuarioDAO {
	public boolean inserirUsuario(Usuario usuario);

	public boolean alterarUsuario(Usuario usuario);

	public boolean removerUsuario(Double cpf);
	
	public Usuario consultarUsuarioLoginSenha(String email, String senha);
	
	public Usuario consultaUsuarioCPF(Double cpf);

}