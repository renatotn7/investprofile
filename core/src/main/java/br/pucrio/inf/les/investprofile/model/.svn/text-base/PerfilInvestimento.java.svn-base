package br.pucrio.inf.les.investprofile.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * @author <a href="mailto:mauricio.pinheiro@gmail.com">Mauricio Pinheiro</a>
 */
@Entity
public class PerfilInvestimento extends BaseObject implements Serializable {
	private static final long serialVersionUID = 13L;

	private Long id;

	private Date dataPerfil;

	private String nome; // obrigatorio

	private Objetivo objetivo; // obrigatorio

	private Float rendimentoEsperado; // obrigatorio

	private Float prazo; // obrigatorio

	private Tempo tipoPrazo; // obrigatorio

	private Float tempo;

	private Tempo tipoTempo;

	private Float liquidez;

	private Tempo tipoLiquidez;

	private Float risco; // obrigatorio

	private Float riscoMaximo;

	private Segmento segmentoPreferencial;

	private Float patrimonio;

	private Carteira carteira;

	private Set respostas; // lista de respostas do questionario

	/**
	 * Construtor da classe sem parâmetros
	 */
	public PerfilInvestimento() {
	}

	/**
	 * @param nome
	 *            Nome do perfil de investimento
	 * @param objetivo
	 *            Código do objetivo de investimento
	 * @param rendimentoEsperado
	 *            Percentagem do rendimento esperado
	 * @param risco
	 *            Percentagem de risco aceita pelo investidor
	 * @param prazo
	 *            Prazo para atingir o rendimento esperado
	 * @param tipoPrazo
	 *            Tipo de tempo do prazo
	 */
	public PerfilInvestimento(String nome, Objetivo objetivo,
			Float rendimentoEsperado, Float risco, Float prazo, Tempo tipoPrazo) {
		this.nome = nome;
		this.objetivo = objetivo;
		this.rendimentoEsperado = rendimentoEsperado;
		this.risco = risco;
		this.prazo = prazo;
		this.tipoPrazo = tipoPrazo;
	}

	/**
	 * @return Retorna o id do perfil de investimento.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 *            Código do investidor
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return Data do cadastro do perfil do investidor
	 */
	@Column(nullable = true)
	public Date getDataPerfil() {
		return dataPerfil;
	}

	/**
	 * @param dataPerfil
	 *            Nova data de cadastro do perfil do investidor
	 */
	public void setDataPerfil(Date dataPerfil) {
		this.dataPerfil = dataPerfil;
	}

	/**
	 * @return Nome Nome do perfil de investimento
	 */
	@Column(nullable = false, length = 50)
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome
	 *            Novo nome do perfil de investimento
	 * @spring.validator type="required"
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return Objetivo Objetivo do investimento
	 */
	@Column(nullable = false)
	public Objetivo getObjetivo() {
		return objetivo;
	}

	/**
	 * @param objetivo
	 *            Novo objetivo de investimento
	 * @spring.validator type="required"
	 */
	public void setObjetivo(Objetivo objetivo) {
		this.objetivo = objetivo;
	}

	/**
	 * @return Patrimônio, em valor monetário, disponível para investimento
	 */
	@Column(nullable = true)
	public Float getPatrimonio() {
		return patrimonio;
	}

	/**
	 * @param patrimonio
	 *            Novo patrimônio, em valor monetário, disponível para
	 *            investimento
	 */
	public void setPatrimonio(Float patrimonio) {
		this.patrimonio = patrimonio;
	}

	/**
	 * @return Percentual do rendimento esperado
	 */
	@Column(nullable = false)
	public Float getRendimentoEsperado() {
		return rendimentoEsperado;
	}

	/**
	 * @param rendimentoEsperado
	 *            Novo percentual de rendimento esperado
	 * @spring.validator type="required"
	 */
	public void setRendimentoEsperado(Float rendimentoEsperado) {
		this.rendimentoEsperado = rendimentoEsperado;
	}

	/**
	 * @return Percentual de risco de perda aceitavel
	 */
	@Column(nullable = false)
	public Float getRisco() {
		return risco;
	}

	/**
	 * @param risco
	 *            Novo percentual de risco de perda
	 * @spring.validator type="required"
	 */
	public void setRisco(Float risco) {
		this.risco = risco;
	}

	/**
	 * @return Percentual de risco máximo aceitavel
	 */
	@Column(nullable = true)
	public Float getRiscoMaximo() {
		return riscoMaximo;
	}

	/**
	 * @param riscoMaximo
	 *            Novo percentual de risco máximo
	 */
	public void setRiscoMaximo(Float riscoMaximo) {
		this.riscoMaximo = riscoMaximo;
	}

	/**
	 * @return Segmento de mercado de preferencia do investidor
	 */
	@Column(nullable = true)
	public Segmento getSegmentoPreferencial() {
		return segmentoPreferencial;
	}

	/**
	 * @param segmentoPreferencial
	 *            Novo segmento de mercado de preferencia do investidor
	 */
	public void setSegmentoPreferencial(Segmento segmentoPreferencial) {
		this.segmentoPreferencial = segmentoPreferencial;
	}

	/**
	 * @return Liquidez máxima da carteira
	 */
	@Column(nullable = true)
	public Float getLiquidez() {
		return liquidez;
	}

	/**
	 * @param liquidez
	 *            Nova liquidez máxima da carteira
	 */
	public void setLiquidez(Float liquidez) {
		this.liquidez = liquidez;
	}

	/**
	 * @return Tipo de tempo de liquidez
	 */
	@Column(nullable = true)
	public Tempo getTipoLiquidez() {
		return tipoLiquidez;
	}

	/**
	 * @param tipoLiquidez
	 *            Novo tipo de tempo de liquidez
	 */
	public void setTipoLiquidez(Tempo tipoLiquidez) {
		this.tipoLiquidez = tipoLiquidez;
	}

	/**
	 * @return Prazo para alcancar o rendimento esperado
	 */
	@Column(nullable = false)
	public Float getPrazo() {
		return prazo;
	}

	/**
	 * @param prazo
	 *            Novo prazo para alcancar o rendimento esperado
	 * @spring.validator type="required"
	 */
	public void setPrazo(Float prazo) {
		this.prazo = prazo;
	}

	/**
	 * @return Tipo de tempo do prazo
	 */
	@Column(nullable = false)
	public Tempo getTipoPrazo() {
		return tipoPrazo;
	}

	/**
	 * @param tipoPrazo
	 *            Novo tipo de tempo de prazo
	 * @spring.validator type="required"
	 */
	public void setTipoPrazo(Tempo tipoPrazo) {
		this.tipoPrazo = tipoPrazo;
	}

	/**
	 * @return Tempo de disponibilidade do patrimonio
	 */
	@Column(nullable = true)
	public Float getTempo() {
		return tempo;
	}

	/**
	 * @param tempo
	 */
	public void setTempo(Float tempo) {
		this.tempo = tempo;
	}

	/**
	 * @return Tipo de tempo para o tempo de disponibilidade do patrimônio
	 */
	@Column(nullable = true)
	public Tempo getTipoTempo() {
		return tipoTempo;
	}

	/**
	 * @param tipoTempo
	 *            Novo tipo de tempo de distponibilidade do patrimônio
	 */
	public void setTipoTempo(Tempo tipoTempo) {
		this.tipoTempo = tipoTempo;
	}

	/**
	 * Obtem a carteira do perfil
	 * 
	 * @return carteira
	 */
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idcarteira")
	public Carteira getCarteira() {
		return carteira;
	}

	/**
	 * Altera a carteira do perfil
	 * 
	 * @param carteira
	 */
	public void setCarteira(Carteira carteira) {
		this.carteira = carteira;
	}

	/**
	 * Obtem a lista de respostas do perfil
	 * 
	 * @return respostas
	 */
	@ManyToMany
	@JoinTable(name = "RespostasPerfil", joinColumns = @JoinColumn(name = "idPerfilInvestimento", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "idResposta", referencedColumnName = "id"))
	public Set<Resposta> getRespostas() {
		return respostas;
	}

	/**
	 * Altera lista de respostas do perfil
	 * 
	 * @param respostas
	 */
	public void setRespostas(Set<Resposta> respostas) {
		this.respostas = respostas;
	}

	/**
	 * Adiciona uma nova resposta à lista de respostas do perfil
	 * 
	 * @param resposta
	 */
	public void addResposta(Resposta resposta) {
		respostas.add(resposta);
	}

	/**
	 * @see java.lang.Object#equals(Object)
	 */
	public boolean equals(Object object) {
		if (!(object instanceof PerfilInvestimento)) {
			return false;
		}
		PerfilInvestimento rhs = (PerfilInvestimento) object;
		return new EqualsBuilder().append(this.id, rhs.id).isEquals();
	}

	/**
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() {
		return new HashCodeBuilder(-1763820879, 1823392581).append(this.id)
				.toHashCode();
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return new ToStringBuilder(this).append(this.nome).toString();
	}
}
