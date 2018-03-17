package br.eti.sen.endereco;

import br.eti.sen.endereco.wscorreios.AtendeCliente;
import br.eti.sen.endereco.wscorreios.AtendeClienteService;
import br.eti.sen.endereco.wscorreios.EnderecoERP;
import br.eti.sen.endereco.wscorreios.SigepClienteException;
import br.eti.sen.endereco.wscorreios.SQLException_Exception;
import br.eti.sen.utilitarios.texto.StringUtil;

/**
 * Classe responsável por disponibilizar métodos de pesquisa de endereços brasileiros na base de dados da Empresa Brasileira de Correios e Telégrafos.
 *
 * @author Samuel Evangelista do Nascimento
 * @since 1.0
 */
public class Localizador {

  // MÉTODOS PRIVADOS

  private String averiguarCEP(String cep) {
    if (StringUtil.stringNulaOuVazia(cep)) {
      throw new IllegalArgumentException("Um CEP deve ser informado. A String informada é nula ou vazia.");
    }

    String cepAveriguado = cep.replaceAll("\\.", "");
    cepAveriguado = cepAveriguado.replaceAll("-", "");

    int size = cepAveriguado.length();
    if (size != 8) {
      StringBuilder mensagem = new StringBuilder("Um CEP válido deve ter 8 dígitos. O CEP informado possui ");
      mensagem.append(size);
      mensagem.append(" dígitos.");
      throw new IllegalArgumentException(mensagem.toString());
    }

    if (StringUtil.valorNaoNumerico(cepAveriguado)) {
      StringBuilder mensagem = new StringBuilder("Um CEP válido deve ter somente dígitos. O CEP informado \"");
      mensagem.append(cep);
      mensagem.append("\" não é válido.");
      throw new IllegalArgumentException(mensagem.toString());
    }

    return cepAveriguado;
  }
  
  private void averiguarEnderecavel(Enderecavel enderecavel) {
	  if (enderecavel == null) {
		throw new IllegalArgumentException("O objeto do tipo Enderecavel não pode ser nulo.");
	  }
  }

  private String formatarComplemento(String complemento0, String complemento1) {
	  StringBuilder complemento = new StringBuilder();
	  
	  if (StringUtil.stringNaoNulaENaoVazia(complemento0)) {
		  complemento.append(complemento);
		  
		  if (StringUtil.stringNaoNulaENaoVazia(complemento1)) {
			  complemento.append(StringUtil.PONTO);
			  complemento.append(StringUtil.ESPACO);
			  complemento.append(complemento1);
		  }
	  }
	  
	  return complemento.length() > 0 ? complemento.toString() : null;
  }
  
  // MÉTODOS PÚBLICOS

  /**
   * Método responsável por pesquisar por um endereço.
   *
   * @param enderecavel objeto do tipo {@link Enderecavel} que terão as propriedades do endereço preenchidas
   * @param cep String de uma posição com um CEP válido com ou sem formatação
   * @throws IllegalArgumentException ocorre nas seguintes situações:
   *	<ul>
   *		<li>quando o objeto do tipo Enderecavel é nulo</li>
   *		<li>quando um CEP não é informado</li>
   *		<li>quando um CEP inválido é informado</li>
   *	</ul>
   * @throws EnderecoNaoEncontradoException ocorre quando um endereço não é encontrado na base de dados da Empresa Brasileira de Correios e Telégrafos
   * @since 1.0
   */
  public void pesquisarEndereco(Enderecavel enderecavel, String cep) throws EnderecoNaoEncontradoException {
    averiguarEnderecavel(enderecavel);
	String cepAveriguado = averiguarCEP(cep);

    try {
      AtendeCliente atendeCliente = new AtendeClienteService().getAtendeClientePort();
      EnderecoERP endereco = atendeCliente.consultaCEP(cepAveriguado);
      enderecavel.setBairro(endereco.getBairro());
	  enderecavel.setCep(endereco.getCep());
	  enderecavel.setCidade(endereco.getCidade());
	  enderecavel.setComplemento(formatarComplemento(endereco.getComplemento(), endereco.getComplemento2()));
	  enderecavel.setLogradouro(endereco.getEnd());
	  enderecavel.setUf(endereco.getUf());
	  
    } catch (SigepClienteException ex) {
      StringBuilder mensagem = new StringBuilder("Não foi encontrado nenhum endereço com o CEP \"");
      mensagem.append(cep);
      mensagem.append("\" informado.");
      throw new EnderecoNaoEncontradoException(mensagem.toString());

    } catch (SQLException_Exception ex) {
      StringBuilder mensagem = new StringBuilder("Ocorreu um erro nos servidores dos Correios ao tentar consultar um endereço. Mensagem de erro apresentada:\n");
      mensagem.append(ex.getMessage());
      throw new RuntimeException(mensagem.toString());
    }

  }

}
