package br.pucrio.inf.les.investprofile.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * @author <a href="mailto:mauricio.pinheiro@gmail.com">Mauricio Pinheiro</a>
 */
@Entity
public class RecomendacaoPerfil extends Recomendacao {
	private static final long serialVersionUID = 161L;

	private PerfilInvestimento perfilinvestimento;

	/**
	 * 
	 */
	public RecomendacaoPerfil() {
	}

	/**
	 * @return
	 */
	@ManyToOne
	@JoinColumn(name = "idperfilinvestimento")
	public PerfilInvestimento getPerfilinvestimento() {
		return perfilinvestimento;
	}

	/**
	 * @param perfilinvestimento
	 */
	public void setPerfilinvestimento(PerfilInvestimento perfilinvestimento) {
		this.perfilinvestimento = perfilinvestimento;
	};

}
