package br.pucrio.inf.les.investprofile.dao;

import java.util.Date;
import java.util.List;

import br.pucrio.inf.les.investprofile.model.Acao;
import br.pucrio.inf.les.investprofile.model.Cotacao;

/**
 * Cotacao Data Access Object (Dao) interface.
 * 
 * <p>
 * <a href="AcaoDao.java.html"><i>View Source</i></a>
 * </p>
 * 
 * @author <a href="mailto:mauricio.pinheiro@gmail.com">Mauricio Pinheiro</a>
 */
public interface CotacaoDao extends GenericDao<Cotacao, Long> {
	/**
	 * Obtem as informações da cotação baseado no id
	 * 
	 * @param id
	 *            o id da cotação
	 * @return Cotacao objeto Cotacao preenchido
	 */
	public Cotacao getCotacao(Long id);

	/**
	 * Obtem a primeira cotação de uma ação
	 * 
	 * @param codigoBovespa
	 *            código Bovespa da ação
	 * @return Cotacao objeto Cotacao preenchido
	 */
	public Cotacao getPrimeiraCotacaoAcao(String codigoBovespa);

	/**
	 * Obtem a ultima cotação de uma ação
	 * 
	 * @param codigoBovespa
	 *            código Bovespa da ação
	 * @return Cotacao objeto Cotacao preenchido
	 */
	public Cotacao getUltimaCotacaoAcao(String codigoBovespa);

	/**
	 * Obtem uma lista de cotações baseada no código bovespa de uma ação
	 * 
	 * @param codigoBovespa
	 *            o código bovespa da ação
	 * @return Lista de cotações
	 */
	public List<Cotacao> getCotacoesPorCodigoBovespa(String codigoBovespa);

	/**
	 * Obtem uma lista de cotações a partir de uma data e baseada no código
	 * bovespa de uma ação
	 * 
	 * @param codigoBovespa
	 *            o código bovespa da ação
	 * @param dataInicio
	 *            data de inicio da listagem
	 * @return Lista de cotações
	 */
	public List<Cotacao> getCotacoesPorCodigoBovespaDesde(String codigoBovespa,
			Date dataInicio);

	/**
	 * Obtem uma lista de cotações baseada nos atributos da açao recebida
	 * 
	 * @param acao
	 * @return List lista de cotações preenchidas
	 */
	public List<Cotacao> getCotacoesAcao(Acao acao);

	/**
	 * Obtem uma lista de cotações baseada nos atributos da açao recebida
	 * 
	 * @param acao
	 * @param em
	 * @return List lista de cotações preenchidas
	 */
	public List<Cotacao> getCotacoesAcaoEm(Acao acao, Date em);

	/**
	 * Obtem uma lista de cotações baseada nos atributos da cotaçao recebida
	 * 
	 * @param cotacao
	 * @return List lista de cotações preenchidas
	 */
	public List<Cotacao> getCotacoes(Cotacao cotacao);

	/**
	 * Salva as informações de uma cotação
	 * 
	 * @param cotacao
	 *            o objeto a ser salvo
	 */
	public void saveCotacao(Cotacao cotacao);

	/**
	 * Remove uma cotação baseado no id da cotação
	 * 
	 * @param id
	 *            o id da cotação
	 */
	public void removeCotacao(Long id);
}
