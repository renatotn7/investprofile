package br.pucrio.inf.les.investprofile.service;

import br.pucrio.inf.les.investprofile.dao.QuestionarioDao;
import br.pucrio.inf.les.investprofile.model.Questao;
import br.pucrio.inf.les.investprofile.model.Questionario;

/**
 * Business Service Interface to handle communication between web and
 * persistence layer.
 *
 * <p><a href="QuestionarioManager.java.html"><i>View Source</i></a></p>
 *
 * @author <a href="mailto:mauricio.pinheiro@gmail.com">Mauricio Pinheiro</a>
 */
public interface QuestionarioManager extends GenericManager<Questionario, Long>{
    
    /**
     * @param questionarioDao
     */
    public void setQuestionarioDao(QuestionarioDao questionarioDao);

    /**
     * Retorna um questionario selecionada pelo identificador. Uma exceção é levantada se nenhum questionario for encontrada.
     * @param id identificador da questionario
     * @return Questionario objeto de questionario preenchido
     */
    public Questionario getQuestionario();
  
}
