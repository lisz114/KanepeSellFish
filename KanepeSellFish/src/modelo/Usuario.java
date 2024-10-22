package modelo;

public class Usuario {

	private String nome;
	private String senha;
	private String email;
	private String cpf;
	private String tel;
	private Endereco end;
	private Produtor prod;

	// private String nempresa;
//	private String cidade;
//	private String rua;
//	private String bairro;
	public Usuario() {
	}

	public Usuario(String cpf, String nome, String senha, String email) {
		this.cpf = cpf;
		this.nome = nome;
		this.senha = senha;
		this.email = email;
	}

	public Endereco getEnd() {
		return end;
	}

	public Produtor getProd() {
		return prod;
	}

	public void setProd(Produtor prod) {
		this.prod = prod;
	}

	public void setEnd(Endereco end) {
		this.end = end;
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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;
		Usuario usuario = (Usuario) obj;
		return cpf == usuario.cpf;
	}
}