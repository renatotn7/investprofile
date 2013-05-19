package br.pucrio.inf.les.investprofile.webapp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import br.pucrio.inf.les.investprofile.Constants;
import br.pucrio.inf.les.investprofile.model.Acao;
import br.pucrio.inf.les.investprofile.service.AcaoManager;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/**
 * @author jonny
 */
public class AcaoController implements Controller {
	private final Log log = LogFactory.getLog(AcaoController.class);

	private AcaoManager acaoManager = null;

	/**
	 * @param acaoManager
	 */
	public void setAcaoManager(AcaoManager acaoManager) {
		this.acaoManager = acaoManager;
	}

	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		if (log.isDebugEnabled()) {
			log.debug("entering 'handleRequest' method...");
		}

		return new ModelAndView("acaoList", Constants.ACAO_LISTA, acaoManager
				.getAcoes(new Acao()));
	}
}
