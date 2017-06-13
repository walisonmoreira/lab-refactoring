package lab.refactoring.web.venda;

/**
 * Enumerado para representar o tipo da venda.
 * 
 * @author Danilo Guimarães
 *
 */
public enum TIPO_VENDA {
	A_VISTA("A_VISTA"),
	A_PRAZO("A_PRAZO");
	
	private String tipoVenda;
	
	TIPO_VENDA(String tipoVenda) {
		this.tipoVenda = tipoVenda;
	}
	
	/**
	 * @return o tipo da venda
	 */
	public String getTipoVenda() {
		return tipoVenda;
	}

	/**
	 * 
	 * @param tipo
	 * @return
	 */
	public static TIPO_VENDA from(String tipo) {
		for (TIPO_VENDA tipoVenda : values()) {
			if (tipoVenda.getTipoVenda().equals(tipo)) {
				return tipoVenda;
			}
		}
		return null;
	}

}
