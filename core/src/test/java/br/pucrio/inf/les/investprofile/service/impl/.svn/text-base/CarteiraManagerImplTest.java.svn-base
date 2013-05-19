package br.pucrio.inf.les.investprofile.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.jmock.Mock;

import br.pucrio.inf.les.investprofile.dao.CarteiraDao;
import br.pucrio.inf.les.investprofile.model.Carteira;

/**
 *
 * @author <a href="mailto:mauricio.pinheiro@gmail.com">Mauricio Costa Pinheiro</a>
 * @version %I%, %G%
 */
public class CarteiraManagerImplTest extends BaseManagerMockTestCase {
	// ~ Instance fields
	// ========================================================

	private CarteiraManagerImpl carteiraManager = null;

	private Mock carteiraDao = null;

	private Carteira carteira;

	// ~ Methods
	// ================================================================

	protected void setUp() throws Exception {
		super.setUp();
		carteiraDao = new Mock(CarteiraDao.class);
		carteiraManager = new CarteiraManagerImpl((CarteiraDao) carteiraDao
				.proxy());
	}

	protected void tearDown() throws Exception {
		super.tearDown();
		carteiraManager = null;
	}

	/**
	 * @throws Exception
	 */
	public void testGetCarteira() throws Exception {
		Carteira testData = new Carteira();
		testData.setId(new Long(1));
		// set expected behavior on dao
		carteiraDao.expects(once()).method("getCarteira").with(eq(new Long(1)))
				.will(returnValue(testData));

		Carteira carteira = carteiraManager.getCarteira("1");
		assertTrue(carteira != null);
		carteiraDao.verify();
	}

	/**
	 * @throws Exception
	 */
	public void testGetCarteiras() throws Exception {
		List results = new ArrayList();
		carteira = new Carteira();
		results.add(carteira);

		// set expected behavior on dao
		carteiraDao.expects(once()).method("getCarteiras").will(
				returnValue(results));

		List carteiras = carteiraManager.getCarteiras(null);
		assertTrue(carteiras.size() == 1);
		carteiraDao.verify();
	}

	public void testSaveCarteira() throws Exception {
		Carteira testData = new Carteira();
		testData.setId(new Long(1));
		// set expected behavior on dao
		carteiraDao.expects(once()).method("getCarteira").with(eq(new Long(1)))
				.will(returnValue(testData));

		Carteira carteira = carteiraManager.getCarteira("1");
		carteira.setRendimento(new Double(567));
		carteiraDao.verify();

		// reset expectations
		carteiraDao.reset();
		carteiraDao.expects(once()).method("saveCarteira").with(same(carteira));

		carteiraManager.saveCarteira(carteira);
		assertTrue(carteira.getRendimento().equals(new Double(567)));
		carteiraDao.verify();
	}

	public void testAddAndRemoveCarteira() throws Exception {
		Carteira carteira = new Carteira();
		// call populate method in super class to populate test data
		// from a properties file matching this class name
		// carteira = (Carteira) populate(carteira);
		carteira.setRendimento(new Double(11));
		carteira.setDataCarteira(new Date(345));
		// carteira.setProfile(null);

		// set expected behavior on carteira dao
		carteiraDao.expects(once()).method("saveCarteira").with(same(carteira));

		carteiraManager.saveCarteira(carteira);
		assertTrue(carteira.getDataCarteira().equals(new Date(345)));
		carteiraDao.verify();

		// reset expectations
		carteiraDao.reset();

		carteiraDao.expects(once()).method("removeCarteira").with(
				eq(new Long(5)));
		carteiraManager.removeCarteira("5");
		carteiraDao.verify();

		// reset expectations
		carteiraDao.reset();
		carteiraDao.expects(once()).method("getCarteira").will(
				returnValue(null));
		carteira = carteiraManager.getCarteira("5");
		assertNull(carteira);
		carteiraDao.verify();
	}
}
