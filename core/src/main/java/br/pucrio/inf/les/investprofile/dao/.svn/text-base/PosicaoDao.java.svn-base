package br.pucrio.inf.les.investprofile.dao;

import java.util.List;

import br.pucrio.inf.les.investprofile.model.Posicao;

/**
 * Posicao Data Access Object (Dao) interface.
 * 
 * <p>
 * <a href="PosicaoDao.java.html"><i>View Source</i></a>
 * </p>
 * 
 * @author <a href="mailto:mauricio.pinheiro@gmail.com">Mauricio Pinheiro</a>
 */
public interface PosicaoDao extends GenericDao<Posicao, Long> {
	/**
	 * Obtem uma ação em carteira baseada na informação de um id de uma ação em
	 * carteira
	 * 
	 * @param id
	 *            O id da AcaoCarteira
	 * @return AcaoCarteira um objeto de AcaoCarteira preenchido
	 */
	public Posicao getPosicao(Long id);

	/**
	 * Obtem uma lista de ações em carteira baseada nos atributos de uma ação em
	 * carteira
	 * 
	 * @param posicao
	 * @return List lista de objetos Posicao
	 */
	public List<Posicao> getPosicoes(Posicao posicao);

	/**
	 * Obtem uma lista de ações em carteira baseadas no id da carteira
	 * 
	 * @param idPerfilInvestimento
	 *            código do perfil de investimento
	 * @return List lista de objetos Posicao
	 */
	public List<Posicao> getPosicoesPorPerfil(Long idPerfilInvestimento);

	/**
	 * Salva as informações de uma ação em carteira
	 * 
	 * @param posicao
	 *            o objeto a ser salvo
	 */
	public void savePosicao(Posicao posicao);

	/**
	 * Remove uma posição baseada no código da posição.
	 * 
	 * @param idPosicao
	 *            código da podição
	 */
	public void removePosicao(Long idPosicao);
}
