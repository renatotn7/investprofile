package br.pucrio.inf.les.investprofile.dao;

import java.util.GregorianCalendar;
import java.util.List;

import br.com.ur2.libs.Data;
import br.pucrio.inf.les.investprofile.model.Acao;
import br.pucrio.inf.les.investprofile.model.Cotacao;

/**
 *
 * @author <a href="mailto:mauricio.pinheiro@gmail.com">Mauricio Costa Pinheiro</a>
 * @version %I%, %G%
 */
public class CotacaoDaoTest extends BaseDaoTestCase {
	private Cotacao cotacao = null;

	private CotacaoDao dao = null;

	private AcaoDao acaoDao = null;

	/**
	 * @param dao
	 */
	public void setCotacaoDao(CotacaoDao dao) {
		this.dao = dao;
	}

	/**
	 * @param dao
	 */
	public void setAcaoDao(AcaoDao dao) {
		this.acaoDao = dao;
	}

	/**
	 * @throws Exception
	 */
	public void testGetCotacaoInvalida() throws Exception {
		cotacao = dao.getCotacao(new Long(-1));
		assertNull(cotacao);
	}

	/**
	 * @throws Exception
	 */
	public void testGetCotacao() throws Exception {
		cotacao = dao.getCotacao(new Long(1));
		assertNotNull(cotacao);
	}

	/**
	 * @throws Exception
	 */
	public void testGetCotacaoPorCodigoBovespa() throws Exception {
		List results = dao.getCotacoesPorCodigoBovespa(new String("PETR4"));
		assertTrue(results.size() > 0);
	}

	/**
	 * @throws Exception
	 */
	public void testGetCotacaoPorCodigoBovespaDesde() throws Exception {
		List<Cotacao> results = dao.getCotacoesPorCodigoBovespaDesde(new String("PETR4"), Data.criaData(2007,1,1));
		assertTrue(results.size() > 0);
		assertTrue(results.get(0).getDataPregao().compareTo(Data.criaData(2007,1,1)) >= 0);
	}
		
	/**
	 * @throws Exception
	 */
	public void testGetUltimaCotacaoAcao() throws Exception {
		cotacao = dao.getUltimaCotacaoAcao("PETR4");
		assertNotNull(cotacao);
	}

	/**
	 * 
	 */
	public void testGetCotacoesAcao() {
		cotacao = new Cotacao();
		Acao acao = new Acao();
		acao = acaoDao.getAcaoPorCodigoBovespa("PETR4");
		List results = dao.getCotacoesAcao(acao);
		assertTrue(results.size() > 0);
	}

	/**
	 * 
	 */
	public void testGetCotacoes() {
		cotacao = new Cotacao();
		List results = dao.getCotacoes(cotacao);
		assertTrue(results.size() > 0);
	}

	/**
	 * @throws Exception
	 */
	public void testUpdateCotacao() throws Exception {
		cotacao = dao.getPrimeiraCotacaoAcao("PETR4");
		log.debug(cotacao);
		cotacao.setNegocios(99);
		dao.saveCotacao(cotacao);
		assertEquals(dao.getPrimeiraCotacaoAcao("PETR4").getNegocios(), 99);
	}

	/**
	 * @throws Exception
	 */
	public void testAddAndRemoveCotacao() throws Exception {
		long id = 0;
		cotacao = new Cotacao();
		cotacao.setAcao(acaoDao.getAcaoPorCodigoBovespa("VALE5"));
		cotacao.setDataPregao(new GregorianCalendar(2007, 1, 5).getTime());
		dao.saveCotacao(cotacao);
		assertNotNull(cotacao.getAcao().getCodigoBovespa());
		id = cotacao.getId();
		dao.removeCotacao(new Long(id));
		endTransaction();

		cotacao = dao.getCotacao(new Long(id));
		assertNull(cotacao);
	}
}
