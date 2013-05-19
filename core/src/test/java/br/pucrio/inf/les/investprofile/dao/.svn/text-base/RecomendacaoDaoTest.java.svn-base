package br.pucrio.inf.les.investprofile.dao;

import java.util.Date;
import java.util.List;

import org.springframework.dao.DataAccessException;

import br.pucrio.inf.les.investprofile.model.Recomendacao;
import br.pucrio.inf.les.investprofile.model.TipoOperacao;

/**
 * 
 * @author <a href="mailto:mauricio.pinheiro@gmail.com">Mauricio Costa Pinheiro</a>
 * @version %I%, %G%
 */
public class RecomendacaoDaoTest extends BaseDaoTestCase {
	private Recomendacao recomendacao = null;

	private RecomendacaoDao dao = null;

	private List<Recomendacao> recomendacoes = null;

	private AcaoDao sdao = null;

	/**
	 * @param dao
	 */
	public void setRecomendacaoDao(RecomendacaoDao dao) {
		this.dao = dao;
	}

	/**
	 * @param dao
	 */
	public void setAcaoDao(AcaoDao dao) {
		this.sdao = dao;
	}

	/**
	 * @throws Exception
	 */
	public void testGetRecomendacaoInvalid() throws Exception {
		Long id = 13L;
		try {
			recomendacao = dao.getRecomendacao(id);
		} catch (DataAccessException d) {
			if (log.isDebugEnabled()) {
				log.debug("Recomendacao " + id.toString()
						+ " não encontrada do banco de dados.");
			}
			assertTrue(d != null);
		}
	}

	/**
	 * @throws Exception
	 */
	public void testGetRecomendacao() throws Exception {
		recomendacao = dao.getRecomendacao(1L);
		assertNotNull(recomendacao);
	}

	/**
	 * 
	 */
	public void testGetRecomendacoes() {
		recomendacao = new Recomendacao();
		List<Recomendacao> results = dao.getRecomendacoes(recomendacao);
		assertTrue(results.size() > 0);
	}

	/**
	 * @throws Exception
	 */
	public void testUpdateRecomendacao() throws Exception {
		recomendacao = dao.getRecomendacao(new Long(2));
		recomendacao.setGrauConfianca(new Double(444.444));

		dao.saveRecomendacao(recomendacao);

		assertEquals(dao.getRecomendacao(new Long(2)).getGrauConfianca(),
				new Double(444.444));
	}

	/**
	 * @throws Exception
	 */
	public void testAddAndRemoveRecomendacao() throws Exception {
		Long id = null;
		recomendacao = new Recomendacao(sdao.getAcao(new Long(2)));
		recomendacao.setId(null);
		recomendacao.setGrauConfianca(new Double(56.34));
		recomendacao.setData(new Date(444));
		recomendacao.setPreco(new Double(122.345));
		recomendacao.setHora(new Long(778));
		recomendacao.setOperacao(TipoOperacao.VENDER);
		dao.saveRecomendacao(recomendacao);
		assertNotNull(recomendacao.getAcao().getCodigoBovespa());
		id = recomendacao.getId();

		dao.removeRecomendacao(id);
		endTransaction();

		try {
			recomendacao = dao.getRecomendacao(id);
			fail("'Recomendacao id ' found in database, failing test...");
		} catch (DataAccessException d) {
			assertTrue(d != null);
		}
	}
}
