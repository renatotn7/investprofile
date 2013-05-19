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
	 * Obtem uma recomenda��o de uma a��o baseada no id.
	 * 
	 * @param RecomendacaoId
	 *            o id da recomenda��o da a��o
	 * @return Recomendacao
	 */
	public Recomendacao getRecomendacao(Long RecomendacaoId);

	/**
	 * Obtem uma lista de recomenda��es das a��es baseada nos atributos de uma
	 * recomenda��o de a��o
	 * 
	 * @param recomendacao
	 *            uma recomenda��o como par�metro de busca
	 * @return List lista de recomenda��es
	 */
	public List<Recomendacao> getRecomendacoes(Recomendacao recomendacao);

	/**
	 * Salva as informa��es de uma recomenda��o
	 * 
	 * @param Recomendacao
	 *            o objeto a ser salvo
	 */
	public void saveRecomendacao(Recomendacao recomendacao);

	/**
	 * Remove uma recomenda��o baseada no id
	 * 
	 * @param RecomendacaoId
	 *            o id da recomenda��o
	 */
	public void removeRecomendacao(Long RecomendacaoId);
}
