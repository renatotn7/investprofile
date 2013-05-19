package br.pucrio.inf.les.investprofile.dao;

import java.util.List;

import br.pucrio.inf.les.investprofile.model.Resposta;

/**
 * Resposta Data Access Object (Dao) interface.
 * 
 * <p>
 * <a href="RespostaDao.java.html"><i>View Source</i></a>
 * </p>
 * 
 * @author <a href="mailto:mauricio.pinheiro@gmail.com">Mauricio Pinheiro</a>
 */
public interface RespostaDao extends GenericDao<Resposta, Long> {
	/**
	 * Obtem as informações da opcao baseado no id
	 * 
	 * @param id
	 *            o id da opcao
	 * @return Resposta objeto Resposta preenchido
	 */
	public Resposta getResposta(Long id);

	/**
	 * Obtem uma opcao baseado no nome
	 * 
	 * @param nome
	 *            o nome da opcao
	 * @return Resposta objeto Resposta preenchido
	 */
	public Resposta getRespostaPorTrechoResposta(String nome);

	/**
	 * Obtem uma lista de opcoes baseada nos atributos da opcao recebida
	 * 
	 * @param resposta
	 * @return List lista de respostas preenchidas
	 */
	public List<Resposta> getRespostas(Resposta resposta);

	/**
	 * Salva as informações de uma opcao
	 * 
	 * @param resposta
	 *            o objeto a ser salvo
	 */
	public void saveResposta(Resposta resposta);

	/**
	 * Remove uma ação baseado no id da opcao
	 * 
	 * @param id
	 *            o id da opcao
	 */
	public void removeResposta(Long id);
}
