package br.pucrio.inf.les.investprofile.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.jmock.Mock;

import br.pucrio.inf.les.investprofile.dao.RecomendacaoAnalistaDao;
import br.pucrio.inf.les.investprofile.model.Acao;
import br.pucrio.inf.les.investprofile.model.RecomendacaoAnalista;
import br.pucrio.inf.les.investprofile.service.RecomendacaoAnalistaManager;

/**
 * 
 * @author <a href="mailto:mauricio.pinheiro@gmail.com">Mauricio Costa Pinheiro</a>
 * @version %I%, %G%
 */
public class RecomendacaoAnalistaManagerImplTest extends
		BaseManagerMockTestCase {
	// ~ Instance fields
	// ========================================================

	private RecomendacaoAnalistaManagerImpl recomendacaoAnalistaManager = null;

	private Mock recomendacaoAnalistaDao = null;

	private Acao acao = null;

	private RecomendacaoAnalistaManager mgr = null;

	// ~ Methods
	// ================================================================

	protected void setUp() throws Exception {
		super.setUp();
		recomendacaoAnalistaDao = new Mock(RecomendacaoAnalistaDao.class);
		recomendacaoAnalistaManager = new RecomendacaoAnalistaManagerImpl(
				(RecomendacaoAnalistaDao) recomendacaoAnalistaDao.proxy());
	}

	protected void tearDown() throws Exception {
		super.tearDown();
		recomendacaoAnalistaManager = null;
	}

	/**
	 * @throws Exception
	 */
	public void testGetRecomendacoesAnalistas() throws Exception {
		List results = new ArrayList();
		acao = new Acao();
		results.add(acao);

		// set expected behavior on dao
		recomendacaoAnalistaDao.expects(once()).method(
				"getRecomendacoesAnalistas").will(returnValue(results));

		List<RecomendacaoAnalista> recomendacoesAnalistas = recomendacaoAnalistaManager
				.getRecomendacoesAnalistas(new RecomendacaoAnalista());
		assertTrue(recomendacoesAnalistas.size() > 0);
		recomendacaoAnalistaDao.verify();
	}

	/**
	 * @throws Exception
	 */
	public void testGetTodasAcoes() throws Exception {
		List results = new ArrayList();
		acao = new Acao();
		results.add(acao);

		// set expected behavior on dao
		recomendacaoAnalistaDao.expects(once()).method(
				"getRecomendacoesAnalista").will(returnValue(results));

		List<RecomendacaoAnalista> recomendacoesAnalistas = recomendacaoAnalistaManager
				.getRecomendacoesAnalista("Super");
		assertTrue(recomendacoesAnalistas.size() > 0);
		recomendacaoAnalistaDao.verify();
	}
}
