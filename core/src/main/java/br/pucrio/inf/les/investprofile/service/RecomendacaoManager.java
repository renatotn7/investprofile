package br.pucrio.inf.les.investprofile.service;

import java.util.List;

import br.pucrio.inf.les.investprofile.dao.RecomendacaoDao;
import br.pucrio.inf.les.investprofile.model.Recomendacao;

/**
 * Business Service Interface to handle communication between web and
 * persistence layer.
 * 
 * <p>
 * <a href="RecomendacaoManager.java.html"><i>View Source</i></a>
 * </p>
 * 
 * @author <a href="mailto:mauricio.pinheiro@gmail.com">Mauricio Pinheiro</a>
 */
public interface RecomendacaoManager extends GenericManager<Recomendacao, Long> {

	/**
	 * @param recomendacaoDao
	 */
	public void setRecomendacaoDao(RecomendacaoDao recomendacaoDao);

	/**
	 * Retorna uma recomenda��o pelo identificador. Uma exce��o � levantada se
	 * uma recomenda��o n�o for encontrada.
	 * 
	 * @param idRecomendacao
	 *            identificador de uma recomenda��o
	 * @return Recomendacao objeto de recomenda��o
	 */
	public Recomendacao getRecomendacao(String idRecomendacao);

	/**
	 * Retorna uma lista de recomenda��es, filtradas pelos atributos de um
	 * objeto de recomenda��o recebido.
	 * 
	 * @param recomendacao
	 *            objeto de recomenda��o
	 * @return List lista de objetos de recomenda��o
	 */
	public List<Recomendacao> getRecomendacoes(Recomendacao recomendacao);

	/**
	 * Salva informa��es de uma recomenda��o. Um exce��o � levantada se nenhuma
	 * recomenda��o for encontrada.
	 * 
	 * @param recomendacao
	 *            informa��es de uma recomenda��o
	 * @throws Exception
	 */
	public void saveRecomendacao(Recomendacao recomendacao) throws Exception;

	/**
	 * Remove uma recomenda��o selecionada pelo c�digo.
	 * 
	 * @param idRecomendacao
	 *            identificador de uma recomenda��o
	 */
	public void removeRecomendacao(String idRecomendacao);
}
