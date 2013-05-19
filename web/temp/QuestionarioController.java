package br.pucrio.inf.les.investprofile.webapp.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Locale;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.acegisecurity.context.SecurityContextHolder;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import br.pucrio.inf.les.investprofile.Constants;
import br.pucrio.inf.les.investprofile.model.LabelValue;
import br.pucrio.inf.les.investprofile.model.PerfilInvestimento;
import br.pucrio.inf.les.investprofile.service.PerfilInvestimentoManager;
import br.pucrio.inf.les.investprofile.model.User;
import br.pucrio.inf.les.investprofile.service.UserManager;
import br.pucrio.inf.les.investprofile.model.Questionario;
import br.pucrio.inf.les.investprofile.service.QuestionarioManager;
import br.pucrio.inf.les.investprofile.model.RespostaPerfil;
import br.pucrio.inf.les.investprofile.service.RespostaPerfilManager;
import br.pucrio.inf.les.investprofile.model.Resposta;
import br.pucrio.inf.les.investprofile.service.RespostaManager;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/**
 * @author jonny
 */
public class QuestionarioController implements Controller {

	private final Log log = LogFactory.getLog(CarteriaController.class);

	private QuestionarioManager questionarioManager = null;

	private RespostaManager respostaManager = null;

	private RespostaPerfilManager respostaPerfilManager = null;

	private PerfilInvestimentoManager perfilInvestimentoManager = null;

	private UserManager userManager = null;

	/**
	 * @param questionarioManager
	 * @uml.property name="questionarioManager"
	 */
	public void setQuestionarioManager(QuestionarioManager questionarioManager) {
		this.questionarioManager = questionarioManager;
	}

	/**
	 * @param respostaManager
	 * @uml.property name="respostaManager"
	 */
	public void setRespostaManager(RespostaManager respostaManager) {
		this.respostaManager = respostaManager;
	}

	/**
	 * @param respostaPerfilManager
	 * @uml.property name="respostaPerfilManager"
	 */
	public void setRespostaPerfilManager(
			RespostaPerfilManager respostaPerfilManager) {
		this.respostaPerfilManager = respostaPerfilManager;
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

		perfilInvestimento = perfilInvestimentoManager
				.getPerfilInvestimento(idPerfilInvestimento);

		RespostaPerfil respostaPerfil = null;
		Resposta resposta = null;
		List listaRespostasPerfil = null;
		String idResposta = null;
		try {
			// Remove todas as respostas atuais do perfil
			respostaPerfilManager.removeRespostasPerfil();
			// Insere as novas respostas de um perfil
			for (Enumeration e = request.getParameterNames(); e
					.hasMoreElements();) {
				// Obtem objeto de resposta
				idResposta = e.nextElement().toString().substring(
						new String("resposta").length() - 1);
				resposta = respostaManager.getResposta(idResposta);
				// Adiciona nova resposta
				respostaPerfil.setResposta(resposta);
				listaRespostasPerfil = respostaPerfilManager
						.getRespostasPerfil(respostaPerfil);
				if (listaRespostasPerfil == null)
					respostaPerfilManager.saveRespostaPerfil(respostaPerfil);
			}
		} catch (Exception ex) {
			if (log.isDebugEnabled()) {
				log.debug("Erro ao tentar excluir respostas de um perfil!");
				log.debug(ex.getMessage());
			}
			return new ModelAndView("redirect:MainMenu.html");
		}

		Map myModel = new HashMap();
		myModel.put("perfilInvestimentoAtual", idPerfilInvestimento);
		myModel.put("perfilInvestimentoLista", perfisInvestimentosLabelValue);
		myModel.put("questionario", questionarioManager.getQuestionario());
		myModel.put("respostaperfil", respostaPerfilManager
				.getRespostasPerfil(new RespostaPerfil()));

		return new ModelAndView("questionarioForm", Constants.QUESTIONARIO,
				myModel);
	}
}
