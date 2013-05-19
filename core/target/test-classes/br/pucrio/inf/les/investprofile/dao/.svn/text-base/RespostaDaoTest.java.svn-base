package br.pucrio.inf.les.investprofile.dao;

import java.util.List;
import br.pucrio.inf.les.investprofile.model.Resposta;

public class RespostaDaoTest extends BaseDaoTestCase {
    private Resposta resposta = null;
    private RespostaDao dao = null;

    public void setRespostaDao(RespostaDao dao) {
        this.dao = dao;
    }

    public void testGetOpcaoInvalid() throws Exception {
        resposta = dao.getRespostaPorTrechoResposta("badopcaoresposta");
        assertNull(resposta);
    }

    public void testGetOpcao() throws Exception {
        resposta = dao.getRespostaPorTrechoResposta(new String("Até 2%"));
        assertNotNull(resposta);
    }

    public void testGetOpcoes() {
        resposta = new Resposta();
        List results = dao.getRespostas(resposta);
        assertTrue(results.size() > 0);
    }
    
    public void testUpdateOpcao() throws Exception {
    	resposta = dao.getResposta(1L);
        log.debug(resposta);
        resposta.setConteudo("Até 5%");
        
        dao.saveResposta(resposta);

        assertEquals(dao.getResposta(1L).getConteudo(), "Até 5%");
    }

    public void testAddAndRemoveOpcao() throws Exception {
        resposta = new Resposta("Conservar o patrimônio e/ou manter uma reserva");
        resposta.setId(null);
        dao.saveResposta(resposta);
        assertNotNull(resposta.getConteudo());

        dao.removeResposta(dao.getRespostaPorTrechoResposta("Conservar o patrimônio").getId());

        endTransaction();

        resposta = dao.getRespostaPorTrechoResposta("Conservar o patrimônio");
        assertNull(resposta);
    }
}
