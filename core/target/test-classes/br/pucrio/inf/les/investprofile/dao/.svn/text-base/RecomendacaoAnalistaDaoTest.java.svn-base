package br.pucrio.inf.les.investprofile.dao;

import java.util.List;

import br.pucrio.inf.les.investprofile.model.RecomendacaoAnalista;

/**
 * 
 * @author <a href="mailto:mauricio.pinheiro@gmail.com">Mauricio Costa Pinheiro</a>
 * @version %I%, %G%
 */
public class RecomendacaoAnalistaDaoTest extends BaseDaoTestCase {
	private RecomendacaoAnalistaDao dao = null;

	/**
	 * @param dao
	 */
	public void setRecomendacaoAnalistaDao(RecomendacaoAnalistaDao dao) {
		this.dao = dao;
	}

	/**
	 * 
	 */
	public void testGetRecomendacoesAnalistaPorAcao() {
		List<RecomendacaoAnalista> results = dao
				.getRecomendacoesAnalistasPorAcao(50L);
		assertTrue(results.size() > 0);
	}

	/**
	 * 
	 */
	public void testGetRecomendacoesAnalista() {
		List<RecomendacaoAnalista> results = dao.getRecomendacoesAnalista("Super");
		assertTrue(results.size() > 0);
	}
}
