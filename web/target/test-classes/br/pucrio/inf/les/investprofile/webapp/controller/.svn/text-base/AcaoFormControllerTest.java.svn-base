package br.pucrio.inf.les.investprofile.webapp.controller;

import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.validation.BindException;
import org.springframework.validation.Errors;
import org.springframework.web.servlet.ModelAndView;

import br.pucrio.inf.les.investprofile.model.Acao;
import br.pucrio.inf.les.investprofile.model.EspecificacaoPapel;
import br.pucrio.inf.les.investprofile.model.Segmento;

/**
 *
 * @author <a href="mailto:mauricio.pinheiro@gmail.com">Mauricio Costa Pinheiro</a>
 * @version %I%, %G%
 */
public class AcaoFormControllerTest extends BaseControllerTestCase {
	private AcaoFormController c;

	private MockHttpServletRequest request;

	private ModelAndView mv;

	/**
	 * @param form
	 */
	public void setAcaoFormController(AcaoFormController form) {
		this.c = form;
	}

	/**
	 * @throws Exception
	 */
	public void testEdit() throws Exception {
		log.debug("testing edit...");
		request = newGet("/acaoForm.html");
		request.addParameter("id", "1");

		mv = c.handleRequest(request, new MockHttpServletResponse());

		assertEquals("acaoForm", mv.getViewName());
	}

	/**
	 * @throws Exception
	 */
	public void testSave() throws Exception {
		request = newGet("/acaoForm.html");
		request.addParameter("id", "6");

		request.setRemoteUser("admin");
		
		mv = c.handleRequest(request, new MockHttpServletResponse());

		Acao acao = (Acao) mv.getModel().get(c.getCommandName());
		assertNotNull(acao);
		request = newPost("/acaoForm.html");
		super.objectToRequestParameters(acao, request);

		// update the form's fields and add it back to the request
		acao.setCodigoADR("RIOPR");
		acao.setCodigoBovespa("VALE5");
		acao.setNome("BaKpBrAjQwFzRcLmTyMdWdTcMyHvWdPmGlUeUjWaEvPzAeTsBw");
		acao.setFatorNegociacao(new Integer(5));
		acao.setSegmento(Segmento.MINERACAO);
		acao.setEspecificacaoPapel(EspecificacaoPapel.PN);

		mv = c.handleRequest(request, new MockHttpServletResponse());
		Errors errors = (Errors) mv.getModel().get(BindException.MODEL_KEY_PREFIX  + "acao");

		if (errors != null) {
			log.debug(errors);
		}
		assertNull(errors);
		assertNotNull(request.getSession().getAttribute("successMessages"));
	}

	/**
	 * @throws Exception
	 */
	public void testRemove() throws Exception {
		request = newPost("/acaoForm.html");
		request.addParameter("delete", "");
		request.addParameter("id", "6");

		mv = c.handleRequest(request, new MockHttpServletResponse());
		assertNotNull(request.getSession().getAttribute("successMessages"));
	}
}
