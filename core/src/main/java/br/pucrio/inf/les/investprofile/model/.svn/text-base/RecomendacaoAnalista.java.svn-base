package br.pucrio.inf.les.investprofile.model;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * @author <a href="mailto:mauricio.pinheiro@gmail.com">Mauricio Pinheiro</a>
 */
@Entity
public class RecomendacaoAnalista extends Recomendacao {
	private static final long serialVersionUID = 162L;

	private String analista;

	/**
	 * 
	 */
	public RecomendacaoAnalista() {
	};

	/**
	 * @return Código do analista da recomendação
	 */
	@Column(nullable = false)
	public String getAnalista() {
		return analista;
	}

	/**
	 * @param analista
	 *            Altera o analista da recomendação
	 */
	public void setAnalista(String analista) {
		this.analista = analista;
	}
}
