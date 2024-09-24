package modelo;

public class Endereco {
	private String nomeComercio;
	private String cnpj;
	private String cep;
	private String cidade;
	private String bairro;
	private int numero;
	private String logradouro;
	
	public Endereco() {
	}

	public Endereco(String nomeComercio, String cnpj, String cep, String cidade, String bairro, int numero, String logradouro) {
		this.nomeComercio = nomeComercio;
		this.cnpj = cnpj;
		this.cep = cep;
		this.cidade = cidade;
		this.bairro = bairro;
		this.numero = numero;
		this.logradouro = logradouro;
		
	}
	
	public String getNomeComercio() {
		return nomeComercio;
	}
	public void setNomeComercio(String nomeComercio) {
		this.nomeComercio = nomeComercio;
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
}