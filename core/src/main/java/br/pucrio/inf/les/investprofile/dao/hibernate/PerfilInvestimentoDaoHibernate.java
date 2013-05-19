package br.pucrio.inf.les.investprofile.dao.hibernate;

import java.util.List;

import org.springframework.orm.ObjectRetrievalFailureException;

import br.pucrio.inf.les.investprofile.dao.PerfilInvestimentoDao;
import br.pucrio.inf.les.investprofile.model.PerfilInvestimento;

/**
 * This class interacts with Spring's HibernateTemplate to save/delete and
 * retrieve PerfilInvestimento objects.
 * 
 * <p>
 * <a href="PerfilInvestimentoDaoHibernate.java.html"><i>View Source</i></a>
 * </p>
 * 
 * @author <a href="mailto:mauricio.pinheiro@gmail.com">Mauricio Pinheiro</a>
 */
public class PerfilInvestimentoDaoHibernate extends
		GenericDaoHibernate<PerfilInvestimento, Long> implements
		PerfilInvestimentoDao {
	/**
	 * Constructor that sets the entity to PerfilInvestimento.class.
	 */
	public PerfilInvestimentoDaoHibernate() {
		super(PerfilInvestimento.class);
	}

	/**
	 * @see br.pucrio.inf.les.profile.dao.PerfilInvestimentoDao#getProfile(Long)
	 */
	public PerfilInvestimento getPerfilInvestimento(Long id) {
		PerfilInvestimento PerfilInvestimento = (PerfilInvestimento) getHibernateTemplate()
				.get(PerfilInvestimento.class, id);

		if (PerfilInvestimento == null) {
			log.warn("uh oh, PerfilInvestimento '" + id + "' not found...");
			throw new ObjectRetrievalFailureException(PerfilInvestimento.class,
					id);
		}

		return PerfilInvestimento;
	}

	/**
	 * @see br.pucrio.inf.les.PerfilInvestimento.dao.PerfilInvestimentoDao#getPerfilInvestimentoPorNome(String)
	 */
	public PerfilInvestimento getPerfilInvestimentoPorNome(String nome) {
		List PerfilInvestimentos = getHibernateTemplate().find(
				"from PerfilInvestimento i where i.nome=?", nome);
		if (PerfilInvestimentos.isEmpty()) {
			return null;
		} else {
			return (PerfilInvestimento) PerfilInvestimentos.get(0);
		}
	}

	/**
	 * @see br.pucrio.inf.les.PerfilInvestimento.dao.PerfilInvestimentoDao#getPerfisInvestimentosPorIdUsuario(Long)
	 */
	@SuppressWarnings("unchecked")
	public List<PerfilInvestimento> getPerfisInvestimentosPorIdUsuario(Long id) {
		return getHibernateTemplate()
				.find(
						"select perfisinvestimentos from User user inner join user.perfisInvestimentos perfisinvestimentos where user.id=?",
						id);
	}

	/**
	 * @see br.pucrio.inf.les.PerfilInvestimento.dao.PerfilInvestimentoDao#getPerfisInvestimentos(br.pucrio.inf.les.PerfilInvestimento.model.PerfilInvestimento)
	 */
	@SuppressWarnings("unchecked")
	public List<PerfilInvestimento> getPerfisInvestimentos(
			PerfilInvestimento PerfilInvestimento) {
		return getHibernateTemplate().find(
				"from PerfilInvestimento p order by upper(p.nome)");
	}

	/**
	 * @see br.pucrio.inf.les.PerfilInvestimento.dao.PerfilInvestimentoDao#saveProfile(br.pucrio.inf.les.PerfilInvestimento.model.PerfilInvestimento)
	 */
	public void savePerfilInvestimento(
			final PerfilInvestimento PerfilInvestimento) {
		if (log.isDebugEnabled()) {
			log.debug("PerfilInvestimento's id: " + PerfilInvestimento.getId());
		}

		getHibernateTemplate().saveOrUpdate(PerfilInvestimento);
		// necessary to throw a DataIntegrityViolation and catch it in
		// ProfileManager
		getHibernateTemplate().flush();
	}

	/**
	 * @see br.pucrio.inf.les.PerfilInvestimento.dao.PerfilInvestimentoDao#removeProfile(Long)
	 */
	public void removePerfilInvestimento(Long PerfilInvestimentoId) {
		getHibernateTemplate().delete(
				getPerfilInvestimento(PerfilInvestimentoId));
	}
}
