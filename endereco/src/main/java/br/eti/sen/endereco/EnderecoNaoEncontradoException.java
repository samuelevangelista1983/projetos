package br.eti.sen.endereco;

/**
 * Classe responsável por representar uma exeção de execução que deve ocorrer quando um endereço não for encontrado na base de dados da Empresa Brasileira de Correios e Telégrafos.
 *
 * @author Samuel Evangelista do Nascimento
 * @since 1.0
 */
public class EnderecoNaoEncontradoException extends Exception {

  /**
   * Construtor responsável por receber a mensagem que será exibida quando a exceção for lançada.
   *
   * @author Samuel Evangelista do Nascimento
   * @param mensagem String com a mensagem ser exibida
   * @since 1.0
   */
  public EnderecoNaoEncontradoException(String mensagem) {
    super(mensagem);
  }

}
