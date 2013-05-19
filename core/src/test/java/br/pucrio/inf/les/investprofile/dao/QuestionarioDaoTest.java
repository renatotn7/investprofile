package br.pucrio.inf.les.investprofile.dao;

import br.pucrio.inf.les.investprofile.model.Questionario;

/**
 * @author Jonny
 * 
 */
public class QuestionarioDaoTest extends BaseDaoTestCase {
	private Questionario questionario = null;

	private QuestionarioDao dao = null;

	/**
	 * @param dao
	 */
	public void setQuestionarioDao(QuestionarioDao dao) {
		this.dao = dao;
	}

	/**
	 * @throws Exception
	 */
	public void testGetQuestionario() throws Exception {
		questionario = dao.getQuestionario();
		assertTrue(questionario.getQuestoes().size() > 0);
	}
}
