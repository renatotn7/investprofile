package br.pucrio.inf.les.investprofile.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.jmock.Mock;

import br.pucrio.inf.les.investprofile.dao.PerfilInvestimentoDao;
import br.pucrio.inf.les.investprofile.model.Objetivo;
import br.pucrio.inf.les.investprofile.model.PerfilInvestimento;
import br.pucrio.inf.les.investprofile.model.Segmento;
import br.pucrio.inf.les.investprofile.model.Tempo;

public class PerfilInvestimentoManagerImplTest extends BaseManagerMockTestCase {
	// ~ Instance fields
	// ========================================================

	private PerfilInvestimentoManagerImpl perfilInvestimentoManager = null;

	private Mock perfilInvestimentoDao = null;

	private PerfilInvestimento perfilInvestimento;

	// ~ Methods
	// ================================================================

	protected void setUp() throws Exception {
		super.setUp();
		perfilInvestimentoDao = new Mock(PerfilInvestimentoDao.class);
		perfilInvestimentoManager = new PerfilInvestimentoManagerImpl(
				(PerfilInvestimentoDao) perfilInvestimentoDao.proxy());
	}

	protected void tearDown() throws Exception {
		super.tearDown();
		perfilInvestimentoManager = null;
	}

	public void testGetPerfilInvestimento() throws Exception {
		PerfilInvestimento testData = new PerfilInvestimento("1",
				Objetivo.MANTER_PATRIMONIO, new Float(34.99), new Float(13.4),
				new Float(1), Tempo.MES);
		// set expected behavior on dao
		perfilInvestimentoDao.expects(once()).method("getPerfilInvestimento")
				.with(eq(new Long(1))).will(returnValue(testData));

		PerfilInvestimento profile = perfilInvestimentoManager
				.getPerfilInvestimento("1");
		assertTrue(profile != null);
		perfilInvestimentoDao.verify();
	}

	public void testGetPerfilInvestimentoPorIdUsuario() throws Exception {
		List results = new ArrayList();
		perfilInvestimento = new PerfilInvestimento();
		results.add(perfilInvestimento);

		// set expected behavior on dao
		perfilInvestimentoDao.expects(once()).method(
				"getPerfisInvestimentosPorIdUsuario")
				.will(returnValue(results));

		List perfilInvestimentos = perfilInvestimentoManager
				.getPerfisInvestimentosPorIdUsuario(new String("1"));
		assertTrue(perfilInvestimentos.size() == 1);
		perfilInvestimentoDao.verify();
	}

	public void testGetPerfisInvestimentos() throws Exception {
		List results = new ArrayList();
		perfilInvestimento = new PerfilInvestimento();
		results.add(perfilInvestimento);

		// set expected behavior on dao
		perfilInvestimentoDao.expects(once()).method("getPerfisInvestimentos")
				.will(returnValue(results));

		List perfilInvestimentos = perfilInvestimentoManager
				.getPerfisInvestimentos(null);
		assertTrue(perfilInvestimentos.size() == 1);
		perfilInvestimentoDao.verify();
	}

	public void testSavePerfilInvestimento() throws Exception {
		PerfilInvestimento testData = new PerfilInvestimento("1",
				Objetivo.MANTER_PATRIMONIO, new Float(34.99), new Float(13.4),
				new Float(1), Tempo.MES);
		// set expected behavior on dao
		perfilInvestimentoDao.expects(once()).method("getPerfilInvestimento")
				.with(eq(new Long(1))).will(returnValue(testData));

		PerfilInvestimento profile = perfilInvestimentoManager
				.getPerfilInvestimento("1");
		profile.setNome("testprofile");
		perfilInvestimentoDao.verify();

		// reset expectations
		perfilInvestimentoDao.reset();
		perfilInvestimentoDao.expects(once()).method("savePerfilInvestimento")
				.with(same(profile));

		perfilInvestimentoManager.savePerfilInvestimento(profile);
		assertTrue(profile.getNome().equals("testprofile"));
		perfilInvestimentoDao.verify();
	}

	public void testAddAndRemovePerfilInvestimento() throws Exception {
		PerfilInvestimento perfilInvestimento = new PerfilInvestimento();
		// call populate method in super class to populate test data
		// from a properties file matching this class name
		// perfilInvestimento = (Profile) populate(perfilInvestimento);
		// perfilInvestimento.setUser(new User("mauricio"));
		perfilInvestimento.setNome("Teste Risco");
		perfilInvestimento.setObjetivo(Objetivo.AUMENTO_SUBSTANCIAL);
		perfilInvestimento.setPatrimonio(new Float(344000));
		perfilInvestimento.setRendimentoEsperado(new Float(16));
		perfilInvestimento.setRisco(new Float(25));
		perfilInvestimento.setRiscoMaximo(new Float(30));
		perfilInvestimento.setSegmentoPreferencial(Segmento.TELECOMUNICACAO);
		perfilInvestimento.setLiquidez(new Float(1));
		perfilInvestimento.setTipoLiquidez(Tempo.DIA);
		perfilInvestimento.setPrazo(new Float(1));
		perfilInvestimento.setTipoPrazo(Tempo.MES);
		perfilInvestimento.setTempo(new Float(6));
		perfilInvestimento.setTipoTempo(Tempo.MES);

		// set expected behavior on perfilInvestimento dao
		perfilInvestimentoDao.expects(once()).method("savePerfilInvestimento")
				.with(same(perfilInvestimento));

		perfilInvestimentoManager.savePerfilInvestimento(perfilInvestimento);
		assertTrue(perfilInvestimento.getNome().equals("Teste Risco"));
		perfilInvestimentoDao.verify();

		// reset expectations
		perfilInvestimentoDao.reset();

		perfilInvestimentoDao.expects(once())
				.method("removePerfilInvestimento").with(eq(new Long(5)));
		perfilInvestimentoManager.removePerfilInvestimento("5");
		perfilInvestimentoDao.verify();

		// reset expectations
		perfilInvestimentoDao.reset();
		perfilInvestimentoDao.expects(once()).method("getPerfilInvestimento")
				.will(returnValue(null));
		perfilInvestimento = perfilInvestimentoManager
				.getPerfilInvestimento("5");
		assertNull(perfilInvestimento);
		perfilInvestimentoDao.verify();
	}
}
