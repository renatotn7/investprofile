package br.pucrio.inf.les.investprofile.service;

import java.util.List;

import br.pucrio.inf.les.investprofile.dao.RespostaDao;
import br.pucrio.inf.les.investprofile.model.Resposta;

/**
 * Business Service Interface to handle communication between web and
 * persistence layer.
 * 
 * <p>
 * <a href="RespostaManager.java.html"><i>View Source</i></a>
 * </p>
 * 
 * @author <a href="mailto:mauricio.pinheiro@gmail.com">Mauricio Pinheiro</a>
 */
public interface RespostaManager extends GenericManager<Resposta, Long> {

	/**
	 * @param respostaDao
	 */
	public void setRespostaDao(RespostaDao respostaDao);

	/**
	 * Retorna uma resposta selecionada pelo identificador. Uma exceção é
	 * levantada se nenhuma reposta for encontrada.
	 * 
	 * @param id
	 *            identificador da respsota
	 * @return Resposta objeto de resposta preenchido
	 */
	public Resposta getResposta(String id);

	/**
	 * Retorna uma resposta selecionada por um trecho da resposta.
	 * 
	 * @param nome
	 *            trecho da resposta
	 * @return Resposta objeto de resposta preenchido
	 * @throws Exception
	 */
	public Resposta getRespostaPorTrechoResposta(String nome) throws Exception;

	/**
	 * Retorna uma lista de respostas, filtrada pelos atributos de um objeto de
	 * resposta
	 * 
	 * @param resposta
	 *            objeto de resposta com atributos para filtragem
	 * @return List
	 */
	public List<Resposta> getRespostas(Resposta resposta);

	/**
	 * Salva as informações de uma resposta
	 * 
	 * @param resposta
	 *            informações de uma resposta
	 * @throws Exception
	 */
	public void saveResposta(Resposta resposta) throws Exception;

	/**
	 * Remove uma resposta do banco de dados selecionada pelo identificador
	 * 
	 * @param id
	 *            identificador de uma resposta
	 */
	public void removeOpcao(String id);
}
