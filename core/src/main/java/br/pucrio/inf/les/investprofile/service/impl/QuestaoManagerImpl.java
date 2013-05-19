package br.pucrio.inf.les.investprofile.service.impl;

import java.util.List;

import org.springframework.dao.DataIntegrityViolationException;

import br.pucrio.inf.les.investprofile.dao.QuestaoDao;
import br.pucrio.inf.les.investprofile.model.Questao;
import br.pucrio.inf.les.investprofile.service.QuestaoManager;

/**
 * Implementation of QuestaoManager interface.
 * </p>
 * <p>
 * <a href="QuestaoManagerImpl.java.html"><i>View Source</i></a>
 * </p>
 * 
 * @author <a href="mailto:mauricio.pinheiro@gmail.com">Mauricio Pinheiro</a>
 */
public class QuestaoManagerImpl extends GenericManagerImpl<Questao, Long>
		implements QuestaoManager {
	private QuestaoDao dao;

	/**
	 * @param dao
	 */
	public QuestaoManagerImpl(QuestaoDao dao) {
		super(dao);
		this.dao = dao;
	}

	/**
	 * Set the Dao for communication with the data layer.
	 * 
	 * @param dao
	 */
	public void setQuestaoDao(QuestaoDao dao) {
		this.dao = dao;
	}

	/**
	 * @see br.pucrio.inf.les.investprofile.service.QuestaoManager#getQuestao(java.lang.String)
	 */
	public Questao getQuestao(String id) {
		return dao.getQuestao(new Long(id));
	}

	/**
	 * @see br.pucrio.inf.les.investprofile.service.QuestaoManager#getQuestaoPorTrechoPergunta(java.lang.String)
	 */
	public Questao getQuestaoPorTrechoPergunta(String nome) throws Exception {
		return dao.getQuestaoPorTrechoPergunta(nome);
	}

	/**
	 * @see br.pucrio.inf.les.investprofile.service.QuestaoManager#getQuestoes(br.pucrio.inf.les.investprofile.model.Questao)
	 */
	public List<Questao> getQuestoes(Questao questao) {
		return dao.getQuestoes(questao);
	}

	/**
	 * @see br.pucrio.inf.les.investprofile.service.QuestaoManager#saveQuestao(br.pucrio.inf.les.investprofile.model.Questao)
	 */
	public void saveQuestao(Questao questao) throws Exception {
		try {
			dao.saveQuestao(questao);
		} catch (DataIntegrityViolationException e) {
			throw new Exception("Questao '" + questao.getId().toString()
					+ "' ja existe!");
		}
	}

	/**
	 * @see br.pucrio.inf.les.investprofile.service.QuestaoManager#removeQuestao(java.lang.String)
	 */
	public void removeQuestao(String id) {
		if (log.isDebugEnabled()) {
			log.debug("removendo acao: " + id);
		}

		dao.removeQuestao(new Long(id));
	}
}
