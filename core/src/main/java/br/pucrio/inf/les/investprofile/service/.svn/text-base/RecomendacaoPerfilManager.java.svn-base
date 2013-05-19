package br.pucrio.inf.les.investprofile.service;

import java.util.List;

import br.pucrio.inf.les.investprofile.dao.RecomendacaoPerfilDao;
import br.pucrio.inf.les.investprofile.model.RecomendacaoPerfil;

/**
 * Business Service Interface to handle communication between web and
 * persistence layer.
 * 
 * <p>
 * <a href="RecomendacaoPerfilManager.java.html"><i>View Source</i></a>
 * </p>
 * 
 * @author <a href="mailto:mauricio.pinheiro@gmail.com">Mauricio Pinheiro</a>
 */
public interface RecomendacaoPerfilManager extends
		GenericManager<RecomendacaoPerfil, Long> {

	/**
	 * @param dao
	 */
	public void setRecomendacaoPerfilDao(RecomendacaoPerfilDao dao);

	/**
	 * Retorna uma recomendação de um perfil
	 * 
	 * @param idRecomendacaoPerfil
	 *            código da recomendação
	 * @return RecomendacaoPerfil recomendação de um perfil
	 */
	public RecomendacaoPerfil getRecomendacaoPerfil(String idRecomendacaoPerfil);

	/**
	 * Retorna as recomendações de um perfis
	 * 
	 * @param idPerfilInvestimento
	 *            código do perfil de investimento
	 * @return List lista de recomendações de perfis
	 */
	public List<RecomendacaoPerfil> getRecomendacoesPerfil(String idPerfilInvestimento);

	/**
	 * Retorna as recomendações dos perfis
	 * 
	 * @param recomendacaoPerfil
	 *            recomendação de um perfil utilizada para filtragem
	 * @return List lista de recomendações de perfis
	 */
	public List<RecomendacaoPerfil> getRecomendacoesPerfis(
			RecomendacaoPerfil recomendacaoPerfil);

	/**
	 * Salva uma recomendação de um perfil
	 * 
	 * @param recomendacaoPerfil
	 *            informações de uma recomendação de um perfil
	 * @throws Exception
	 */
	public void saveRecomendacaoPerfil(RecomendacaoPerfil recomendacaoPerfil)
			throws Exception;

	/**
	 * Remove uma recomendação de um perfil selecionada pelo código
	 * 
	 * @param idRecomendacaoPerfil
	 *            código da recomendação de um perfil
	 */
	public void removeRecomendacaoPerfil(String idRecomendacaoPerfil);
}
