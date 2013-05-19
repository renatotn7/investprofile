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
	 * Retorna uma recomendação pelo identificador. Uma exceção é levantada se
	 * uma recomendação não for encontrada.
	 * 
	 * @param idRecomendacao
	 *            identificador de uma recomendação
	 * @return Recomendacao objeto de recomendação
	 */
	public Recomendacao getRecomendacao(String idRecomendacao);

	/**
	 * Retorna uma lista de recomendações, filtradas pelos atributos de um
	 * objeto de recomendação recebido.
	 * 
	 * @param recomendacao
	 *            objeto de recomendação
	 * @return List lista de objetos de recomendação
	 */
	public List<Recomendacao> getRecomendacoes(Recomendacao recomendacao);

	/**
	 * Salva informações de uma recomendação. Um exceção é levantada se nenhuma
	 * recomendação for encontrada.
	 * 
	 * @param recomendacao
	 *            informações de uma recomendação
	 * @throws Exception
	 */
	public void saveRecomendacao(Recomendacao recomendacao) throws Exception;

	/**
	 * Remove uma recomendação selecionada pelo código.
	 * 
	 * @param idRecomendacao
	 *            identificador de uma recomendação
	 */
	public void removeRecomendacao(String idRecomendacao);
}
