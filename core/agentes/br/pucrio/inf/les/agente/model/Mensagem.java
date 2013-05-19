package br.pucrio.inf.les.agente.model;

import java.util.HashMap;

/**
 * @author <a href="mailto:mauricio.pinheiro@gmail.com">Mauricio Costa Pinheiro</a>
 *
 */
public class Mensagem extends HashMap<Enum, Object> {
	private static final long serialVersionUID = 333L;

	/**
	 * @author <a href="mailto:mauricio.pinheiro@gmail.com">Mauricio Costa Pinheiro</a>
	 *
	 */
	private enum Estrutura {
		/**
		 * Assunto da mensgem
		 */
		Assunto,
		/**
		 * Conteúdo da mensagem 
		 */
		Conteudo
	}

	/**
	 * Construtor padrão
	 */
	public Mensagem() {

	}

	/**
	 * Obtem o assunto da mensagem
	 * @return Texto com o assunto da mensagem
	 */
	public String getAssunto() {
		return (String) this.get(Estrutura.Assunto);
	}

	/**
	 * Insere o assunto da mensagem
	 * @param assunto Texto com o assunto da mensagem
	 */
	public void setAssunto(String assunto) {
		this.put(Estrutura.Assunto, assunto);
	}

	/**
	 * Obtem o conteúdo da mensagem
	 * @return O conteúdo da mensagem
	 */
	public Conteudo getConteudo() {
		return (Conteudo) this.get(Estrutura.Conteudo);
	}

	/**
	 * Insere um conteúdo na mensagem
	 * @param conteudo O conteúdo da mensagem
	 */
	public void setConteudo(Conteudo conteudo) {
		this.put(Estrutura.Conteudo, conteudo);
	}
}
