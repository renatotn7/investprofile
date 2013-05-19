package br.pucrio.inf.les.investprofile.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.jmock.Mock;

import br.pucrio.inf.les.investprofile.dao.AcaoDao;
import br.pucrio.inf.les.investprofile.dao.CarteiraDao;
import br.pucrio.inf.les.investprofile.dao.PosicaoDao;
import br.pucrio.inf.les.investprofile.model.Acao;
import br.pucrio.inf.les.investprofile.model.Carteira;
import br.pucrio.inf.les.investprofile.model.Posicao;

/**
 *
 * @author <a href="mailto:mauricio.pinheiro@gmail.com">Mauricio Costa Pinheiro</a>
 * @version %I%, %G%
 */
public class PosicaoManagerImplTest extends BaseManagerMockTestCase {
	// ~ Instance fields
	// ========================================================

	private PosicaoManagerImpl posicaoManager = null;

	private Mock posicaoDao = null;

	private AcaoManagerImpl acaoManager = null;

	private Mock acaoDao = null;

	private CarteiraManagerImpl carteiraManager = null;

	private Mock carteiraDao = null;

	private Posicao posicao;

	private Acao acao;

	private Carteira carteira;

	// ~ Methods
	// ================================================================

	protected void setUp() throws Exception {
		super.setUp();
		posicaoDao = new Mock(PosicaoDao.class);
		acaoDao = new Mock(AcaoDao.class);
		carteiraDao = new Mock(CarteiraDao.class);

		posicaoManager = new PosicaoManagerImpl(
				(PosicaoDao) posicaoDao.proxy());
		acaoManager = new AcaoManagerImpl((AcaoDao) acaoDao.proxy());
		carteiraManager = new CarteiraManagerImpl((CarteiraDao) carteiraDao
				.proxy());
	}

	protected void tearDown() throws Exception {
		super.tearDown();
		posicaoManager = null;
		acaoManager = null;
		carteiraManager = null;
	}

	/**
	 * @throws Exception
	 */
	public void testGePosicao() throws Exception {
		// set expected behavior on dao
		posicaoDao.expects(once()).method("getPosicao").will(
				returnValue(new Posicao()));
		posicao = posicaoManager.getPosicao("1");
		assertTrue(posicao != null);
		posicaoDao.verify();
	}

	/**
	 * @throws Exception
	 */
	public void testGetPosicoes() throws Exception {
		List results = new ArrayList();
		posicao = new Posicao();
		results.add(posicao);

		// set expected behavior on dao
		posicaoDao.expects(once()).method("getPosicoes").will(
				returnValue(results));

		List posicoes = posicaoManager.getPosicoes(null);
		assertTrue(posicoes.size() > 0);
		posicaoDao.verify();
	}

	/**
	 * @throws Exception
	 */
	public void testGetPosicoesPorPerfil() throws Exception {
		List results = new ArrayList();
		posicao = new Posicao();
		results.add(posicao);

		// set expected behavior on dao
		posicaoDao.expects(once()).method("getPosicoesPorPerfil").will(
				returnValue(results));

		List posicoes = posicaoManager.getPosicoesPorPerfil("1");
		assertTrue(posicoes.size() > 0);
		posicaoDao.verify();
	}
	
	/**
	 * @throws Exception
	 */
	public void testSavePosicao() throws Exception {
		// set expected behavior on dao
		posicaoDao.expects(once()).method("savePosicao").with(
				same(posicao)).isVoid();
		posicaoManager.savePosicao(posicao);
		posicaoDao.verify();
	}

	/**
	 * @throws Exception
	 */
	public void testAddAndRemovePosicao() throws Exception {
		posicao = new Posicao();

		acaoDao.expects(once()).method("getAcaoPorCodigoBovespa").will(
				returnValue(new Acao()));
		acao = acaoManager.getAcaoPorCodigoBovespa(new String("VALE5"));
		assertNotNull(acao);

		carteiraDao.expects(once()).method("getCarteira").will(
				returnValue(new Carteira()));
		carteira = carteiraManager.getCarteira("1");
		assertNotNull(carteira);

		// call populate method in super class to populate test data
		// from a properties file matching this class name
		// posicao = (Posicao) populate(posicao);
		posicao.setAcao(acao);

		// set expected behavior on posicao dao
		posicaoDao.expects(once()).method("savePosicao").with(
				same(posicao)).isVoid();
		posicaoManager.savePosicao(posicao);
		posicaoDao.verify();

		// reset expectations
		posicaoDao.reset();

		posicaoDao.expects(once()).method("removePosicao").with(
				eq(new Long(3)));
		posicaoManager.removePosicao("3");
		posicaoDao.verify();

		// reset expectations
		posicaoDao.reset();
		posicaoDao.expects(once()).method("getPosicao").will(
				returnValue(null));
		posicao = posicaoManager.getPosicao("3");
		assertNull(posicao);
		posicaoDao.verify();
	}
}
