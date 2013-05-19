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
	 * Retorna uma cotação pelo id. Uma exceção é levantada se a cotacao não for
	 * encontrada.
	 * 
	 * @param id
	 *            identificador da cotação
	 * @return Cotacao objeto de cotação
	 */
	public Cotacao getCotacao(String id);

	/**
	 * Retorna uma cotação pelo código Bovespa da ação. Uma exceção é levantada
	 * se a cotacao não for encontrada.
	 * 
	 * @param codigoBovespa
	 *            código bovespa da cotação.
	 * @return Cotacao última cotação da ação.
	 */
	public Cotacao getUltimaCotacaoAcao(String codigoBovespa);

	/**
	 * Retorna uma lista de cotaçoes, filtrada pelos atributos de um objeto
	 * Cotacao recebido.
	 * 
	 * @param cotacao
	 *            objeto de cotação
	 * @return List
	 */
	public List<Cotacao> getCotacoes(Cotacao cotacao);

	/**
	 * Retorna uma lista de cotaçoes, filtrada código bovespa da ação.
	 * 
	 * @param codigoBovespa
	 *            código da ação na Bovespa.
	 * @return lista de cotações
	 * @throws Exception
	 */
	public List<Cotacao> getCotacoesPorCodigoBovespa(String codigoBovespa)
			throws Exception;

	/**
	 * Retorna uma lista de cotaçoes, filtrada código bovespa da ação e a partir
	 * de uma data inicial.
	 * 
	 * @param codigoBovespa
	 *            código da ação na Bovespa.
	 * @param dataInicio
	 *            data de início da lista de cotações.
	 * @return lista de cotações
	 * @throws Exception
	 */
	public List<Cotacao> getCotacoesPorCodigoBovespaDesde(String codigoBovespa,
			Date dataInicio) throws Exception;

	/**
	 * Salva uma cotação
	 * 
	 * @param cotacao
	 *            informações de uma cotação em carteira
	 * @throws Exception
	 */
	public void saveCotacao(Cotacao cotacao) throws Exception;

	/**
	 * Remove uma cotação selecionada pelo id
	 * 
	 * @param id
	 *            identificação de uma cotação
	 */
	public void removeCotacao(String id);
}
