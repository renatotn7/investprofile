package br.pucrio.inf.les.investprofile.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import br.com.ur2.libs.Data;
import br.pucrio.inf.les.investprofile.model.Carteira;

/**
 * @author Jonny
 * 
 */
public class CarteiraDaoTest extends BaseDaoTestCase {
	private Carteira carteira = null;

	private CarteiraDao dao = null;

	private PerfilInvestimentoDao perfilInvestimentoDao = null;

	/**
	 * @param dao
	 */
	public void setPerfilInvestimentoDao(PerfilInvestimentoDao dao) {
		this.perfilInvestimentoDao = dao;
	}

	/**
	 * @param dao
	 */
	public void setCarteiraDao(CarteiraDao dao) {
		this.dao = dao;
	}

	/**
	 * @throws Exception
	 */
	public void testGetCarteiraInvalid() throws Exception {
		try {
			carteira = dao.getCarteira(new Long(7));
			fail("'carteira.id 7' found in database, failing test...");
		} catch (DataAccessException d) {
			assertTrue(d != null);
		}
	}

	/**
	 * @throws Exception
	 */
	public void testGetCarteira() throws Exception {
		Long id = new Long(1);
		carteira = dao.getCarteira(id);
		assertNotNull(carteira);
	}

	/**
	 * 
	 */
	public void testGetCarteiras() {
		carteira = new Carteira();
		List results = dao.getCarteiras(carteira);
		assertTrue(results.size() > 0);
	}

	/**
	 * @throws Exception
	 */
	public void testUpdateCarteira() throws Exception {
		carteira = dao.getCarteira(new Long(1));
		log.debug(carteira);
		carteira.setRendimento(new Double(453));

		dao.saveCarteira(carteira);

		assertEquals(dao.getCarteira(new Long(1)).getRendimento(), new Double(
				453));
	}

	/**
	 * @throws Exception
	 */
	public void testAddAndRemoveCarteira() throws Exception {
		Long id = null;
		carteira = new Carteira();
		carteira.setId(null);
		carteira.setRendimento(12D);
		carteira.setDataCarteira(Data.criaData(2007, 11, 20));
		carteira.setPerfilInvestimento(perfilInvestimentoDao.getPerfilInvestimento(4L));
		dao.saveCarteira(carteira);
		assertNotNull(carteira.getId());

		id = carteira.getId();

		dao.removeCarteira(id);

		endTransaction();

		try {
			carteira = dao.getCarteira(id);
			fail("'carteiraid ' found in database, failing test...");
		} catch (DataAccessException d) {
			assertTrue(d != null);
		}
	}
}
