package br.pucrio.inf.les.investprofile.service.impl;

import java.util.List;

import org.springframework.dao.DataIntegrityViolationException;

import br.pucrio.inf.les.investprofile.dao.RespostaDao;
import br.pucrio.inf.les.investprofile.model.Resposta;
import br.pucrio.inf.les.investprofile.service.RespostaManager;

/**
 * Implementation of StockManager interface.
 * </p>
 * <p>
 * <a href="RespostaManagerImpl.java.html"><i>View Source</i></a>
 * </p>
 * 
 * @author <a href="mailto:mauricio.pinheiro@gmail.com">Mauricio Pinheiro</a>
 */
public class RespostaManagerImpl extends GenericManagerImpl<Resposta, Long>
		implements RespostaManager {
	private RespostaDao dao;

	/**
	 * @param dao
	 */
	public RespostaManagerImpl(RespostaDao dao) {
		super(dao);
		this.dao = dao;
	}

	/**
	 * Set the Dao for communication with the data layer.
	 * 
	 * @param dao
	 */
	public void setRespostaDao(RespostaDao dao) {
		this.dao = dao;
	}

	/**
	 * @see br.pucrio.inf.les.investprofile.service.RespostaManager#getResposta(java.lang.String)
	 */
	public Resposta getResposta(String id) {
		return dao.getResposta(new Long(id));
	}

	/**
	 * @see br.pucrio.inf.les.investprofile.service.RespostaManager#getRespostaPorTrechoResposta(java.lang.String)
	 */
	public Resposta getRespostaPorTrechoResposta(String nome) throws Exception {
		return dao.getRespostaPorTrechoResposta(nome);
	}

	/**
	 * @see br.pucrio.inf.les.investprofile.service.RespostaManager#getRespostas(br.pucrio.inf.les.investprofile.model.Resposta)
	 */
	public List<Resposta> getRespostas(Resposta resposta) {
		return dao.getRespostas(resposta);
	}

	/**
	 * @see br.pucrio.inf.les.investprofile.service.RespostaManager#saveResposta(br.pucrio.inf.les.investprofile.model.Resposta)
	 */
	public void saveResposta(Resposta resposta) throws Exception {
		try {
			dao.saveResposta(resposta);
		} catch (DataIntegrityViolationException e) {
			throw new Exception("Resposta '" + resposta.getId().toString()
					+ "' ja existe!");
		}
	}

	/**
	 * @see br.pucrio.inf.les.investprofile.service.RespostaManager#removeOpcao(java.lang.String)
	 */
	public void removeOpcao(String id) {
		if (log.isDebugEnabled()) {
			log.debug("removendo resposta: " + id);
		}

		dao.removeResposta(new Long(id));
	}
}
