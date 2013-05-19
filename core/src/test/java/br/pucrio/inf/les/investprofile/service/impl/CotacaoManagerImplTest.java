package br.pucrio.inf.les.investprofile.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.jmock.Mock;

import br.com.ur2.libs.Data;
import br.pucrio.inf.les.investprofile.dao.CotacaoDao;
import br.pucrio.inf.les.investprofile.model.Acao;
import br.pucrio.inf.les.investprofile.model.Cotacao;
import br.pucrio.inf.les.investprofile.service.impl.BaseManagerMockTestCase;
import br.pucrio.inf.les.investprofile.service.impl.CotacaoManagerImpl;

public class CotacaoManagerImplTest extends BaseManagerMockTestCase {
	// ~ Instance fields
	// ========================================================

	private CotacaoManagerImpl cotacaoManager = null;

	private Mock cotacaoDao = null;

	private Cotacao cotacao;

	private List<Cotacao> cotacoes;

	// ~ Methods
	// ================================================================

	protected void setUp() throws Exception {
		super.setUp();
		cotacaoDao = new Mock(CotacaoDao.class);
		cotacaoManager = new CotacaoManagerImpl((CotacaoDao) cotacaoDao.proxy());
	}

	protected void tearDown() throws Exception {
		super.tearDown();
		cotacaoManager = null;
	}
/*
	public void testGetCotacao() throws Exception {
		List<Cotacao> results = new ArrayList<Cotacao>();

		// set expected behavior on dao
		cotacaoDao.expects(once()).method("getCotacoesPorCodigoBovespa").will(
				returnValue(results));

		cotacoes = cotacaoManager.getCotacoesPorCodigoBovespa("PETR4");
		assertTrue(cotacoes.size() > 0);
		cotacaoDao.verify();
	}
*/
	public void testGetCotacoes() throws Exception {
		List<Cotacao> results = new ArrayList<Cotacao>();
		cotacao = new Cotacao();
		results.add(cotacao);

		// set expected behavior on dao
		cotacaoDao.expects(once()).method("getCotacoes").will(
				returnValue(results));

		cotacoes = cotacaoManager.getCotacoes(null);
		assertTrue(cotacoes.size() > 0);
		cotacaoDao.verify();
	}

	public void testSaveCotacao() throws Exception {
		// set expected behavior on dao
		cotacaoDao.expects(once()).method("saveCotacao").with(same(cotacao))
				.isVoid();

		cotacaoManager.saveCotacao(cotacao);
		cotacaoDao.verify();
	}

	public void testAddAndRemoveCotacao() throws Exception {
		Cotacao cotacao = new Cotacao();
		// call populate method in super class to populate test data
		// from a properties file matching this class name
		// cotacao = (Cotacao) populate(cotacao);
		cotacao.setAcao(new Acao("CSAN3"));
		cotacao.setDataPregao(Data.criaData(2007, 01, 05));
		cotacao.setNegocios(5);
		cotacao.setPrecoAbertura(2.44);
		cotacao.setPrecoMaximo(2.55);
		cotacao.setPrecoMedio(2.43);
		cotacao.setPrecoMelhorOfertaCompra(2.59);
		cotacao.setPrecoMelhorOfertaVenda(2.32);
		cotacao.setPrecoMinimo(2.33);
		cotacao.setPrecoUltimo(2.45);
		cotacao.setTitulosNegociados(200);

		// set expected behavior on cotacao dao
		cotacaoDao.expects(once()).method("saveCotacao").with(same(cotacao));
		cotacaoManager.saveCotacao(cotacao);
		assertTrue(cotacao.getPrecoAbertura() == 2.44);
		cotacaoDao.verify();
		Long id = cotacao.getId();
		// reset expectations
		cotacaoDao.reset();

		cotacaoDao.expects(once()).method("removeCotacao").with(eq(id));
		cotacaoManager.removeCotacao(id.toString());
		cotacaoDao.verify();

		// reset expectations
		cotacaoDao.reset();
		cotacaoDao.expects(once()).method("getCotacao").will(returnValue(null));
		cotacao = cotacaoManager.getCotacao("1");
		assertNull(cotacao);
		cotacaoDao.verify();
	}
}
