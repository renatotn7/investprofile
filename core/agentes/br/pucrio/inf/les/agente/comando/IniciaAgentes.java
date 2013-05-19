package br.pucrio.inf.les.agente.comando;


/**
 * @author <a href="mailto:mauricio.pinheiro@gmail.com">Mauricio Costa Pinheiro</a>
 * 
 */
public class IniciaAgentes {

	/**
	 * Cria agente controlador ambiente de agentes
	 */
	public static void inicia() {

		// Cria um agente controlador para iniciar os agentes que farão as recomendações de investimento.
		AmbienteCybele.criaAgente("Agente.Controlador",
				"Controla ambiente dos agentes",
				"br.pucrio.inf.les.agente.Controlador", null);

	}
}
