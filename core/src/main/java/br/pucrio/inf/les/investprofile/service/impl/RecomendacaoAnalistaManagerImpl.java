package br.pucrio.inf.les.investprofile.service.impl;

import java.util.List;

import org.springframework.dao.DataIntegrityViolationException;

import br.pucrio.inf.les.investprofile.dao.RecomendacaoAnalistaDao;
import br.pucrio.inf.les.investprofile.model.RecomendacaoAnalista;
import br.pucrio.inf.les.investprofile.service.RecomendacaoAnalistaManager;

/**
 * Implementation of RecomendacaoAnalistaManager interface.
 * </p>
 * <p>
 * <a href="RecomendacaoAnalistaManagerImpl.java.html"><i>View Source</i></a>
 * </p>
 * 
 * @author <a href="mailto:mauricio.pinheiro@gmail.com">Mauricio Pinheiro</a>
 */
public class RecomendacaoAnalistaManagerImpl extends
		GenericManagerImpl<RecomendacaoAnalista, Long> implements
		RecomendacaoAnalistaManager {

	private RecomendacaoAnalistaDao dao;

	/**
	 * @param dao
	 */
	public RecomendacaoAnalistaManagerImpl(RecomendacaoAnalistaDao dao) {
		super(dao);
		this.dao = dao;
	}

	/**
	 * Set the Dao for communication with the data layer.
	 * 
	 * @param dao
	 */
	public void setRecomendacaoAnalistaDao(RecomendacaoAnalistaDao dao) {
		this.dao = dao;
	}

	/**
	 * @see br.pucrio.inf.les.investprofile.service.RecomendacaoAnalistaManager#getRecomendacaoAnalista(java.lang.String)
	 */
	public RecomendacaoAnalista getRecomendacaoAnalista(String idRecomendacaoAnalista) {
		return dao.getRecomendacaoAnalista(new Long(idRecomendacaoAnalista));
	}
	
	/**
	 * @see br.pucrio.inf.les.investprofile.service.RecomendacaoAnalistaManager#getRecomendacoesAnalista(java.lang.String)
	 */
	public List<RecomendacaoAnalista> getRecomendacoesAnalista(String analista) {
		return dao.getRecomendacoesAnalista(analista);
	}

	/**
	 * @see br.pucrio.inf.les.investprofile.service.RecomendacaoAnalistaManager#getRecomendacoesAnalistasPorAcao(java.lang.String)
	 */
	public List<RecomendacaoAnalista> getRecomendacoesAnalistas(
			RecomendacaoAnalista recomendacaoAnalista) {
		return dao.getRecomendacoesAnalistas(recomendacaoAnalista);
	}

	/**
	 * @see br.pucrio.inf.les.investprofile.service.RecomendacaoAnalistaManager#saveRecomendacaoAnalista(br.pucrio.inf.les.investprofile.model.RecomendacaoAnalista)
	 */
	public void saveRecomendacaoAnalista(
			RecomendacaoAnalista recomendacaoAnalista) throws Exception {
		try {
			dao.saveRecomendacaoAnalista(recomendacaoAnalista);
		} catch (DataIntegrityViolationException e) {
			throw new Exception("Recomendacao '" + recomendacaoAnalista.getId()
					+ "' already exists!");
		}
	}

	/**
	 * @see br.pucrio.inf.les.investprofile.service.RecomendacaoAnalistaManager#removeRecomendacaoAnalista(java.lang.String)
	 */
	public void removeRecomendacaoAnalista(String idRecomendacaoAnalista) {
		if (log.isDebugEnabled()) {
			log.debug("removing operationAdvice: " + idRecomendacaoAnalista);
		}

		dao.removeRecomendacaoAnalista(new Long(idRecomendacaoAnalista));
	}
}
