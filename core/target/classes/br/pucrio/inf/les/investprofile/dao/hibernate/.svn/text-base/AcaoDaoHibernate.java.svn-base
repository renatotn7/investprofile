package br.pucrio.inf.les.investprofile.dao.hibernate;

import java.util.List;

import org.springframework.orm.ObjectRetrievalFailureException;

import br.pucrio.inf.les.investprofile.dao.AcaoDao;
import br.pucrio.inf.les.investprofile.model.Acao;

/**
 * This class interacts with Spring's HibernateTemplate to save/delete and
 * retrieve Acao objects.
 * 
 * <p>
 * <a href="AcaoDaoHibernate.java.html"><i>View Source</i></a>
 * </p>
 * 
 * @author <a href="mailto:mauricio.pinheiro@gmail.com">Mauricio Pinheiro</a>
 */
public class AcaoDaoHibernate extends GenericDaoHibernate<Acao, Long> implements
		AcaoDao {

	/**
	 * Constructor that sets the entity to Acao.class.
	 */
	public AcaoDaoHibernate() {
		super(Acao.class);
	}

	/**
	 * @see br.pucrio.inf.les.investprofile.dao.AcaoDao#getAcao(Long)
	 */
	public Acao getAcao(Long id) {
		Acao acao = (Acao) getHibernateTemplate().get(Acao.class, id);
		return acao;
	}

	/**
	 * @see br.pucrio.inf.les.investprofile.dao.AcaoDao#getAcaoPorNome(String)
	 */
	public Acao getAcaoPorNome(String nome) {
		List acoes = getHibernateTemplate()
				.find("from Acao where nome=?", nome);
		if (acoes.isEmpty()) {
			return null;
		} else {
			return (Acao) acoes.get(0);
		}
	}

	/**
	 * @see br.pucrio.inf.les.investprofile.dao.AcaoDao#getAcaoPorCodigoBovespa(String)
	 */
	public Acao getAcaoPorCodigoBovespa(String codigoBovespa) {
		List acoes = getHibernateTemplate()
				.find(
						"from Acao where codigoBovespa=? order by dataInicioPregao DESC",
						codigoBovespa);
		if (acoes.isEmpty()) {
			return null;
		} else {
			return (Acao) acoes.get(0);
		}
	}

	/**
	 * @see br.pucrio.inf.les.investprofile.dao.AcaoDao#getAcoes(br.pucrio.inf.les.investprofile.model.Acao)
	 */
	@SuppressWarnings("unchecked")
	public List<Acao> getAcoes(Acao acao) {
		return getHibernateTemplate().find(
				"from Acao s order by upper(s.codigoBovespa)");
	}

	/**
	 * @see br.pucrio.inf.les.investprofile.dao.AcaoDao#saveAcao(br.pucrio.inf.les.investprofile.model.Acao)
	 */
	public void saveAcao(final Acao acao) {
		if (log.isDebugEnabled()) {
			log.debug("Acao's id: " + acao.getId());
		}

		getHibernateTemplate().saveOrUpdate(acao);
		// necessary to throw a DataIntegrityViolation and catch it in
		// AcaoManager
		getHibernateTemplate().flush();
	}

	/**
	 * @see br.pucrio.inf.les.investprofile.dao.AcaoDao#removeAcao(Long)
	 */
	public void removeAcao(Long id) {
		getHibernateTemplate().delete(getAcao(id));
	}
}
