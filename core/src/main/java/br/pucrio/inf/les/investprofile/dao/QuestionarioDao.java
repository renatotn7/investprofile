package br.pucrio.inf.les.investprofile.dao;

import br.pucrio.inf.les.investprofile.model.Questionario;

/**
 * Questionario Data Access Object (Dao) interface.
 * 
 * <p>
 * <a href="QuestionarioDao.java.html"><i>View Source</i></a>
 * </p>
 * 
 * @author <a href="mailto:mauricio.pinheiro@gmail.com">Mauricio Pinheiro</a>
 */
public interface QuestionarioDao extends GenericDao<Questionario, Long> {

	/**
	 * Obtem uma lista de questoes baseada nos atributos da questao recebida
	 * 
	 * @return List lista de questoes preenchidas
	 */
	public Questionario getQuestionario();

}
