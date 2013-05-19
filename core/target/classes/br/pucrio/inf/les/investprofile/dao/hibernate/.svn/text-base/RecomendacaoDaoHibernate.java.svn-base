package br.pucrio.inf.les.investprofile.dao.hibernate;

import java.util.List;

import org.springframework.orm.ObjectRetrievalFailureException;

import br.pucrio.inf.les.investprofile.dao.RecomendacaoDao;
import br.pucrio.inf.les.investprofile.model.Recomendacao;

/**
 * This class interacts with Spring's HibernateTemplate to save/delete and
 * retrieve AcaoRecomendacao objects.
 * 
 * <p>
 * <a href="AcaoRecomendacaoDaoHibernate.java.html"><i>View Source</i></a>
 * </p>
 * 
 * @author <a href="mailto:mauricio.pinheiro@gmail.com">Mauricio Pinheiro</a>
 */
public class RecomendacaoDaoHibernate extends
		GenericDaoHibernate<Recomendacao, Long> implements RecomendacaoDao {

	/**
	 * Constructor that sets the entity to AcaoRecomendacao.class.
	 */
	public RecomendacaoDaoHibernate() {
		super(Recomendacao.class);
	}

	/**
	 * @see br.pucrio.inf.les.portfolio.dao.RecomendacaoDao#getRecomendacao(Long)
	 */
	public Recomendacao getRecomendacao(Long recomendacaoId) {
		Recomendacao acaoRecomendacao = (Recomendacao) getHibernateTemplate()
				.get(Recomendacao.class, recomendacaoId);

		if (acaoRecomendacao == null) {
			log.warn("uh oh, Recomendacao '" + recomendacaoId
					+ "' not found...");
			throw new ObjectRetrievalFailureException(Recomendacao.class,
					recomendacaoId);
		}
		return acaoRecomendacao;
	}

	/**
	 * @see br.pucrio.inf.les.Recomendacao.dao.RecomendacaoDao#getRecomendacoes(br.pucrio.inf.les.investprofile.model.Recomendacao)
	 */
	@SuppressWarnings("unchecked")
	public List<Recomendacao> getRecomendacoes(Recomendacao recomendacao) {
		return getHibernateTemplate().find(
				"from Recomendacao o order by upper(o.id)");
	}

	/**
	 * @see br.pucrio.inf.les.Recomendacao.dao.RecomendacaoDao#saveAcaoRecomendacao(br.pucrio.inf.les.Recomendacao.model.AcaoRecomendacao)
	 */
	public void saveRecomendacao(final Recomendacao recomendacao) {
		if (log.isDebugEnabled()) {
			log.debug("Recomendacao's id: " + recomendacao.getId() + " saved.");
		}

		getHibernateTemplate().saveOrUpdate(recomendacao);
		getHibernateTemplate().flush();
	}

	/**
	 * @see br.pucrio.inf.les.Recomendacao.dao.RecomendacaoDao#removeAcaoRecomendacao(Long)
	 */
	public void removeRecomendacao(Long recomendacaoId) {
		getHibernateTemplate().delete(getRecomendacao(recomendacaoId));
	}
}
