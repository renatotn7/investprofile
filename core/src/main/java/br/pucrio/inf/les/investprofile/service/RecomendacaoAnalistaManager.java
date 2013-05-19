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
	 * Retorna uma recomenda��o de um analista
	 * 
	 * @param idRecomendacaoAnalista
	 *            c�digo da recomenda��o
	 * @return RecomendacaoAnalista recomenda��o de um analista
	 */
	public RecomendacaoAnalista getRecomendacaoAnalista(String idRecomendacaoAnalista);
	
	/**
	 * Retorna as recomenda��es de um analista
	 * 
	 * @param analista
	 *            identifica��o do analista
	 * @return List lista de recomenda��es de analistas
	 */
	public List<RecomendacaoAnalista> getRecomendacoesAnalista(String analista);

	/**
	 * Retorna as recomenda��es dos analista
	 * 
	 * @param recomendacaoAnalista
	 *            recomenda��o de um analista utilizada para filtragem
	 * @return List lista de recomenda��es de analistas
	 */
	public List<RecomendacaoAnalista> getRecomendacoesAnalistas(RecomendacaoAnalista recomendacaoAnalista);
	
	/**
	 * Salva uma recomenda��o de um analista
	 * 
	 * @param recomendacaoAnalista
	 *            informa��es de uma recomenda��o de um analista
	 * @throws Exception
	 */
	public void saveRecomendacaoAnalista(RecomendacaoAnalista recomendacaoAnalista) throws Exception;

	/**
	 * Remove uma recomenda��o de um analista selecionada pelo c�digo
	 * 
	 * @param idRecomendacaoAnalista
	 *            c�digo da recomenda��o de um analista
	 */
	public void removeRecomendacaoAnalista(String idRecomendacaoAnalista);
}
