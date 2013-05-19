package br.pucrio.inf.les.investprofile.dao.hibernate;

import java.util.List;

import br.pucrio.inf.les.investprofile.dao.RecomendacaoPerfilDao;
import br.pucrio.inf.les.investprofile.model.RecomendacaoAnalista;
import br.pucrio.inf.les.investprofile.model.RecomendacaoPerfil;

/**
 * This class interacts with Spring's HibernateTemplate to retrieve
 * CarteiraAtual objects.
 * 
 * <p>
 * <a href="CarteiraAtualDaoHibernate.java.html"><i>View Source</i></a>
 * </p>
 * 
 * @author <a href="mailto:mauricio.pinheiro@gmail.com">Mauricio Pinheiro</a>
 */
public class RecomendacaoPerfilDaoHibernate extends
		GenericDaoHibernate<RecomendacaoPerfil, Long> implements
		RecomendacaoPerfilDao {

	/**
	 * Constructor that sets the entity to CarteiraAtual.class.
	 */
	public RecomendacaoPerfilDaoHibernate() {
		super(RecomendacaoPerfil.class);
	}

	/**
	 * @see br.pucrio.inf.les.investprofile.dao.RecomendacaoPerfilDao#getRecomendacaoPerfil(Long)
	 */
	public RecomendacaoPerfil getRecomendacaoPerfil(Long id) {
		RecomendacaoPerfil recomendacaoPerfil = (RecomendacaoPerfil) getHibernateTemplate()
				.get(RecomendacaoPerfil.class, id);
		return recomendacaoPerfil;
	}

	/**
	 * @see br.pucrio.inf.les.investprofile.dao.RecomendacaoPerfilDao#getRecomendacoesPerfil(Long)
	 */
	@SuppressWarnings("unchecked")
	public List<RecomendacaoPerfil> getRecomendacoesPerfil(
			Long idPerfilInvestimento) {
		if (log.isDebugEnabled()) {
			log.debug("obtendo todas as ações de uma carteira...");
		}
		return getHibernateTemplate()
				.find(
						"select rp from RecomendacaoPerfil as rp inner join rp.perfilinvestimento as pi where pi.id=? order by rp.data",
						idPerfilInvestimento);
	}

	/**
	 * @see br.pucrio.inf.les.investprofile.dao.RecomendacaoAnalistaDao#getRecomendacoesAnalistas(br.pucrio.inf.les.investprofile.model.RecomendacaoAnalista)
	 */
	@SuppressWarnings("unchecked")
	public List<RecomendacaoPerfil> getRecomendacoesPerfis(
			RecomendacaoPerfil recomendacaoPerfil) {
		return getHibernateTemplate().find(
				"from RecomendacaoPerfil s order by upper(s.data)");
	}

	/**
	 * @see br.pucrio.inf.les.investprofile.dao.RecomendacaoPerfilDao#saveRecomendacaoPerfil(br.pucrio.inf.les.investprofile.model.RecomendacaoPerfil)
	 */
	public void saveRecomendacaoPerfil(
			final RecomendacaoPerfil recomendacaoPerfil) {
		if (log.isDebugEnabled()) {
			log.debug("Acao's id: " + recomendacaoPerfil.getId());
		}

		getHibernateTemplate().saveOrUpdate(recomendacaoPerfil);
		// necessary to throw a DataIntegrityViolation and catch it in
		// RecomendacaoPerfilManager
		getHibernateTemplate().flush();
	}

	/**
	 * @see br.pucrio.inf.les.investprofile.dao.RecomendacaoPerfilDao#removeRecomendacaoPerfil(Long)
	 */
	public void removeRecomendacaoPerfil(Long idRecomendacaoPerfil) {
		getHibernateTemplate().delete(
				getRecomendacaoPerfil(idRecomendacaoPerfil));
	}
}
