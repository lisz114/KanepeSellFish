package modelo;

public class Endereco {
	private String cep;
	private String cidade;
	private String bairro;
	private int numero;
	private String logradouro;

	public Endereco() {
	}

	public Endereco(String cep, String cidade, String bairro, int numero, String logradouro) {
		this.cep = cep;
		this.cidade = cidade;
		this.bairro = bairro;
		this.numero = numero;
		this.logradouro = logradouro;

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