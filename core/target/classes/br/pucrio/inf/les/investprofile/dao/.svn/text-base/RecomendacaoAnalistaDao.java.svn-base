package br.pucrio.inf.les.investprofile.dao;

import java.util.List;

import br.pucrio.inf.les.investprofile.model.Acao;
import br.pucrio.inf.les.investprofile.model.RecomendacaoAnalista;

/**
 * RecomendacaoAnalista Data Access Object (Dao) interface.
 * 
 * <p>
 * <a href="RecomendacaoAnalistaDao.java.html"><i>View Source</i></a>
 * </p>
 * 
 * @author <a href="mailto:mauricio.pinheiro@gmail.com">Mauricio Pinheiro</a>
 */
public interface RecomendacaoAnalistaDao extends
		GenericDao<RecomendacaoAnalista, Long> {

	/**
	 * @param idAcao
	 * @return List lista de CarteiraRecomendada preenchida
	 */
	public List<RecomendacaoAnalista> getRecomendacoesAnalistasPorAcao(
			Long idAcao);

	/**
	 * @param idRecomendacaoAnalista
	 * @return RecomendacaoAnalista
	 */
	public RecomendacaoAnalista getRecomendacaoAnalista(Long idRecomendacaoAnalista);
	
	/**
	 * @param analista
	 * @return List lista de RecomendacaoAnalista preenchida
	 */
	public List<RecomendacaoAnalista> getRecomendacoesAnalista(String analista);

	/**
	 * Obtem uma lista de recomendações de analistas baseada nos atributos da
	 * recomendação recebida
	 * 
	 * @param recomendacaoAnalista
	 * @return List lista de recomendações de analistas preenchidas
	 */
	public List<RecomendacaoAnalista> getRecomendacoesAnalistas(
			RecomendacaoAnalista recomendacaoAnalista);

	/**
	 * Salva as informações de uma recomendação de analista
	 * 
	 * @param recomendacaoAnalista
	 *            o objeto a ser salvo
	 */
	public void saveRecomendacaoAnalista(
			RecomendacaoAnalista recomendacaoAnalista);

	/**
	 * Remove uma recomendação de um analista baseado no código da recomendação
	 * de um analaista
	 * 
	 * @param idRecomendacaoAnalista
	 *            código da recomendação de um analaista
	 */
	public void removeRecomendacaoAnalista(Long idRecomendacaoAnalista);
}
