package br.pucrio.inf.les.investprofile.dao.hibernate;

import java.util.Date;
import java.util.List;

import org.springframework.orm.ObjectRetrievalFailureException;

import br.pucrio.inf.les.investprofile.dao.CotacaoDao;
import br.pucrio.inf.les.investprofile.model.Acao;
import br.pucrio.inf.les.investprofile.model.Cotacao;

/**
 * This class interacts with Spring's HibernateTemplate to save/delete and
 * retrieve Cotacao objects.
 * 
 * <p>
 * <a href="CotacaoDaoHibernate.java.html"><i>View Source</i></a>
 * </p>
 * 
 * @author <a href="mailto:mauricio.pinheiro@gmail.com">Mauricio Pinheiro</a>
 */
public class CotacaoDaoHibernate extends GenericDaoHibernate<Cotacao, Long>
		implements CotacaoDao {
	/**
	 * Constructor that sets the entity to Cotacao.class.
	 */
	public CotacaoDaoHibernate() {
		super(Cotacao.class);
	}

	/**
	 * @see br.pucrio.inf.les.profile.dao.CotacaoDao#getCotacao(Long)
	 */
	public Cotacao getCotacao(Long id) {
		Cotacao Cotacao = (Cotacao) getHibernateTemplate().get(Cotacao.class,
				id);
		/*
		if (Cotacao == null) {
			log.warn("uh oh, Cotacao '" + id + "' not found...");
			throw new ObjectRetrievalFailureException(Cotacao.class, id);
		}
		*/
		return Cotacao;
	}

	/**
	 * @see br.pucrio.inf.les.Cotacao.dao.CotacaoDao#getPrimeiraCotacaoAcao(String)
	 */
	public Cotacao getPrimeiraCotacaoAcao(String codigoBovespa) {
		List cotacoes = getHibernateTemplate()
				.find(
						"select co from Cotacao as co inner join co.acao as acao where acao.codigoBovespa=? order by dataPregao asc",
						codigoBovespa);
		if (cotacoes.isEmpty()) {
			return null;
		} else {
			return (Cotacao) cotacoes.get(0);
		}
	}

	/**
	 * @see br.pucrio.inf.les.Cotacao.dao.CotacaoDao#getUltimaCotacaoAcao(String)
	 */
	public Cotacao getUltimaCotacaoAcao(String codigoBovespa) {
		List cotacoes = getHibernateTemplate()
				.find(
						"select co from Cotacao as co inner join co.acao as acao where acao.codigoBovespa=? order by dataPregao desc",
						codigoBovespa);
		if (cotacoes.isEmpty()) {
			return null;
		} else {
			return (Cotacao) cotacoes.get(0);
		}
	}

	/**
	 * @see br.pucrio.inf.les.Cotacao.dao.CotacaoDao#getCotacoesPorCodigoBovespa(String)
	 */
	@SuppressWarnings("unchecked")
	public List<Cotacao> getCotacoesPorCodigoBovespa(String codigoBovespa) {
		return getHibernateTemplate()
				.find(
						"select co from Cotacao as co inner join co.acao as acao where acao.codigoBovespa=? order by co.dataPregao DESC",
						codigoBovespa);
	}

	/**
	 * @see br.pucrio.inf.les.Cotacao.dao.CotacaoDao#getCotacoesPorCodigoBovespaDesde(String,
	 *      Date)
	 */
	@SuppressWarnings("unchecked")
	public List<Cotacao> getCotacoesPorCodigoBovespaDesde(String codigoBovespa,
			Date dataInicio) {
		Object[] args = { codigoBovespa, dataInicio };
		return getHibernateTemplate()
				.find(
						"select co from Cotacao as co inner join co.acao as acao where acao.codigoBovespa=? and co.dataPregao>=? order by co.dataPregao",
						args);
	}

	/**
	 * @see br.pucrio.inf.les.Cotacao.dao.CotacaoDao#getCotacoesAcao(br.pucrio.inf.les.investprofile.model.Acao)
	 */
	@SuppressWarnings("unchecked")
	public List<Cotacao> getCotacoesAcao(Acao acao) {
		return getHibernateTemplate().find("from Cotacao where acao.id=?",
				acao.getId());
	}

	/**
	 * @see br.pucrio.inf.les.Cotacao.dao.CotacaoDao#getCotacoesAcaoEm(br.pucrio.inf.les.investprofile.model.Acao,
	 *      Date)
	 */
	@SuppressWarnings("unchecked")
	public List<Cotacao> getCotacoesAcaoEm(Acao acao, Date em) {
		Object[] args = { acao.getId(), em };
		return getHibernateTemplate().find(
				"from Cotacao where acao.id=? and dataPregao=?", args);
	}

	/**
	 * @see br.pucrio.inf.les.Cotacao.dao.CotacaoDao#getCotacoes(br.pucrio.inf.les.investprofile.model.Cotacao)
	 */
	@SuppressWarnings("unchecked")
	public List<Cotacao> getCotacoes(Cotacao cotacao) {
		return getHibernateTemplate().find(
				"from Cotacao s order by upper(s.acao.codigoBovespa)");
	}

	/**
	 * @see br.pucrio.inf.les.Cotacao.dao.CotacaoDao#saveCotacao(br.pucrio.inf.les.investprofile.model.Cotacao)
	 */
	public void saveCotacao(final Cotacao acao) {
		if (log.isDebugEnabled()) {
			log.debug("Cotacao's id: " + acao.getId());
		}

		getHibernateTemplate().saveOrUpdate(acao);
		// necessary to throw a DataIntegrityViolation and catch it in
		// CotacaoManager
		getHibernateTemplate().flush();
	}

	/**
	 * @see br.pucrio.inf.les.Cotacao.dao.CotacaoDao#removeCotacao(Long)
	 */
	public void removeCotacao(Long id) {
		getHibernateTemplate().delete(getCotacao(id));
	}
}
