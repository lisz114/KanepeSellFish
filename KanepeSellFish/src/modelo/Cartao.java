package modelo;

import java.sql.Date;

public class Cartao {

	private long numdoCartão;
	private Date validade;
	private int CVV;
	private Usuario idUsuario;
	private Object TipodoCartão;
	private String apelido;

	public long getNumdoCartão() {
		return numdoCartão;
	}

	public void setNumdoCartão(long numdoCartão) {
		this.numdoCartão = numdoCartão;
	}

	public Date getValidade() {
		return validade;
	}

	public void setValidade(Date validade) {
		this.validade = validade;
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

	public Object getTipodoCartão() {
		return TipodoCartão;
	}

	public void setTipodoCartão(Object tipodoCartão) {
		TipodoCartão = tipodoCartão;
	}

	public String getApelido() {
		return apelido;
	}

	public void setApelido(String apelido) {
		this.apelido = apelido;
	}

}
