package br.pucrio.inf.les.agente;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

import br.pucrio.inf.les.agente.analistas.Confianca;
import br.pucrio.inf.les.agente.analistas.PessoalInvestimento;
import br.pucrio.inf.les.agente.analistas.Risco;
import br.pucrio.inf.les.agente.analistas.Similaridade;
import br.pucrio.inf.les.agente.comando.AmbienteCybele;
import br.pucrio.inf.les.agente.facade.ControladorContexto;
import br.pucrio.inf.les.agente.facade.GerenteLog;
import br.pucrio.inf.les.agente.model.AgenteInvestimentoSimples;
import br.pucrio.inf.les.agente.model.AgenteSimples;
import br.pucrio.inf.les.agente.model.Mensagem;
import br.pucrio.inf.les.agente.model.Tag;
import br.pucrio.inf.les.investprofile.model.PerfilInvestimento;
import br.pucrio.inf.les.investprofile.service.PerfilInvestimentoManager;
import cybele.kernel.CybeleEvent;

/**
 * Inicia e gerencia todos agentes do sistema. Busca todos os perfis de
 * investimento existentes no sistema e cria um agente pessoal de investimento
 * para cada perfil.
 * 
 * @author <a href="mailto:mauricio.pinheiro@gmail.com">Mauricio Costa Pinheiro</a>
 * @version %I%, %G%
 */
public class Controlador extends AgenteSimples {
	private static final long serialVersionUID = 60L;

	/**
	 * 
	 */
	public Controlador() {
		iniciaControlador();
		iniciaAgentes();
	}

	/**
	 * Inicia configurações necessárias do controlador: - Canais de comunicação
	 * com outros agentes
	 */
	private void iniciaControlador() {
		// Cria canal de comunicação para retorno de informações dos agentes.
		this.criaCanalComunicacao(new Tag("controlador"), "estadoAgente", this,
				50);
		// Cria canal de comunicação para retorno de qualquer informação não
		// padronizada.
		this.criaCanalComunicacao(new Tag("controlador"), "retorno", this, 50);
	}

	/**
	 * 
	 */
	private void iniciaAgentes() {
		// iniciaCalculoConfianca();
		criaAgenteSimilaridade();
		iniciaAgentesPessoais();
	}

	/**
	 * 
	 */
	private void iniciaAgentesPessoais() {
		try {
			int ind = 1;
			// busca lista de perfis de investimento.
			List<PerfilInvestimento> listaPerfisInvestimento = buscaPerfisInvestimento();
			// Cria um agente para cada perfil de investimento.
			Iterator i = listaPerfisInvestimento.iterator();
			while (i.hasNext()) {
				criaAgentePessoalInvestimento((PerfilInvestimento) i.next(),ind);
				ind++;
			}
		} catch (Exception e) {
			GerenteLog.registraExcessao(e);
		}
	}

	/**
	 * 
	 */
	private void iniciaCalculoConfianca() {
		// Cria um objeto de analista.
		Confianca analista = new Confianca();
		// Envelopa o analista para ser passada para o agente.
		Serializable[] pars = { analista };
		// Cria um novo agente de informação para executar o analista.
		AmbienteCybele.criaAgente(analista.obtemNomeAgente(), analista
				.obtemDescricaoAgente(), AgenteInvestimentoSimples.class
				.getCanonicalName(), pars);
	}

	/**
	 * 
	 */
	private void iniciaCalculoRisco() {
		// Cria um objeto de analista.
		Risco analista = new Risco();
		// Envelopa o analista para ser passada para o agente.
		Serializable[] pars = { analista };
		// Cria um novo agente de informação para executar o analista.
		AmbienteCybele.criaAgente(analista.obtemNomeAgente(), analista
				.obtemDescricaoAgente(), AgenteInvestimentoSimples.class
				.getCanonicalName(), pars);

	}

	/**
	 * Metodo para receber os eventos de comunicação de estado dos agentes.
	 * 
	 * @param ev
	 *            Evento que contém a mensagem.
	 */
	public void estadoAgente(CybeleEvent ev) {
		// Desempacota a mesagem do evento.
		Mensagem msg = desempacota(ev.getMessage());
		// Se conteúdo OK busca informações de estado.
		if (msg.getConteudo().conteudoOK()) {
			/*
			 * System.out.println((PerfilInvestimento) msg.getConteudo().get(
			 * PessoalInvestimento.na.perfilInvestimento));
			 */
			// Se conteúdo ERRO registra problema.
		} else {
			GerenteLog.registraErroAgente(msg.getConteudo().getMensagemErro());
		}
	}

	/**
	 * Metodo para receber os eventos de comunicação não padronizados.
	 * 
	 * @param ev
	 *            Evento que contém a mensagem.
	 */
	public void retorno(CybeleEvent ev) {
		// Desempacota a mesagem do evento.
		Mensagem msg = desempacota(ev.getMessage());
		// Se conteúdo OK busca informações de estado.
		if (msg.getConteudo().conteudoOK()) {
			/*
			 * System.out.println((PerfilInvestimento) msg.getConteudo().get(
			 * PessoalInvestimento.Retorno.perfilInvestimento));
			 */
			// Se conteúdo ERRO registra problema.
		} else {
			GerenteLog.registraErroAgente(msg.getConteudo().getMensagemErro());
		}
	}

	/**
	 * Busca a lsita de perfis de investimento cadastradas
	 * 
	 * @return Lista de perfis de investimento.
	 */
	private List<PerfilInvestimento> buscaPerfisInvestimento() {
		try {
			// Busca objeto da camada de serviço
			PerfilInvestimentoManager perfilMng = (PerfilInvestimentoManager) ControladorContexto
					.instancia().contexto()
					.getBean("perfilInvestimentoManager");
			return perfilMng.getAll();
		} catch (Exception ex) {
			GerenteLog.registraExcessao(ex);
			return null;
		}

	}

	/**
	 * Cria um novo agente pessoal de investimento baseado nas informações do
	 * perfil recebido.
	 * 
	 * @param perfilInvestimento
	 *            Perfil de investimento.
	 */
	private void criaAgentePessoalInvestimento(
			PerfilInvestimento perfilInvestimento, int i) {
		Serializable[] pars = { perfilInvestimento };
		// Cria um novo agente de informação para executar o analista.
		AmbienteCybele.criaAgente(PessoalInvestimento.obtemNomeAgente()
				+ i, PessoalInvestimento
				.obtemDescricaoAgente(), PessoalInvestimento.class
				.getCanonicalName(), pars);
	}

	/**
	 * 
	 */
	private void criaAgenteSimilaridade() {
		/*
		 * Calcula similaridade do perfil com as ações perioricamente
		 * Inicialmente vamos fazer isso a cada hora
		 */
		// Cria um objeto de analista.
		Similaridade analista = new Similaridade();
		// Envelopa o analista para ser passada para o agente.
		Serializable[] pars = { analista };
		// Cria um novo agente de informação para executar o analista.
		AmbienteCybele.criaAgente(analista.obtemNomeAgente(), analista
				.obtemDescricaoAgente(), AgenteInvestimentoSimples.class
				.getCanonicalName(), pars);
	}
}
