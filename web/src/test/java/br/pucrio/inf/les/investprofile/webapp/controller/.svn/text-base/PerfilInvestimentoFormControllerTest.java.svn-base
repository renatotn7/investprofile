package br.pucrio.inf.les.investprofile.webapp.controller;

import org.acegisecurity.GrantedAuthority;
import org.acegisecurity.GrantedAuthorityImpl;
import org.acegisecurity.context.SecurityContext;
import org.acegisecurity.context.SecurityContextHolder;
import org.acegisecurity.context.SecurityContextImpl;
import org.acegisecurity.providers.UsernamePasswordAuthenticationToken;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.validation.BindException;
import org.springframework.validation.Errors;
import org.springframework.web.servlet.ModelAndView;

import br.pucrio.inf.les.investprofile.Constants;
import br.pucrio.inf.les.investprofile.model.Objetivo;
import br.pucrio.inf.les.investprofile.model.PerfilInvestimento;
import br.pucrio.inf.les.investprofile.model.Segmento;
import br.pucrio.inf.les.investprofile.model.Tempo;


/**
 *
 * @author <a href="mailto:mauricio.pinheiro@gmail.com">Mauricio Costa Pinheiro</a>
 * @version %I%, %G%
 */
public class PerfilInvestimentoFormControllerTest extends BaseControllerTestCase {
    private PerfilInvestimentoFormController c;
    private MockHttpServletRequest request;
    private ModelAndView mv;

	/**
	 * @param form
	 */
	public void setPerfilInvestimentoFormController(PerfilInvestimentoFormController form) {
		this.c = form;
	}

    /**
     * @throws Exception
     */
    public void testEdit() throws Exception {
        log.debug("testing edit...");
        request = newGet("/perfilInvestimentoForm.html");
        request.addParameter("id", "1");

        mv = c.handleRequest(request, new MockHttpServletResponse());

        assertEquals("perfilInvestimentoForm", mv.getViewName());
    }

    /**
     * @throws Exception
     */
    /*
    public void testSave() throws Exception {
   	
        request = newGet("/perfilInvestimentoForm.html");
        // Qual o perfil que será alterado
        request.addParameter("id", "2");
        
    	// Indicando o usuário para ser associado ao perfil
    	request.setRemoteUser("user");
       
        mv = c.handleRequest(request, new MockHttpServletResponse());

        PerfilInvestimento perfilInvestimento = (PerfilInvestimento) mv.getModel().get(c.getCommandName());
        assertNotNull(perfilInvestimento);
        request = newPost("/perfilInvestimentoForm.html");
        super.objectToRequestParameters(perfilInvestimento, request);
        
        // update the form's fields and add it back to the request
        perfilInvestimento.setNome("t");
        perfilInvestimento.setObjetivo(Objetivo.RENDA_CAPITAL);
        perfilInvestimento.setPatrimonio(new Float(3.2467325E38));
        perfilInvestimento.setRendimentoEsperado(new Float(3.1235467E38));
        perfilInvestimento.setRisco(new Float(3));
        perfilInvestimento.setRiscoMaximo(new Float(5.1576297E37));
        perfilInvestimento.setSegmentoPreferencial(Segmento.MINERACAO);
        perfilInvestimento.setLiquidez(new Float(3));
        perfilInvestimento.setTipoLiquidez(Tempo.MES);
        perfilInvestimento.setPrazo(new Float(1));
        perfilInvestimento.setTipoPrazo(Tempo.ANO);
        perfilInvestimento.setTempo(new Float(2));
        perfilInvestimento.setTipoTempo(Tempo.ANO);
        
        mv = c.handleRequest(request, new MockHttpServletResponse());
        Errors errors = (Errors) mv.getModel().get(BindException.MODEL_KEY_PREFIX + "perfilInvestimento");

        if (errors != null) {
            log.debug(errors);
        }
        assertNull(errors);
        assertNotNull(request.getSession().getAttribute("successMessages"));
    }
*/
    /**
     * @throws Exception
     */
    public void testRemove() throws Exception {
        request = newPost("/perfilInvestimentoForm.html");
        request.addParameter("delete", "");
        request.addParameter("id", "4");
        mv = c.handleRequest(request, new MockHttpServletResponse());
        assertNotNull(request.getSession().getAttribute("successMessages"));
    }
}
