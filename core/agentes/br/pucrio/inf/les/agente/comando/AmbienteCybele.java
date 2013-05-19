package br.pucrio.inf.les.agente.comando;

import static br.pucrio.inf.les.agente.Constantes.CLOCKID;

import java.io.Serializable;

import cybele.exception.CybeleRuntimeException;
import cybele.kernel.Cybele;


/**
 * Cria uma instância do ambiente de agentes implementando o padrão singleton.
 * 
 * @author <a href="mailto:mauricio.pinheiro@gmail.com">Mauricio Costa Pinheiro</a>
 * @version %I%, %G%
 */
public class AmbienteCybele {

	private static AmbienteCybele instance = null;

	/**
	 * Inicia o ambiente de agentes Cybele
	 * 
	 * @throws InterruptedException
	 */
	public AmbienteCybele() throws InterruptedException {
		try {
			Cybele.startUp("StockAgents", null);
			Cybele.createClock(CLOCKID, Cybele.LOCAL, 0, 1.0D);
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			throw e;
		} catch (CybeleRuntimeException ex) {
			System.out.println((ex.getMessage()));
		}
	}

	/**
	 * Cria uma instância da classe ou retona a instanciada.
	 */
	public static void inicia() throws InterruptedException {
		if (instance == null) {
			try {
				instance = new AmbienteCybele();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Cria um novo agente no ambiente de agentes.
	 * 
	 * @param nome
	 *            Nome do novo agente
	 * @param descricao
	 *            Descrição do agente
	 * @param classe
	 *            Nome da classe com pacote
	 * @param pars
	 *            Parâmetros de chamada
	 */
	public static void criaAgente(String nome, String descricao, String classe,
			Serializable[] pars) {
		System.out.println("Criando " + nome);
		Cybele.createAgent(nome, descricao, classe, pars);
	}
}
