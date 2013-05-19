package br.pucrio.inf.les.agente.analistas;

import java.io.Serializable;

import br.pucrio.inf.les.agente.model.Conteudo;
import br.pucrio.inf.les.agente.model.Tag;

/**
 * @author <a href="mailto:mauricio.pinheiro@gmail.com">Mauricio Costa Pinheiro</a>
 * Interface de implementação de algoritmos de agentes
 */
public interface Processo extends Serializable {

	/**
	 * Obtem o nome do agente
	 * @return Nome do agente
	 */
	public String obtemNomeAgente();

	/**
	 * Obtem a descrição do agente
	 * @return Descrição do agente
	 */
	public String obtemDescricaoAgente();

	/**
	 * Obtem o canal de comunicação do agente
	 * @return O Tag do canal de comunicacao
	 */
	public Tag getCanal();

	/**
	 * Executa o processo do agente
	 * @param conteudo Conteúdo dos parâmetros para execução do processo
	 * @return Conteúdo gerado pelo processo
	 */
	public Conteudo executaProcesso(Conteudo conteudo);

}
