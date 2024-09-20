package modelo;

public class Usuario {
	private String nome;
	private String senha;
	private String email;
	private Double cpf;
	private String tel;
//	private String nempresa;
//	private String cidade;
//	private String rua;
//	private String bairro;

	public Usuario() {
	}

	public Usuario(Double cpf, String nome, String senha, String email) {
		this.nome = nome;
		this.senha = senha;
		this.email = email;
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Double getCpf() {
		return cpf;
	}

	public void setCpf(Double cpf) {
		this.cpf = cpf;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}
}
