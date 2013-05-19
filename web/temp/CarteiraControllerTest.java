package br.pucrio.inf.les.investprofile.webapp.controller;

import java.util.Map;

import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.web.servlet.ModelAndView;

import br.pucrio.inf.les.investprofile.Constants;

public class CarteiraControllerTest extends BaseControllerTestCase {
	private MockHttpServletRequest request;

	public void testHandleRequest() throws Exception {
		/*
		// autenticando usuário do sistema
		SecurityContext context = new SecurityContextImpl();
		UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(
				"tomcat", "tomcat",
				new GrantedAuthority[] { new GrantedAuthorityImpl(
						Constants.USER_ROLE) });
		context.setAuthentication(token);
		SecurityContextHolder.setContext(context);
*/
		
		CarteriaController c = (CarteriaController) applicationContext
				.getBean("carteiraAtualController");
		request = newGet("/carteiraAtualList.html");
		request.addParameter("idUsuario", "2");
		request.addParameter("idPerfilInvestimento", "1");
		// ModelAndView mav = c.handleRequest((HttpServletRequest)
		// null,(HttpServletResponse) null);
		ModelAndView mav = c.handleRequest(request,
				new MockHttpServletResponse());
		Map m = mav.getModel();

		assertNotNull(m.get(Constants.CARTEIRAATUAL_LISTA));
		assertEquals(mav.getViewName(), "carteiraAtualList");
	}
}