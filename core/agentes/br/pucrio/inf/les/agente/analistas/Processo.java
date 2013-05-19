package br.pucrio.inf.les.agente.analistas;

import java.io.Serializable;

import br.pucrio.inf.les.agente.model.Conteudo;
import br.pucrio.inf.les.agente.model.Tag;

/**
 * @author <a href="mailto:mauricio.pinheiro@gmail.com">Mauricio Costa Pinheiro</a>
 * Interface de implementa��o de algoritmos de agentes
 */
public interface Processo extends Serializable {

	/**
	 * Obtem o nome do agente
	 * @return Nome do agente
	 */
	public String obtemNomeAgente();

	/**
	 * Obtem a descri��o do agente
	 * @return Descri��o do agente
	 */
	public String obtemDescricaoAgente();

	/**
	 * Obtem o canal de comunica��o do agente
	 * @return O Tag do canal de comunicacao
	 */
	public Tag getCanal();

	/**
	 * Executa o processo do agente
	 * @param conteudo Conte�do dos par�metros para execu��o do processo
	 * @return Conte�do gerado pelo processo
	 */
	public Conteudo executaProcesso(Conteudo conteudo);

}
