package br.pucrio.inf.les.investprofile.service.impl;

import java.util.List;

import org.springframework.dao.DataIntegrityViolationException;

import br.pucrio.inf.les.investprofile.dao.CarteiraDao;
import br.pucrio.inf.les.investprofile.model.Carteira;
import br.pucrio.inf.les.investprofile.service.CarteiraManager;

/**
 * Implementation of PortfolioManager interface.
 * </p>
 * <p>
 * <a href="CarteiraManagerImpl.java.html"><i>View Source</i></a>
 * </p>
 * 
 * @author <a href="mailto:mauricio.pinheiro@gmail.com">Mauricio Pinheiro</a>
 */
public class CarteiraManagerImpl extends GenericManagerImpl<Carteira, Long>
		implements CarteiraManager {
	private CarteiraDao dao;

	/**
	 * @param dao
	 *            Objeto de camada de dados de carteira
	 */
	public CarteiraManagerImpl(CarteiraDao dao) {
		super(dao);
		this.dao = dao;
	}

	/**
	 * Set the Dao for communication with the data layer.
	 * 
	 * @param dao
	 */
	public void setCarteiraDao(CarteiraDao dao) {
		this.dao = dao;
	}

	/**
	 * @see br.pucrio.inf.les.investprofile.service.CarteiraManager#getCarteira(java.lang.String)
	 */
	public Carteira getCarteira(String portfolioId) {
		return dao.getCarteira(new Long(portfolioId));
	}

	/**
	 * @see br.pucrio.inf.les.investprofile.service.CarteiraManager#getCarteiras(br.pucrio.inf.les.investprofile.model.Carteira)
	 */
	public List<Carteira> getCarteiras(Carteira carteira) {
		return dao.getCarteiras(carteira);
	}

	/**
	 * @see br.pucrio.inf.les.investprofile.service.CarteiraManager#saveCarteira(br.pucrio.inf.les.investprofile.model.Carteira)
	 */
	public void saveCarteira(Carteira portfolio) throws Exception {
		try {
			dao.saveCarteira(portfolio);
		} catch (DataIntegrityViolationException e) {
			throw new Exception("Carteira '" + portfolio.getId()
					+ "' already exists!");
		}
	}

	/**
	 * @see br.pucrio.inf.les.investprofile.service.CarteiraManager#removeCarteira(java.lang.String)
	 */
	public void removeCarteira(String portfolioId) {
		if (log.isDebugEnabled()) {
			log.debug("removing portfolio: " + portfolioId);
		}

		dao.removeCarteira(new Long(portfolioId));
	}
}
