package br.pucrio.inf.les.investprofile.dao;

import java.util.List;

import br.pucrio.inf.les.investprofile.model.RecomendacaoAnalista;
import br.pucrio.inf.les.investprofile.model.RecomendacaoPerfil;

/**
 * RecomendacaoPerfil Data Access Object (Dao) interface.
 *
 * <p>
 * <a href="RecomendacaoPerfilDao.java.html"><i>View Source</i></a>
 * </p>
 *
 * @author <a href="mailto:mauricio.pinheiro@gmail.com">Mauricio Pinheiro</a>
 */
public interface RecomendacaoPerfilDao extends GenericDao<RecomendacaoPerfil, Long> {

    /**
     * @param idRecomendacaoPerfil
     * @return List lista de AcaoCarteira preenchida
     */
    public RecomendacaoPerfil getRecomendacaoPerfil(Long idRecomendacaoPerfil);
	
    /**
     * @param idPerfilInvestimento
     * @return List lista de AcaoCarteira preenchida
     */
    public List<RecomendacaoPerfil> getRecomendacoesPerfil(Long idPerfilInvestimento);
    
	/**
	 * Obtem uma lista de recomenda��es para um perfil baseada nos atributos da
	 * recomenda��o recebida
	 * 
	 * @param recomendacaoPerfil
	 * @return List lista de recomenda��es para um perfil preenchida
	 */
	public List<RecomendacaoPerfil> getRecomendacoesPerfis(
			RecomendacaoPerfil recomendacaoPerfil);

	/**
	 * Salva as informa��es de uma recomenda��o para um perfil
	 * 
	 * @param recomendacaoPerfil
	 *            o objeto a ser salvo
	 */
	public void saveRecomendacaoPerfil(
			RecomendacaoPerfil recomendacaoPerfil);

	/**
	 * Remove uma recomenda��o de um analista baseado no c�digo da recomenda��o
	 * para um perfil
	 * 
	 * @param idRecomendacaoPerfil
	 *            c�digo da recomenda��o para um perfil
	 */
	public void removeRecomendacaoPerfil(Long idRecomendacaoPerfil);
}
