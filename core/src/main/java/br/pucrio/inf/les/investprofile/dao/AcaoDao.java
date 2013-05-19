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
	 * Obtem as informa��es da a��o baseado no id
	 * 
	 * @param id
	 *            o id da a��o
	 * @return Acao objeto Acao preenchido
	 */
	public Acao getAcao(Long id);

	/**
	 * Obtem uma a��o baseado no nome
	 * 
	 * @param nome
	 *            o nome da a��o
	 * @return Acao objeto Acao preenchido
	 */
	public Acao getAcaoPorNome(String nome);

	/**
	 * Obtem uma a��o baseado no c�digo bovespa da a��o
	 * 
	 * @param codigoBovespa
	 *            o c�digo bovespa
	 * @return Acao objeto Acao preenchido
	 */
	public Acao getAcaoPorCodigoBovespa(String codigoBovespa);

	/**
	 * Obtem uma lista de a��es baseada nos atributos da a�ao recebida
	 * 
	 * @param acao
	 * @return List lista de a��es preenchidas
	 */
	public List<Acao> getAcoes(Acao acao);

	/**
	 * Salva as informa��es de uma a��o
	 * 
	 * @param acao
	 *            o objeto a ser salvo
	 */
	public void saveAcao(Acao acao);

	/**
	 * Remove uma a��o baseado no id da a��o
	 * 
	 * @param id
	 *            o id da a��o
	 */
	public void removeAcao(Long id);
}
