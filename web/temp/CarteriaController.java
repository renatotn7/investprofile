package br.pucrio.inf.les.investprofile.webapp.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.acegisecurity.context.SecurityContextHolder;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import br.pucrio.inf.les.investprofile.Constants;
import br.pucrio.inf.les.investprofile.model.LabelValue;
import br.pucrio.inf.les.investprofile.model.PerfilInvestimento;
import br.pucrio.inf.les.investprofile.model.User;
import br.pucrio.inf.les.investprofile.service.CarteiraManager;
import br.pucrio.inf.les.investprofile.service.PerfilInvestimentoManager;
import br.pucrio.inf.les.investprofile.service.PosicaoManager;
import br.pucrio.inf.les.investprofile.service.UserManager;

/**
 * @author jonny
 */
public class CarteriaController implements Controller {

	private final Log log = LogFactory.getLog(CarteriaController.class);

	private CarteiraManager carteiraManager = null;

	private PerfilInvestimentoManager perfilInvestimentoManager = null;

	private UserManager userManager = null;

	/**
	 * @param posicaoManager
	 */
	public void setPosicaoManager(CarteiraManager carteiraManager) {
		this.carteiraManager = carteiraManager;
	}

	/**
	 * @param perfilInvestimentoManager
	 */
	public void setPerfilInvestimentoManager(
			PerfilInvestimentoManager perfilInvestimentoManager) {
		this.perfilInvestimentoManager = perfilInvestimentoManager;
	}

	/**
	 * @param userManager
	 * @uml.property name="userManager"
	 */
	public void setUserManager(UserManager userManager) {
		this.userManager = userManager;
	}

	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		if (log.isDebugEnabled()) {
			log.debug("entering 'handleRequest' method...");
		}

		User currentUser = null;
		String idUsuario = null;
		String idPerfilInvestimento = null;
		List perfisInvestimentos = null;

		if (request.getParameter("idUsuario") != null) {
			idUsuario = request.getParameter("idUsuario");
			perfisInvestimentos = perfilInvestimentoManager
					.getPerfisInvestimentosPorIdUsuario(idUsuario);
		} else {

			try {
				String userName = "";
				if (SecurityContextHolder.getContext().getAuthentication()
						.getPrincipal() instanceof User) {
					userName = ((User) SecurityContextHolder.getContext()
							.getAuthentication().getPrincipal()).getUsername();
				} else if (SecurityContextHolder.getContext()
						.getAuthentication().getPrincipal() instanceof String) {
					userName = (String) SecurityContextHolder.getContext()
							.getAuthentication().getPrincipal();
				} else {
					throw new IllegalArgumentException(
							"Unrecognized principal type : "
									+ SecurityContextHolder.getContext()
											.getAuthentication().getPrincipal());
				}
				currentUser = userManager.getUserByUsername(userName);
				if (currentUser.getId() == null) {
					if (log.isDebugEnabled())
						log.debug("Usuario inexistente!");
					return new ModelAndView("redirect:MainMenu.html");
				}
			} catch (NullPointerException ex) {
				if (log.isDebugEnabled()) {
					log.debug("Usuario inexistente!");
				}
				return new ModelAndView("redirect:MainMenu.html");
			}
			perfisInvestimentos = perfilInvestimentoManager
					.getPerfisInvestimentosPorIdUsuario(currentUser.getId()
							.toString());
		}

		List perfisInvestimentosLabelValue = new ArrayList();
		PerfilInvestimento perfilInvestimento = null;

		for (int i = 0; i < perfisInvestimentos.size(); i++) {
			perfilInvestimento = (PerfilInvestimento) perfisInvestimentos
					.get(i);
			perfisInvestimentosLabelValue.add(new LabelValue(perfilInvestimento
					.getNome(), perfilInvestimento.getId().toString()));
		}

		if (request.getParameter("idPerfilInvestimento") != null)
			idPerfilInvestimento = request.getParameter("idPerfilInvestimento");
		else {
			LabelValue perfilInvestimentoLabelValue = (LabelValue) perfisInvestimentosLabelValue
					.get(0);
			idPerfilInvestimento = perfilInvestimentoLabelValue.getValue();
		}

		Map myModel = new HashMap();
		myModel.put("perfilInvestimentoAtual", idPerfilInvestimento);
		myModel.put("perfilInvestimentoLista", perfisInvestimentosLabelValue);
		myModel.put("carteira", perfilInvestimento.getCarteira());
		myModel.put("posicoesList", perfilInvestimento.getCarteira()
				.getPosicoes());

		return new ModelAndView("carteira", Constants.CARTEIRA_LISTA, myModel);
	}
}
