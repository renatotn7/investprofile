package br.pucrio.inf.les.agente.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

/**
 * Classe que contém operações matemáticas utilizadas em estatistica e probabilidade.
 * @author <a href="mailto:mauricio.pinheiro@gmail.com">Mauricio Costa Pinheiro</a>
 *
 */
public final class Estatistica {
  
  /*
   * Calcula o desvio padrao de uma lista de valores
   * <a href="http://pt.wikipedia.org/wiki/Desvio_padr%C3%A3o">Desvio Padrão</a>
   * @param valores lista de valores do tipo double
   * @return o valor do desvio padrao
   */
  public static double desvioPadrao(List<Double> valores)
  {
    double desvioPadrao = 0;
    desvioPadrao = Math.sqrt(variancia(valores));
    return desvioPadrao;
  }
  
  /*
   * Calcula o momento central de uma lista de valores
   * <a href="http://pt.wikipedia.org/wiki/Momento_central">Momento Central</a>
   * @param valores lista de valores do tipo double
   * @return o valor do momento
   */
  public static double momentoCentral(List<Double> valores, int potencia)
  {
    double variancia = 0;
    double media = media(valores);
    List<Double> elevadoDaDistanciaDaMedia = new ArrayList<Double>();
    for(double valor : valores)
    {
      elevadoDaDistanciaDaMedia.add(Math.pow((valor-media), potencia));
    }
    variancia = media(elevadoDaDistanciaDaMedia);
    return variancia;
  }
  
  /*
   * Calcula a variância de uma lista de valores
   * <a href="http://pt.wikipedia.org/wiki/Vari%C3%A2ncia">Variância</a>
   * @param valores lista de valores do tipo double
   * @return o valor da variância
   */
  public static double variancia(List<Double> valores)
  {
    double variancia = 0;
    variancia = momentoCentral(valores,2);
    return variancia;
  }
  
  /*
   * Calcula a obliquidade de uma lista de valores
   * <a href="http://pt.wikipedia.org/wiki/Obliquidade">Obliquidade</a>
   * @param valores lista de valores do tipo double
   * @return o valor da obliquidade
   */
  public static double obliquidade(List<Double> valores)
  {
    double obliquidade = 0;
    obliquidade = momentoCentral(valores,3)/Math.pow(desvioPadrao(valores),3);
    return obliquidade;
  }
  
  /*
   * Calcula a curtose de uma lista de valores
   * <a href="http://pt.wikipedia.org/wiki/Curtose">Curtose</a>
   * @param valores lista de valores do tipo double
   * @return o valor da curtose
   */
  public static double curtose(List<Double> valores)
  {
    double curtose = 0;
    curtose = momentoCentral(valores,4)/Math.pow(desvioPadrao(valores),4);
    return curtose;
  }
  
  /*
   * Calcula a média de uma lista de valores
   * <a href="http://pt.wikipedia.org/wiki/M%C3%A9dia_aritm%C3%A9tica">Média</a>
   * @param valores lista de valores do tipo double
   * @return o valor da média
   */
  public static double media(List<Double> valores)
  {
    double media = 0;
    for(double valor : valores)
    {
      media += valor;
    }
    return media/valores.size();
  }
  
  /*
   * Calcula a mediana de uma lista de valores
   * @param valores lista de valores do tipo double
   * @return o valor da mediana
   */
  public static double mediana(List<Double> valores)
  {
    double mediaItens = 0;
    double mediana = 0;
    double resto = 0;
    Collections.sort(valores);
    mediaItens = (valores.size() + 1) / 2;
    resto = (valores.size() + 1) % 2;
    mediana = valores.get((int)mediaItens);
    if(resto > 0) {
      mediana = (
          valores.get((int)(mediaItens+resto)) +
          valores.get((int)(mediaItens-resto)) ) / 2;
    }
    return mediana;
  }
}
