package br.pucrio.inf.les.investprofile.service;

import java.util.List;

import br.pucrio.inf.les.investprofile.dao.QuestaoDao;
import br.pucrio.inf.les.investprofile.model.Questao;

/**
 * Business Service Interface to handle communication between web and
 * persistence layer.
 * 
 * <p>
 * <a href="QuestaoManager.java.html"><i>View Source</i></a>
 * </p>
 * 
 * @author <a href="mailto:mauricio.pinheiro@gmail.com">Mauricio Pinheiro</a>
 */
public interface QuestaoManager extends GenericManager<Questao, Long> {

	/**
	 * @param questaoDao
	 */
	public void setQuestaoDao(QuestaoDao questaoDao);

	/**
	 * Retorna uma questao selecionada pelo identificador. Uma exceção é
	 * levantada se nenhuma questao for encontrada.
	 * 
	 * @param id
	 *            identificador da questao
	 * @return Questao objeto de questao preenchido
	 */
	public Questao getQuestao(String id);

	/**
	 * Retorna uma questao selecionada por um trecho da pergunta.
	 * 
	 * @param nome
	 *            trecho da questao
	 * @return Questao objeto de ação preenchido
	 * @throws Exception
	 */
	public Questao getQuestaoPorTrechoPergunta(String nome) throws Exception;

	/**
	 * Retorna uma lista de questao, filtrada pelos atributos de um objeto de
	 * questao
	 * 
	 * @param questao
	 *            objeto de questao com atributos para filtragem
	 * @return List
	 */
	public List<Questao> getQuestoes(Questao questao);

	/**
	 * Salva as informações de uma questao
	 * 
	 * @param questao
	 *            informações de uma questao
	 * @throws Exception
	 */
	public void saveQuestao(Questao questao) throws Exception;

	/**
	 * Remove uma questao do banco de dados selecionada pelo identificador
	 * 
	 * @param id
	 *            identificador de uma questao
	 */
	public void removeQuestao(String id);
}
