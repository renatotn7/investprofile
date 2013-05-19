package br.pucrio.inf.les.agente.comando;

import br.pucrio.inf.les.agente.facade.ControladorContexto;
import br.pucrio.inf.les.agente.model.StockAgentException;

/**
 * @author <a href="mailto:mauricio.pinheiro@gmail.com">Mauricio Costa Pinheiro</a>
 * 
 */
public class IniciaAmbienteAgentes {
	/**
	 * @param args
	 * @throws StockAgentException
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws StockAgentException,
			InterruptedException {
		try {
			// Inicia beans do spring para acesso a dados
			ControladorContexto.inicia();
			// Inicia ambiente Cybele
			AmbienteCybele.inicia();
			// Inicia agentes
			IniciaAgentes.inicia();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
