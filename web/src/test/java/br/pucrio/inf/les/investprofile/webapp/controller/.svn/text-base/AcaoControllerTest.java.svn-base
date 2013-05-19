package br.pucrio.inf.les.investprofile.webapp.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.pucrio.inf.les.investprofile.Constants;
import org.springframework.web.servlet.ModelAndView;

public class AcaoControllerTest extends BaseControllerTestCase {
	public void testHandleRequest() throws Exception {
		AcaoController c = (AcaoController) applicationContext.getBean("acaoController");
		ModelAndView mav = c.handleRequest((HttpServletRequest) null,
				(HttpServletResponse) null);
		Map m = mav.getModel();
		assertNotNull(m.get(Constants.ACAO_LISTA));
		assertEquals(mav.getViewName(), "acaoList");
	}
}
