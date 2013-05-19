package br.pucrio.inf.les.investprofile.dao.hibernate;

import java.util.List;

import org.springframework.orm.ObjectRetrievalFailureException;

import br.pucrio.inf.les.investprofile.dao.RespostaDao;
import br.pucrio.inf.les.investprofile.model.Resposta;

/**
 * This class interacts with Spring's HibernateTemplate to save/delete and
 * retrieve Resposta objects.
 * 
 * <p>
 * <a href="RespostaDaoHibernate.java.html"><i>View Source</i></a>
 * </p>
 * 
 * @author <a href="mailto:mauricio.pinheiro@gmail.com">Mauricio Pinheiro</a>
 */
public class RespostaDaoHibernate extends GenericDaoHibernate<Resposta, Long>
		implements RespostaDao {

	/**
	 * Constructor that sets the entity to Cotacao.class.
	 */
	public RespostaDaoHibernate() {
		super(Resposta.class);
	}

	/**
	 * @see br.pucrio.inf.les.profile.dao.RespostaDao#getResposta(Long)
	 */
	public Resposta getResposta(Long id) {
		Resposta Resposta = (Resposta) getHibernateTemplate().get(
				Resposta.class, id);
		if (Resposta == null) {
			log.warn("uh oh, Resposta '" + id + "' not found...");
			throw new ObjectRetrievalFailureException(Resposta.class, id);
		}
		return Resposta;
	}

	/**
	 * @see br.pucrio.inf.les.Resposta.dao.RespostaDao#getRespostaPorTrechoResposta(String)
	 */
	public Resposta getRespostaPorTrechoResposta(String conteudo) {
		List respostas = getHibernateTemplate().findByNamedParam(
				"from Resposta where conteudo like :conteudo",
				new String("conteudo"), new String("%" + conteudo + "%"));
		if (respostas.isEmpty()) {
			return null;
		} else {
			return (Resposta) respostas.get(0);
		}
	}

	/**
	 * @see br.pucrio.inf.les.Resposta.dao.RespostaDao#getRespostas(br.pucrio.inf.les.investprofile.model.Resposta)
	 */
	@SuppressWarnings("unchecked")
	public List<Resposta> getRespostas(Resposta resposta) {
		return getHibernateTemplate().find(
				"from Resposta s order by upper(s.conteudo)");
	}

	/**
	 * @see br.pucrio.inf.les.Resposta.dao.RespostaDao#saveResposta(br.pucrio.inf.les.investprofile.model.Resposta)
	 */
	public void saveResposta(final Resposta resposta) {
		if (log.isDebugEnabled()) {
			log.debug("Resposta's id: " + resposta.getId());
		}

		getHibernateTemplate().saveOrUpdate(resposta);
		// necessary to throw a DataIntegrityViolation and catch it in
		// RespostaManager
		getHibernateTemplate().flush();
	}

	/**
	 * @see br.pucrio.inf.les.Resposta.dao.RespostaDao#removeResposta(Long)
	 */
	public void removeResposta(Long id) {
		getHibernateTemplate().delete(getResposta(id));
	}
}
