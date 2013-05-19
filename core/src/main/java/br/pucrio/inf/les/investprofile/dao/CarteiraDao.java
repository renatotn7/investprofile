package br.pucrio.inf.les.investprofile.dao;

import java.util.List;

import br.pucrio.inf.les.investprofile.model.Carteira;

/**
 * Carteira Data Access Object (Dao) interface.
 * 
 * <p>
 * <a href="CarteiraDao.java.html"><i>View Source</i></a>
 * </p>
 * 
 * @author <a href="mailto:mauricio.pinheiro@gmail.com">Mauricio Pinheiro</a>
 */
public interface CarteiraDao extends GenericDao<Carteira, Long> {
	/**
	 * Obtem uma carteira baseada no id
	 * 
	 * @param id
	 *            o id da carteira
	 * @return Carteira objeto de carteira preenchido
	 */
	public Carteira getCarteira(Long id);

	/**
	 * Obtem uma lista de carteira baseada nos atributos do parâmetro
	 * 
	 * @param carteira
	 * @return List lista preenchida de carterias
	 */
	public List<Carteira> getCarteiras(Carteira carteira);

	/**
	 * Salva as informações de uma carteria
	 * 
	 * @param carteira
	 *            o objeto a ser salvo
	 */
	public void saveCarteira(Carteira carteira);

	/**
	 * Remove uma carteira baseada no id
	 * 
	 * @param id
	 *            o id da carteria
	 */
	public void removeCarteira(Long id);
}
