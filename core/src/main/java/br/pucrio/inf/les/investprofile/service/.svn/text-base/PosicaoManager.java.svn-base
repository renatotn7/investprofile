package br.pucrio.inf.les.investprofile.service;

import java.util.List;

import br.pucrio.inf.les.investprofile.dao.PosicaoDao;
import br.pucrio.inf.les.investprofile.model.Posicao;

/**
 * Business Service Interface to handle communication between web and
 * persistence layer.
 * 
 * <p>
 * <a href="PosicaoManager.java.html"><i>View Source</i></a>
 * </p>
 * 
 * @author <a href="mailto:mauricio.pinheiro@gmail.com">Mauricio Pinheiro</a>
 */
public interface PosicaoManager extends GenericManager<Posicao, Long> {

	/**
	 * @param posicaoDao
	 */
	public void setPosicaoDao(PosicaoDao posicaoDao);

	/**
	 * Retorna uma posição pelo id. Uma exceção é levantada se a posição não for
	 * encontrada.
	 * 
	 * @param id
	 *            código da posição
	 * @return Posicao objeto de posição
	 */
	public Posicao getPosicao(String id);

	/**
	 * Retorna uma lista de posições, filtrada pelos atributos de um
	 * objeto Posicao recebido.
	 * 
	 * @param posicao
	 *            objeto de posição
	 * @return List
	 */
	public List<Posicao> getPosicoes(Posicao posicao);

	/**
	 * Retorna uma lista de posições, filtrada pelos atributos de um
	 * objeto Posicao recebido.
	 * 
	 * @param idPerfilInvestimento
	 *            código de um perfil de investimento
	 * @return List lista de posições
	 */
	public List<Posicao> getPosicoesPorPerfil(String idPerfilInvestimento);
	
	/**
	 * Salva uma posição
	 * 
	 * @param posicao
	 *            informações de uma posição
	 * @throws Exception
	 */
	public void savePosicao(Posicao posicao) throws Exception;

	/**
	 * Remove uma posição selecionada pelo código
	 * 
	 * @param id
	 *            código da posição
	 */
	public void removePosicao(String idPosicao);
}
