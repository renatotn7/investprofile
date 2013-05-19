package br.pucrio.inf.les.investprofile.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * @author <a href="mailto:mauricio.pinheiro@gmail.com">Mauricio Pinheiro</a>
 */
@Entity
public class Questao extends BaseObject implements Serializable {
	private static final long serialVersionUID = 50L;

	private Long id;

	private String pergunta;

	private Set<Resposta> respostas = new HashSet<Resposta>();

	/**
	 * 
	 */
	public Questao() {
	}

	/**
	 * @param pergunta
	 */
	public Questao(String pergunta) {
		this.pergunta = pergunta;
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
	 * @return Pergunta
	 */
	@Column(nullable = false)
	public String getPergunta() {
		return pergunta;
	}

	/**
	 * @param pergunta
	 */
	public void setPergunta(String pergunta) {
		this.pergunta = pergunta;
	}

	/**
	 * @return Lista de respostas
	 */
	@OneToMany
	@JoinColumn(name="idquestao")
	public Set<Resposta> getRespostas() {
		return respostas;
	}

	/**
	 * @param respostas
	 */
	public void setRespostas(Set<Resposta> respostas) {
		this.respostas = respostas;
	}

	/**
	 * @see java.lang.Object#equals(Object)
	 */
	public boolean equals(Object object) {
		if (!(object instanceof Questao)) {
			return false;
		}
		Questao rhs = (Questao) object;
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
		return new ToStringBuilder(this).append("questao", this.pergunta)
				.toString();
	}

}
