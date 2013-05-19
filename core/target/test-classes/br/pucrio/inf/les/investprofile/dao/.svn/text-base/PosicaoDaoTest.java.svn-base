package br.pucrio.inf.les.investprofile.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import br.pucrio.inf.les.investprofile.model.Acao;
import br.pucrio.inf.les.investprofile.model.Posicao;

/**
 *
 * @author <a href="mailto:mauricio.pinheiro@gmail.com">Mauricio Costa Pinheiro</a>
 * @version %I%, %G%
 */
public class PosicaoDaoTest extends BaseDaoTestCase {
	private Posicao posicao = null;

	private PosicaoDao dao = null;

	private List<Posicao> posicoes = null;

	private AcaoDao sdao = null;

	/**
	 * @param dao
	 */
	public void setPosicaoDao(PosicaoDao dao) {
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
	public void testGetPosicaoInvalid() throws Exception {
		Long id = 13L;
		try {
			posicao = dao.getPosicao(id);
		} catch (DataAccessException d) {
    		if (log.isDebugEnabled()) {
    			log.debug("Posicao " + id.toString() + " não encontrada do banco de dados.");
    		}
			assertTrue(d != null);
		}
	}

	/**
	 * @throws Exception
	 */
	public void testGetPosicao() throws Exception {
		Long id = 1L;
		try {
			posicao = dao.getPosicao(id);
			assertNotNull(posicao);
		} catch (DataAccessException e) {
    		if (log.isDebugEnabled()) {
    			log.debug("Posicao " + id.toString() + " não encontrada do banco de dados.");
    		}
			assertTrue(e != null);
		}
	}

	/**
	 * 
	 */
	public void testGetPosicoes() {
		posicao = new Posicao();
		List<Posicao> results = dao.getPosicoes(posicao);
		assertTrue(results.size() > 0);
	}

	/**
	 * @throws Exception
	 */
	public void testGetPosicaoPorPerfil() throws Exception {
		Long id = 1L;
		try {
			posicoes = dao
					.getPosicoesPorPerfil(id);
			assertTrue(posicoes.size() > 0);
		} catch (DataAccessException e) {
    		if (log.isDebugEnabled()) {
    			log.debug("Posicao " + id.toString() + " não encontrada do banco de dados.");
    		}
			assertTrue(e != null);
		}
	}

	/**
	 * @throws Exception
	 */
	public void testUpdatePosicao() throws Exception {
		Long id = new Long(1);
		Acao acao = new Acao();
		String codigoBovespa = new String("VALE5");
		try {
			posicao = dao.getPosicao(id);
			assertNotNull(posicao);
		} catch (DataAccessException e) {
    		if (log.isDebugEnabled()) {
    			log.debug("Posicao " + id.toString() + " não encontrada do banco de dados.");
    		}
			assertTrue(e != null);
		}
		try {
			acao = sdao.getAcaoPorCodigoBovespa(codigoBovespa);
			assertNotNull(acao);
		} catch (DataAccessException e) {
    		if (log.isDebugEnabled()) {
    			log.debug("Acao com código bovespa " + codigoBovespa + " não encontrada do banco de dados.");
    		}
			assertTrue(e != null);
		}		
		posicao.setAcao(acao);
		dao.savePosicao(posicao);
		assertEquals(dao.getPosicao(1L).getAcao()
				.getCodigoBovespa(), "VALE5");

	}

	/**
	 * @throws Exception
	 */
	public void testAddAndRemovePosicao() throws Exception {
		Long id = new Long(1);
		Long idNew = null;
		Acao acao = new Acao();
		try {
			acao = sdao.getAcao(id);
			assertNotNull(acao);
		} catch (DataAccessException e) {
    		if (log.isDebugEnabled()) {
    			log.debug("Acao " + id.toString() + " não encontrada do banco de dados.");
    		}
			assertTrue(e != null);
		}		
		try {
			posicao = new Posicao(acao,
					new Double(234.77));
		} catch (DataAccessException e) {
    		if (log.isDebugEnabled()) {
    			log.debug("AcaoCarteira " + id.toString() + " não encontrada do banco de dados.");
    		}
			assertTrue(e != null);
		}		
		posicao.setId(null);
		dao.savePosicao(posicao);
		assertNotNull(posicao.getAcao().getCodigoBovespa());
		idNew = posicao.getId();

		dao.removePosicao(idNew);
		endTransaction();

		try {
			posicao = dao.getPosicao(idNew);
		} catch (DataAccessException d) {
    		if (log.isDebugEnabled()) {
    			log.debug("Posicao " + idNew.toString() + " não encontrada do banco de dados.");
    		}			
			assertTrue(d != null);
		}
	}
}
