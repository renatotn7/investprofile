package br.pucrio.inf.les.investprofile.service;

import java.util.List;

import br.pucrio.inf.les.investprofile.dao.CarteiraDao;
import br.pucrio.inf.les.investprofile.model.Carteira;

/**
 * Business Service Interface to handle communication between web and
 * persistence layer.
 * 
 * <p>
 * <a href="CarteiraManager.java.html"><i>View Source</i></a>
 * </p>
 * 
 * @author <a href="mailto:mauricio.pinheiro@gmail.com">Mauricio Pinheiro</a>
 */
public interface CarteiraManager extends GenericManager<Carteira, Long> {

	/**
	 * @param portfolioDao
	 */
	public void setCarteiraDao(CarteiraDao portfolioDao);

	/**
	 * Retorna uma carteira pelo id. Uma exceção é levantada se uma carteria não
	 * for encontrada.
	 * 
	 * @param id
	 *            identificador de uma carteira
	 * @return Carteira objeto de carteira
	 */
	public Carteira getCarteira(String id);

	/**
	 * Retorna uma lista de carterias, filtradas pelos atributos de um objeto de
	 * carteria
	 * 
	 * @param carteira
	 *            objeto de carteira
	 * @return List
	 */
	public List<Carteira> getCarteiras(Carteira carteira);

	/**
	 * Salva as informações de uma carteria
	 * 
	 * @param carteira
	 *            informações de uma carteira
	 * @throws Exception
	 */
	public void saveCarteira(Carteira carteira) throws Exception;

	/**
	 * Remove uma carteira do banco de dados selecionada pelo identificador da
	 * carteira
	 * 
	 * @param id
	 *            identificador da carteira
	 */
	public void removeCarteira(String id);
}
