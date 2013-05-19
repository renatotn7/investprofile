package br.pucrio.inf.les.agente.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import cybele.comm.ChannelHandler;
import cybele.exception.CybeleRuntimeException;
import cybele.kernel.Activity;
import cybele.kernel.Handler;

/**
 * @author <a href="mailto:mauricio.pinheiro@gmail.com">Mauricio Costa Pinheiro</a>
 * 
 */
public abstract class AgenteSimples implements Handler {

	protected Map<String, ChannelHandler> canaisAgentes = new HashMap<String, ChannelHandler>();

	private Map<String, ChannelHandler> canaisProprios = new HashMap<String, ChannelHandler>();

	/**
	 * Cria um novo canal de comunicação e armazena na lista de canais próprios
	 * 
	 * @param tag
	 *            Caminho do canal
	 * @param metodoChamado
	 *            Metodo que trata chamadas neste canal
	 * @param handler
	 * @param prioridade
	 */
	protected void criaCanalComunicacao(Tag tag, String metodoChamado,
			Handler handler, int prioridade) {
		try {
			String rcvTicket = Activity.openChannel(tag.toString(),
					metodoChamado, handler, prioridade);
			canaisProprios.put(tag.toString(), Activity
					.getLocalChannel(rcvTicket));
		} catch (CybeleRuntimeException e) {
			System.out.println("Erro ao tentar abrir canal.");
		} catch (Exception e) {
			System.out.println("Erro ao tentar guardar novo canal.");
		}
	}

	/**
	 * Obtem o canal próprio criado com o tag informado
	 * 
	 * @param tag
	 *            Tag do canal próprio
	 * @return Canal próprio
	 */
	public ChannelHandler getCanalProprio(Tag tag) {
		if (!canaisProprios.containsKey(tag.toString()))
			return null;
		return canaisProprios.get(tag.toString());
	}

	/**
	 * Obtem o canal do agente remetente
	 * 
	 * @param pacote
	 *            Pacote recebido
	 * @return Canal do remetente
	 */
	public ChannelHandler getCanalAgente(Serializable[] pacote) {
		if (!canaisAgentes.containsKey(getIdAgentePacote(pacote)))
			canaisAgentes.put(getIdAgentePacote(pacote),
					getCanalPacote(pacote));
		return canaisAgentes.get(getIdAgentePacote(pacote));
	}

	/**
	 * Envia uma mensagem para todos em um canal
	 * 
	 * @param tag
	 *            Canal
	 * @param tagCanalRetorno
	 *            Canal de retorno
	 * @param mensagem
	 */
	protected void enviaMensagem(Tag tag, Tag tagCanalRetorno, Mensagem mensagem) {
		Activity.sendAll(tag.toString(), empacota(tagCanalRetorno, mensagem));
	}

	/**
	 * Envia uma mensagem para um agente específico em um canal
	 * 
	 * @param canal
	 *            Canal destino da mensagem
	 * @param tagCanalRemetente
	 *            Canal de retorno
	 * @param mensagemRemetente
	 *            Mensagem
	 */
	protected void enviaMensagemPara(ChannelHandler canal,
			Tag tagCanalRemetente, Mensagem mensagemRemetente) {
		Activity.send(canal, empacota(tagCanalRemetente, mensagemRemetente));
	}

	/**
	 * Envia uma mensagem para um agente específico em um canal
	 * 
	 * @param mensagemOrigem
	 *            Mensagem recebida do agente que vamos enviar a mensagem
	 * @param tagCanalRemetente
	 *            Canal de retorno
	 * @param mensagemRemetente
	 *            Mensagem
	 */
	protected void enviaMensagemParaRemetente(Serializable[] mensagemOrigem,
			Tag tagCanalRemetente, Mensagem mensagemRemetente) {
		Activity.send(getCanalAgente(mensagemOrigem), empacota(
				tagCanalRemetente, mensagemRemetente));
	}

	/**
	 * Empacota uma mensagem com o canal próprio antes da transmissão
	 * 
	 * @param tag
	 *            Tag do canal próprio
	 * @param mensagem
	 * @return Pacote com a mensagem
	 */
	private Serializable[] empacota(Tag tag, Mensagem mensagem) {
		Serializable[] retorno = { getCanalProprio(tag).getAgentId(),
				getCanalProprio(tag), mensagem };
		return retorno;
	}

	/**
	 * Desempacota uma mensagem recebida e guarda o remetente
	 * 
	 * @param pacote
	 * @return Mensagem original desempacotada
	 */
	protected Mensagem desempacota(Serializable[] pacote) {
		getCanalAgente(pacote);
		return (Mensagem) pacote[2];
	}

	/**
	 * Obtem o agente remetente da mensagem
	 * 
	 * @param mensagem
	 *            Mensagem do remetente
	 * @return Identificação do agente remetente
	 */
	protected String getIdAgentePacote(Serializable[] mensagem) {
		return (String) mensagem[0];
	}

	/**
	 * Obtem o canal de um pacote
	 * 
	 * @param mensagem
	 *            Pacote recebido
	 * @return
	 */
	private ChannelHandler getCanalPacote(Serializable[] mensagem) {
		return (ChannelHandler) mensagem[1];
	}

	/**
	 * Verifica se o agente remetente já é conhecido
	 * 
	 * @param mensagem
	 *            Pacote recebido
	 * @return verdadeiro ou falso
	 */
	protected boolean conhecoDestinatario(Serializable[] mensagem) {
		return canaisAgentes.containsKey(getIdAgentePacote(mensagem));
	}
}
