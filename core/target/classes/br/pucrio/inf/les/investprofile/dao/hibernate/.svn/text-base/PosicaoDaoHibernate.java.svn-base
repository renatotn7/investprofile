package br.pucrio.inf.les.investprofile.dao.hibernate;

import java.util.List;

import org.springframework.orm.ObjectRetrievalFailureException;

import br.pucrio.inf.les.investprofile.dao.PosicaoDao;
import br.pucrio.inf.les.investprofile.model.Posicao;

/**
 * This class interacts with Spring's HibernateTemplate to save/delete and
 * retrieve Posicao objects.
 * 
 * <p>
 * <a href="PosicaoDaoHibernate.java.html"><i>View Source</i></a>
 * </p>
 * 
 * @author <a href="mailto:mauricio.pinheiro@gmail.com">Mauricio Pinheiro</a>
 */
public class PosicaoDaoHibernate extends
		GenericDaoHibernate<Posicao, Long> implements PosicaoDao {

	/**
	 * Constructor that sets the entity to AcaoCarteira.class.
	 */
	public PosicaoDaoHibernate() {
		super(Posicao.class);
	}

	/**
	 * @see br.pucrio.inf.les.portfolio.dao.PosicaoDao#getPosicao(Long)
	 */
	public Posicao getPosicao(Long id) {
		Posicao posicao = (Posicao) getHibernateTemplate().get(
				Posicao.class, id);

		if (posicao == null) {
			log.warn("uh oh, Posicao '" + id + "' not found...");
			throw new ObjectRetrievalFailureException(Posicao.class, id);
		}
		return posicao;
	}

	/**
	 * @see br.pucrio.inf.les.Posicao.dao.PosicaoDao#getPosicoes(br.pucrio.inf.les.investprofile.model.Posicao)
	 */
	@SuppressWarnings("unchecked")
	public List<Posicao> getPosicoes(Posicao posicao) {
		return getHibernateTemplate().find(
				"from Posicao p order by upper(p.quantidade)");
	}

	/**
	 * @see br.pucrio.inf.les.Posicao.dao.PosicaoDao#getPosicaoPorPerfil(Long)
	 */
	public List<Posicao> getPosicoesPorPerfil(Long idPerfilInvestimento) {
		List<Posicao> posicoes = getHibernateTemplate()
				.find(
						"select c.posicoes from Perfilinvestimento as p inner join p.carteira as c where p.idPerfilInvestimento=?",
						idPerfilInvestimento);
		if (posicoes == null || posicoes.isEmpty()) {
			throw new ObjectRetrievalFailureException(Posicao.class, idPerfilInvestimento);
		} else {
			return posicoes;
		}
	}

	/**
	 * @see br.pucrio.inf.les.Posicao.dao.PosicaoDao#savePosicao(br.pucrio.inf.les.investprofile.model.Posicao)
	 */
	public void savePosicao(final Posicao posicao) {
		if (log.isDebugEnabled()) {
			log.debug("AcaoCarteira's id: " + posicao.getId());
		}

		getHibernateTemplate().saveOrUpdate(posicao);
		getHibernateTemplate().flush();
	}

	/**
	 * @see br.pucrio.inf.les.Posicao.dao.PosicaoDao#removePosicao(Long)
	 */
	public void removePosicao(Long id) {
		getHibernateTemplate().delete(getPosicao(id));
	}
}
