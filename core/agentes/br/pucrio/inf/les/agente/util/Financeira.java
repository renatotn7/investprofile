package br.pucrio.inf.les.agente.util;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe que contém operações financeiras.
 * @author <a href="mailto:mauricio.pinheiro@gmail.com">Mauricio Costa Pinheiro</a>
 *
 */
public class Financeira {

  public static List<Double> calculaRendimentoDiario(List<Double> valores) {
    List<Double> rendimentos = new ArrayList<Double>();
    double ultValor = valores.get(0);
    for(double valor : valores)
    {
      rendimentos.add( (valor - ultValor) / ultValor );
    }
    return rendimentos;
  }
    
  public static List<Double> calculaLogProporcaoDiaria(List<Double> valores) {
    List<Double> logProporcoes = new ArrayList<Double>();
    double ultValor = valores.get(0);
    for(double valor : valores)
    {
      logProporcoes.add( Math.log(valor / ultValor) );
    }
    return logProporcoes;
  }
}
