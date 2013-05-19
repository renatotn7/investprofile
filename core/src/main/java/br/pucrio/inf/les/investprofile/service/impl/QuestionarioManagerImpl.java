package br.pucrio.inf.les.investprofile.service.impl;

import br.pucrio.inf.les.investprofile.dao.QuestionarioDao;
import br.pucrio.inf.les.investprofile.model.Questionario;
import br.pucrio.inf.les.investprofile.service.QuestionarioManager;

/**
 * Implementation of QuestionarioManager interface.
 * </p>
 * <p>
 * <a href="QuestionarioManagerImpl.java.html"><i>View Source</i></a>
 * </p>
 * 
 * @author <a href="mailto:mauricio.pinheiro@gmail.com">Mauricio Pinheiro</a>
 */
public class QuestionarioManagerImpl extends
		GenericManagerImpl<Questionario, Long> implements QuestionarioManager {
	private QuestionarioDao dao;

	/**
	 * @param dao
	 */
	public QuestionarioManagerImpl(QuestionarioDao dao) {
		super(dao);
		this.dao = dao;
	}

	/**
	 * Set the Dao for communication with the data layer.
	 * 
	 * @param dao
	 */
	public void setQuestionarioDao(QuestionarioDao dao) {
		this.dao = dao;
	}

	/**
	 * @see br.pucrio.inf.les.investprofile.service.getQuestionario#getQuestionario()
	 */
	public Questionario getQuestionario() {
		return dao.getQuestionario();
	}
}
