package br.eti.sen.endereco.cliente;

import br.eti.sen.endereco.EnderecoNaoEncontradoException;
import br.eti.sen.endereco.Localizador;
import br.eti.sen.utilitarios.texto.StringUtil;

/**
 * Classe responsável por implementar um exemplo de como utilizar o projeto "endereco" em pesquisas de endereços.
 *
 * @author Samuel Evangelista do Nascimento
 * @since 1.0
 */
public class App {

  /**
   * Método responsável por utilizar a classe {@link Localizador} para pesquisar por um endereço.
   *
   * @param args String[] de uma posição com um CEP válido
   * @since 1.0
   */
  public static void main( String[] args ) {
    if (args.length == 1) {
      StringBuilder mensagem = null;

      try {
		Endereco endereco = new Endereco();
		Localizador localizador = new Localizador();
		localizador.pesquisarEndereco(endereco, args[0]);
		mensagem = new StringBuilder("Endereço encontrado:\n");
		
		String logradouro = endereco.getLogradouro();
		if (StringUtil.stringNaoNulaENaoVazia(logradouro)) {
		  mensagem.append(logradouro);
		  mensagem.append(". ");
		}

		String complemento = endereco.getComplemento();
		if (StringUtil.stringNaoNulaENaoVazia(complemento)) {
		  mensagem.append(complemento);
		  mensagem.append(". ");
		}

		String bairro = endereco.getBairro();
		if (StringUtil.stringNaoNulaENaoVazia(bairro)) {
		  mensagem.append("Bairro ");
		  mensagem.append(bairro);
		  mensagem.append(". ");
		}

		mensagem.append(endereco.getCidade());
		mensagem.append(", ");
		mensagem.append(endereco.getUf());
		mensagem.append(". CEP ");
		mensagem.append(endereco.getCep());
		mensagem.append('.');

      } catch (IllegalArgumentException | EnderecoNaoEncontradoException ex) {
		mensagem = new StringBuilder(ex.getMessage());
      }

      System.out.println(mensagem.toString());

    } else {
      System.out.println("Para pesquisar por um endereço é preciso informar um CEP, como no exemplo a seguir:\njava -jar endereco.jar 32.210-140");
    }

  }

}
