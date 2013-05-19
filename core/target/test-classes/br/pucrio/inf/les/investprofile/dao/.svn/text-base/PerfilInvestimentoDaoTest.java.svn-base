package br.pucrio.inf.les.investprofile.dao;

import java.util.List;

import br.pucrio.inf.les.investprofile.model.Objetivo;
import br.pucrio.inf.les.investprofile.model.PerfilInvestimento;
import br.pucrio.inf.les.investprofile.model.Segmento;
import br.pucrio.inf.les.investprofile.model.Tempo;

/**
 * @author Jonny
 * 
 */
public class PerfilInvestimentoDaoTest extends BaseDaoTestCase {
	private PerfilInvestimento perfilInvestimento = null;

	private PerfilInvestimentoDao dao = null;

	/**
	 * @param dao
	 */
	public void setPerfilInvestimentoDao(PerfilInvestimentoDao dao) {
		this.dao = dao;
	}

	/**
	 * @throws Exception
	 */
	public void testGetPerfilInvestimentoInvalid() throws Exception {
		perfilInvestimento = dao
				.getPerfilInvestimentoPorNome("badPerfilInvestimentoname");
		assertNull(perfilInvestimento);
	}

	/**
	 * @throws Exception
	 */
	public void testGetPerfilInvestimento() throws Exception {
		perfilInvestimento = dao.getPerfilInvestimentoPorNome("Baixo Risco");
		assertNotNull(perfilInvestimento);
	}

	/**
	 * 
	 */
	public void testGetPerfilInvestimentosPorUserId() {
		List results = dao.getPerfisInvestimentosPorIdUsuario(new Long(1));
		assertTrue(results.size() > 0);
	}

	/**
	 * 
	 */
	public void testGetPerfilInvestimentos() {
		perfilInvestimento = new PerfilInvestimento();
		List results = dao.getPerfisInvestimentos(perfilInvestimento);
		assertTrue(results.size() > 0);
	}

	/**
	 * @throws Exception
	 */
	public void testUpdatePerfilInvestimento() throws Exception {
		perfilInvestimento = dao.getPerfilInvestimentoPorNome("Alto Risco");
		log.debug(perfilInvestimento);
		perfilInvestimento.setNome("Médio Risco");

		dao.savePerfilInvestimento(perfilInvestimento);
		assertEquals(perfilInvestimento.getNome(), "Médio Risco");
	}

	/**
	 * @throws Exception
	 */
	public void testAddAndRemovePerfilInvestimento() throws Exception {
		perfilInvestimento = dao.getPerfilInvestimentoPorNome("Alto Risco");
		// user = PerfilInvestimento.getUser();
		perfilInvestimento = null;

		perfilInvestimento = new PerfilInvestimento("testPerfilInvestimento",
				Objetivo.AUMENTO_SUBSTANCIAL, new Float(13.7), new Float(22),
				new Float(2), Tempo.MES);
		perfilInvestimento.setPatrimonio(new Float(120000));
		perfilInvestimento.setRiscoMaximo(new Float(50.0));
		perfilInvestimento.setLiquidez(new Float(3));
		perfilInvestimento.setTipoLiquidez(Tempo.DIA);
		perfilInvestimento.setTempo(new Float(1));
		perfilInvestimento.setTipoTempo(Tempo.ANO);
		perfilInvestimento.setSegmentoPreferencial(Segmento.VAREJO);

		dao.savePerfilInvestimento(perfilInvestimento);
		assertNotNull(perfilInvestimento.getNome());

		dao.removePerfilInvestimento(dao.getPerfilInvestimentoPorNome(
				"testPerfilInvestimento").getId());

		endTransaction();

		perfilInvestimento = dao
				.getPerfilInvestimentoPorNome("testPerfilInvestimento");
		assertNull(perfilInvestimento);
	}
}
