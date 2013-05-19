package br.pucrio.inf.les.investprofile.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * @author <a href="mailto:mauricio.pinheiro@gmail.com">Mauricio Pinheiro</a>
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Carteira extends BaseObject implements Serializable {
	private static final long serialVersionUID = 14L;

	private Long id;

	private Double rendimento;

	private Date dataCarteira;

	private Set<Posicao> posicoes = new HashSet<Posicao>();

	private PerfilInvestimento perfilInvestimento = null;

	/**
	 * 
	 */
	public Carteira() {
	};

	/**
	 * @return Retorna o código da carteria.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	/**
	 * Altera o código da carteira
	 * @param id Código da carteira
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Obtem o rendimento da carteira
	 * @return Percentual de rendimento da carteria
	 */
	@Column(nullable=true)
	public Double getRendimento() {
		return rendimento;
	}

	/**
	 * Altera o redimento da carteira
	 * @param rendimento Percentual do rendimento da carteira 
	 */
	public void setRendimento(Double rendimento) {
		this.rendimento = rendimento;
	}

	/**
	 * Obtem a data de criação da carteira
	 * @return data de criação da carteira
	 */
	@Column(nullable=false)
	public Date getDataCarteira() {
		return dataCarteira;
	}

	/**
	 * Altera a data de criação da carteira
	 * @param dataCarteira data de criação da carteira
	 */
	public void setDataCarteira(Date dataCarteira) {
		this.dataCarteira = dataCarteira;
	}

	/**
	 * Obtem a lista de ações em carteria
	 * @return lista de ações em carteria
	 */
	@OneToMany
	@JoinColumn(name="idcarteira")
	public Set<Posicao> getPosicoes() {
		return posicoes;
	}

	/**
	 * Altera a lista de ações em carteria
	 * @param posicoes lista de ações em carteria
	 */
	public void setPosicoes(Set<Posicao> posicoes) {
		this.posicoes = posicoes;
	}

	/**
	 * Aciciona uma ação comprada à carteira de ações
	 * @param posicao ação em carteira
	 */
	public void addPosicao(Posicao posicao) {
		getPosicoes().add(posicao);
	}

	/**
	 * Obtem o perfil de investimento associado a carteria
	 * @return perfilInvestimento Perfil de investimento 
	 */
	@OneToOne(optional=false)
	@JoinColumn(name="idperfilinvestimento")
	public PerfilInvestimento getPerfilInvestimento() {
		return perfilInvestimento;
	}

	/**
	 * Altera o perfil de investimento associado a carteria
	 * @param perfilInvestimento Perfil de investimento
	 */
	public void setPerfilInvestimento(PerfilInvestimento perfilInvestimento) {
		this.perfilInvestimento = perfilInvestimento;
	}
	
	/**
	 * @see java.lang.Object#equals(Object)
	 */
	public boolean equals(Object object) {
		if (!(object instanceof Carteira)) {
			return false;
		}
		Carteira rhs = (Carteira) object;
		return new EqualsBuilder().append(this.id, rhs.id).isEquals();
	}

	/**
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() {
		return new HashCodeBuilder(1941638165, -881216605).append(this.id)
				.toHashCode();
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return new ToStringBuilder(this).append("id", this.getId()).toString();
	}

}
