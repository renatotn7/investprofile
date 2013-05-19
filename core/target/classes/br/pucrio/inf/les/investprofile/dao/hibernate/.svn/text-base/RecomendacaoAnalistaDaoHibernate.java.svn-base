package br.pucrio.inf.les.investprofile.dao.hibernate;

import java.util.List;

import br.pucrio.inf.les.investprofile.dao.RecomendacaoAnalistaDao;
import br.pucrio.inf.les.investprofile.model.RecomendacaoAnalista;

/**
 * This class interacts with Spring's HibernateTemplate to retrieve
 * RecomendacaoAnalista objects.
 * 
 * <p>
 * <a href="RecomendacaoAnalistaDaoHibernate.java.html"><i>View Source</i></a>
 * </p>
 * 
 * @author <a href="mailto:mauricio.pinheiro@gmail.com">Mauricio Pinheiro</a>
 */
public class RecomendacaoAnalistaDaoHibernate extends
		GenericDaoHibernate<RecomendacaoAnalista, Long> implements
		RecomendacaoAnalistaDao {
	/**
	 * Constructor that sets the entity to CarteiraRecomendada.class.
	 */
	public RecomendacaoAnalistaDaoHibernate() {
		super(RecomendacaoAnalista.class);
	}

	/**
	 * @see br.pucrio.inf.les.investprofile.dao.RecomendacaoAnalistaDao#getRecomendacaoAnalista(Long)
	 */
	public RecomendacaoAnalista getRecomendacaoAnalista(Long id) {
		RecomendacaoAnalista recomendacaoAnalista = (RecomendacaoAnalista) getHibernateTemplate()
				.get(RecomendacaoAnalista.class, id);
		return recomendacaoAnalista;
	}

	/**
	 * @see br.pucrio.inf.les.investprofile.dao.RecomendacaoAnalistaDao#getRecomendacoesAnalistasPorAcao(Long)
	 */
	@SuppressWarnings("unchecked")
	public List<RecomendacaoAnalista> getRecomendacoesAnalistasPorAcao(
			Long idAcao) {
		if (log.isDebugEnabled()) {
			log.debug("obtendo todas as recomendacoes de uma analista...");
		}

		return getHibernateTemplate()
				.find(
						"select ra from RecomendacaoAnalista ra inner join ra.acao ac where ac.id=? order by ra.data",
						idAcao);
	}

	/**
	 * @see br.pucrio.inf.les.investprofile.dao.RecomendacaoAnalistaDao#getRecomendacoesAnalistas(String)
	 */
	@SuppressWarnings("unchecked")
	public List<RecomendacaoAnalista> getRecomendacoesAnalista(String analista) {
		if (log.isDebugEnabled()) {
			log.debug("obtendo todas as recomendações de um analista...");
		}

		return getHibernateTemplate()
				.find(
						"select ra from RecomendacaoAnalista ra where ra.analista=? order by ra.data",
						analista);
	}

	/**
	 * @see br.pucrio.inf.les.investprofile.dao.RecomendacaoAnalistaDao#getRecomendacoesAnalistas(br.pucrio.inf.les.investprofile.model.RecomendacaoAnalista)
	 */
	@SuppressWarnings("unchecked")
	public List<RecomendacaoAnalista> getRecomendacoesAnalistas(
			RecomendacaoAnalista recomendacaoAnalista) {
		return getHibernateTemplate().find(
				"from RecomendacaoAnalista s order by upper(s.data)");
	}

	/**
	 * @see br.pucrio.inf.les.investprofile.dao.RecomendacaoAnalistaDao#saveRecomendacaoAnalista(br.pucrio.inf.les.investprofile.model.RecomendacaoAnalista)
	 */
	public void saveRecomendacaoAnalista(
			final RecomendacaoAnalista recomendacaoAnalista) {
		if (log.isDebugEnabled()) {
			log.debug("RecomendacaoAnalista's id: "
					+ recomendacaoAnalista.getId());
		}

		getHibernateTemplate().saveOrUpdate(recomendacaoAnalista);
		// necessary to throw a DataIntegrityViolation and catch it in
		// AcaoManager
		getHibernateTemplate().flush();
	}

	/**
	 * @see br.pucrio.inf.les.investprofile.dao.RecomendacaoAnalistaDao#removeRecomendacaoAnalista(Long)
	 */
	public void removeRecomendacaoAnalista(Long id) {
		getHibernateTemplate().delete(getRecomendacaoAnalista(id));
	}
}
