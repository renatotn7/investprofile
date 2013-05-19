package br.pucrio.inf.les.agente.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.Calendar;
import java.util.Date;

public class Data extends Throwable {
  private static final long serialVersionUID = 911L;
  
  private static final long SEGUNDOS_MINUTO = 60;
  private static final long MINUTOS_HORA = 60;
  private static final long HORAS_DIA = 24;
  private static final long MILISEGUNDOS_DIA =
    Calendar.MILLISECOND * 
    SEGUNDOS_MINUTO * 
    MINUTOS_HORA *
    HORAS_DIA;
  
  // Padroniza as chamadas de formato de data para formato brasileiro
  public static final String DATA_FORMATO_BRASIL = "dd/MM/yyyy";
  //Padroniza as chamadas de formato de data para formato sql
  public static final String DATA_FORMATO_SQL = "yyyy-MM-dd";
  
  /**
   * @param String com a data no formato recebido.
   * @param String com formato da conversão. Converte para dd/mm/aaaa se formato nulo ou vazio.
   * @return Data recebida convertida para tipo Date.
   */ 
  public static Date parse(String data, String formato) throws ParseException {
    if(formato == null || formato.length() == 0)
      formato = Data.DATA_FORMATO_BRASIL;
    try {
      return new SimpleDateFormat(formato).parse(data);
    }
    catch(ParseException ex) {
      throw(ex);
    }
  }
  
  /**
   * @return Data de hoje.
   */ 
  public static Date hoje() {
    GregorianCalendar calendar = new GregorianCalendar();
    return calendar.getTime();
  }
  
  /**
   * @param data que deve ser adicionada
   * @return Data recebida convertida para tipo Date.
   */ 
  public static Date adicionaDias(Date data, int dias) {
    GregorianCalendar calendar = new GregorianCalendar();
    calendar.add(Calendar.DATE, dias);
    return calendar.getTime();
  }
  
  public static Date adicionaMeses(Date data, int meses) {
    GregorianCalendar calendar = new GregorianCalendar();
    calendar.add(Calendar.MONTH, meses);
    return calendar.getTime();
  }
  
  public static Date adicionaAnos(Date data, int anos) {
    GregorianCalendar calendar = new GregorianCalendar();
    calendar.add(Calendar.YEAR, anos);
    return calendar.getTime();
  }
  
  public static int diferencaEmDias(Date data1, Date data2) {
    GregorianCalendar calendar1 = new GregorianCalendar();
    GregorianCalendar calendar2 = new GregorianCalendar();
    calendar1.setTime(data1);
    calendar2.setTime(data2);
    long diferencaMilisegundos = calendar1.getTimeInMillis() - calendar2.getTimeInMillis();
    return (int)(diferencaMilisegundos/MILISEGUNDOS_DIA);   
  }
}
