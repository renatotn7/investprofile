package br.pucrio.inf.les.investprofile.dao;

import java.util.List;

import br.pucrio.inf.les.investprofile.model.PerfilInvestimento;

/**
 * PerfilInvestimento Data Access Object (Dao) interface.
 * 
 * <p>
 * <a href="PerfilInvestimentoDao.java.html"><i>View Source</i></a>
 * </p>
 * 
 * @author <a href="mailto:mauricio.pinheiro@gmail.com">Mauricio Pinheiro</a>
 */
public interface PerfilInvestimentoDao extends
		GenericDao<PerfilInvestimento, Long> {
	/**
	 * Obtem um perfil de invstimento baseado no id
	 * 
	 * @param id
	 *            o id do perfil de investimento
	 * @return PerfilInvestimento objeto PerfilInvestimento preenchido
	 */
	public PerfilInvestimento getPerfilInvestimento(Long id);

	/**
	 * Obtem um perfil de investimento baseado no nome do perfil
	 * 
	 * @param nome
	 *            o nome do perfil de investimento
	 * @return PerfilInvestimento objeto PerfilInvestimento preenchido
	 */
	public PerfilInvestimento getPerfilInvestimentoPorNome(String nome);

	/**
	 * Obtem um perfil de investimento baseado no id do usuário
	 * 
	 * @param id
	 *            o id do usuário
	 * @return List lista de PerfilInvestimento preechidos
	 */
	public List<PerfilInvestimento> getPerfisInvestimentosPorIdUsuario(Long id);

	/**
	 * Obtem uma lista de perfis de investimentos basada nos atributos do objeto
	 * recebido
	 * 
	 * @param perfilInvestimento
	 * @return List lista de PerfilInvestimento preenchidos
	 */
	public List<PerfilInvestimento> getPerfisInvestimentos(
			PerfilInvestimento perfilInvestimento);

	/**
	 * Salva as informações de um perfil de investimento
	 * 
	 * @param perfilInvestimento
	 *            o objeto a ser salvo
	 */
	public void savePerfilInvestimento(PerfilInvestimento perfilInvestimento);

	/**
	 * Remove um perfil de investimento baseado no id
	 * 
	 * @param id
	 *            o id do perfil de investimento
	 */
	public void removePerfilInvestimento(Long id);
}
