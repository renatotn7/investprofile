package br.pucrio.inf.les.investprofile.dao;

import java.util.List;

import br.pucrio.inf.les.investprofile.model.Recomendacao;

/**
 * Recomendacao Data Access Object (Dao) interface.
 * 
 * <p>
 * <a href="RecomendacaoDao.java.html"><i>View Source</i></a>
 * </p>
 * 
 * @author <a href="mailto:mauricio.pinheiro@gmail.com">Mauricio Pinheiro</a>
 */
public interface RecomendacaoDao extends GenericDao<Recomendacao, Long> {
	/**
	 * Obtem uma recomendação de uma ação baseada no id.
	 * 
	 * @param RecomendacaoId
	 *            o id da recomendação da ação
	 * @return Recomendacao
	 */
	public Recomendacao getRecomendacao(Long RecomendacaoId);

	/**
	 * Obtem uma lista de recomendações das ações baseada nos atributos de uma
	 * recomendação de ação
	 * 
	 * @param recomendacao
	 *            uma recomendação como parâmetro de busca
	 * @return List lista de recomendações
	 */
	public List<Recomendacao> getRecomendacoes(Recomendacao recomendacao);

	/**
	 * Salva as informações de uma recomendação
	 * 
	 * @param Recomendacao
	 *            o objeto a ser salvo
	 */
	public void saveRecomendacao(Recomendacao recomendacao);

	/**
	 * Remove uma recomendação baseada no id
	 * 
	 * @param RecomendacaoId
	 *            o id da recomendação
	 */
	public void removeRecomendacao(Long RecomendacaoId);
}
