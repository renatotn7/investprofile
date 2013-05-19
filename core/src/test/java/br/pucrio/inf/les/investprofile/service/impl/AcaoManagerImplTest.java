package br.pucrio.inf.les.investprofile.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.jmock.Mock;

import br.pucrio.inf.les.investprofile.dao.AcaoDao;
import br.pucrio.inf.les.investprofile.model.Acao;
import br.pucrio.inf.les.investprofile.model.EspecificacaoPapel;
import br.pucrio.inf.les.investprofile.model.Segmento;

/**
 *
 * @author <a href="mailto:mauricio.pinheiro@gmail.com">Mauricio Costa Pinheiro</a>
 * @version %I%, %G%
 */
public class AcaoManagerImplTest extends BaseManagerMockTestCase {
	// ~ Instance fields
	// ========================================================

	private AcaoManagerImpl acaoManager = null;

	private Mock acaoDao = null;

	private Acao acao;

	// ~ Methods
	// ================================================================

	protected void setUp() throws Exception {
		super.setUp();
		acaoDao = new Mock(AcaoDao.class);
		acaoManager = new AcaoManagerImpl((AcaoDao) acaoDao.proxy());
	}

	protected void tearDown() throws Exception {
		super.tearDown();
		acaoManager = null;
	}

	/**
	 * @throws Exception
	 */
	public void testGetAcao() throws Exception {
		// set expected behavior on dao
		acaoDao.expects(once()).method("getAcaoPorCodigoBovespa").will(
				returnValue(new Acao()));

		acao = acaoManager.getAcaoPorCodigoBovespa("PETR4");
		assertTrue(acao != null);
		acaoDao.verify();
	}

	/**
	 * @throws Exception
	 */
	public void testGetAcoes() throws Exception {
		List<Acao> results = new ArrayList<Acao>();
		acao = new Acao();
		results.add(acao);

		// set expected behavior on dao
		acaoDao.expects(once()).method("getAcoes").will(returnValue(results));

		List<Acao> acoes = acaoManager.getAcoes(null);
		assertTrue(acoes.size() > 0);
		acaoDao.verify();
	}

	/**
	 * @throws Exception
	 */
	public void testSaveAcao() throws Exception {
		// set expected behavior on dao
		acaoDao.expects(once()).method("saveAcao").with(same(acao)).isVoid();

		acaoManager.saveAcao(acao);
		acaoDao.verify();
	}

	/**
	 * @throws Exception
	 */
	public void testAddAndRemoveAcao() throws Exception {
		Acao acao = new Acao();
		// call populate method in super class to populate test data
		// from a properties file matching this class name
		// acao = (Acao) populate(acao);
		acao.setCodigoADR("PETR");
		acao.setCodigoBovespa("PETR3");
		acao.setNome("Petrobrás");
		acao.setFatorNegociacao(new Integer(5));
		acao.setSegmento(Segmento.PETROLEO);
		acao.setEspecificacaoPapel(EspecificacaoPapel.ON);

		// set expected behavior on acao dao
		acaoDao.expects(once()).method("saveAcao").with(same(acao));
		acaoManager.saveAcao(acao);
		assertTrue(acao.getNome().equals("Petrobrás"));
		acaoDao.verify();

		// reset expectations
		acaoDao.reset();

		acaoDao.expects(once()).method("removeAcao").with(eq(new Long(5)));
		acaoManager.removeAcao("5");
		acaoDao.verify();

		// reset expectations
		acaoDao.reset();
		acaoDao.expects(once()).method("getAcao").will(returnValue(null));
		acao = acaoManager.getAcao("5");
		assertNull(acao);
		acaoDao.verify();
	}
}
