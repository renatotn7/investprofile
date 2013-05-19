package br.pucrio.inf.les.investprofile.service.impl;

import java.util.List;

import org.springframework.dao.DataIntegrityViolationException;

import br.pucrio.inf.les.investprofile.dao.RecomendacaoDao;
import br.pucrio.inf.les.investprofile.model.Recomendacao;
import br.pucrio.inf.les.investprofile.service.RecomendacaoManager;

/**
 * Implementation of OperationAdviceManager interface.
 * </p>
 * <p>
 * <a href="RecomendacaoManagerImpl.java.html"><i>View Source</i></a>
 * </p>
 * 
 * @author <a href="mailto:mauricio.pinheiro@gmail.com">Mauricio Pinheiro</a>
 */
public class RecomendacaoManagerImpl extends
		GenericManagerImpl<Recomendacao, Long> implements RecomendacaoManager {
	private RecomendacaoDao dao;

	/**
	 * @param dao
	 */
	public RecomendacaoManagerImpl(RecomendacaoDao dao) {
		super(dao);
		this.dao = dao;
	}

	/**
	 * Set the Dao for communication with the data layer.
	 * 
	 * @param dao
	 */
	public void setRecomendacaoDao(RecomendacaoDao dao) {
		this.dao = dao;
	}

	/**
	 * @see br.pucrio.inf.les.investprofile.service.RecomendacaoManager#getRecomendacao(java.lang.String)
	 */
	public Recomendacao getRecomendacao(String id) {
		return dao.getRecomendacao(new Long(id));
	}

	/**
	 * @see br.pucrio.inf.les.investprofile.service.RecomendacaoManager#getAcoesRecomendacoes(br.pucrio.inf.les.investprofile.model.Recomendacao)
	 */
	public List<Recomendacao> getRecomendacoes(Recomendacao recomendacao) {
		return dao.getRecomendacoes(recomendacao);
	}

	/**
	 * @see br.pucrio.inf.les.investprofile.service.RecomendacaoManager#saveRecomendacao(br.pucrio.inf.les.investprofile.model.Recomendacao)
	 */
	public void saveRecomendacao(Recomendacao recomendacao)
			throws Exception {
		try {
			dao.saveRecomendacao(recomendacao);
		} catch (DataIntegrityViolationException e) {
			throw new Exception("Recomendacao '" + recomendacao.getId()
					+ "' already exists!");
		}
	}

	/**
	 * @see br.pucrio.inf.les.investprofile.service.RecomendacaoManager#removeRecomendacao(java.lang.String)
	 */
	public void removeRecomendacao(String id) {
		if (log.isDebugEnabled()) {
			log.debug("removing operationAdvice: " + id);
		}

		dao.removeRecomendacao(new Long(id));
	}
}
