package br.pucrio.inf.les.investprofile.dao.hibernate;

import java.util.List;

import org.springframework.orm.ObjectRetrievalFailureException;

import br.pucrio.inf.les.investprofile.dao.QuestaoDao;
import br.pucrio.inf.les.investprofile.model.Questao;

/**
 * This class interacts with Spring's HibernateTemplate to save/delete and
 * retrieve Questao objects.
 * 
 * <p>
 * <a href="QuestaoDaoHibernate.java.html"><i>View Source</i></a>
 * </p>
 * 
 * @author <a href="mailto:mauricio.pinheiro@gmail.com">Mauricio Pinheiro</a>
 */
public class QuestaoDaoHibernate extends GenericDaoHibernate<Questao, Long>
		implements QuestaoDao {
	/**
	 * Constructor that sets the entity to Cotacao.class.
	 */
	public QuestaoDaoHibernate() {
		super(Questao.class);
	}

	/**
	 * @see br.pucrio.inf.les.profile.dao.QuestaoDao#getQuestao(Long)
	 */
	public Questao getQuestao(Long id) {
		Questao Questao = (Questao) getHibernateTemplate().get(Questao.class,
				id);
		if (Questao == null) {
			log.warn("uh oh, Questao '" + id + "' not found...");
			throw new ObjectRetrievalFailureException(Questao.class, id);
		}
		return Questao;
	}

	/**
	 * @see br.pucrio.inf.les.Questao.dao.QuestaoDao#getQuestaoPorTrechoPergunta(String)
	 */
	public Questao getQuestaoPorTrechoPergunta(String questao) {
		List opcoes = getHibernateTemplate().findByNamedParam(
				"from Questao where pergunta like :questao",
				new String("questao"), new String("%" + questao + "%"));
		if (opcoes.isEmpty()) {
			return null;
		} else {
			return (Questao) opcoes.get(0);
		}
	}

	/**
	 * @see br.pucrio.inf.les.Questao.dao.QuestaoDao#getQuestoes(br.pucrio.inf.les.investprofile.model.Questao)
	 */
	@SuppressWarnings("unchecked")
	public List<Questao> getQuestoes(Questao questao) {
		return getHibernateTemplate().find(
				"from Questao s order by upper(s.pergunta)");
	}

	/**
	 * @see br.pucrio.inf.les.Questao.dao.QuestaoDao#saveQuestao(br.pucrio.inf.les.investprofile.model.Questao)
	 */
	public void saveQuestao(final Questao questao) {
		if (log.isDebugEnabled()) {
			log.debug("Questao's id: " + questao.getId());
		}

		getHibernateTemplate().saveOrUpdate(questao);
		// necessary to throw a DataIntegrityViolation and catch it in
		// QuestaoManager
		getHibernateTemplate().flush();
	}

	/**
	 * @see br.pucrio.inf.les.Questao.dao.QuestaoDao#removeQuestao(Long)
	 */
	public void removeQuestao(Long id) {
		getHibernateTemplate().delete(getQuestao(id));
	}
}
