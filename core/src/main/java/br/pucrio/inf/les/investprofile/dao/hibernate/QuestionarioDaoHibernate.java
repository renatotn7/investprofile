package br.pucrio.inf.les.investprofile.dao.hibernate;

import java.util.Iterator;
import java.util.List;

import org.springframework.orm.ObjectRetrievalFailureException;

import br.pucrio.inf.les.investprofile.dao.QuestionarioDao;
import br.pucrio.inf.les.investprofile.model.Questao;
import br.pucrio.inf.les.investprofile.model.Questionario;

/**
 * This class interacts with Spring's HibernateTemplate to save/delete and
 * retrieve Questionario objects.
 * 
 * <p>
 * <a href="QuestionarioDaoHibernate.java.html"><i>View Source</i></a>
 * </p>
 * 
 * @author <a href="mailto:mauricio.pinheiro@gmail.com">Mauricio Pinheiro</a>
 */
public class QuestionarioDaoHibernate extends
		GenericDaoHibernate<Questionario, Long> implements QuestionarioDao {

	/**
	 * Constructor that sets the entity to Cotacao.class.
	 */
	public QuestionarioDaoHibernate() {
		super(Questionario.class);
	}

	/**
	 * @see br.pucrio.inf.les.Questao.dao.QuestaoDao#getQuestionario(br.pucrio.inf.les.investprofile.model.Questao)
	 */
	public Questionario getQuestionario() {
		Questionario questionario = new Questionario();
		List questoes = getHibernateTemplate().find(
				"select s from Questao s inner join s.respostas r order by upper(s.pergunta), r.id");
		if (questoes.size() == 0) {
			log.warn("uh oh, Questionario not found...");
			throw new ObjectRetrievalFailureException(Questionario.class, null);
		}
		Iterator iterator = questoes.iterator();
		while (iterator.hasNext()) {
			questionario.addQuestao((Questao) iterator.next());
		}
		return questionario;
	}
}
