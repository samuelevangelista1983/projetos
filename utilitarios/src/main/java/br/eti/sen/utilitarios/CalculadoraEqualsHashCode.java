package br.eti.sen.utilitarios;

/**
 * Classe calculadora de operações equals e hashCode. Para tanto, basta que o objeto em questão
 * sobreescreva o método toString da superclasse Object.
 *
 * <pre>
 * public class Classe1 {
 *
 *  private String atr0;
 *  private String atr1;
 *
 *  // É necessário sobreescrever o método toString()
 *  @Override
 *  public String toString() {
 *      return atr0 + atr1;
 *  }
 *
 *  // Exemplo de uso do método calcularEquals() no corpo do método equals() sobreescrito
 *  @Override
 *  public boolean equals(Object obj) {
 *      boolean equals = obj instanceof Classe1;
 *
 *      if (equals) {
 *          equals = new CalculadoraEqualsHashCode<Classe1>().calcularEquals(this, (Classe1) obj);
 *      }
 *
 *      return equals;
 *  }
 *
 *  // Exemplo de uso do método calcularHashCode() no corpo do método hashCode() sobreescrito
 *  @Override
 *  public int hashCode(Object obj) {
 *      return new CalculadoraEqualsHashCode<Classe1>().calcularHashCode(this);
 *  }
 * }
 * </pre>
 *
 * @author Samuel Evangelista do Nascimento
 * @param <T>
 * @since 1.0
 */
public class CalculadoraEqualsHashCode<T> {

  // MÉTODOS PRIVADOS

  private String setStringToEqualsAndHashCode(T tipo) {
      return tipo.toString();
  }

  // MÉTODOS PÚBLICOS

  /**
    * Determina se dois objetos do tipo "T" são iguais.
    *
    * @param tipo0 primeiro objeto do tipo "T" a ser comparado
    * @param tipo1 segundo objeto do tipo "T" a ser comparado
    * @return True se os objetos forem iguais, do contrário false
	* @since 1.0
    */
  public boolean calcularEquals(T tipo0, T tipo1) {
      String strObj0 = setStringToEqualsAndHashCode(tipo0);
      String strObj1 = setStringToEqualsAndHashCode(tipo1);
      return strObj0.equals(strObj1);
  }

  /**
    * Calcula o código hash do objeto do tipo "T".
    *
    * @param tipo objeto do tipo "T" a ter o seu código hash calculado
    * @return O código hash do objeto informado
	* @since 1.0
    */
  public int calcularHashCode(T tipo) {
      return setStringToEqualsAndHashCode(tipo).hashCode();
  }

}
