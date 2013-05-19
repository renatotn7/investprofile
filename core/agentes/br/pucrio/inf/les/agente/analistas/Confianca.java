package br.pucrio.inf.les.agente.analistas;

import java.util.List;

import br.pucrio.inf.les.agente.facade.ControladorContexto;
import br.pucrio.inf.les.agente.model.CanaisAnalistas;
import br.pucrio.inf.les.agente.model.Conteudo;
import br.pucrio.inf.les.agente.model.Tag;
import br.pucrio.inf.les.investprofile.model.Acao;
import br.pucrio.inf.les.investprofile.model.RecomendacaoAnalista;
import br.pucrio.inf.les.investprofile.service.AcaoManager;

/**
 * 
 * @author <a href="mailto:mauricio.pinheiro@gmail.com">Mauricio Costa Pinheiro</a>
 * @version %I%, %G%
 */
public class Confianca implements Processo {
	private static final long serialVersionUID = 2332L;

	private final Tag canal = CanaisAnalistas.Confianca.tag();

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.pucrio.inf.les.agente.analistas.Processo#obtemNomeAgente()
	 */
	public String obtemNomeAgente() {
		return new String("Agente.Confianca");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.pucrio.inf.les.agente.analistas.Processo#obtemDescricaoAgente()
	 */
	public String obtemDescricaoAgente() {
		return new String("Agente de cálculo de confiança nos analistas");
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
		try {
		AcaoManager acaoMng = (AcaoManager) ControladorContexto.instancia()
				.contexto().getBean("acaoManager");
		}
		catch(Exception e) {
			
		}
		
		
		return new Conteudo();
	}
	
	private double iniciaCalculoConfianca(List<RecomendacaoAnalista> recomendacoes){
		return new Double(0);
	}
	
	public void processaMensagemRentabilidade(Conteudo mensagemRentabilidade){
		
	}
	
	private void calculaConfianca(Acao acao, double rentabilidade){
		
	}
	
	public void obtemConfianca(String analista){
		
	}

}
