package br.pucrio.inf.les.investprofile.dao;

import java.util.List;
import br.pucrio.inf.les.investprofile.model.Questao;

public class QuestaoDaoTest extends BaseDaoTestCase {
    private Questao questao = null;
    private QuestaoDao dao = null;

    public void setQuestaoDao(QuestaoDao dao) {
        this.dao = dao;
    }

    public void testGetQuestaoInvalid() throws Exception {
        questao = dao.getQuestaoPorTrechoPergunta("badquestaoresposta");
        assertNull(questao);
    }

    public void testGetQuestao() throws Exception {
        questao = dao.getQuestaoPorTrechoPergunta(new String("Qual a percentagem de ganho mensal"));
        assertNotNull(questao);
    }

    public void testGetQuestoes() {
        questao = new Questao();
        List results = dao.getQuestoes(questao);
        assertTrue(results.size() > 0);
    }
    
    public void testUpdateQuestao() throws Exception {
    	questao = dao.getQuestao(1L);
        log.debug(questao);
        questao.setPergunta("Quanto você quer ganhar hoje?");
        
        dao.saveQuestao(questao);

        assertEquals(dao.getQuestao(1L).getPergunta(), "Quanto você quer ganhar hoje?");
    }

    public void testAddAndRemoveQuestao() throws Exception {
        questao = new Questao("Quantos dedos tem na minha mão?");
        questao.setId(null);
        dao.saveQuestao(questao);
        assertNotNull(questao.getPergunta());

        dao.removeQuestao(dao.getQuestaoPorTrechoPergunta("Quantos dedos tem").getId());

        endTransaction();

        questao = dao.getQuestaoPorTrechoPergunta("Quantos dedos tem");
        assertNull(questao);
    }
}
