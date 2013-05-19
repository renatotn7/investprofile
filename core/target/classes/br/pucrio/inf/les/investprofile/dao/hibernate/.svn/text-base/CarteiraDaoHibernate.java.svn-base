package br.pucrio.inf.les.investprofile.dao.hibernate;

import java.util.List;

import org.springframework.orm.ObjectRetrievalFailureException;

import br.pucrio.inf.les.investprofile.dao.CarteiraDao;
import br.pucrio.inf.les.investprofile.model.Carteira;

/**
 * This class interacts with Spring's HibernateTemplate to save/delete and
 * retrieve Carteira objects.
 * 
 * <p>
 * <a href="CarteiraDaoHibernate.java.html"><i>View Source</i></a>
 * </p>
 * 
 * @author <a href="mailto:mauricio.pinheiro@gmail.com">Mauricio Pinheiro</a>
 */
public class CarteiraDaoHibernate extends GenericDaoHibernate<Carteira, Long>
		implements CarteiraDao {
	/**
	 * Constructor that sets the entity to Carteira.class.
	 */
	public CarteiraDaoHibernate() {
		super(Carteira.class);
	}

	/**
	 * @see br.pucrio.inf.les.Carteira.dao.CarteiraDao#getCarteira(Long)
	 */
	public Carteira getCarteira(Long CarteiraId) {
		Carteira Carteira = (Carteira) getHibernateTemplate().get(
				Carteira.class, CarteiraId);

		if (Carteira == null) {
			log.warn("uh oh, Carteira '" + CarteiraId + "' not found...");
			throw new ObjectRetrievalFailureException(Carteira.class,
					CarteiraId);
		}

		return Carteira;
	}

	/**
	 * @see br.pucrio.inf.les.Carteira.dao.CarteiraDao#getCarteiras(br.pucrio.inf.les.investprofile.model.Carteira)
	 */
	@SuppressWarnings("unchecked")
	public List<Carteira> getCarteiras(Carteira Carteira) {
		return getHibernateTemplate().find(
				"from Carteira p order by upper(p.dataCarteira)");
	}

	/**
	 * @see br.pucrio.inf.les.Carteira.dao.CarteiraDao#saveCarteira(br.pucrio.inf.les.investprofile.model.Carteira)
	 */
	public void saveCarteira(final Carteira Carteira) {
		if (log.isDebugEnabled()) {
			log.debug("Carteira's id: " + Carteira.getId());
		}

		getHibernateTemplate().saveOrUpdate(Carteira);
		// necessary to throw a DataIntegrityViolation and catch it in
		// CarteiraManager
		getHibernateTemplate().flush();
	}

	/**
	 * @see br.pucrio.inf.les.Carteira.dao.CarteiraDao#removeCarteira(Long)
	 */
	public void removeCarteira(Long CarteiraId) {
		getHibernateTemplate().delete(getCarteira(CarteiraId));
	}
}
