package br.eti.sen.utilitarios.seguranca;

import java.security.NoSuchAlgorithmException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class CriptografiaUtilTest {

    private static String texto0;
    private static String texto1;

    // MÉTODOS PÚBLICOS

    @BeforeClass
    public static void inicializarClasse() {
        texto0 = "Este é o texto 0.";
        texto1 = "Este é o texto 1.";
    }

    @Before
    public void inicializarTeste() {}

    @AfterClass
    public static void finalizarClasse() {
        texto0 = null;
        texto1 = null;
    }

    @After
    public void finalizarTeste() {}

    @Test(expected=NullPointerException.class)
    public void testarHashCodeMD5ParametroNulo() throws Exception {
        CriptografiaUtil.calcularHashMD5(null);
    }

    @Test
    public void testarHashCodeMD5ObjetosDiferentes() throws NoSuchAlgorithmException {
    	/*TODO verificar este teste
        String hashCode0 = CriptografiaUtil.calcularHashMD5(texto0);
        String hashCode1 = CriptografiaUtil.calcularHashMD5(texto1);
        Assert.assertFalse(!hashCode0.equals(hashCode1));*/
    }

    @Test
    public void testarHashCodeMD5ObjetosIguais() throws NoSuchAlgorithmException {
    	/*TODO verificar este teste
        String hashCode0 = CriptografiaUtil.calcularHashMD5(texto0);
        String hashCode1 = CriptografiaUtil.calcularHashMD5(texto0);
        Assert.assertFalse(hashCode0.equals(hashCode1));*/
    }

}
