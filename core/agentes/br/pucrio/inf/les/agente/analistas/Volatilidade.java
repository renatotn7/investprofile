package br.pucrio.inf.les.agente.analistas;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import br.pucrio.inf.les.agente.facade.ControladorContexto;
import br.pucrio.inf.les.agente.model.CanaisAnalistas;
import br.pucrio.inf.les.agente.model.Conteudo;
import br.pucrio.inf.les.agente.model.Tag;
import br.pucrio.inf.les.agente.util.Data;
import br.pucrio.inf.les.agente.util.Estatistica;
import br.pucrio.inf.les.agente.util.Financeira;
import br.pucrio.inf.les.investprofile.model.Cotacao;
import br.pucrio.inf.les.investprofile.service.CotacaoManager;

/**
 * @author jonny
 */
public class Volatilidade implements Processo {
	private static final long serialVersionUID = 222L;

	private final Tag canal = CanaisAnalistas.Volatilidade.tag();

	/**
	 * @author jonny
	 */
	public enum Estrutura {
		pAbrangencia, pCodigoBovespa, pDataInicioHistorico, rVolatilidade
	}

	/**
	 * @author jonny
	 */
	public enum Abrangencia {
		Instrumento, Carteira
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.pucrio.inf.les.agente.analistas.Processo#obtemNomeAgente()
	 */
	public String obtemNomeAgente() {
		return new String("Agente.Volatilidade");
	}
	
	/* (non-Javadoc)
	 * @see br.pucrio.inf.les.agente.analistas.Processo#obtemDescricaoAgente()
	 */
	public String obtemDescricaoAgente() {
		return new String("Agente de cálculo de volatilidade das ações");
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return obtemNomeAgente();
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see br.pucrio.inf.les.agente.estrategias.EstrategiaInformacao#getInformacao(br.pucrio.inf.les.agente.model.Conteudo)
	 */
	public Conteudo executaProcesso(Conteudo conteudo) {
		// Cria o conteudo de resultado.
		Conteudo resultado = new Conteudo();
		try {
			// Declara objetos de acesso aos serviços do Spring.
			CotacaoManager cotacaoMng;
			// Define se o cálculo é para uma ação ou para uma carteira.
			switch ((Abrangencia) conteudo.get(Estrutura.pAbrangencia)) {
			// Cálculo para uma ação.
			case Instrumento:
				cotacaoMng = (CotacaoManager) ControladorContexto
						.instancia().contexto().getBean("cotacaoManager");
				// Busca objetos de cotação a partir de uma data.
				List cotacoes = cotacaoMng.getCotacoesPorCodigoBovespaDesde(
						(String) conteudo.get(Estrutura.pCodigoBovespa),
						new SimpleDateFormat(Data.DATA_FORMATO_BRASIL)
								.parse((String) conteudo
										.get(Estrutura.pDataInicioHistorico)));
				double volatilidade = calculaVolatilidade((ArrayList<Cotacao>) cotacoes);
				resultado.put(Estrutura.rVolatilidade, volatilidade);
				resultado.setConteudoOK();
				break;
			case Carteira:

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

	/**
	 * @return
	 */
	public Tag getCanal() {
		return this.canal;
	}

	/*
	 * Calcula o VaR em função da serie histórica de valores de uma ação. @param
	 * acao objeto de Acao @return valor do VaR.
	 */
	public double calculaVolatilidade(ArrayList<Cotacao> cotacoes) {
		double volatilidade = 0;
		List<Double> valores = new ArrayList<Double>();
		List<Double> proporcoes;

		for (Cotacao cotacao : cotacoes) {
			valores.add(cotacao.getPrecoMedio());
		}
		proporcoes = Financeira.calculaLogProporcaoDiaria(valores);
		volatilidade = Estatistica.desvioPadrao(proporcoes);
		return volatilidade;
	}
}
