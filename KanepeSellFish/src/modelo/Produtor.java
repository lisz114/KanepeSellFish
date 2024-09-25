package modelo;

import java.util.ArrayList;

public class Produtor extends Usuario {
	private String idUsuario;
	private String nomeComercio;
	private int IdEndereco;
	private ArrayList<Pedido> pedido;
	private String cnpj;

	public Produtor() {
	}

	public Produtor(String idUsuario, String nomeComercio, int IdEndereco, ArrayList<Pedido> pedido, String cnpj) {
		this.idUsuario = idUsuario;
		this.nomeComercio = nomeComercio;
		this.IdEndereco = IdEndereco;
		this.pedido = pedido;
		this.cnpj = cnpj;
	}

	public String getidUsuario() {
		return idUsuario;
	}

	public void setidUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNomeComercio() {
		return nomeComercio;
	}

	public void setNomeComercio(String nomeComercio) {
		this.nomeComercio = nomeComercio;
	}

	public int getEndereco() {
		return IdEndereco;
	}

	public void setEndereco(int IdEndereco) {
		this.IdEndereco = IdEndereco;
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
