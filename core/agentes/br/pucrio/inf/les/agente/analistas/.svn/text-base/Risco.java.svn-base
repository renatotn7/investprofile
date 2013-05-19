package br.pucrio.inf.les.agente.analistas;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.pucrio.inf.les.agente.facade.ControladorContexto;
import br.pucrio.inf.les.agente.model.CanaisAnalistas;
import br.pucrio.inf.les.agente.model.Conteudo;
import br.pucrio.inf.les.agente.model.Tag;
import br.pucrio.inf.les.agente.util.Financeira;
import br.pucrio.inf.les.investprofile.model.Cotacao;
import br.pucrio.inf.les.investprofile.service.CotacaoManager;

/**
 * @author <a href="mailto:mauricio.pinheiro@gmail.com">Mauricio Costa Pinheiro</a>
 *
 */
public class Risco implements Processo {
	private static final long serialVersionUID = 22L;

	/** Valor Z para confiança de 95% */
	public static final double VALOR_Z_95 = -1.64485362695147;

	/** Valor Z para confiança de 95% */
	public static final double VALOR_Z_99 = -2.32634787404084;

	/**
	 * @author jonny
	 */
	public enum Estrutura {
		pCodigoBovespa, pDataInicioHistorico, pPercentagemConfianca, rRiscoVaR
	}
	
	private final Tag canal = CanaisAnalistas.Risco.tag();

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.pucrio.inf.les.agente.analistas.Processo#obtemNomeAgente()
	 */
	public String obtemNomeAgente() {
		return new String("Agente.Risco");
	}
	
	/* (non-Javadoc)
	 * @see br.pucrio.inf.les.agente.analistas.Processo#obtemDescricaoAgente()
	 */
	public String obtemDescricaoAgente() {
		return new String("Agente de cálculo de risco");
	}
	
	/* (non-Javadoc)
	 * @see br.pucrio.inf.les.agente.analistas.Processo#getCanal()
	 */
	public Tag getCanal() {
		return this.canal;
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
			// Obtem instância do objeto de serviço de cotação.
			cotacaoMng = (CotacaoManager) ControladorContexto.instancia()
					.contexto().getBean("cotacaoManager");
			// Busca objetos de cotação a partir de uma data.
			ArrayList<Cotacao> cotacoes = (ArrayList<Cotacao>) cotacaoMng
					.getCotacoesPorCodigoBovespaDesde(
							(String) conteudo
									.get(Risco.Estrutura.pCodigoBovespa),
							new SimpleDateFormat("dd/MM/yyyy")
									.parse((String) conteudo
											.get(Risco.Estrutura.pDataInicioHistorico)));
			double risco = calculaVaRHistorico(cotacoes, (Integer) conteudo
					.get(Risco.Estrutura.pPercentagemConfianca));
			// Armazena o resultado no conteudo.
			resultado.put(Risco.Estrutura.rRiscoVaR, risco);
			resultado.setConteudoOK();
		} catch (NullPointerException e) {
			resultado.setConteudoErro("Parâmetro não encontrado.");
		} catch (Exception e) {
			resultado.setConteudoErro(e.getMessage());
		}
		return resultado;
	}

    /*
	 * Calcula o VaR em função da serie histórica de valores de uma ação. @param
	 * acao objeto de Acao @return valor do VaR.
	 */
	public double calculaVaRHistorico(List<Cotacao> cotacoes,
			Integer percentagemConfianca) {
		double valorVaR = 0;
		List<Double> valores = new ArrayList<Double>();
		List<Double> rendimento;
		double cincoPorcentoMenores = 0;
		double confianca = (percentagemConfianca.doubleValue() / 100);

		for (Cotacao cotacao : cotacoes) {
			valores.add(cotacao.getPrecoUltimo());
		}
		// Calcula o rendimento para cada dia da cotação
		rendimento = Financeira.calculaRendimentoDiario(valores);
		// Ordena os rendimentos do menor para o maior
		Collections.sort(rendimento);
		// Calcula a quantidade de rendimentos que se enquadram nos 5% menores
		cincoPorcentoMenores = Math.round(Math.abs((1 - confianca)
				* rendimento.size()));
		// Calcula a percentagem do melhor, dos 5% piores rendimentos.
		valorVaR = Math.abs(rendimento.get((int) cincoPorcentoMenores) * 100);
		return valorVaR;
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return obtemNomeAgente();
	}
}
