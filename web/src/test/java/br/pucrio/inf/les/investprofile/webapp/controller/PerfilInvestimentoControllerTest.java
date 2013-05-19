package br.pucrio.inf.les.investprofile.webapp.controller;

import java.util.Map;

import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.web.servlet.ModelAndView;

import br.pucrio.inf.les.investprofile.Constants;

/**
 *
 * @author <a href="mailto:mauricio.pinheiro@gmail.com">Mauricio Costa Pinheiro</a>
 * @version %I%, %G%
 */
public class PerfilInvestimentoControllerTest extends BaseControllerTestCase {
	private MockHttpServletRequest request;

	/**
	 * @throws Exception
	 */
	public void testHandleRequest() throws Exception {
		/*
		 * // autenticando usuário do sistema SecurityContext context = new
		 * SecurityContextImpl(); UsernamePasswordAuthenticationToken token =
		 * new UsernamePasswordAuthenticationToken("admin", "admin", new
		 * GrantedAuthority[] {new GrantedAuthorityImpl(Constants.ADMIN_ROLE)});
		 * context.setAuthentication(token);
		 * SecurityContextHolder.setContext(context);
		 */
		PerfilInvestimentoController c = (PerfilInvestimentoController) applicationContext
				.getBean("perfilInvestimentoController");
		request = newGet("/perfilInvestimentoList.html");
		request.addParameter("idUsuario", "2");

		ModelAndView mav = c.handleRequest(request,
				new MockHttpServletResponse());

		Map m = mav.getModel();
		assertNotNull(m.get(Constants.PERFILINVESTIMENTO_LISTA));
		assertEquals(mav.getViewName(), "perfilInvestimentoList");
	}
}
