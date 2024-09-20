package modelo;

public class Cliente extends Usuario{

	private String idCliente;
	private Endereco endereco;
	private CarrinhoCompras carrinho;
	private Double cpf;
	
	public Cliente(){}
	
	public Cliente(String idCliente, Double cpf, Endereco endereco, CarrinhoCompras carrinho) {
		this.idCliente = idCliente;
		this.cpf = cpf;
		this.endereco = endereco;
		this.carrinho = carrinho;	
	}
	
	public String getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(String idCliente) {
		this.idCliente = idCliente;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	public CarrinhoCompras getCarrinho() {
		return carrinho;
	}
	public void setCarrinho(CarrinhoCompras carrinho) {
		this.carrinho = carrinho;
	}
	public Double getCpf() {
		return cpf;
	}
	public void setCpf(Double cpf) {
		this.cpf = cpf;
	}
		
	
	
	}
