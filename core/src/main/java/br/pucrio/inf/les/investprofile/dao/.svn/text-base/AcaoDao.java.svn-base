package br.pucrio.inf.les.investprofile.dao;

import java.util.List;

import br.pucrio.inf.les.investprofile.model.Acao;

/**
 * Acao Data Access Object (Dao) interface.
 * 
 * <p>
 * <a href="AcaoDao.java.html"><i>View Source</i></a>
 * </p>
 * 
 * @author <a href="mailto:mauricio.pinheiro@gmail.com">Mauricio Pinheiro</a>
 */
public interface AcaoDao extends GenericDao<Acao, Long> {
	/**
	 * Obtem as informações da ação baseado no id
	 * 
	 * @param id
	 *            o id da ação
	 * @return Acao objeto Acao preenchido
	 */
	public Acao getAcao(Long id);

	/**
	 * Obtem uma ação baseado no nome
	 * 
	 * @param nome
	 *            o nome da ação
	 * @return Acao objeto Acao preenchido
	 */
	public Acao getAcaoPorNome(String nome);

	/**
	 * Obtem uma ação baseado no código bovespa da ação
	 * 
	 * @param codigoBovespa
	 *            o código bovespa
	 * @return Acao objeto Acao preenchido
	 */
	public Acao getAcaoPorCodigoBovespa(String codigoBovespa);

	/**
	 * Obtem uma lista de ações baseada nos atributos da açao recebida
	 * 
	 * @param acao
	 * @return List lista de ações preenchidas
	 */
	public List<Acao> getAcoes(Acao acao);

	/**
	 * Salva as informações de uma ação
	 * 
	 * @param acao
	 *            o objeto a ser salvo
	 */
	public void saveAcao(Acao acao);

	/**
	 * Remove uma ação baseado no id da ação
	 * 
	 * @param id
	 *            o id da ação
	 */
	public void removeAcao(Long id);
}
