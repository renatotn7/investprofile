package br.pucrio.inf.les.investprofile.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.jmock.Mock;

import br.pucrio.inf.les.investprofile.dao.RespostaDao;
import br.pucrio.inf.les.investprofile.model.Resposta;
import br.pucrio.inf.les.investprofile.service.impl.BaseManagerMockTestCase;
import br.pucrio.inf.les.investprofile.service.impl.RespostaManagerImpl;

public class RespostaManagerImplTest extends BaseManagerMockTestCase {
	// ~ Instance fields
	// ========================================================

	private RespostaManagerImpl respostaManager = null;

	private Mock respostaDao = null;

	private Resposta resposta;

	// ~ Methods
	// ================================================================

	protected void setUp() throws Exception {
		super.setUp();
		respostaDao = new Mock(RespostaDao.class);
		respostaManager = new RespostaManagerImpl((RespostaDao) respostaDao
				.proxy());
	}

	protected void tearDown() throws Exception {
		super.tearDown();
		respostaManager = null;
	}

	public void testGetOpcao() throws Exception {
		// set expected behavior on dao
		respostaDao.expects(once()).method("getRespostaPorTrechoResposta")
				.will(returnValue(new Resposta()));

		resposta = respostaManager.getRespostaPorTrechoResposta("Até 2%");
		assertTrue(resposta != null);
		respostaDao.verify();
	}

	public void testGetAcoes() throws Exception {
		List results = new ArrayList();
		resposta = new Resposta();
		results.add(resposta);

		// set expected behavior on dao
		respostaDao.expects(once()).method("getRespostas").will(
				returnValue(results));

		List opcaos = respostaManager.getRespostas(null);
		assertTrue(opcaos.size() == 1);
		respostaDao.verify();
	}

	public void testSaveOpcao() throws Exception {
		// set expected behavior on dao
		respostaDao.expects(once()).method("saveResposta").with(same(resposta))
				.isVoid();

		respostaManager.saveResposta(resposta);
		respostaDao.verify();
	}

	public void testAddAndRemoveOpcao() throws Exception {
		Resposta resposta = new Resposta();
		// call populate method in super class to populate test data
		// from a properties file matching this class name
		// resposta = (Resposta) populate(resposta);
		resposta.setConteudo("Teste do manager.");

		// set expected behavior on resposta dao
		respostaDao.expects(once()).method("saveResposta").with(same(resposta));
		respostaManager.saveResposta(resposta);
		assertTrue(resposta.getConteudo().equals("Teste do manager."));
		respostaDao.verify();

		// reset expectations
		respostaDao.reset();

		respostaDao.expects(once()).method("removeResposta").with(
				eq(new Long(1)));
		respostaManager.removeOpcao("1");
		respostaDao.verify();

		// reset expectations
		respostaDao.reset();
		respostaDao.expects(once()).method("getResposta").will(
				returnValue(null));
		resposta = respostaManager.getResposta("1");
		assertNull(resposta);
		respostaDao.verify();
	}
}
