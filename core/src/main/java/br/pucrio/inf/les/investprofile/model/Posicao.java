package br.pucrio.inf.les.investprofile.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * @author <a href="mailto:mauricio.pinheiro@gmail.com">Mauricio Pinheiro</a>
 */
@Entity
public class Posicao extends BaseObject implements Serializable {

	private static final long serialVersionUID = 19L;

	private Long id;

	private Acao acao;

	private Double quantidade;
	
	private Date data;
	
	private double preco;

	/**
	 * 
	 */
	public Posicao() {
	}

	/**
	 * @param acao
	 *            Ação associada a carteira
	 * @param quantidade
	 *            A quantidade da ação que existe na carteira
	 */

	public Posicao(Acao acao, Double quantidade) {
		this.acao = acao;
		this.quantidade = quantidade;
	}

	/**
	 * @return Retorna o identificador de uma ação em carteira.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 *            Altera o identificador de uma ação em carteira
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return A ação que está na carteira.
	 */
	@ManyToOne
	@JoinColumn(name="idacao")
	public Acao getAcao() {
		return acao;
	}

	/**
	 * @param acao
	 *            Altera a ação da carteira
	 */
	public void setAcao(Acao acao) {
		this.acao = acao;
	}

	/**
	 * @return Retorna a quantidade.
	 */
	@Column(nullable = false)
	public Double getQuantidade() {
		return quantidade;
	}

	/**
	 * @param qtde
	 *            Altera a quantidade da ação em carteira
	 */
	public void setQuantidade(Double qtde) {
		this.quantidade = qtde;
	}

	/**
	 * @return
	 */
	@Column(nullable = true)
	public Date getData() {
		return data;
	}

	/**
	 * @param data
	 */
	public void setData(Date data) {
		this.data = data;
	}

	/**
	 * @return
	 */
	@Column(nullable = true)
	public double getPreco() {
		return preco;
	}

	/**
	 * @param preco
	 */
	public void setPreco(double preco) {
		this.preco = preco;
	}
	
	/**
	 * @see java.lang.Object#equals(Object)
	 */
	public boolean equals(Object object) {
		if (!(object instanceof Posicao)) {
			return false;
		}
		Posicao rhs = (Posicao) object;
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
