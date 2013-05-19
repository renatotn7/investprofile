package br.pucrio.inf.les.investprofile.dao;

import java.util.List;

import br.pucrio.inf.les.investprofile.model.Questao;

/**
 * Questao Data Access Object (Dao) interface.
 * 
 * <p>
 * <a href="QuestaoDao.java.html"><i>View Source</i></a>
 * </p>
 * 
 * @author <a href="mailto:mauricio.pinheiro@gmail.com">Mauricio Pinheiro</a>
 */
public interface QuestaoDao extends GenericDao<Questao, Long> {
	/**
	 * Obtem as informações da questao baseado no id
	 * 
	 * @param id
	 *            o id da questao
	 * @return Questao objeto Questao preenchido
	 */
	public Questao getQuestao(Long id);

	/**
	 * Obtem uma questao baseado no nome
	 * 
	 * @param nome
	 *            o nome da questao
	 * @return Questao objeto Questao preenchido
	 */
	public Questao getQuestaoPorTrechoPergunta(String nome);

	/**
	 * Obtem uma lista de questoes baseada nos atributos da questao recebida
	 * 
	 * @param questao
	 * @return List lista de questoes preenchidas
	 */
	public List<Questao> getQuestoes(Questao questao);

	/**
	 * Salva as informações de uma questao
	 * 
	 * @param questao
	 *            o objeto a ser salvo
	 */
	public void saveQuestao(Questao questao);

	/**
	 * Remove uma questao baseado no id da questao
	 * 
	 * @param id
	 *            o id da questao
	 */
	public void removeQuestao(Long id);
}
