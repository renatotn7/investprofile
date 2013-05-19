package br.pucrio.inf.les.investprofile.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.jmock.Mock;

import br.pucrio.inf.les.investprofile.dao.RecomendacaoPerfilDao;
import br.pucrio.inf.les.investprofile.model.RecomendacaoPerfil;

/**
 * @author Jonny
 * 
 */
public class RecomendacaoPerfilManagerImplTest extends BaseManagerMockTestCase {
	// ~ Instance fields
	// ========================================================

	private RecomendacaoPerfilManagerImpl recomendacaoPerfilManager = null;

	private Mock recomendacaoPerfilDao = null;

	// ~ Methods
	// ================================================================

	protected void setUp() throws Exception {
		super.setUp();
		recomendacaoPerfilDao = new Mock(RecomendacaoPerfilDao.class);
		recomendacaoPerfilManager = new RecomendacaoPerfilManagerImpl(
				(RecomendacaoPerfilDao) recomendacaoPerfilDao.proxy());
	}

	protected void tearDown() throws Exception {
		super.tearDown();
		recomendacaoPerfilManager = null;
	}

	/**
	 * @throws Exception
	 */
	public void testGetRecomendacoesPerfis() throws Exception {
		List<RecomendacaoPerfil> results = new ArrayList();
		RecomendacaoPerfil recomendacaoPerfil = new RecomendacaoPerfil();
		results.add(recomendacaoPerfil);

		// set expected behavior on dao
		recomendacaoPerfilDao.expects(once()).method("getRecomendacoesPerfis")
				.will(returnValue(results));

		List<RecomendacaoPerfil> recomendacoesPerfis = recomendacaoPerfilManager
				.getRecomendacoesPerfis(new RecomendacaoPerfil());
		assertTrue(recomendacoesPerfis.size() > 0);
		recomendacaoPerfilDao.verify();
	}
}
