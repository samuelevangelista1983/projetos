package br.eti.sen.utilitarios.tempo;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import br.eti.sen.utilitarios.localizacao.I18n;

/**
 * Classe utilitária responsável por disponibilizar métodos que auxiliam o trabalho com data e hora.
 *
 * @author Samuel Evangelista do Nascimento
 * @since 1.0
 */
public class DataUtil {

  /**
   * Métoddo responsável por configurar as informações de tempo de em um objeto do tipo
   * {@link java.time.LocalDateTime LocalDateTime}.
   *
   * @param data {@link java.util.LocalDateTime LocalDateTime} objeto a ter as informações de tempo configuradas
   * @param horas horas a serem configuradas
   * @param minutos minutos a serem configurados
   * @param segundos segundos a serem configurados
   * @param milisegundos milisegundos a serem configurados
   * return objeto do tipo {@link java.util.LocalDateTime LocalDateTime} com as informações de tempo configuradas
   */
  public static LocalDateTime configurarTempo(LocalDateTime localDateTime, int horas, int minutos, int segundos, int milisegundos) {
    return localDateTime.withHour(horas).withMinute(minutos).withSecond(segundos).withNano(milisegundos);
  }

  /**
   * Método que retorna uma String que representa uma data no formato DD/MM/AAAA.
   *
   * @param data {@link java.util.LocalDate LocalDate} a ser formatado
   * return {@link java.lang.String String} que representa uma data no formato DD/MM/AAAA
   */
  public static String formatarData(LocalDate data) {
    return formatarData(data, I18n.DATA_BRASILEIRA.getValor());
  }

  /**
   * Método que retorna uma String que representa uma data no formato informado.
   *
   * @param data {@link java.util.LocalDate LocalDate} a ser formatado
   * @param padrao {@link java.lang.String String} padrão a ser considerado na formatação da data
   * return {@link java.lang.String String} que representa uma data no formato informado
   */
  public static String formatarData(LocalDate data, String padrao) {
    return data.format(DateTimeFormatter.ofPattern(padrao));
  }

  /**
   * Método que retorna uma String que representa uma data e hora no formato DD/MM/AAAA HH:mm.
   *
   * @param data {@link java.util.LocalDateTime LocalDateTime} a ser formatado
   * return {@link java.lang.String String} que representa uma data e hora no formato DD/MM/AAAA HH:mm
   */
  public static String formatarDataHora(LocalDateTime dataHora) {
    return formatarDataHora(dataHora, I18n.DATA_HORA_BRASILEIRA.getValor());
  }

  /**
   * Método que retorna uma String que representa uma data e hora no formato informado.
   *
   * @param data {@link java.util.LocalDateTime LocalDateTime} a ser formatado
   * @param padrao {@link java.lang.String String} padrão a ser considerado na formatação da data e hora
   * return {@link java.lang.String String} que representa uma data no formato informado
   */
  public static String formatarDataHora(LocalDateTime dataHora, String padrao) {
    return dataHora.format(DateTimeFormatter.ofPattern(padrao));
  }

  /**
   * Retorna uma String que representa uma hora no formato HH:mm.
   *
   * @param hora {@link java.util.LocalTime LocalTime} a ser formatada
   * return String que representa uma hora no formato HH:mm
   */
  public static String formatarHora(LocalTime hora) {
    return formatarHora(hora, I18n.HORA_BRASILEIRA.getValor());
  }

   /**
   * Método que retorna uma String que representa uma hora no formato informado.
   *
   * @param hora {@link java.util.LocalTime LocalTime} a ser formatada
   * @param padrao {@link java.lang.String String} padrão a ser considerado na formatação da hora
   * return {@link java.lang.String String} que representa uma hora no formato informado
   */
  public static String formatarHora(LocalTime hora, String padrao) {
    return hora.format(DateTimeFormatter.ofPattern(padrao));
  }

  /**
   * Método que verifica se a data informada representa um dia diferente de Sábado e de Domingo.
   *
   * @param data {@link java.util.LocalDate LocalDate} a ser verificado
   * @return true se a data representa um dia diferente de Sábado e de Domingo
   */
  public static boolean isDiaUtil(LocalDate data) {
    DayOfWeek dayOfWeek = data.getDayOfWeek();
    return dayOfWeek != DayOfWeek.SATURDAY && dayOfWeek != DayOfWeek.SUNDAY;
  }

  /**
   * Método que retorna um objeto do tipo {@link java.util.LocalDate LocalDate} ao informar uma String que
   * representa uma data no formato DD/MM/AAAA.
   *
   * @param str {@link java.lang.String String} que representa uma data no formato DD/MM/AAAA
   * @return {@link java.util.LocalDate LocalDate}
   */
  public static LocalDate parserData(String str) {
    return LocalDate.parse(str, DateTimeFormatter.ofPattern(I18n.DATA_BRASILEIRA.getValor()));
  }

  /**
   * Método que retorna um objeto do tipo {@link java.util.LocalDate LocalDate} ao informar uma String que
   * representa uma data no formato informado.
   *
   * @param str {@link java.lang.String String} que representa uma data
   * @param padrao formato da data representada pelo parâmetro <i>str</i>
   * @return {@link java.util.LocalDate LocalDate}
   */
  public static LocalDate parserData(String str, String padrao) {
    return LocalDate.parse(str, DateTimeFormatter.ofPattern(padrao));
  }

  /**
   * Método que retorna um objeto do tipo {@link java.util.LocalDateTime LocalDateTime} ao informar uma String que
   * representa uma data no formato DD/MM/AAAA HH:mm.
   *
   * @param str {@link java.lang.String String} que representa uma data no formato DD/MM/AAAA HH:mm
   * @return {@link java.util.LocalDateTime LocalDateTime}
   */
  public static LocalDateTime parserDataHora(String str) {
    return LocalDateTime.parse(str, DateTimeFormatter.ofPattern(I18n.DATA_HORA_BRASILEIRA.getValor()));
  }

  /**
   * Método que retorna um objeto do tipo {@link java.util.LocalDateTime LocalDateTime} ao informar uma String que
   * representa uma data no formato informado.
   *
   * @param str {@link java.lang.String String} que representa uma data e hora
   * @param padrao formato da data representada pelo parâmetro <i>str</i>
   * @return {@link java.util.LocalDateTime LocalDateTime}
   */
  public static LocalDateTime parserDataHora(String str, String padrao) {
    return LocalDateTime.parse(str, DateTimeFormatter.ofPattern(padrao));
  }

  /**
   * Método que retorna um objeto do tipo {@link java.util.LocalTime LocalTime} ao informar uma String que
   * representa uma data no formato HH:mm.
   *
   * @param str {@link java.lang.String String} que representa uma hora no formato HH:mm
   * @return {@link java.util.LocalTime LocalTime}
   */
  public static LocalTime parseHora(String str) {
    return LocalTime.parse(str, DateTimeFormatter.ofPattern(I18n.HORA_BRASILEIRA.getValor()));
  }

  /**
   * Método que retorna um objeto do tipo {@link java.util.LocalTime LocalTime} ao informar uma String que
   * representa uma data no formato informado.
   *
   * @param str {@link java.lang.String String} que representa uma hora
   * @param padrao formato da hora representada pelo parâmetro <i>str</i>
   * @return {@link java.util.LocalTime LocalTime}
   */
  public static LocalTime parserHora(String str, String padrao) {
    return LocalTime.parse(str, DateTimeFormatter.ofPattern(padrao));
  }

}
