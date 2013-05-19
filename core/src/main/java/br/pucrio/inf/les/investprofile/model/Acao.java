package br.pucrio.inf.les.investprofile.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * @author <a href="mailto:mauricio.pinheiro@gmail.com">Mauricio Costa Pinheiro</a>
 */
@Entity
public class Acao extends BaseObject implements Serializable {
	private static final long serialVersionUID = 17L;

	private Long id;

	private Date dataInicioPregao;

	private String codigoBovespa; /* C�digo na Bovespa - obrigatorio */

	private String codigoADR; /* C�digo na Bolsa de Nova York */

	private String nome; /* Nome da empresa */

	private Integer fatorNegociacao;

	private Segmento segmento;

	private EspecificacaoPapel especificacaoPapel;

	/**
	 * Construtor da a��o
	 */
	public Acao() {
	}

	/**
	 * @param codigoBovespa
	 *            c�digo da a��o na bovespa
	 */
	public Acao(String codigoBovespa) {
		this.codigoBovespa = codigoBovespa;
	}

	/**
	 * @param id
	 *            identificador num�rico do banco de dados
	 * @param codigoBovespa
	 *            c�digo da a��o na bovespa
	 * @param codigoADR
	 *            codigo da a��o na NYSE
	 * @param segmento
	 *            segmento de mercado da a��o/empresa
	 * @param nome
	 *            nome da a��o/empresa
	 * @param especificacaoPapel
	 * @param fatorNegociacao
	 */
	public Acao(Long id, String codigoBovespa, String codigoADR,
			Segmento segmento, String nome, EspecificacaoPapel especificacaoPapel,
			Integer fatorNegociacao) {
		this.id = id;
		this.codigoBovespa = codigoBovespa;
		this.codigoADR = codigoADR;
		this.segmento = segmento;
		this.nome = nome;
		this.especificacaoPapel = especificacaoPapel;
		this.fatorNegociacao = fatorNegociacao;
	}

	/**
	 * @return Retorna o id do profile.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 *            c�digo de identificacao do banco de dados
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return Retorna a data de in�cio na Bovespa
	 */
	@Column(nullable = true)
	public Date getDataInicioPregao() {
		return dataInicioPregao;
	}

	/**
	 * @param dataInicioPregao
	 *            Nova data de inicio na Bovespa
	 */
	public void setDataInicioPregao(Date dataInicioPregao) {
		this.dataInicioPregao = dataInicioPregao;
	}

	/**
	 * @return c�digo da a��o na Bovespa
	 * @spring.validator tipo="required"
	 */
	@Column(nullable = false)
	public String getCodigoBovespa() {
		return codigoBovespa;
	}

	/**
	 * @param codigoBovespa
	 *            Novo codigo da a��o na Bovespa
	 */
	public void setCodigoBovespa(String codigoBovespa) {
		this.codigoBovespa = codigoBovespa;
	}

	/**
	 * @return Codigo da a��o na NYSE
	 */
	@Column(nullable = true)
	public String getCodigoADR() {
		return codigoADR;
	}

	/**
	 * @param codigoADR
	 */
	public void setCodigoADR(String codigoADR) {
		this.codigoADR = codigoADR;
	}

	/**
	 * @return Nome da a��o/empresa
	 * @spring.validator tipo="required"
	 */
	@Column(nullable = true)
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome
	 *            Nome da a��o/empresa
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return fator de negocia��o
	 */
	@Column(nullable = true)
	public Integer getFatorNegociacao() {
		return fatorNegociacao;
	}

	/**
	 * @param fatorNegociacao
	 */
	public void setFatorNegociacao(Integer fatorNegociacao) {
		this.fatorNegociacao = fatorNegociacao;
	}

	/**
	 * @return Segmento de mercado da a��o/empresa
	 */
	@Column(nullable = true)
	public Segmento getSegmento() {
		return segmento;
	}

	/**
	 * @param segmento
	 *            Novo segmento de mercado da a��o/empresa
	 */
	public void setSegmento(Segmento segmento) {
		this.segmento = segmento;
	}

	/**
	 * @return especifica��o do papel
	 * @spring.validator tipo="required"
	 */
	@Column(nullable = false)
	public EspecificacaoPapel getEspecificacaoPapel() {
		return especificacaoPapel;
	}

	/**
	 * @param especificacaoPapel
	 *            Nova especifica��o do papel
	 */
	public void setEspecificacaoPapel(EspecificacaoPapel especificacaoPapel) {
		this.especificacaoPapel = especificacaoPapel;
	}

	/**
	 * @see java.lang.Object#equals(Object)
	 */
	public boolean equals(Object object) {
		if (!(object instanceof Acao)) {
			return false;
		}
		Acao rhs = (Acao) object;
		return new EqualsBuilder()
				.append(this.codigoBovespa, rhs.codigoBovespa).isEquals();
	}

	/**
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() {
		return new HashCodeBuilder(-423999931, -845649863).append(
				this.codigoBovespa).toHashCode();
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return new ToStringBuilder(this).append("codigoBovespa",
				this.codigoBovespa).toString();
	}

}
