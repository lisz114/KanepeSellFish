package modelo;

public class Usuario {

	private String nome;
	private String desc;
	private String senha;
	private String email;
	private String cpf;
	private String tel;
	private Produtor prod;
	private Endereco end;
	private Cartao cartao;
	protected int idUsuario;
	private String img;
	private boolean Cartaoid;

	
	public Usuario() {}

	public Usuario(String cpf, String nome, String senha, String email, String desc) {
		this.cpf = cpf;
		this.nome = nome;
		this.senha = senha;
		this.email = email;
		this.setDesc(desc);
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	
	public Produtor getProd() {
		return prod;
	}

	public void setProd(Produtor prod) {
		this.prod = prod;
	}

	public Endereco getEnd() {
		return end;
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
  
  	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;
		Usuario usuario = (Usuario) obj;
		return cpf == usuario.cpf;
	}
	public int getIdUsuario() {
		return this.idUsuario;
	}

	public boolean isProdutor() {
		// TODO Auto-generated method stub
		return false;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public boolean getCartaoid(boolean b) {
		return Cartaoid;
	}

	public boolean setCartaoid(boolean b) {
		return Cartaoid = b;
	}

	public Cartao getCartao() {
		return cartao;
	}

	public void setCartao(Cartao cartao) {
		this.cartao = cartao;
	}
}
