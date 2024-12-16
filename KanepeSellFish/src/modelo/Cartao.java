package modelo;

import java.sql.Date;
import java.time.LocalDate;

public class Cartao {

	private long numdoCartao;
	private LocalDate validade;
	private int CVV;
	private Usuario idUsuario;
	private int idC;
	private Object TipodoCartao;
	private String apelido;

	public long getNumdoCartao() {
		return numdoCartao;
	}

	public void setNumdoCartao(long numdoCartao) {
		this.numdoCartao = numdoCartao;
	}

	public LocalDate getValidade() {
		return validade;
	}

	public void setValidade(LocalDate validade2) {
		this.validade = validade2;
	}

	public int getCVV() {
		return CVV;
	}

	public void setCVV(int cVV) {
		CVV = cVV;
	}

	public Usuario getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Usuario idUsuario) {
		this.idUsuario = idUsuario;
	}

	public Object getTipodoCartao() {
		return TipodoCartao;
	}

	public void setTipodoCartao(Object tipodoCartao) {
		TipodoCartao = tipodoCartao;
	}

	public String getApelido() {
		return apelido;
	}

	public void setApelido(String apelido) {
		this.apelido = apelido;
	}

	public int getIdC() {
		return idC;
	}

	public void setIdC(int idC) {
		this.idC = idC;
	}

}
