package br.pucrio.inf.les.investprofile.webapp.controller;

import java.util.Map;
import br.pucrio.inf.les.investprofile.Constants;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.acegisecurity.GrantedAuthority;
import org.acegisecurity.GrantedAuthorityImpl;
import org.acegisecurity.context.SecurityContext;
import org.acegisecurity.context.SecurityContextHolder;
import org.acegisecurity.context.SecurityContextImpl;
import org.acegisecurity.providers.UsernamePasswordAuthenticationToken;

public class QuestionarioControllerTest extends BaseControllerTestCase {
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
		 * */
		
		QuestionarioController q = (QuestionarioController) applicationContext
				.getBean("questionarioController");

		request = newGet("/editQuestionario.html");
		request.addParameter("idUsuario", "2");
		request.addParameter("idPerfilInvestimento", "1");
		// ModelAndView mav = c.handleRequest((HttpServletRequest)
		// null,(HttpServletResponse) null);
		ModelAndView mav = q.handleRequest(request,
				new MockHttpServletResponse());
		Map m = mav.getModel();

		assertNotNull(m.get(Constants.QUESTIONARIO));
		assertEquals(mav.getViewName(), "questionarioForm");
	}
}