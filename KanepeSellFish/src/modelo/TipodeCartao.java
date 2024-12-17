package modelo;

public enum TipodeCartao {
	
	DEBITO("Débito"),CREDITO("Crédito");
	
	private String tipo;
	
	private TipodeCartao(String tipo) {
		this.tipo = tipo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	} 
	
	public static TipodeCartao getCartaoporTipo(String cartao) {
		
		switch (cartao) {
		case "Débito":
			return DEBITO;
		case "Crédito":
			return CREDITO;
		default:
			throw new IllegalArgumentException("Unxpected value: "+cartao);
		}
	}
}
