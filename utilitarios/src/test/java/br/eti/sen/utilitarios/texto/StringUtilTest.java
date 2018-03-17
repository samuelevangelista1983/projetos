package br.eti.sen.utilitarios.texto;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class StringUtilTest {

    private static String conteudo;
    private static String vazio;

    // MÉTODOS PÚBLICOS

    @BeforeClass
    public static void inicializarClasse() {
        conteudo = "uma string com um conteúdo qualquer";
        vazio = "";
    }

    @Before
    public void inicializarTeste() {}

    @AfterClass
    public static void finalizarClasse() {
        conteudo = null;
        vazio = null;
    }

    @After
    public void finalizarTeste() {}

    @Test(expected=NullPointerException.class)
    public void testarContemCaracteresEspeciaisNulo() {
        StringUtil.contemCaracteresEspeciais(null);
    }

    @Test
    public void testarContemCaracteresEspeciaisFalse() {
        String str = "stringsemcaracterespecial";// TODO está tratando o espaço como caracter especial
        Assert.assertFalse(StringUtil.contemCaracteresEspeciais(str));
    }

    @Test
    public void testarContemCaracteresEspeciais() {
        String str = "string com os seguintes caracteres especiais $%&@#";
        Assert.assertTrue(StringUtil.contemCaracteresEspeciais(str));
    }

    @Test(expected=NullPointerException.class)
    public void testarContemDigitoNulo() {
        StringUtil.contemDigito(null);
    }

    @Test
    public void testarContemDigitoFalse() {
        String str = "string sem digitos";
        Assert.assertFalse(StringUtil.contemDigito(str));
    }

    @Test
    public void testarContemDigito() {
        String str = "string com 1 digito";
        Assert.assertTrue(StringUtil.contemDigito(str));
    }

    @Test(expected=NullPointerException.class)
    public void testarContemEspacoNulo() {
        StringUtil.contemEspaco(null);
    }

    @Test
    public void testarContemEspacoFalse() {
        String str = "stringsemespacos";
        Assert.assertFalse(StringUtil.contemEspaco(str));
    }

    @Test
    public void testarContemEspaco() {
        String str = "string com espacos";
        Assert.assertTrue(StringUtil.contemEspaco(str));
    }

    @Test(expected=NullPointerException.class)
    public void testarNormalizarNulo() {
        StringUtil.normalizar(null);
    }

    @Test
    public void testarNormalizar() {
        String str = "d'água";
        String normalizada = "d'agua";
        Assert.assertEquals(normalizada, StringUtil.normalizar(str));
    }

    @Test
    public void testarNaoNulaENaoVaziaNulo() {
        Assert.assertFalse(StringUtil.stringNaoNulaENaoVazia(null));
    }

    @Test
    public void testarNaoNulaENaoVaziaVazio() {
        Assert.assertFalse(StringUtil.stringNaoNulaENaoVazia(StringUtilTest.vazio));
    }

    @Test
    public void testarNaoNulaENaoVaziaFalse() {
    	Assert.assertFalse(StringUtil.stringNaoNulaENaoVazia(null));
    	Assert.assertFalse(StringUtil.stringNaoNulaENaoVazia(StringUtilTest.vazio));
    }

    @Test
    public void testarNulaOuVaziaNulo() {
        Assert.assertTrue(StringUtil.stringNulaOuVazia(null));
    }

    @Test
    public void testarNulaOuVaziaVazio() {
        Assert.assertTrue(StringUtil.stringNulaOuVazia(StringUtilTest.vazio));
    }

    @Test
    public void testarNulaOuVaziaFalse() {
        Assert.assertFalse(StringUtil.stringNulaOuVazia(StringUtilTest.conteudo));
    }

    @Test
    public void testarValorNaoNumericoTrue() {
        Assert.assertTrue(StringUtil.valorNaoNumerico("CEP 32210-140"));
    }

    @Test
    public void testarValorNaoNumericoFalse() {
        Assert.assertFalse(StringUtil.valorNaoNumerico("9873"));
    }

    @Test
    public void testarValorNumericoTrue() {
        Assert.assertTrue(StringUtil.valorNumerico("9873"));
    }

    @Test
    public void testarValorNumericoFalse() {
        Assert.assertFalse(StringUtil.valorNumerico("CEP 32210-140"));
    }

}
