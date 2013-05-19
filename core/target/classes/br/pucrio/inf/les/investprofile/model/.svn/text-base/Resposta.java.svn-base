package br.pucrio.inf.les.investprofile.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * @author <a href="mailto:mauricio.pinheiro@gmail.com">Mauricio Pinheiro</a>
 */
@Entity
public class Resposta extends BaseObject implements Serializable {
	private static final long serialVersionUID = 51L;

	private Long id;

	private Questao questaoFilha;

	private String conteudo;

	/**
	 * 
	 */
	public Resposta() {
	}

	/**
	 * @param conteudo
	 */
	public Resposta(String conteudo) {
		this.conteudo = conteudo;
	}

	/**
	 * @return Retorna o id da questao.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return Conteúdo
	 */
	@Column(nullable = false)
	public String getConteudo() {
		return conteudo;
	}

	/**
	 * @param conteudo
	 */
	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}

	/**
	 * @return questão filha
	 */
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="idquestaofilha")
	public Questao getQuestaoFilha() {
		return questaoFilha;
	}

	/**
	 * @param questao
	 */
	public void setQuestaoFilha(Questao questao) {
		this.questaoFilha = questao;
	}

	/**
	 * @see java.lang.Object#equals(Object)
	 */
	public boolean equals(Object object) {
		if (!(object instanceof Resposta)) {
			return false;
		}
		Resposta rhs = (Resposta) object;
		return new EqualsBuilder().append(this.id, rhs.id).isEquals();
	}

	/**
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() {
		return new HashCodeBuilder(-423999931, -845649863).append(this.id)
				.toHashCode();
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return new ToStringBuilder(this).append("conteudo", this.conteudo)
				.toString();
	}

}
