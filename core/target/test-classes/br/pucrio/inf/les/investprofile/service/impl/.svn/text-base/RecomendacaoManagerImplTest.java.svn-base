package br.pucrio.inf.les.investprofile.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.jmock.Mock;

import br.pucrio.inf.les.investprofile.dao.AcaoDao;
import br.pucrio.inf.les.investprofile.dao.CarteiraDao;
import br.pucrio.inf.les.investprofile.dao.RecomendacaoDao;
import br.pucrio.inf.les.investprofile.model.Acao;
import br.pucrio.inf.les.investprofile.model.Carteira;
import br.pucrio.inf.les.investprofile.model.Recomendacao;
import br.pucrio.inf.les.investprofile.model.TipoOperacao;

/**
 * 
 * @author <a href="mailto:mauricio.pinheiro@gmail.com">Mauricio Costa Pinheiro</a>
 * @version %I%, %G%
 */
public class RecomendacaoManagerImplTest extends BaseManagerMockTestCase {
	// ~ Instance fields
	// ========================================================

	private RecomendacaoManagerImpl recomendacaoManager = null;

	private Mock recomendacaoDao = null;

	private AcaoManagerImpl acaoManager = null;

	private Mock acaoDao = null;

	private CarteiraManagerImpl carteiraManager = null;

	private Mock carteiraDao = null;

	private Recomendacao recomendacao;

	private Acao acao;

	private Carteira carteira = null;

	// ~ Methods
	// ================================================================

	protected void setUp() throws Exception {
		super.setUp();
		recomendacaoDao = new Mock(RecomendacaoDao.class);
		acaoDao = new Mock(AcaoDao.class);
		carteiraDao = new Mock(CarteiraDao.class);

		recomendacaoManager = new RecomendacaoManagerImpl(
				(RecomendacaoDao) recomendacaoDao.proxy());
		acaoManager = new AcaoManagerImpl((AcaoDao) acaoDao.proxy());
		carteiraManager = new CarteiraManagerImpl((CarteiraDao) carteiraDao
				.proxy());
	}

	protected void tearDown() throws Exception {
		super.tearDown();
		recomendacaoManager = null;
		acaoManager = null;
		carteiraManager = null;
	}

	public void testGetRecomendacao() throws Exception {
		// set expected behavior on dao
		recomendacaoDao.expects(once()).method("getRecomendacao").will(
				returnValue(new Recomendacao()));
		recomendacao = recomendacaoManager.getRecomendacao("1");
		assertTrue(recomendacao != null);
		recomendacaoDao.verify();
	}

	public void testGetRecomendacoes() throws Exception {
		List results = new ArrayList();
		recomendacao = new Recomendacao();
		results.add(recomendacao);

		// set expected behavior on dao
		recomendacaoDao.expects(once()).method("getRecomendacoes").will(
				returnValue(results));

		List recomendacaos = recomendacaoManager.getRecomendacoes(null);
		assertTrue(recomendacaos.size() == 1);
		recomendacaoDao.verify();
	}

	public void testSaveRecomendacao() throws Exception {
		// set expected behavior on dao
		recomendacaoDao.expects(once()).method("saveRecomendacao").with(
				same(recomendacao)).isVoid();

		recomendacaoManager.saveRecomendacao(recomendacao);
		assertNull(recomendacao);
		recomendacaoDao.verify();
	}

	/**
	 * @throws Exception
	 */
	public void testAddAndRemoveRecomendacao() throws Exception {
		recomendacao = new Recomendacao();

		acaoDao.expects(once()).method("getAcaoPorCodigoBovespa").with(
				eq(new String("VALE5"))).will(returnValue(new Acao()));
		acao = acaoManager.getAcaoPorCodigoBovespa("VALE5");
		acaoDao.verify();

		// call populate method in super class to populate test data
		// from a properties file matching this class name
		// recomendacao = (Recomendacao) populate(recomendacao);
		recomendacao.setAcao(acao);
		recomendacao.setGrauConfianca(new Double(34.777));
		recomendacao.setData(new Date(5443));
		recomendacao.setPreco(new Double(66788.009));
		recomendacao.setHora(new Long(5588));
		recomendacao.setOperacao(TipoOperacao.VENDER);

		// set expected behavior on recomendacao dao
		recomendacaoDao.expects(once()).method("saveRecomendacao").with(
				same(recomendacao));
		recomendacaoManager.saveRecomendacao(recomendacao);
		recomendacaoDao.verify();

		// reset expectations
		recomendacaoDao.reset();
		recomendacaoDao.expects(once()).method("removeRecomendacao").with(
				eq(new Long(3)));
		recomendacaoManager.removeRecomendacao("3");
		recomendacaoDao.verify();

		// reset expectations
		recomendacaoDao.reset();
		recomendacaoDao.expects(once()).method("getRecomendacao").will(
				returnValue(null));
		recomendacao = recomendacaoManager.getRecomendacao("3");
		assertNull(recomendacao);
		recomendacaoDao.verify();
	}
}
