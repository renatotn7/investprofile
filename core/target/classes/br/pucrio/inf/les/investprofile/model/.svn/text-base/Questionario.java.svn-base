package br.pucrio.inf.les.investprofile.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * @author <a href="mailto:mauricio.pinheiro@gmail.com">Mauricio Pinheiro</a>
 */
public class Questionario extends BaseObject implements Serializable {
	private static final long serialVersionUID = 60L;

	private Long id;

	private Set<Questao> questoes = new HashSet<Questao>();

	/**
	 * @return Retorna o id da questao.
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 *            Código da questão
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return Lista de questões
	 */
	public Set<Questao> getQuestoes() {
		return questoes;
	}

	/**
	 * @param questoes
	 */
	public void setQuestoes(Set<Questao> questoes) {
		this.questoes = questoes;
	}

	/**
	 * Adiciona um conselho de uma ação para uma carteira aconselhada
	 * 
	 * @param questao
	 */
	public void addQuestao(Questao questao) {
		getQuestoes().add(questao);
	}

	/**
	 * @see java.lang.Object#equals(Object)
	 */
	public boolean equals(Object object) {
		if (!(object instanceof Questionario)) {
			return false;
		}
		Questionario rhs = (Questionario) object;
		return new EqualsBuilder().append(this.questoes, rhs.questoes)
				.isEquals();
	}

	/**
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() {
		return new HashCodeBuilder(1941638165, -881216605)
				.append(this.questoes).toHashCode();
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return new ToStringBuilder(this).append("questoes", this.getQuestoes())
				.toString();
	}
}
