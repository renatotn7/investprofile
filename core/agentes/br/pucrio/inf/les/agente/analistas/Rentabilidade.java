package br.pucrio.inf.les.agente.analistas;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import br.pucrio.inf.les.agente.facade.ControladorContexto;
import br.pucrio.inf.les.agente.model.CanaisAnalistas;
import br.pucrio.inf.les.agente.model.Conteudo;
import br.pucrio.inf.les.agente.model.Tag;
import br.pucrio.inf.les.agente.util.Data;
import br.pucrio.inf.les.investprofile.model.Acao;
import br.pucrio.inf.les.investprofile.model.Cotacao;
import br.pucrio.inf.les.investprofile.model.Posicao;
import br.pucrio.inf.les.investprofile.service.AcaoManager;
import br.pucrio.inf.les.investprofile.service.CotacaoManager;
import br.pucrio.inf.les.investprofile.service.PosicaoManager;

/**
 * Rentabilidade é uma classe que permite o cálculo da rentabilidade de uma
 * carteira ou de uma ação.
 * 
 * @author Mauricio Costa Pinheiro
 * @version %I%, %G%
 */

public class Rentabilidade implements Processo {
	private static final long serialVersionUID = 233L;

	private final Tag canal = CanaisAnalistas.Rentabilidade.tag();

	/**
	 * @author jonny
	 */
	public enum Parametros {
		Abrangencia, IdPerfil, Acao, DataReferencia, TempoEmDias
	}

	/**
	 * @author jonny
	 */
	public enum Abrangencia {
		Acao, Acoes, Carteira
	}

	/**
	 * @author jonny
	 */
	public enum Retorno {
		RentabilidadeAcao,RentabilidadesAcoes,RentabilidadeCarteira 
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see br.pucrio.inf.les.agente.analistas.Processo#obtemNomeAgente()
	 */
	public String obtemNomeAgente() {
		return new String("Agente.Rentabilidade");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.pucrio.inf.les.agente.analistas.Processo#obtemDescricaoAgente()
	 */
	public String obtemDescricaoAgente() {
		return new String(
				"Agente de cálculo de rentabilidade de açoes e carteiras");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.pucrio.inf.les.agente.analistas.Processo#getCanal()
	 */
	public Tag getCanal() {
		return this.canal;
	}

	public Conteudo executaProcesso(Conteudo conteudo) {
		// Cria o conteudo de resultado.
		String dado = new String("Teste");
		Conteudo resultado = new Conteudo();
		return resultado;
	}

	public Conteudo getInformacoes(Conteudo conteudo) {
		// Cria o conteudo de resultado.
		Conteudo resultado = new Conteudo();
		try {
			// Declara objetos de acesso aos serviços do Spring.
			PosicaoManager posicaoMng;
			double rentabilidade;
			// Define se o cálculo é para uma ação ou para uma carteira.
			switch ((Abrangencia) conteudo.get(Parametros.Abrangencia)) {
			// Cálculo para uma ação.
			case Acao:
				rentabilidade = getRentabilidadeAcao((String) conteudo
						.get(Parametros.Acao), Data.parse((String) conteudo
						.get(Parametros.DataReferencia), null),
						Integer.parseInt((String) conteudo
								.get(Parametros.TempoEmDias)));
				resultado.put(Retorno.RentabilidadeAcao, rentabilidade);
				break;
			case Acoes:
				HashMap<Acao,Double> rentabilidades = new HashMap<Acao,Double>();
				AcaoManager acaoMng = (AcaoManager) ControladorContexto
						.instancia().contexto().getBean("acaoManager");
				List<Acao> acoes = acaoMng.getAll();
				Iterator i = acoes.iterator();
				while (i.hasNext()) {
					Acao acao = (Acao) i.next();
					rentabilidade = getRentabilidadeAcao(acao
							.getCodigoBovespa(), Data.parse((String) conteudo
							.get(Parametros.DataReferencia), null), Integer
							.parseInt((String) conteudo
									.get(Parametros.TempoEmDias)));
					rentabilidades.put(acao, rentabilidade);
				}
				resultado.put(Retorno.RentabilidadesAcoes, rentabilidades);
				break;
			case Carteira:
				posicaoMng = (PosicaoManager) ControladorContexto.instancia()
						.contexto().getBean("posicaoManager");
				// Busca objetos de posicao.
				List<Posicao> posicoes = (List<Posicao>) posicaoMng
						.getPosicoesPorPerfil((String) conteudo
								.get(Parametros.IdPerfil));
				rentabilidade = getRentabilidadeCarteira(posicoes,
						Data.parse((String) conteudo
								.get(Parametros.DataReferencia), null), Integer
								.parseInt((String) conteudo
										.get(Parametros.TempoEmDias)));
				resultado.put(Retorno.RentabilidadeCarteira, rentabilidade);
				break;
			default:
				break;
			}
			return resultado;
		} catch (NullPointerException e) {
			resultado.setConteudoErro("Parâmetro não encontrado.");
		} catch (Exception e) {
			resultado.setConteudoErro(e.getMessage());
		}

		return resultado;
	}

	private double getRentabilidadeCarteira(List<Posicao> posicoes,
			Date dataReferencia, int dias) {
		double rentabilidade = 0.0;
		// Para cada ação da carteira
		for (Posicao posicao : posicoes) {
			rentabilidade += getRentabilidadeAcao(posicao.getAcao()
					.getCodigoBovespa(), dataReferencia, dias)
					* posicao.getQuantidade();
		}
		return 0;
	}

	private double getRentabilidadeAcao(String codigoBovespa,
			Date dataReferencia, int dias) {
		List<Cotacao> cotacoes;
		cotacoes = getCotacoes(codigoBovespa, dataReferencia, dias);
		if (cotacoes.isEmpty())
			return 0.0;
		return Math.abs((cotacoes.get(0).getPrecoUltimo() - cotacoes.get(
				cotacoes.size() - 1).getPrecoUltimo()));
	}

	private List<Cotacao> getCotacoes(String codigoBovespa,
			Date dataReferencia, int dias) {
		try {
			CotacaoManager cotacaoMng = (CotacaoManager) ControladorContexto
					.instancia().contexto().getBean("cotacaoManager");
			Date dataInicio = Data.adicionaDias(dataReferencia, dias * (-1));
			List<Cotacao> cotacoes = (List<Cotacao>) cotacaoMng
					.getCotacoesPorCodigoBovespaDesde(codigoBovespa, dataInicio);
			return cotacoes;
		} catch (Exception ex) {
			return null;
		}
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return obtemNomeAgente();
	}

}
