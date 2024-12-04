package modelo;

public interface IUsuarioDAO {
	public int inserirUsuario(Usuario usuario);

	public int alterarUsuario(Usuario usuario);

	public boolean removerUsuario(String cpf);
	
	public boolean consultarUsuarioVendedor(Usuario usuario);
	
	public Usuario consultaUsuarioCadastrado(String cpf, String email);
	
    public boolean validarCPF(String cpf);

	Usuario consultarUsuarioLoginSenha(String email, String senha);
    
}