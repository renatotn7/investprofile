package br.pucrio.inf.les.investprofile.webapp.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.acegisecurity.context.SecurityContextHolder;

import br.pucrio.inf.les.investprofile.Constants;
import br.pucrio.inf.les.investprofile.model.CarteiraRecomendada;
import br.pucrio.inf.les.investprofile.model.PerfilInvestimento;
import br.pucrio.inf.les.investprofile.model.User;
import br.pucrio.inf.les.investprofile.model.LabelValue;
import br.pucrio.inf.les.investprofile.service.RecomendacaoAnalistaManager;
import br.pucrio.inf.les.investprofile.service.PerfilInvestimentoManager;
import br.pucrio.inf.les.investprofile.service.UserManager;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

/**
 * @author jonny
 */
public class RecomendacaoPerfilController implements Controller {

	private final Log log = LogFactory
			.getLog(RecomendacaoPerfilController.class);

	private RecomendacaoAnalistaManager carteiraRecomendadaManager = null;

	private PerfilInvestimentoManager perfilInvestimentoManager = null;

	private UserManager userManager = null;

	/**
	 * @param CarteiraRecomendadaManager
	 * @uml.property name="carteiraRecomendadaManager"
	 */
	public void setCarteiraRecomendadaManager(
			RecomendacaoAnalistaManager CarteiraRecomendadaManager) {
		this.carteiraRecomendadaManager = CarteiraRecomendadaManager;
	}

	/**
	 * @param perfilInvestimentoManager
	 * @uml.property name="perfilInvestimentoManager"
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
			if (perfisInvestimentosLabelValue.size() > 0) {
				LabelValue perfilInvestimentoLabelValue = (LabelValue) perfisInvestimentosLabelValue
						.get(0);
				idPerfilInvestimento = perfilInvestimentoLabelValue.getValue();
			}
		}
		
		if (log.isDebugEnabled()) {
			if (idPerfilInvestimento == null)
				log.debug("Usuario não possui perfil cadastrado!");
		}

		List carteirasRecomendadas = carteiraRecomendadaManager
				.getTodasCarteirasRecomendadas(idPerfilInvestimento);
		List carteirasRecomendadasLabelValue = new ArrayList();
		CarteiraRecomendada carteiraRecomendada = null;
		for (int i = 0; i < carteirasRecomendadas.size(); i++) {
			carteiraRecomendada = (CarteiraRecomendada) carteirasRecomendadas
					.get(i);
			carteirasRecomendadasLabelValue.add(new LabelValue(
					carteiraRecomendada.getDataCarteira().toString(),
					carteiraRecomendada.getId().toString()));
		}
		String idCarteiraRecomendada = null;
		if (carteirasRecomendadasLabelValue.size() > 0) {
			LabelValue carteiraRecomendadaLabelValue = (LabelValue) carteirasRecomendadasLabelValue
					.get(0);
			idCarteiraRecomendada = carteiraRecomendadaLabelValue.getValue();
		}
		if (request.getParameter("idCarteiraRecomendada") != null)
			idCarteiraRecomendada = request
					.getParameter("idCarteiraRecomendada");

		Map myModel = new HashMap();
		myModel.put("idPerfilInvestimento", idPerfilInvestimento);
		myModel.put("idCarteiraRecomendada", idCarteiraRecomendada);
		myModel.put("perfilInvestimentoLista", perfisInvestimentosLabelValue);
		myModel.put("carteiraRecomendadaListaPorData",
				carteirasRecomendadasLabelValue);
		myModel.put("carteiraRecomendadaAcaoLista", carteiraRecomendadaManager
				.getTodasAcoes(idCarteiraRecomendada));

		return new ModelAndView("carteiraRecomendadaList",
				Constants.CARTEIRARECOMENDADA_LISTA, myModel);
	}
}
