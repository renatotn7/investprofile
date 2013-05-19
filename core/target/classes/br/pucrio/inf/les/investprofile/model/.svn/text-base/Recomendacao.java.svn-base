package br.pucrio.inf.les.investprofile.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * @author <a href="mailto:mauricio.pinheiro@gmail.com">Mauricio Pinheiro</a>
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Recomendacao extends BaseObject implements Serializable {
	private static final long serialVersionUID = 16L;

	private Long id;

	private Acao acao;

	private TipoOperacao operacao;

	private Date data;

	private Long hora;

	private Double preco;

	private Double grauConfianca;

	/**
	 * 
	 */
	public Recomendacao() {
	};

	/**
	 * @param acao
	 *            Ação recomendada para a carteira
	 */
	public Recomendacao(Acao acao) {
		this.acao = acao;
	}

	/**
	 * @param acao
	 *            Ação recomendada para a carteira
	 * @param operacao
	 *            Compra ou Venda
	 * @param grauConfianca
	 *            Percentual de confiabilidade na recomendação
	 * @param analista
	 *            Analista que recomendou
	 * @param data
	 *            Data da recomendação
	 */
	public Recomendacao(Acao acao, TipoOperacao operacao, Date data) {
		this.acao = acao;
		this.operacao = operacao;
		this.data = data;
	}

	/**
	 * @return Returns opetarion id.
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
	 * @return Ação recomendada
	 */
	@ManyToOne
	@JoinColumn(name = "idacao")
	public Acao getAcao() {
		return acao;
	}

	/**
	 * @param acao
	 *            Altera ação recomendada
	 */
	public void setAcao(Acao acao) {
		this.acao = acao;
	}

	/**
	 * @return Identificador da operação
	 */
	@Column(nullable = false)
	public TipoOperacao getOperacao() {
		return operacao;
	}

	/**
	 * @param operacao
	 *            Altera operação
	 */
	public void setOperacao(TipoOperacao operacao) {
		this.operacao = operacao;
	}

	/**
	 * @return Retorna o nome da operação
	 */
	public String obtemDescricaoOperacao() {
		return this.operacao.descricao();
	}

	/**
	 * @return Data da recomendação
	 */
	@Column(nullable = false)
	public Date getData() {
		return data;
	}

	/**
	 * @param data
	 *            Altera a data da recomendação
	 */
	public void setData(Date data) {
		this.data = data;
	}

	/**
	 * @return Hora da recomendação
	 */
	@Column(nullable = false)
	public Long getHora() {
		return hora;
	}

	/**
	 * @param hora
	 *            Altera a hora da recomendação
	 */
	public void setHora(Long hora) {
		this.hora = hora;
	}

	/**
	 * @return Preço da ação recomendada
	 */
	@Column(nullable = false)
	public Double getPreco() {
		return preco;
	}

	/**
	 * @param preco
	 *            Altera o preço da ação recomendada
	 */
	public void setPreco(Double preco) {
		this.preco = preco;
	}

	/**
	 * @return Grau de confiaça da recomendação
	 */
	@Column(nullable = true)
	public Double getGrauConfianca() {
		return grauConfianca;
	}

	/**
	 * @param grauConfianca
	 *            Altera o grau de confiança
	 */
	public void setGrauConfianca(Double grauConfianca) {
		this.grauConfianca = grauConfianca;
	}

	/**
	 * @see java.lang.Object#equals(Object)
	 */
	public boolean equals(Object object) {
		if (!(object instanceof Recomendacao)) {
			return false;
		}
		Recomendacao rhs = (Recomendacao) object;
		return new EqualsBuilder().append(this.id, rhs.id).isEquals();
	}

	/**
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() {
		return new HashCodeBuilder(1248928921, 1164288127).append(this.id)
				.toHashCode();
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return new ToStringBuilder(this).append("id", this.id).toString();
	}
}
