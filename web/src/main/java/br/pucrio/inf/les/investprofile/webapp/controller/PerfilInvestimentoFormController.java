package br.pucrio.inf.les.investprofile.webapp.controller;

import java.util.Iterator;
import java.util.Locale;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.acegisecurity.userdetails.UsernameNotFoundException;
import org.apache.commons.lang.StringUtils;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import br.pucrio.inf.les.investprofile.model.PerfilInvestimento;
import br.pucrio.inf.les.investprofile.model.User;
import br.pucrio.inf.les.investprofile.service.PerfilInvestimentoManager;
import br.pucrio.inf.les.investprofile.service.UserManager;

/**
 * 
 * @author <a href="mailto:mauricio.pinheiro@gmail.com">Mauricio Costa Pinheiro</a>
 * @version %I%, %G%
 */
public class PerfilInvestimentoFormController extends BaseFormController {
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
	 */
	public void setUserManager(UserManager userManager) {
		this.userManager = userManager;
	}

	/**
	 * 
	 */
	public PerfilInvestimentoFormController() {
		setCommandName("perfilInvestimento");
		setCommandClass(PerfilInvestimento.class);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.pucrio.inf.les.investprofile.webapp.controller.BaseFormController#processFormSubmission(javax.servlet.http.HttpServletRequest,
	 *      javax.servlet.http.HttpServletResponse, java.lang.Object,
	 *      org.springframework.validation.BindException)
	 */
	public ModelAndView processFormSubmission(HttpServletRequest request,
			HttpServletResponse response, Object command, BindException errors)
			throws Exception {
		if (request.getParameter("cancel") != null) {
			return new ModelAndView(new RedirectView(getCancelView()));
		}

		return super.processFormSubmission(request, response, command, errors);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.web.servlet.mvc.AbstractFormController#formBackingObject(javax.servlet.http.HttpServletRequest)
	 */
	protected Object formBackingObject(HttpServletRequest request)
			throws Exception {
		String id = request.getParameter("id");
		PerfilInvestimento perfilInvestimento = null;

		if (!StringUtils.isEmpty(id)) {
			perfilInvestimento = perfilInvestimentoManager
					.getPerfilInvestimento(id);
		} else {
			perfilInvestimento = new PerfilInvestimento();
		}

		return perfilInvestimento;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.web.servlet.mvc.SimpleFormController#onSubmit(javax.servlet.http.HttpServletRequest,
	 *      javax.servlet.http.HttpServletResponse, java.lang.Object,
	 *      org.springframework.validation.BindException)
	 */
	public ModelAndView onSubmit(HttpServletRequest request,
			HttpServletResponse response, Object command, BindException errors)
			throws Exception {
		if (log.isDebugEnabled()) {
			log.debug("entering 'onSubmit' method...");
		}

		PerfilInvestimento perfilInvestimento = (PerfilInvestimento) command;
		boolean isNew = (perfilInvestimento.getId() == null);
		Locale locale = request.getLocale();

		PerfilInvestimento userPerfilInvestimento = null;
		boolean existePerfilInvestimento = false;

		if (request.getParameter("delete") != null) {
			perfilInvestimentoManager
					.removePerfilInvestimento(perfilInvestimento.getId()
							.toString());

			saveMessage(request, getText("perfilInvestimento.deleted", locale));
		} else {

			perfilInvestimentoManager
					.savePerfilInvestimento(perfilInvestimento);

			User currentUser = null;
			try {
				String userName = request.getRemoteUser();
				log.debug(userName);
				currentUser = userManager.getUserByUsername(userName);
				if (currentUser.getId() == null) {
					if (log.isDebugEnabled())
						log.debug("Usuario inexistente!");
					return new ModelAndView("redirect:MainMenu.html");
				}
			} catch (UsernameNotFoundException ex) {
				if (log.isDebugEnabled()) {
					log.debug("Usuario inexistente!");
				}
				return new ModelAndView("redirect:MainMenu.html");
			} catch (NullPointerException ex) {
				if (log.isDebugEnabled()) {
					log.debug("Usuario inexistente!");
				}
				return new ModelAndView("redirect:MainMenu.html");
			}

			Set perfisInvestimentos = currentUser.getPerfisInvestimentos();
			Iterator perfilInvestimentosIterator = perfisInvestimentos
					.iterator();
			while (perfilInvestimentosIterator.hasNext()
					&& !existePerfilInvestimento) {
				userPerfilInvestimento = (PerfilInvestimento) perfilInvestimentosIterator
						.next();
				if (userPerfilInvestimento.equals(perfilInvestimento))
					existePerfilInvestimento = true;
			}
			if (!existePerfilInvestimento) {
				currentUser.addPerfilInvestimento(perfilInvestimento);
				userManager.saveUser(currentUser);
			}

			String key = (isNew) ? "perfilInvestimento.added"
					: "perfilInvestimento.updated";
			saveMessage(request, getText(key, locale));

			if (!isNew) {
				return new ModelAndView("redirect:perfilInvestimentoForm.html",
						"id", perfilInvestimento.getId());
			}
		}

		return new ModelAndView(getSuccessView());
	}
}
