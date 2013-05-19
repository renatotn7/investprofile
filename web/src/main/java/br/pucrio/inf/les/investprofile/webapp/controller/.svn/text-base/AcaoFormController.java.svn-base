package br.pucrio.inf.les.investprofile.webapp.controller;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;

import br.pucrio.inf.les.investprofile.model.Acao;
import br.pucrio.inf.les.investprofile.service.AcaoManager;

/**
 *
 * @author <a href="mailto:mauricio.pinheiro@gmail.com">Mauricio Costa Pinheiro</a>
 * @version %I%, %G%
 */
public class AcaoFormController extends BaseFormController {
	private AcaoManager acaoManager = null;

	/**
	 * @param acaoManager
	 */
	public void setAcaoManager(AcaoManager acaoManager) {
		this.acaoManager = acaoManager;
	}

	/**
	 * 
	 */
	public AcaoFormController() {
		setCommandClass(Acao.class);
		setCommandName("acao");
	}

	protected Object formBackingObject(HttpServletRequest request)
			throws Exception {
		String id = request.getParameter("id");

		if (!StringUtils.isEmpty(id)) {
			return acaoManager.get(new Long(id));
		}
		return new Acao();
	}

	public ModelAndView onSubmit(HttpServletRequest request,
			HttpServletResponse response, Object command, BindException errors)
			throws Exception {
		if (log.isDebugEnabled()) {
			log.debug("entering 'onSubmit' method...");
		}

		Acao acao = (Acao) command;
		boolean isNew = (acao.getId() == null);
		Locale locale = request.getLocale();

		if (request.getParameter("delete") != null) {
			acaoManager.remove(acao.getId());
			saveMessage(request, getText("acao.deleted", locale));
		} else {
			acaoManager.save(acao);
			
			String key = (isNew) ? "acao.added" : "acao.updated";
			saveMessage(request, getText(key, locale));

			if (!isNew) {
				return new ModelAndView("redirect:acaoForm.html", "id", acao
						.getId());
			}
		}

		return new ModelAndView(getSuccessView());
	}
}
