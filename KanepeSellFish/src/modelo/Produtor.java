package modelo;

import java.util.ArrayList;

public class Produtor extends Usuario {
	private String idProdutor;
	private String nomeComercio;
	private Endereco endereco;
	private ArrayList<Pedido> pedido;
	private String cnpj;

	
	public Produtor(){}
	
	public Produtor(String idProdutor,String nomeComercio, Endereco endereco, ArrayList<Pedido> pedido, String cnpj) {
		this.idProdutor = idProdutor;
		this.nomeComercio = nomeComercio;
		this.endereco = endereco;
		this.pedido = pedido ;
		this.cnpj = cnpj;
		}

	public String getIdProdutor() {
		return idProdutor;
	}

	public void setIdProdutor(String idProdutor) {
		this.idProdutor = idProdutor;
	}

	public String getNomeComercio() {
		return nomeComercio;
	}

	public void setNomeComercio(String nomeComercio) {
		this.nomeComercio = nomeComercio;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public ArrayList<Pedido> getPedido() {
		return pedido;
	}

	public void setPedido(ArrayList<Pedido> pedido) {
		this.pedido = pedido;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	
	
}		
