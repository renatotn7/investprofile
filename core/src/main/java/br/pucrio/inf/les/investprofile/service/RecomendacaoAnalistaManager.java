package br.pucrio.inf.les.investprofile.service;

import java.util.List;

import br.pucrio.inf.les.investprofile.dao.RecomendacaoAnalistaDao;
import br.pucrio.inf.les.investprofile.model.Posicao;
import br.pucrio.inf.les.investprofile.model.Recomendacao;
import br.pucrio.inf.les.investprofile.model.RecomendacaoAnalista;

/**
 * Business Service Interface to handle communication between web and
 * persistence layer.
 * 
 * <p>
 * <a href="RecomendacaoAnalistaManager.java.html"><i>View Source</i></a>
 * </p>
 * 
 * @author <a href="mailto:mauricio.pinheiro@gmail.com">Mauricio Pinheiro</a>
 */
public interface RecomendacaoAnalistaManager extends
		GenericManager<RecomendacaoAnalista, Long> {

	/**
	 * @param dao
	 */
	public void setRecomendacaoAnalistaDao(RecomendacaoAnalistaDao dao);

	/**
	 * Retorna uma recomendação de um analista
	 * 
	 * @param idRecomendacaoAnalista
	 *            código da recomendação
	 * @return RecomendacaoAnalista recomendação de um analista
	 */
	public RecomendacaoAnalista getRecomendacaoAnalista(String idRecomendacaoAnalista);
	
	/**
	 * Retorna as recomendações de um analista
	 * 
	 * @param analista
	 *            identificação do analista
	 * @return List lista de recomendações de analistas
	 */
	public List<RecomendacaoAnalista> getRecomendacoesAnalista(String analista);

	/**
	 * Retorna as recomendações dos analista
	 * 
	 * @param recomendacaoAnalista
	 *            recomendação de um analista utilizada para filtragem
	 * @return List lista de recomendações de analistas
	 */
	public List<RecomendacaoAnalista> getRecomendacoesAnalistas(RecomendacaoAnalista recomendacaoAnalista);
	
	/**
	 * Salva uma recomendação de um analista
	 * 
	 * @param recomendacaoAnalista
	 *            informações de uma recomendação de um analista
	 * @throws Exception
	 */
	public void saveRecomendacaoAnalista(RecomendacaoAnalista recomendacaoAnalista) throws Exception;

	/**
	 * Remove uma recomendação de um analista selecionada pelo código
	 * 
	 * @param idRecomendacaoAnalista
	 *            código da recomendação de um analista
	 */
	public void removeRecomendacaoAnalista(String idRecomendacaoAnalista);
}
