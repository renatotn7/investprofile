package br.pucrio.inf.les.agente.analistas;

import static br.pucrio.inf.les.agente.facade.GerenteLog.consolePrint;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import cybele.kernel.CybeleEvent;

import br.pucrio.inf.les.agente.facade.ControladorContexto;
import br.pucrio.inf.les.agente.facade.GerenteLog;
import br.pucrio.inf.les.agente.model.CanaisAnalistas;
import br.pucrio.inf.les.agente.model.Conteudo;
import br.pucrio.inf.les.agente.model.Mensagem;
import br.pucrio.inf.les.agente.model.Tag;
import br.pucrio.inf.les.investprofile.model.Acao;
import br.pucrio.inf.les.investprofile.model.PerfilInvestimento;
import br.pucrio.inf.les.investprofile.service.AcaoManager;

/**
 * 
 * @author <a href="mailto:mauricio.pinheiro@gmail.com">Mauricio Costa Pinheiro</a>
 * @version %I%, %G%
 */
public class Similaridade implements Processo {
	private static final long serialVersionUID = 2337L;

	private HashMap<Acao, Float> fatorCompatibilidade = new HashMap<Acao, Float>();

	private final Tag canal = CanaisAnalistas.Similaridade.tag();

	/**
	 * 
	 * @author <a href="mailto:mauricio.pinheiro@gmail.com">Mauricio Costa
	 *         Pinheiro</a>
	 * @version %I%, %G%
	 */
	public enum Parametros {
		/**
		 * Identificador do perfil de investimento
		 */
		perfilInvestimento
	}

	/**
	 * 
	 * @author <a href="mailto:mauricio.pinheiro@gmail.com">Mauricio Costa
	 *         Pinheiro</a>
	 * @version %I%, %G%
	 */
	public enum Retorno {
		/**
		 * Identificador do perfil de investimento
		 */
		similaridades
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.pucrio.inf.les.agente.analistas.Processo#obtemNomeAgente()
	 */
	public String obtemNomeAgente() {
		return new String("Agente.Similaridade");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.pucrio.inf.les.agente.analistas.Processo#obtemDescricaoAgente()
	 */
	public String obtemDescricaoAgente() {
		return new String(
				"Agente de cálculo de similaridade do perfil com a ação");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.pucrio.inf.les.agente.analistas.Processo#getCanal()
	 */
	public Tag getCanal() {
		return this.canal;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.pucrio.inf.les.agente.analistas.Processo#executaProcesso(br.pucrio.inf.les.agente.model.Conteudo)
	 */
	public Conteudo executaProcesso(Conteudo conteudo) {
		try {

			// obtem uma instancia da camada de serviço de ação
			AcaoManager acaoMng = (AcaoManager) ControladorContexto.instancia()
					.contexto().getBean("acaoManager");

			List<Acao> acoes = acaoMng.getAll();
			PerfilInvestimento perfil = obtemPerfilInvestimento(conteudo);
			// Cria um agente para cada perfil de investimento.
			Iterator i = acoes.iterator();
			Acao acao;
			while (i.hasNext()) {
				acao = (Acao) i.next();
				fatorCompatibilidade.put(acao, calculaFatorCompatibilidade(
						perfil, acao));
			}
			consolePrint("Finalizando calculo de similaridade... " + perfil.getNome());
			// Cria um conteudo da mensagem
			Conteudo retorno = new Conteudo();
			retorno.put(Retorno.similaridades, fatorCompatibilidade);
			
			return retorno;
		} catch (Exception e) {
			GerenteLog.registraErroAgente(e.getLocalizedMessage());
			return null;
		}
	}

	/**
	 * @param perfil
	 * @param acao
	 * @return
	 */
	private float calculaFatorCompatibilidade(PerfilInvestimento perfil,
			Acao acao) {
		float fator = 0;
		if (perfil.getSegmentoPreferencial().descricao().equals(
				acao.getSegmento().descricao()))
			fator += 1;
		float fatorliquidez = Math.abs((perfil.getLiquidez() - (float) acao
				.getFatorNegociacao()));
		if (fatorliquidez < 5)
			fator += 5 / fatorliquidez;
		return fator;
	}

	private PerfilInvestimento obtemPerfilInvestimento(Conteudo conteudo)
			throws NullPointerException {
		if (conteudo == null)
			throw new NullPointerException();
		Object dado = conteudo.get(Parametros.perfilInvestimento);
		if (dado == null)
			throw new NullPointerException();
		return (PerfilInvestimento) dado;
	}
	
	/**
	 * @param ev
	 */
	public void retornoRentabilidades(CybeleEvent ev) {

	}
	
	/**
	 * @param ev
	 */
	public void retornoRisco(CybeleEvent ev) {

	}
}
