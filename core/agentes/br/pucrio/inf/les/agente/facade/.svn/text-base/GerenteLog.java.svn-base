package br.pucrio.inf.les.agente.facade;

/**
 * Gerencia o registro de erros e problemas.
 * 
 * @author <a href="mailto:mauricio.pinheiro@gmail.com">Mauricio Costa Pinheiro</a>
 * @version %I%, %G%
 */
public class GerenteLog {

	/**
	 * Registra ocorrências de excessões nos agentes.
	 * @param ex Excessão ocorrida.
	 */
	public static void registraExcessao(Exception ex) {
		System.out.println(ex.getLocalizedMessage());
		ex.printStackTrace();
	}

	/**
	 * Registra mensagens de erro dos agentes.
	 * @param mensagem Descrição do problema.
	 */
	public static void registraErroAgente(String mensagem) {
		System.out.println(mensagem);
	}
	
	public static void consolePrint(String mensagem) {
		System.out.println(mensagem);
	}
	
}
