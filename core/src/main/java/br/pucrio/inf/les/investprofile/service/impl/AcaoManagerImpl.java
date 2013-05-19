package br.pucrio.inf.les.investprofile.service.impl;

import java.util.List;

import org.springframework.dao.DataIntegrityViolationException;

import br.pucrio.inf.les.investprofile.dao.AcaoDao;
import br.pucrio.inf.les.investprofile.model.Acao;
import br.pucrio.inf.les.investprofile.service.AcaoManager;

/**
 * Implementation of AcaoManager interface.
 * </p>
 * <p>
 * <a href="AcaoManagerImpl.java.html"><i>View Source</i></a>
 * </p>
 * 
 * @author <a href="mailto:mauricio.pinheiro@gmail.com">Mauricio Pinheiro</a>
 */
public class AcaoManagerImpl extends GenericManagerImpl<Acao, Long> implements
		AcaoManager {
	private AcaoDao dao;

	/**
	 * @param dao
	 */
	public AcaoManagerImpl(AcaoDao dao) {
		super(dao);
		this.dao = dao;
	}

	/**
	 * Set the Dao for communication with the data layer.
	 * 
	 * @param dao
	 */
	public void setAcaoDao(AcaoDao dao) {
		this.dao = dao;
	}

	/**
	 * @see br.pucrio.inf.les.investprofile.service.AcaoManager#getAcao(java.lang.String)
	 */
	public Acao getAcao(String id) {
		return dao.getAcao(new Long(id));
	}

	/**
	 * @see br.pucrio.inf.les.investprofile.service.AcaoManager#getAcaoPorNome(java.lang.String)
	 */
	public Acao getAcaoPorNome(String nome) throws Exception {
		return dao.getAcaoPorNome(nome);
	}

	/**
	 * @see br.pucrio.inf.les.investprofile.service.AcaoManager#getAcaoPorCodigoBovespa(java.lang.String)
	 */
	public Acao getAcaoPorCodigoBovespa(String codigoBovespa) {
		return dao.getAcaoPorCodigoBovespa(codigoBovespa);
	}

	/**
	 * @see br.pucrio.inf.les.investprofile.service.AcaoManager#getAcoes(br.pucrio.inf.les.investprofile.model.Acao)
	 */
	public List<Acao> getAcoes(Acao acao) {
		return dao.getAcoes(acao);
	}

	/**
	 * @see br.pucrio.inf.les.investprofile.service.AcaoManager#saveAcao(br.pucrio.inf.les.investprofile.model.Acao)
	 */
	public void saveAcao(Acao acao) throws Exception {
		try {
			dao.saveAcao(acao);
		} catch (DataIntegrityViolationException e) {
			throw new Exception("Acao '" + acao.getId().toString()
					+ "' ja existe!");
		}
	}

	/**
	 * @see br.pucrio.inf.les.investprofile.service.AcaoManager#removeAcao(java.lang.String)
	 */
	public void removeAcao(String id) {
		if (log.isDebugEnabled()) {
			log.debug("removendo acao: " + id);
		}

		dao.removeAcao(new Long(id));
	}
}
