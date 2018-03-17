package br.eti.sen.utilitarios.seguranca;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Classe utilitária responsável por disponibilizar métodos que auxiliam o trabalho com criptografia.
 *
 * @author Samuel Evangelista do Nascimento
 * @since 1.0
 */
public class CriptografiaUtil {

  // METODOS PUBLICOS

  /**
    * Método responsável por calcular o código hash de uma String por meio do algoritmo MD5.
    *
    * @param texto String com o texto a ter o seu código hash calculado
    * @return String que representa o hash do texto informado
    * @throws NoSuchAlgorithmException
    */
  public static String calcularHashMD5(String texto) throws NoSuchAlgorithmException {
    MessageDigest messageDigest = MessageDigest.getInstance("MD5");
    byte[] byteArray = messageDigest.digest(texto.getBytes());
    return String.format("%02X", byteArray);
  }

}
