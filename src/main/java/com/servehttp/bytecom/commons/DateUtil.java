package com.servehttp.bytecom.commons;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 
 * @author clairton
 * 
 */
public abstract class DateUtil {

  private static final SimpleDateFormat DEFAULT = new SimpleDateFormat("dd/MM/yyyy");
  private static final SimpleDateFormat ANO_MES_DIA = new SimpleDateFormat("yyyyMMdd");
  private static final Logger LOGGER = Logger.getLogger(DateUtil.class.getName());

  /**
   * 
   * 
   * Converte uma data para String no formato <b>dd/MM/yyyy<b>.
   * 
   * <pre>
   * @param dataInstalacao Date
   * @return String
   * </pre>
   */
  public static String format(Date date) {
    return DEFAULT.format(date);
  }

  public static String formataAnoMesDia(Date date) {
    return ANO_MES_DIA.format(date);
  }

  /**
   * 
   * Converte uma String no formato <b>dd/MM/yyyy<b> para java.util.Date.
   * 
   * <pre>
   * @param dateString String
   * @return java.util.Date
   * </pre>
   */
  public static Date parse(String dateString) {
    Date date = null;
    try {
      date = DEFAULT.parse(dateString);
    } catch (ParseException e) {
      LOGGER.log(Level.SEVERE, null, e);
    }
    return date;
  }

  /**
   * 
   * Converte uma String no formato <b>especificado<b> para java.util.Date.
   * 
   * <pre>
   * @param dataInstalacao Date
   * @return java.util.Date
   * </pre>
   */
  public static Date parse(String dateString, String pattern) {
    Date date = null;
    try {
      date = new SimpleDateFormat(pattern).parse(dateString);
    } catch (ParseException e) {

    }
    return date;
  }

  /**
   * Retorna um Date apenas com informações de data, zerando informações de tempo.
   * 
   * @return java.util.Date
   */
  public static Date getHoje() {
    String hojeString = format(new Date());
    Date hoje = parse(hojeString);
    return hoje;
  }

  /**
   * Retorna a data atual adicionado mais 1 mês.
   * 
   * @return Calendar
   */
  public static Calendar getProximoMes() {
    Calendar c = Calendar.getInstance();
    c.add(Calendar.MONTH, 1);
    return c;
  }

  public static Date getDate(int dia, int mes, int ano) {
    Calendar c = Calendar.getInstance();
    c.clear();
    c.set(ano, mes, dia);
    return c.getTime();
  }

  public static Calendar getUltimoDiaDoMes() {
    Calendar c = getPrimeiroDiaDoMes();
    c.add(Calendar.MONTH, 1);
    c.add(Calendar.DAY_OF_MONTH, -1);
    return c;
  }

  public static Calendar getPrimeiroDiaDoMes() {
    Calendar c = Calendar.getInstance();
    c.set(Calendar.DAY_OF_MONTH, 1);
    c.set(Calendar.HOUR, 0);
    c.set(Calendar.MINUTE, 0);
    c.set(Calendar.SECOND, 0);
    return c;
  }

  /**
   * Incrementa o mês da data atual. O mês pode ser incrementado para mais ou para menos de acordo
   * com o sinal da quantidade.
   * 
   * <pre>
   * @param quantidade int
   * @return java.util.Date
   * </pre>
   */
  public static Calendar incrementaMesAtual(int quantidade) {
    Calendar c = Calendar.getInstance();
    c.add(Calendar.MONTH, quantidade);
    return c;
  }

}
