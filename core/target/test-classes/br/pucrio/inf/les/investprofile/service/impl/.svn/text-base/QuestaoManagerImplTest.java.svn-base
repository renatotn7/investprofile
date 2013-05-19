package br.pucrio.inf.les.investprofile.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.jmock.Mock;

import br.pucrio.inf.les.investprofile.dao.QuestaoDao;
import br.pucrio.inf.les.investprofile.model.Questao;
import br.pucrio.inf.les.investprofile.service.impl.BaseManagerMockTestCase;
import br.pucrio.inf.les.investprofile.service.impl.QuestaoManagerImpl;

public class QuestaoManagerImplTest extends BaseManagerMockTestCase {
	// ~ Instance fields
	// ========================================================

	private QuestaoManagerImpl questaoManager = null;

	private Mock questaoDao = null;

	private Questao questao;

	// ~ Methods
	// ================================================================

	protected void setUp() throws Exception {
		super.setUp();
		questaoDao = new Mock(QuestaoDao.class);
		questaoManager = new QuestaoManagerImpl((QuestaoDao) questaoDao.proxy());
	}

	protected void tearDown() throws Exception {
		super.tearDown();
		questaoManager = null;
	}

	public void testGetQuestao() throws Exception {
		// set expected behavior on dao
		questaoDao.expects(once()).method("getQuestaoPorTrechoPergunta").will(
				returnValue(new Questao()));

		questao = questaoManager.getQuestaoPorTrechoPergunta("acima de 20%");
		assertTrue(questao != null);
		questaoDao.verify();
	}

	public void testGetQuestoes() throws Exception {
		List results = new ArrayList();
		questao = new Questao();
		results.add(questao);

		// set expected behavior on dao
		questaoDao.expects(once()).method("getQuestoes").will(
				returnValue(results));

		List questaos = questaoManager.getQuestoes(null);
		assertTrue(questaos.size() == 1);
		questaoDao.verify();
	}

	public void testSaveQuestao() throws Exception {
		// set expected behavior on dao
		questaoDao.expects(once()).method("saveQuestao").with(same(questao))
				.isVoid();

		questaoManager.saveQuestao(questao);
		questaoDao.verify();
	}

	public void testAddAndRemoveQuestao() throws Exception {
		Questao questao = new Questao();
		// call populate method in super class to populate test data
		// from a properties file matching this class name
		// questao = (Questao) populate(questao);
		questao.setPergunta("Teste do manager.");

		// set expected behavior on questao dao
		questaoDao.expects(once()).method("saveQuestao").with(same(questao));
		questaoManager.saveQuestao(questao);
		assertTrue(questao.getPergunta().equals("Teste do manager."));
		questaoDao.verify();

		// reset expectations
		questaoDao.reset();

		questaoDao.expects(once()).method("removeQuestao")
				.with(eq(new Long(1)));
		questaoManager.removeQuestao("1");
		questaoDao.verify();

		// reset expectations
		questaoDao.reset();
		questaoDao.expects(once()).method("getQuestao").will(returnValue(null));
		questao = questaoManager.getQuestao("1");
		assertNull(questao);
		questaoDao.verify();
	}
}
