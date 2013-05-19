package br.pucrio.inf.les.agente.analistas;

import java.util.HashMap;

import br.pucrio.inf.les.agente.facade.GerenteLog;
import br.pucrio.inf.les.agente.model.AgenteSimples;
import br.pucrio.inf.les.agente.model.CanaisAnalistas;
import br.pucrio.inf.les.agente.model.Conteudo;
import br.pucrio.inf.les.agente.model.Mensagem;
import br.pucrio.inf.les.agente.model.Tag;
import br.pucrio.inf.les.investprofile.model.Acao;
import br.pucrio.inf.les.investprofile.model.PerfilInvestimento;
import cybele.comm.ChannelHandler;
import cybele.kernel.CybeleEvent;

/**
 * 
 * @author <a href="mailto:mauricio.pinheiro@gmail.com">Mauricio Costa Pinheiro</a>
 * @version %I%, %G%
 */
public class PessoalInvestimento extends AgenteSimples {
	private static final long serialVersionUID = 233211L;

	private Tag canal = CanaisAnalistas.PessoalInvestimento.tag();

	private PerfilInvestimento perfilInvestimento = null;

	private HashMap<Acao, Float> similaridades = null;
	private HashMap<Acao, Float> rentabilidades = null;

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
		na
	}

	/**
	 * @param perfilInvestimento
	 */
	public PessoalInvestimento(PerfilInvestimento perfilInvestimento) {
		this.perfilInvestimento = perfilInvestimento;
		// Cria um canal
		criaCanalComunicacao(
				CanaisAnalistas.PessoalInvestimentoRetornoSimilaridades.tag(),
				"retornoSimilaridades", this, 50);
		executaAgente();
		// Cria um canal
		criaCanalComunicacao(
				CanaisAnalistas.PessoalInvestimentoRetornoRentabilidade.tag(),
				"retornoRentabilidades", this, 50);
		executaAgente();
	}

	/**
	 * @return
	 */
	public static String obtemNomeAgente() {
		return new String("Agente.PessoalInvestimento");
	}

	/**
	 * @return
	 */
	public static String obtemDescricaoAgente() {
		return new String("Agente pessoal de investimento para um perfil");
	}

	/**
	 * @param perfilInvestimento
	 */
	public void executaAgente() {
		ChannelHandler ch = getCanalProprio(CanaisAnalistas.PessoalInvestimentoRetornoSimilaridades
				.tag());
		try {

			System.out.println("Iniciando agente de investimento pessoal("
					+ ch.getAgentId() + ") para o perfil "
					+ perfilInvestimento.getNome() + " "
					+ perfilInvestimento.getId());
			calculaSimilaridade(perfilInvestimento);

		} catch (Exception ex) {
			GerenteLog.registraErroAgente(ex.getMessage());
		}

	}

	/**
	 * @param ev
	 */
	public void retornoSimilaridades(CybeleEvent ev) {
		Mensagem recebida = desempacota(ev.getMessage());
		Conteudo conteudo = recebida.getConteudo();
		if (conteudo == null)
			throw new NullPointerException();
		similaridades = ((HashMap<Acao, Float>) conteudo
				.get(Similaridade.Retorno.similaridades));
	}

	/**
	 * @param ev
	 */
	public void retornoRentabilidades(CybeleEvent ev) {
		Mensagem recebida = desempacota(ev.getMessage());
		Conteudo conteudo = recebida.getConteudo();
		if (conteudo == null)
			throw new NullPointerException();
		rentabilidades = ((HashMap<Acao, Float>) conteudo
				.get(Rentabilidade.Retorno.RentabilidadesAcoes));
	}

	/**
	 * @param ev
	 */
	public void retornoConfianca(CybeleEvent ev) {
		Mensagem recebida = desempacota(ev.getMessage());
		Conteudo conteudo = recebida.getConteudo();
		if (conteudo == null)
			throw new NullPointerException();
		rentabilidades = ((HashMap<Acao, Float>) conteudo
				.get(Rentabilidade.Retorno.RentabilidadesAcoes));
	}	
	
	/**
	 * @param perfilInvestimento
	 */
	private void calculaSimilaridade(PerfilInvestimento perfilInvestimento) {
		// Cria uma mensagem
		Mensagem msg = new Mensagem();
		// Cria um conteudo da mensagem
		Conteudo conteudoSimilaridade = new Conteudo();
		conteudoSimilaridade.put(Similaridade.Parametros.perfilInvestimento,
				perfilInvestimento);
		// Coloca o conteudo na mensagem.
		msg.setConteudo(conteudoSimilaridade);

		// Envia informações do perfil que será analisado.
		this.enviaMensagem(CanaisAnalistas.Similaridade.tag(),
				CanaisAnalistas.PessoalInvestimentoRetornoSimilaridades.tag(),
				msg);
	}

	/**
	 * 
	 */
	private void calculaRentabilidadeAcoes() {
		// Cria uma mensagem
		Mensagem msg = new Mensagem();
		// Cria um conteudo da mensagem
		Conteudo conteudoRentabilidade = new Conteudo();
		conteudoRentabilidade.put(Rentabilidade.Parametros.Abrangencia,
				Rentabilidade.Abrangencia.Acoes);
		conteudoRentabilidade.put(Rentabilidade.Parametros.DataReferencia, "a");
		conteudoRentabilidade.put(Rentabilidade.Parametros.TempoEmDias, "a");
		// Coloca o conteudo na mensagem.
		msg.setConteudo(conteudoRentabilidade);

		// Envia informações do perfil que será analisado.
		this.enviaMensagem(CanaisAnalistas.Rentabilidade.tag(),
				CanaisAnalistas.PessoalInvestimentoRetornoRentabilidade.tag(),
				msg);
	}
	
	private void processaDecisaoInvestimento() {
				
	}
}
