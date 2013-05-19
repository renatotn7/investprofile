package br.pucrio.inf.les.investprofile.service;

import java.util.Date;
import java.util.List;

import br.pucrio.inf.les.investprofile.dao.CotacaoDao;
import br.pucrio.inf.les.investprofile.model.Cotacao;

/**
 * Business Service Interface to handle communication between web and
 * persistence layer.
 * 
 * <p>
 * <a href="CotacaoManager.java.html"><i>View Source</i></a>
 * </p>
 * 
 * @author <a href="mailto:mauricio.pinheiro@gmail.com">Mauricio Costa Pinheiro</a>
 */
public interface CotacaoManager extends GenericManager<Cotacao, Long> {

	/**
	 * @param cotacaoDao
	 */
	public void setCotacaoDao(CotacaoDao cotacaoDao);

	/**
	 * Retorna uma cota��o pelo id. Uma exce��o � levantada se a cotacao n�o for
	 * encontrada.
	 * 
	 * @param id
	 *            identificador da cota��o
	 * @return Cotacao objeto de cota��o
	 */
	public Cotacao getCotacao(String id);

	/**
	 * Retorna uma cota��o pelo c�digo Bovespa da a��o. Uma exce��o � levantada
	 * se a cotacao n�o for encontrada.
	 * 
	 * @param codigoBovespa
	 *            c�digo bovespa da cota��o.
	 * @return Cotacao �ltima cota��o da a��o.
	 */
	public Cotacao getUltimaCotacaoAcao(String codigoBovespa);

	/**
	 * Retorna uma lista de cota�oes, filtrada pelos atributos de um objeto
	 * Cotacao recebido.
	 * 
	 * @param cotacao
	 *            objeto de cota��o
	 * @return List
	 */
	public List<Cotacao> getCotacoes(Cotacao cotacao);

	/**
	 * Retorna uma lista de cota�oes, filtrada c�digo bovespa da a��o.
	 * 
	 * @param codigoBovespa
	 *            c�digo da a��o na Bovespa.
	 * @return lista de cota��es
	 * @throws Exception
	 */
	public List<Cotacao> getCotacoesPorCodigoBovespa(String codigoBovespa)
			throws Exception;

	/**
	 * Retorna uma lista de cota�oes, filtrada c�digo bovespa da a��o e a partir
	 * de uma data inicial.
	 * 
	 * @param codigoBovespa
	 *            c�digo da a��o na Bovespa.
	 * @param dataInicio
	 *            data de in�cio da lista de cota��es.
	 * @return lista de cota��es
	 * @throws Exception
	 */
	public List<Cotacao> getCotacoesPorCodigoBovespaDesde(String codigoBovespa,
			Date dataInicio) throws Exception;

	/**
	 * Salva uma cota��o
	 * 
	 * @param cotacao
	 *            informa��es de uma cota��o em carteira
	 * @throws Exception
	 */
	public void saveCotacao(Cotacao cotacao) throws Exception;

	/**
	 * Remove uma cota��o selecionada pelo id
	 * 
	 * @param id
	 *            identifica��o de uma cota��o
	 */
	public void removeCotacao(String id);
}
