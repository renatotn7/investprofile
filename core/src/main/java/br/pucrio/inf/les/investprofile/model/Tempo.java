package br.pucrio.inf.les.investprofile.model;

/**
 *
 * @author <a href="mailto:mauricio.pinheiro@gmail.com">Mauricio Costa Pinheiro</a>
 * @version %I%, %G%
 */
public enum Tempo {

	/**
	 * Definição do minuto
	 */
	MINUTO("Minuto"),

	/**
	 * 
	 */
	HORA("Hora"),

	/**
	 * 
	 */
	DIA("Dia"),

	/**
	 * 
	 */
	MES("Mês"),

	/**
	 * 
	 */
	ANO("Ano"),
	DEZANOS("10 anos");

	private String descricao;
	
	private Tempo(String descricao) {
		this.descricao = descricao;		
	}
	
	/**
	 * @return
	 */
	String decricao() {
		return this.descricao;
	}
	
}
