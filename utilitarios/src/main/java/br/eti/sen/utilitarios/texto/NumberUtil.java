package br.eti.sen.utilitarios.texto;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Currency;
import java.util.Locale;

/**
 * Classe utilitária responsável por disponibilizar métodos que auxiliam o trabalho com números.
 *
 * @author Samuel Evangelista do Nascimento
 * @since 1.0
 */
public class NumberUtil {

  /**
    * Método responsável por gerar uma {@link java.lang.String String} de um objeto do tipo {@link java.math.BigDecimal BigDecimal} no padrão informado.
    *
    * @param padrao {@link java.lang.String String} que determina o formato da String gerada
	* @param valor {@link java.math.BigDecimal BigDecimal} com o número que será formatado
    * @return {@link java.lang.String String} que representa um número no formato informado
    */
  public static String formatarNumero(String padrao, BigDecimal valor) {
    DecimalFormat decimalFormat = new DecimalFormat(padrao);
    return decimalFormat.format(valor);
  }

  /**
    * Método responsável por gerar uma {@link java.lang.String String} de um objeto do tipo {@link java.math.BigDecimal BigDecimal} que represente um número com duas casas decimais.
    *
    * @param valor {@link java.math.BigDecimal BigDecimal} com o número que será formatado
    * @return {@link java.lang.String String} que representa um número com duas casas decimais
    */
  public static String formatarNumero(BigDecimal valor) {
    return NumberUtil.formatarNumero("0.00", valor);
  }

  /**
    * Método responsável por retornar uma {@link java.lang.String String} de um objeto do tipo {@link java.math.BigDecimal BigDecimal} que represente um número em formato monetário.
    * O formato monetário é determinado pela localização padrão da JVM.
    *
    * @param valor {@link java.math.BigDecimal BigDecimal} com o número que será formatado
    * @return String que representa um número em formato de moeda de acordo com a localização padrão da JVM
    */
  public static String formatarNumeroMonetario(BigDecimal valor) {
    return NumberUtil.formatarNumero("#,##0.00", valor);
  }

  /**
    * Método responsável por retornar uma {@link java.lang.String String} de um objeto do tipo {@link java.math.BigDecimal BigDecimal} que represente um número em formato monetário.
    * O formato monetário é determinado pela localização informada por meio de um objeto do tipo {@link java.util.Locale Locale}.
    *
    * @param valor {@link java.math.BigDecimal BigDecimal} com o número que será formatado
	* @param localidade {@link java.util.Locale Locale} que represente uma determinada localidade
    * @return String que representa um número em formato de moeda de acordo com a localização informada
    */
  public static String formatarNumeroMonetario(BigDecimal valor, Locale localidade) {
    DecimalFormat decimalFormat = new DecimalFormat("#,##0.00#, valor");
    decimalFormat.setCurrency(Currency.getInstance(localidade));
    return decimalFormat.format(valor);
  }

}
