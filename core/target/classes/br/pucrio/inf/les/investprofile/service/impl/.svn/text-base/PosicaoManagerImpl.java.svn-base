package br.pucrio.inf.les.investprofile.service.impl;

import java.util.List;

import org.springframework.dao.DataIntegrityViolationException;

import br.pucrio.inf.les.investprofile.dao.PosicaoDao;
import br.pucrio.inf.les.investprofile.model.Posicao;
import br.pucrio.inf.les.investprofile.service.PosicaoManager;

/**
 * Implementation of PosicaoManager interface.
 * </p>
 * <p>
 * <a href="PosicaoManagerImpl.java.html"><i>View Source</i></a>
 * </p>
 * 
 * @author <a href="mailto:mauricio.pinheiro@gmail.com">Mauricio Pinheiro</a>
 */
public class PosicaoManagerImpl extends GenericManagerImpl<Posicao, Long>
		implements PosicaoManager {
	private PosicaoDao dao;

	/**
	 * @param dao
	 */
	public PosicaoManagerImpl(PosicaoDao dao) {
		super(dao);
		this.dao = dao;
	}

	/**
	 * Set the Dao for communication with the data layer.
	 * 
	 * @param dao
	 */
	public void setPosicaoDao(PosicaoDao dao) {
		this.dao = dao;
	}

	/**
	 * @see br.pucrio.inf.les.investprofile.service.PosicaoManager#getPosicao(java.lang.String)
	 */
	public Posicao getPosicao(String id) {
		return dao.getPosicao(new Long(id));
	}

	/**
	 * @see br.pucrio.inf.les.investprofile.service.PosicaoManager#getPosicoes(br.pucrio.inf.les.investprofile.model.Posicao)
	 */
	public List<Posicao> getPosicoes(Posicao posicao) {
		return dao.getPosicoes(posicao);
	}

	/**
	 * @see br.pucrio.inf.les.investprofile.service.PosicaoManager#getPosicoesPorPerfil(String)
	 */
	public List<Posicao> getPosicoesPorPerfil(String idPerfilInvestimento) {
		return dao.getPosicoesPorPerfil(new Long(idPerfilInvestimento));
	}
	
	/**
	 * @see br.pucrio.inf.les.investprofile.service.PosicaoManager#savePosicao(br.pucrio.inf.les.investprofile.model.Posicao)
	 */
	public void savePosicao(Posicao posicao) throws Exception {
		try {
			dao.savePosicao(posicao);
		} catch (DataIntegrityViolationException e) {
			throw new Exception("Posicao '" + posicao.getId().toString()
					+ "' already exists!");
		}
	}

	/**
	 * @see br.pucrio.inf.les.investprofile.service.PosicaoManager#removePosicao(java.lang.String)
	 */
	public void removePosicao(String id) {
		if (log.isDebugEnabled()) {
			log.debug("removing posicao: " + id);
		}

		dao.removePosicao(new Long(id));
	}
}
