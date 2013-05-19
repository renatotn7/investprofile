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
 * @author <a href="mailto:mauricio.pinheiro@gmail.com">Mauricio Costa Pinheiro</a>
 * 
 * Indica uma cotação de uma ação em uma data do pregão da Bovespa
 */
@Entity
public class Cotacao extends BaseObject implements Serializable {
	private static final long serialVersionUID = 31L;

	private long id;

	private Date dataPregao;

	private Acao acao;

	private double precoAbertura;

	private double precoMaximo;

	private double precoMinimo;

	private double precoMedio;

	private double precoUltimo;

	private double precoMelhorOfertaCompra;

	private double precoMelhorOfertaVenda;

	private int negocios;

	private long titulosNegociados;

	private double volume;

	/**
	 * Construtor da classe
	 */
	public Cotacao() {
		dataPregao = new Date();
	}

	/**
	 * @return Retorna código da cotação.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getId() {
		return id;
	}

	/**
	 * @param id
	 *            Novo código de cotação
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return Data da cotação
	 */
	@Column(nullable = false)
	public Date getDataPregao() {
		return dataPregao;
	}

	/**
	 * @param dataPregao
	 *            Nova data da cotação
	 */
	public void setDataPregao(Date dataPregao) {
		this.dataPregao = dataPregao;
	}

	/**
	 * @return Ação referente a cotação
	 */
	@ManyToOne(optional = true)
	@JoinColumn(name="idacao")
	public Acao getAcao() {
		return acao;
	}

	/**
	 * @param acao
	 *            Nova ação
	 */
	public void setAcao(Acao acao) {
		this.acao = acao;
	}

	/**
	 * @return Preço de abertura da cotação
	 */
	@Column(nullable = false)
	public double getPrecoAbertura() {
		return precoAbertura;
	}

	/**
	 * @param precoAbertura
	 *            Novo preço de abertura
	 */
	public void setPrecoAbertura(double precoAbertura) {
		this.precoAbertura = precoAbertura;
	}

	/**
	 * @return Maior preço da ação na data da cotação
	 */
	@Column(nullable = false)
	public double getPrecoMaximo() {
		return precoMaximo;
	}

	/**
	 * @param precoMaximo
	 *            Novo maior preço da açao na data da cotação
	 */
	public void setPrecoMaximo(double precoMaximo) {
		this.precoMaximo = precoMaximo;
	}

	/**
	 * @return Menor preço da ação na data da cotação
	 */
	@Column(nullable = false)
	public double getPrecoMinimo() {
		return precoMinimo;
	}

	/**
	 * @param precoMinimo
	 *            Novo menor preço da açao na data da cotação
	 */
	public void setPrecoMinimo(double precoMinimo) {
		this.precoMinimo = precoMinimo;
	}

	/**
	 * @return Preço médio da ação na data da cotação
	 */
	@Column(nullable = false)
	public double getPrecoMedio() {
		return precoMedio;
	}

	/**
	 * @param precoMedio
	 *            Novo preço médio da ação na data da cotação
	 */
	public void setPrecoMedio(double precoMedio) {
		this.precoMedio = precoMedio;
	}

	/**
	 * @return Último preço da ação na data da cotação
	 */
	@Column(nullable = false)
	public double getPrecoUltimo() {
		return precoUltimo;
	}

	/**
	 * @param precoUltimo
	 *            Novo último preço negociado da ação na data da cotação
	 */
	public void setPrecoUltimo(double precoUltimo) {
		this.precoUltimo = precoUltimo;
	}

	/**
	 * @return Melhor oferta de compra da ação na data da cotação
	 */
	@Column(nullable = false)
	public double getPrecoMelhorOfertaCompra() {
		return precoMelhorOfertaCompra;
	}

	/**
	 * @param precoMelhorOfertaCompra
	 *            Novo preço da melhor oferta de compra da ação na data da
	 *            cotação
	 */
	public void setPrecoMelhorOfertaCompra(double precoMelhorOfertaCompra) {
		this.precoMelhorOfertaCompra = precoMelhorOfertaCompra;
	}

	/**
	 * @return Melhor oferta de venda da ação na data da cotação
	 */
	@Column(nullable = false)
	public double getPrecoMelhorOfertaVenda() {
		return precoMelhorOfertaVenda;
	}

	/**
	 * @param precoMelhorOfertaVenda
	 *            Novo preço da melhor oferta de venda da ação na data da
	 *            cotação
	 */
	public void setPrecoMelhorOfertaVenda(double precoMelhorOfertaVenda) {
		this.precoMelhorOfertaVenda = precoMelhorOfertaVenda;
	}

	/**
	 * @return Quantiade de negócios realizados com a ação na data da cotação
	 */
	@Column(nullable = false)
	public int getNegocios() {
		return negocios;
	}

	/**
	 * @param negocios
	 *            Nova quantidade de negócios da ação na data da cotação
	 */
	public void setNegocios(int negocios) {
		this.negocios = negocios;
	}

	/**
	 * @return Quantidade de títulos negociados da ação na data da cotação
	 */
	@Column(nullable = false)
	public long getTitulosNegociados() {
		return titulosNegociados;
	}

	/**
	 * @param titulosNegociados
	 *            Nova quantidade de títulos negociados da ação na data da
	 *            cotação
	 */
	public void setTitulosNegociados(long titulosNegociados) {
		this.titulosNegociados = titulosNegociados;
	}

	/**
	 * @return Volume de negócios relaizados com a ação na data da cotação
	 */
	@Column(nullable = false)
	public double getVolume() {
		return volume;
	}

	/**
	 * @param volume
	 *            Novo volume negociado da ação na data da cotação
	 */
	public void setVolume(double volume) {
		this.volume = volume;
	}

	/**
	 * @return Maior variação da ação na data da cotação
	 */
	public double obtemVariacaoDiaria() {
		return getPrecoMaximo() - getPrecoMinimo();
	}

	/**
	 * @return Retorna verdadeiro se existe uma ação relacionada a cotação ou
	 *         false se não existe
	 */
	public boolean existeAcaoAssociada() {
		return (this.acao == null);
	}

	/**
	 * @see java.lang.Object#equals(Object)
	 */
	public boolean equals(Object object) {
		if (!(object instanceof Cotacao)) {
			return false;
		}
		Cotacao rhs = (Cotacao) object;
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
		return new ToStringBuilder(this).append("codigoBovespa",
				this.acao.getCodigoBovespa()).append("data", this.dataPregao)
				.append("valor", this.precoUltimo).toString();
	}
}