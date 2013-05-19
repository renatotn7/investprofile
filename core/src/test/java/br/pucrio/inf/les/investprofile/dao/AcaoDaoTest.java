package br.pucrio.inf.les.investprofile.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import br.pucrio.inf.les.investprofile.model.Acao;
import br.pucrio.inf.les.investprofile.model.EspecificacaoPapel;
import br.pucrio.inf.les.investprofile.model.Segmento;

/**
 * @author Jonny
 * 
 */
public class AcaoDaoTest extends BaseDaoTestCase {
	private Acao acao = null;

	private AcaoDao dao = null;

	/**
	 * @param dao
	 */
	public void setAcaoDao(AcaoDao dao) {
		this.dao = dao;
	}

	/**
	 * @throws Exception
	 */
	public void testGetAcaoInvalid() throws Exception {
		acao = dao.getAcaoPorNome("badacaoname");
		assertNull(acao);
	}

	/**
	 * @throws Exception
	 */
	public void testGetAcao() throws Exception {
		acao = dao.getAcaoPorCodigoBovespa(new String("PETR4"));
		assertNotNull(acao);
	}

	/**
	 * 
	 */
	public void testGetAcoes() {
		acao = new Acao();
		List results = dao.getAcoes(acao);
		assertTrue(results.size() > 0);
	}

	/**
	 * @throws Exception
	 */
	public void testUpdateAcao() throws Exception {
		String nomeAcao = new String("PETR4");
		try {
			acao = dao.getAcaoPorCodigoBovespa(nomeAcao);
		} catch (DataAccessException e) {
			if (log.isDebugEnabled()) {
				log.debug("Ação " + nomeAcao
						+ " selecionada não existe no banco de dados.");
			}
			assertTrue(e != null);
		}
		assertTrue(acao != null);
		log.debug(acao);
		acao.setNome("PetroBrasil");

		dao.saveAcao(acao);

		assertEquals(
				dao.getAcaoPorCodigoBovespa(new String("PETR4")).getNome(),
				"PetroBrasil");
	}

	/**
	 * @throws Exception
	 */
	public void testAddAndRemoveAcao() throws Exception {
		String nomeEmpresa = new String("Tractebel2");
		acao = new Acao(new Long(22), "TBLE3", "TBLE", Segmento.ENERGIA,
				nomeEmpresa, EspecificacaoPapel.ON, new Integer(5));
		acao.setId(null);
		dao.saveAcao(acao);
		assertNotNull(acao.getCodigoBovespa());

		dao.removeAcao(dao.getAcaoPorNome(nomeEmpresa).getId());

		endTransaction();

		acao = dao.getAcaoPorNome(nomeEmpresa);
		assertNull(acao);
	}
}
