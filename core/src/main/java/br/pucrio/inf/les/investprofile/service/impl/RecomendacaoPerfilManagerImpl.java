package br.pucrio.inf.les.investprofile.service.impl;

import java.util.List;

import org.springframework.dao.DataIntegrityViolationException;

import br.pucrio.inf.les.investprofile.dao.RecomendacaoPerfilDao;
import br.pucrio.inf.les.investprofile.model.RecomendacaoPerfil;
import br.pucrio.inf.les.investprofile.service.RecomendacaoPerfilManager;

/**
 * Implementation of RecomendacaoPerfilManager interface.
 * </p>
 * <p>
 * <a href="RecomendacaoPerfilManagerImpl.java.html"><i>View Source</i></a>
 * </p>
 * 
 * @author <a href="mailto:mauricio.pinheiro@gmail.com">Mauricio Pinheiro</a>
 */
public class RecomendacaoPerfilManagerImpl extends
		GenericManagerImpl<RecomendacaoPerfil, Long> implements
		RecomendacaoPerfilManager {

	private RecomendacaoPerfilDao dao;

	/**
	 * @param dao
	 */
	public RecomendacaoPerfilManagerImpl(RecomendacaoPerfilDao dao) {
		super(dao);
		this.dao = dao;
	}

	/**
	 * Set the Dao for communication with the data layer.
	 * 
	 * @param dao
	 */
	public void setRecomendacaoPerfilDao(RecomendacaoPerfilDao dao) {
		this.dao = dao;
	}

	/**
	 * @see br.pucrio.inf.les.investprofile.service.RecomendacaoPerfilManager#getRecomendacaoPerfil(java.lang.String)
	 */
	public RecomendacaoPerfil getRecomendacaoPerfil(String idRecomendacaoPerfil) {
		return dao.getRecomendacaoPerfil(new Long(idRecomendacaoPerfil));
	}

	/**
	 * @see br.pucrio.inf.les.investprofile.service.RecomendacaoPerfilManager#getRecomendacoesPerfil(java.lang.String)
	 */
	public List<RecomendacaoPerfil> getRecomendacoesPerfil(
			String idPerfilInvestimento) {
		return dao.getRecomendacoesPerfil(new Long(idPerfilInvestimento));
	}

	/**
	 * @see br.pucrio.inf.les.investprofile.service.RecomendacaoPerfilManager#getRecomendacoesPerfis(java.lang.String)
	 */
	public List<RecomendacaoPerfil> getRecomendacoesPerfis(
			RecomendacaoPerfil recomendacaoPerfil) {
		return dao.getRecomendacoesPerfis(recomendacaoPerfil);
	}

	/**
	 * @see br.pucrio.inf.les.investprofile.service.RecomendacaoPerfilManager#saveRecomendacaoPerfil(br.pucrio.inf.les.investprofile.model.RecomendacaoPerfil)
	 */
	public void saveRecomendacaoPerfil(RecomendacaoPerfil recomendacaoPerfil)
			throws Exception {
		try {
			dao.saveRecomendacaoPerfil(recomendacaoPerfil);
		} catch (DataIntegrityViolationException e) {
			throw new Exception("Recomendacao de um perfil '"
					+ recomendacaoPerfil.getId() + "' already exists!");
		}
	}

	/**
	 * @see br.pucrio.inf.les.investprofile.service.RecomendacaoPerfilManager#removeRecomendacaoPerfil(java.lang.String)
	 */
	public void removeRecomendacaoPerfil(String idRecomendacaoPerfil) {
		if (log.isDebugEnabled()) {
			log.debug("removing operationAdvice: " + idRecomendacaoPerfil);
		}

		dao.removeRecomendacaoPerfil(new Long(idRecomendacaoPerfil));
	}
}
