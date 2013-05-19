package br.pucrio.inf.les.investprofile.service;

import java.util.List;

import br.pucrio.inf.les.investprofile.dao.PerfilInvestimentoDao;
import br.pucrio.inf.les.investprofile.model.PerfilInvestimento;

/**
 * Business Service Interface to handle communication between web and
 * persistence layer.
 * 
 * <p>
 * <a href="PerfilInvestimentoManager.java.html"><i>View Source</i></a>
 * </p>
 * 
 * @author <a href="mailto:mauricio.pinheiro@gmail.com">Mauricio Pinheiro</a>
 */
public interface PerfilInvestimentoManager extends
		GenericManager<PerfilInvestimento, Long> {

	/**
	 * @param investprofileDao
	 */
	public void setPerfilInvestimentoDao(PerfilInvestimentoDao investprofileDao);

	/**
	 * Retorna um perfil de investimento baseado no id. Levanta uma exceção se
	 * nenhum perfil de investimento for encontrado.
	 * 
	 * @param id
	 *            identificador do perfil do investimento
	 * @return PerfilInvestimento
	 */
	public PerfilInvestimento getPerfilInvestimento(String id);

	/**
	 * Retorna uma lista de perfilInvestimento, filtrando com os atributos do
	 * objeto perfilInvestimento
	 * 
	 * @param perfilInvestimento
	 *            com atributos para filtragem
	 * @return List
	 */
	public List<PerfilInvestimento> getPerfisInvestimentos(
			PerfilInvestimento perfilInvestimento);

	/**
	 * Retorna uma lista de perfilInvestimento, filtrando com o id do usuário
	 * 
	 * @param id
	 *            id do usuário para filtragem
	 * @return List
	 */
	public List<PerfilInvestimento> getPerfisInvestimentosPorIdUsuario(String id);

	/**
	 * Encontra um objeto perfilInvestimento pelo nome do perfil de
	 * investimento.
	 * 
	 * @param nome
	 *            nome do perfil de investimento
	 * @return PerfilInvestimento um objeto de perfil de investimento preenchido
	 * @throws Exception
	 */
	public PerfilInvestimento getPerfilInvestimentoPorNome(String nome)
			throws Exception;

	/**
	 * Salva um perfil de investimento
	 * 
	 * @param perfilInvestimento
	 *            as informações de um perfil de investimento
	 * @throws Exception
	 */
	public void savePerfilInvestimento(PerfilInvestimento perfilInvestimento)
			throws Exception;

	/**
	 * Remove um PerfilInvestimento baseado no id de um perfil de investimento
	 * 
	 * @param id
	 *            identificador do perfil de investimento
	 */
	public void removePerfilInvestimento(String id);
}
