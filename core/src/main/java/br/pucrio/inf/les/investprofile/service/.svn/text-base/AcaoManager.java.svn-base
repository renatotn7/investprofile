package br.pucrio.inf.les.investprofile.service;

import java.util.List;

import br.pucrio.inf.les.investprofile.dao.AcaoDao;
import br.pucrio.inf.les.investprofile.model.Acao;

/**
 * Business Service Interface to handle communication between web and
 * persistence layer.
 * 
 * <p>
 * <a href="AcaoManager.java.html"><i>View Source</i></a>
 * </p>
 * 
 * @author <a href="mailto:mauricio.pinheiro@gmail.com">Mauricio Pinheiro</a>
 */
public interface AcaoManager extends GenericManager<Acao, Long> {

	/**
	 * @param acaoDao
	 */
	public void setAcaoDao(AcaoDao acaoDao);

	/**
	 * Retorna uma ação selecionada pelo identificador. Uma exceção é levantada
	 * se nenhuma ação for encontrada.
	 * 
	 * @param id
	 *            identificador da ação
	 * @return Acao objeto de ação preenchido
	 */
	public Acao getAcao(String id);

	/**
	 * Retorna uma ação selecionada pelo nome.
	 * 
	 * @param nome
	 *            nome da ação
	 * @return Acao objeto de ação preenchido
	 * @throws Exception
	 */
	public Acao getAcaoPorNome(String nome) throws Exception;

	/**
	 * Retorna uma ação selecionada pelo código Bovespa.
	 * 
	 * @param codigoBovespa
	 *            código Bovespa da ação
	 * @return Acao um objeto de ação preenchido
	 * @throws Exception
	 */
	public Acao getAcaoPorCodigoBovespa(String codigoBovespa);

	/**
	 * Retorna uma lista de ações, filtrada pelos atributos de um objeto de ação
	 * 
	 * @param acao
	 *            objeto de ação com atributos para filtragem
	 * @return List
	 */
	public List<Acao> getAcoes(Acao acao);

	/**
	 * Salva as informações de uma ação
	 * 
	 * @param acao
	 *            informações de uma ação
	 * @throws Exception
	 */
	public void saveAcao(Acao acao) throws Exception;

	/**
	 * Remove uma ação do banco de dados selecionada pelo identificador
	 * 
	 * @param id
	 *            identificador de uma ação
	 */
	public void removeAcao(String id);
}
