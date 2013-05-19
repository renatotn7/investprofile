package br.pucrio.inf.les.investprofile.service.impl;

import org.jmock.Mock;

import br.pucrio.inf.les.investprofile.dao.QuestionarioDao;
import br.pucrio.inf.les.investprofile.model.Questionario;
import br.pucrio.inf.les.investprofile.service.impl.BaseManagerMockTestCase;
import br.pucrio.inf.les.investprofile.service.impl.QuestionarioManagerImpl;

public class QuestionarioManagerImplTest extends BaseManagerMockTestCase {
	// ~ Instance fields
	// ========================================================

	private QuestionarioManagerImpl questionarioManager = null;

	private Mock questionarioDao = null;

	private Questionario questionario;

	// ~ Methods
	// ================================================================

	protected void setUp() throws Exception {
		super.setUp();
		questionarioDao = new Mock(QuestionarioDao.class);
		questionarioManager = new QuestionarioManagerImpl(
				(QuestionarioDao) questionarioDao.proxy());
	}

	protected void tearDown() throws Exception {
		super.tearDown();
		questionarioManager = null;
	}

	public void testGetQuestionario() throws Exception {
		// set expected behavior on dao
		questionarioDao.expects(once()).method("getQuestionario").will(
				returnValue(new Questionario()));

		questionario = questionarioManager.getQuestionario();
		assertTrue(questionario != null);
		// assertTrue(questionario.getQuestoes().size() > 0);
		questionarioDao.verify();
	}
}
