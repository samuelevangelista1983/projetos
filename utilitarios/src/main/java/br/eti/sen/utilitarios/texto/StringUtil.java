package br.eti.sen.utilitarios.texto;

import java.text.Normalizer;

/**
 * Classe utilitária responsável por disponibilizar métodos que auxiliam o trabalho com objetos Strings.
 *
 * @author Samuel Evangelista do Nascimento
 * @since 1.0
 */
public class StringUtil {

  /**
   * Constante que representa uma barra
   */
  public final static String BARRA = "/";
  /**
   * Constante que representa um espaço
   */
  public final static String ESPACO = " ";
  /**
   * Constante que representa um hifen
   */
  public final static String HIFEN = "-";
  /**
   * Constante que representa um ponto
   */
  public final static String PONTO = ".";

  // METODOS PUBLICOS

  /**
    * Método responsável por verificar se uma {@link java.lang.String String} possui caraceres diferentes de letras e números.
    *
    * @param str {@link java.lang.String String} a ser verificada
    * @return True caso a {@link java.lang.String String} possua caracteres diferentes de letras e número, do contrário false
    */
  public static boolean contemCaracteresEspeciais(String str) {
      boolean contem = false;

      int length = str.length();
      for (int i=0; i<length; i++) {
		  char[] caracteres = {str.charAt(i)};
		  String caracter = new String(caracteres);

		  contem = caracter.matches("[^A-Za-z0-9]");// TODO está tratando o espaço como caracter especial

		  if (contem) {
			  break;
		  }
      }

      return contem;
  }

  /**
    * Método responsável por verificar se uma {@link java.lang.String String} possui caraceres numéricos.
    *
    * @param str {@link java.lang.String String} a ser verificada
    * @return True caso a {@link java.lang.String String} possua caracteres numéricos, do contrário false
    */
  public static boolean contemDigito(String str) {
      boolean contem = false;

      int length = str.length();
      for (int i=0; i<length; i++) {
		  char[] caracteres = {str.charAt(i)};
		  String caracter = new String(caracteres);

		  contem = caracter.matches("[0-9]");

		  if (contem) {
			  break;
		  }
      }

      return contem;
  }

  /**
    * Método responsável por verificar se uma {@link java.lang.String String} possui caraceres de espaço.
    *
    * @param str {@link java.lang.String String} a ser verificada
    * @return True caso a {@link java.lang.String String} possua caracteres de espaço, do contrário false
    */
  public static boolean contemEspaco(String str) {
      return str.contains(ESPACO);
  }

  /**
    * Método responsável por trocar os caracteres com acentos pelos respectivos caracteres sem acentos, exemplo:<br/>
    * <ul>
    * <li>A palavra "órgão" ao ser "normalizada" passa a ser "orgao"</li>
    * <li>A palavra "d'água" ao ser "normalizada" passa a ser "d'agua"</li>
    * <li>A palavra "lingüiça" ao ser "normalizada" passa a ser "linguica"</li>
    * </ul>
	* <br/>Este processo é denominado normalização.
    *
    * @param str {@link java.lang.String String} a ser normalizada
    * @return {@link java.lang.String String} normalizada
    */
  public static String normalizar(String str) {
      String newStr = Normalizer.normalize(str, Normalizer.Form.NFD);
      return newStr.replaceAll("[^\\p{ASCII}]","");
  }

  /**
    * Método responsável por verificar se uma {@link java.lang.String String} não é nula e se a mesma não é vazia (sem nenhum caracter).
    *
    * @param str {@link java.lang.String String} a ser verificada
    * @return True caso a {@link java.lang.String String} não seja nula e não seja vazia, do contrário false
    */
  public static boolean stringNaoNulaENaoVazia(String str) {
    return !stringNulaOuVazia(str);
  }

  /**
    * Método responsável por verificar se uma {@link java.lang.String String} é nula ou vazia (sem nenhum caracter).
    *
    * @param str {@link java.lang.String String} a ser verificada
    * @return True caso a {@link java.lang.String String} seja nula ou vazia, do contrário false
    */
  public static boolean stringNulaOuVazia(String str) {
    return str == null || str.isEmpty();
  }

  /**
    * Método responsável por verificar se uma {@link java.lang.String String} não represente um valor numérico (não é formada somente por números).
    *
    * @param str {@link java.lang.String String} a ser verificada
    * @return True caso a {@link java.lang.String String} não represente um valor numérico, do contrário false
    */
  public static boolean valorNaoNumerico(String str) {
      return !valorNumerico(str);
  }

  /**
    * Método responsável por verificar se uma {@link java.lang.String String} representa um valor numérico (formada somente por números).
    *
    * @param str {@link java.lang.String String} a ser verificada
    * @return True caso a {@link java.lang.String String} represente um valor numérico, do contrário false
    */
  public static boolean valorNumerico(String str) {
      return str.matches("[0-9]+");
  }

}
