package br.pucrio.inf.les.agente.model;

import br.pucrio.inf.les.agente.analistas.Processo;
import cybele.comm.ChannelHandler;
import cybele.kernel.CybeleEvent;

/**
 *
 * @author <a href="mailto:mauricio.pinheiro@gmail.com">Mauricio Costa Pinheiro</a>
 * @version %I%, %G%
 */
public class AgenteInvestimentoSimples extends AgenteSimples {
	private static final long serialVersionUID = 14356L;
	
	protected Processo processo;

	protected Tag tag;

	/**
	 * @param processo
	 */
	public AgenteInvestimentoSimples(Processo processo) {
		this.processo = processo;
		System.out.println("Processo: " + processo.toString());
		iniciaAgente();
	}

	protected void iniciaAgente() {
		// Cria a tag referente ao canal
		tag = processo.getCanal();
		// Cria um canal para receber comunicação para a estratégia
		// utilizada no agente.
		criaCanalComunicacao(tag, "executaProcesso", this, 50);
	}

	/**
	 * Executa o processo do agente
	 * @param e Evento com a mensagem de parâmetros do pedido
	 */
	public void executaProcesso(CybeleEvent e) {
		// Obtem a mensagem recebida pelo agente.
		Mensagem recebida = desempacota(e.getMessage());
		Conteudo conteudoRetorno = (Conteudo) processo.executaProcesso(recebida
				.getConteudo());
		// Cria a mensagem de retorno se conteúdo não for nulo
		if (conteudoRetorno != null) {
			enviaMensagemRetorno(conteudoRetorno,
					getCanalAgente(e.getMessage()));
		}
	}

	private void enviaMensagemRetorno(Conteudo conteudo,
			ChannelHandler destinatario) {
		Mensagem mensagemRetorno = new Mensagem();
		mensagemRetorno.setAssunto(processo.obtemDescricaoAgente());
		// Coloca o conteudo da mensagem de retorno a informação
        // recebida do algoritmo do agente.
		mensagemRetorno.setConteudo(conteudo);
		// System.out.println(getIdAgentePacote(e.getMessage()));
		// Envia a mensagem de volta ao solicitante.
		enviaMensagemPara(destinatario, tag, mensagemRetorno);
	}

}
