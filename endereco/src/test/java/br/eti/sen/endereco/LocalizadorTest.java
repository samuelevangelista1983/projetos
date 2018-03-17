package br.eti.sen.endereco;

import br.eti.sen.endereco.EnderecoNaoEncontradoException;
import br.eti.sen.endereco.Localizador;
import br.eti.sen.endereco.cliente.Endereco;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Teste de unidade da classe {@link br.eti.sen.endereco.Localizador Localizador}
 *
 * @author Samuel Evangelista do Nascimento
 * @since 1.0
 */
public class LocalizadorTest {

  private static String cepAlfanumerico;
  private static String cepComHifen;
  private static String cepComPonto;
  private static String cepFormatado;
  private static String cepInexistente;
  private static String cepMais8Digitos;
  private static String cepMenos8Digitos;
  private static String cepNaoFormatado;
  private static String cepVazio;
  private static Endereco enderecoEsperado;

  private Localizador localizador;

  // MÉTODOS PÚBLICOS

  @BeforeClass
  public static void inicializarClasse() throws EnderecoNaoEncontradoException {
    cepAlfanumerico = "3221ol4o";
    cepComPonto = "32.210140";
    cepComHifen = "32210-140";
    cepFormatado = "32.210-140";
    cepInexistente = "32210999";
    cepMais8Digitos = "322101400";
    cepMenos8Digitos = "3221014";
    cepNaoFormatado = "32210140";
    cepVazio = "";
    enderecoEsperado = new Endereco();
    enderecoEsperado.setLogradouro("Rua Osório de Morais");
    enderecoEsperado.setComplemento(null);
    enderecoEsperado.setBairro("Cidade Industrial");
    enderecoEsperado.setCidade("Contagem");
    enderecoEsperado.setUf("MG");
    enderecoEsperado.setCep("32210140");
  }

  @Before
  public void inicializarTeste() throws EnderecoNaoEncontradoException {
    localizador = new Localizador();
  }

  @AfterClass
  public static void finalizarClasse() throws EnderecoNaoEncontradoException {
    cepAlfanumerico = null;
    cepComPonto = null;
    cepComHifen = null;
    cepFormatado = null;
    cepInexistente = null;
    cepMais8Digitos = null;
    cepMenos8Digitos = null;
    cepNaoFormatado = null;
    cepVazio = null;
    enderecoEsperado = null;
  }

  @After
  public void finalizarTeste() throws EnderecoNaoEncontradoException {
    localizador = null;
  }

  @Test(expected=IllegalArgumentException.class)
  public void testarEnderecavelNuloInformado() throws EnderecoNaoEncontradoException {
    localizador.pesquisarEndereco(null, LocalizadorTest.cepFormatado);
  }
  
  @Test(expected=IllegalArgumentException.class)
  public void testarCEPVazioInformado() throws EnderecoNaoEncontradoException {
    localizador.pesquisarEndereco(new Endereco(), LocalizadorTest.cepVazio);
  }

  @Test(expected=IllegalArgumentException.class)
  public void testarCEPComLetras() throws EnderecoNaoEncontradoException {
    localizador.pesquisarEndereco(new Endereco(), LocalizadorTest.cepAlfanumerico);
  }

  @Test(expected=IllegalArgumentException.class)
  public void testarCEPComMaisDe8Digitos() throws EnderecoNaoEncontradoException {
    localizador.pesquisarEndereco(new Endereco(), LocalizadorTest.cepMais8Digitos);
  }

  @Test(expected=IllegalArgumentException.class)
  public void testarCEPComMenosDe8Digitos() throws EnderecoNaoEncontradoException {
    localizador.pesquisarEndereco(new Endereco(), LocalizadorTest.cepMenos8Digitos);
  }

  @Test
  public void testarCEPComPonto() throws EnderecoNaoEncontradoException {
    Endereco endereco = new Endereco();
    localizador.pesquisarEndereco(endereco, LocalizadorTest.cepComPonto);
    Assert.assertEquals(LocalizadorTest.enderecoEsperado, endereco);
  }

  @Test
  public void testarCEPComHifen() throws EnderecoNaoEncontradoException {
    Endereco endereco = new Endereco();
    localizador.pesquisarEndereco(endereco, LocalizadorTest.cepComHifen);
    Assert.assertEquals(LocalizadorTest.enderecoEsperado, endereco);
  }

  @Test
  public void testarCEPFormatado() throws EnderecoNaoEncontradoException {
    Endereco endereco = new Endereco();
    localizador.pesquisarEndereco(endereco, LocalizadorTest.cepFormatado);
    Assert.assertEquals(LocalizadorTest.enderecoEsperado, endereco);
  }

  @Test
  public void testarCEPSemFormatacao() throws EnderecoNaoEncontradoException {
	Endereco endereco = new Endereco();
    localizador.pesquisarEndereco(endereco, LocalizadorTest.cepNaoFormatado);
    Assert.assertEquals(LocalizadorTest.enderecoEsperado, endereco);
  }

  @Test(expected=EnderecoNaoEncontradoException.class)
  public void testarCEPNaoExistente() throws EnderecoNaoEncontradoException {
    localizador.pesquisarEndereco(new Endereco(), LocalizadorTest.cepInexistente);
  }

}
