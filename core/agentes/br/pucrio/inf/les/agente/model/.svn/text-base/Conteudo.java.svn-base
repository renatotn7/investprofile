package br.pucrio.inf.les.agente.model;

import java.util.HashMap;

/**
 * @author <a href="mailto:mauricio.pinheiro@gmail.com">Mauricio Costa Pinheiro</a>
 *         Representa um conteúdo de uma mensagem. O conteúdo possui um estado
 *         que deve ser informado pelo agente que gerou o mesmo. Em caso de erro
 *         o agente deve informar o estado.
 */
public class Conteudo extends HashMap<Object, Object> {
	private static final long serialVersionUID = 171L;

	/**
	 * Construtor pardrão do conteúdo com estado normal
	 */
	public Conteudo() {
		setConteudoOK();
	}

	/**
	 * Construtor pardrão do conteúdo com estado normal e dado
	 * @param mensagemErro Mensagem de erro
	 */
	public Conteudo(String mensagemErro) {
		setConteudoErro(mensagemErro);
	}
	
	/**
	 * @author <a href="mailto:mauricio.pinheiro@gmail.com">Mauricio Costa
	 *         Pinheiro</a>
	 * 
	 */
	private enum Estrutura {
		/**
		 * Indica o estado da mensagem
		 */
		Estado,
		/**
		 * Indica mensagem de erro
		 */
		MensagemErro
	}

	/**
	 * @author <a href="mailto:mauricio.pinheiro@gmail.com">Mauricio Costa
	 *         Pinheiro</a>
	 * 
	 */
	private enum Estado {
		/**
		 * Indica estado normal do conteúdo
		 */
		OK,
		/**
		 * Indica estado de erro do conteúdo
		 */
		Erro
	}

	/**
	 * Informa que o conteúdo tem estado OK
	 */
	public void setConteudoOK() {
		this.put(Estrutura.Estado, Estado.OK);
		setMensagemErro("");
	}

	/**
	 * Informa que o conteúdo tem estado de erro e uma mensagem respetiva
	 * 
	 * @param mensagemErro
	 *            Mensagem de erro
	 */
	public void setConteudoErro(String mensagemErro) {
		if ((mensagemErro != null) && (mensagemErro.trim().length() > 0)) {
			setMensagemErro(mensagemErro);
		}
		else{
			setMensagemErro("Ocorreu um erro em que a mensagem era nula ou vazia.");
		}
		this.put(Estrutura.Estado, Estado.Erro);
	}

	/**
	 * Verifica se o conteúdo tem estado OK
	 * 
	 * @return verdadeiro para estado OK ou falso para estado erro
	 */
	public boolean conteudoOK() {
		return ((Estado) this.get(Estrutura.Estado)).equals(Estado.OK);
	}

	/**
	 * Informa a mensagem de erro do conteudo
	 * 
	 * @param erro
	 *            Descrição do erro
	 */
	private void setMensagemErro(String erro) {
		this.put(Estrutura.MensagemErro, erro);
	}

	/**
	 * Obtem o erro do conteúdo
	 * 
	 * @return Descrição do erro
	 */
	public String getMensagemErro() {
		return (String) this.get(Estrutura.MensagemErro);
	}
}
