package br.pucrio.inf.les.investprofile.dao;

import java.util.List;

import br.pucrio.inf.les.investprofile.model.RecomendacaoPerfil;

/**
 * 
 * @author <a href="mailto:mauricio.pinheiro@gmail.com">Mauricio Costa Pinheiro</a>
 * @version %I%, %G%
 */
public class RecomendacaoPerfilDaoTest extends BaseDaoTestCase {
	private RecomendacaoPerfilDao dao = null;

	/**
	 * @param dao
	 */
	public void setRecomendacaoPerfilDao(RecomendacaoPerfilDao dao) {
		this.dao = dao;
	}

	/**
	 * 
	 */
	public void testGetRecomendacoesPerfil() {
		List<RecomendacaoPerfil> results = dao.getRecomendacoesPerfil(1L);
		assertTrue(results.size() > 0);
	}
}
