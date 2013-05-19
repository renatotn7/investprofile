package br.pucrio.inf.les.investprofile.webapp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.acegisecurity.context.SecurityContextHolder;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import br.pucrio.inf.les.investprofile.Constants;
import br.pucrio.inf.les.investprofile.model.User;
import br.pucrio.inf.les.investprofile.service.PerfilInvestimentoManager;
import br.pucrio.inf.les.investprofile.service.UserManager;

/**
 * 
 * @author <a href="mailto:mauricio.pinheiro@gmail.com">Mauricio Costa Pinheiro</a>
 * @version %I%, %G%
 */
public class PerfilInvestimentoController implements Controller {
	private final Log log = LogFactory
			.getLog(PerfilInvestimentoController.class);

	private PerfilInvestimentoManager perfilInvestimentoManager = null;

	private UserManager userManager = null;

	/**
	 * @param perfilInvestimentoManager
	 */
	public void setPerfilInvestimentoManager(
			PerfilInvestimentoManager perfilInvestimentoManager) {
		this.perfilInvestimentoManager = perfilInvestimentoManager;
	}

	/**
	 * @param userManager
	 * 
	 */
	public void setUserManager(UserManager userManager) {
		this.userManager = userManager;
	}

	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		if (log.isDebugEnabled()) {
			log.debug("entering 'handleRequest' method...");
		}

		String idUsuario = null;
		User currentUser = null;

		if (request.getParameter("idUsuario") != null)
			idUsuario = request.getParameter("idUsuario");
		else {
			try {
				String userName = request.getRemoteUser();
				
				currentUser = userManager.getUserByUsername(userName);
				if (currentUser.getId() == null) {
					if (log.isDebugEnabled())
						log.debug("Usuario inexistente!");
					return new ModelAndView("redirect:/MainMenu.html");
				}
			} catch (NullPointerException ex) {
				if (log.isDebugEnabled()) {
					log.debug("Usuario inexistente!");
				}
				return new ModelAndView("redirect:/MainMenu.html");
			}
		}
		if (idUsuario == null)
			return new ModelAndView("perfilInvestimentoList",
					Constants.PERFILINVESTIMENTO_LISTA,
					perfilInvestimentoManager
							.getPerfisInvestimentosPorIdUsuario(currentUser
									.getId().toString()));
		else
			return new ModelAndView("perfilInvestimentoList",
					Constants.PERFILINVESTIMENTO_LISTA,
					perfilInvestimentoManager
							.getPerfisInvestimentosPorIdUsuario(idUsuario));
	}
}
