package br.pucrio.inf.les.investprofile.service.impl;

import java.util.List;

import org.springframework.dao.DataIntegrityViolationException;

import br.pucrio.inf.les.investprofile.dao.PerfilInvestimentoDao;
import br.pucrio.inf.les.investprofile.model.PerfilInvestimento;
import br.pucrio.inf.les.investprofile.service.PerfilInvestimentoManager;

/**
 * Implementation of PerfilInvestimentoManager interface.
 * </p>
 * <p>
 * <a href="PerfilInvestimentoManagerImpl.java.html"><i>View Source</i></a>
 * </p>
 * 
 * @author <a href="mailto:mauricio.pinheiro@gmail.com">Mauricio Pinheiro</a>
 */
public class PerfilInvestimentoManagerImpl extends
		GenericManagerImpl<PerfilInvestimento, Long> implements
		PerfilInvestimentoManager {
	private PerfilInvestimentoDao dao;

	/**
	 * @param dao
	 */
	public PerfilInvestimentoManagerImpl(PerfilInvestimentoDao dao) {
		super(dao);
		this.dao = dao;
	}

	/**
	 * Set the Dao for communication with the data layer.
	 * 
	 * @param dao
	 */
	public void setPerfilInvestimentoDao(PerfilInvestimentoDao dao) {
		this.dao = dao;
	}

	/**
	 * @see br.pucrio.inf.les.profile.service.PerfilInvestimentoManager#getPerfilInvestimento(java.lang.String)
	 */
	public PerfilInvestimento getPerfilInvestimento(String id) {
		return dao.getPerfilInvestimento(new Long(id));
	}

	/**
	 * @see br.pucrio.inf.les.investprofile.service.PerfilInvestimentoManager#getPerfisInvestimentosPorIdUsuario(Long)
	 */
	public List<PerfilInvestimento> getPerfisInvestimentosPorIdUsuario(String id) {
		return dao.getPerfisInvestimentosPorIdUsuario(new Long(id));
	}

	/**
	 * @see br.pucrio.inf.les.investprofile.service.PerfilInvestimentoManager#getPerfisInvestimentos(br.pucrio.inf.les.investprofile.model.PerfilInvestimento)
	 */
	public List<PerfilInvestimento> getPerfisInvestimentos(
			PerfilInvestimento perfilInvestimento) {
		return dao.getPerfisInvestimentos(perfilInvestimento);
	}

	/**
	 * @see br.pucrio.inf.les.profile.service.PerfilInvestimentoManager#getProfileByName(java.lang.String)
	 */
	public PerfilInvestimento getPerfilInvestimentoPorNome(String nome)
			throws Exception {
		return (PerfilInvestimento) dao.getPerfilInvestimentoPorNome(nome);
	}

	/**
	 * @see br.pucrio.inf.les.profile.service.PerfilInvestimentoManager#savePerfilInvestimento(br.pucrio.inf.les.profile.model.PerfilInvestimento)
	 */
	public void savePerfilInvestimento(PerfilInvestimento perfilInvestimento)
			throws Exception {
		try {
			dao.savePerfilInvestimento(perfilInvestimento);
		} catch (DataIntegrityViolationException e) {
			throw new Exception("PerfilInvestimento '"
					+ perfilInvestimento.getId() + "' already exists!");
		}
	}

	/**
	 * @see br.pucrio.inf.les.profile.service.PerfilInvestimentoManager#removePerfilInvestimento(java.lang.String)
	 */
	public void removePerfilInvestimento(String id) {
		if (log.isDebugEnabled()) {
			log.debug("removing profile: " + id);
		}
		dao.removePerfilInvestimento(new Long(id));
	}
}
