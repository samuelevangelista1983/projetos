package br.eti.sen.utilitarios;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class CalculadoraEqualsHashCodeTest {

    private static CalculadoraEqualsHashCodeTest objeto0;
    private static CalculadoraEqualsHashCodeTest objeto1;

    private CalculadoraEqualsHashCode<CalculadoraEqualsHashCodeTest> calculadora;
    private String atributo0;
    private String atributo1;

    // MÉTODOS PÚBLICOS

    @BeforeClass
    public static void inicializarClasse() {
        objeto0 = new CalculadoraEqualsHashCodeTest();
        objeto0.atributo0 = "Este é o atributo 0 do objeto 0.";
        objeto0.atributo0 = "Este é o atributo 1 do objeto 0.";
        objeto1 = new CalculadoraEqualsHashCodeTest();
        objeto1.atributo0 = "Este é o atributo 0 do objeto 1.";
        objeto1.atributo0 = "Este é o atributo 1 do objeto 1.";
    }

    @Before
    public void inicializarTeste() {
        calculadora = new CalculadoraEqualsHashCode<CalculadoraEqualsHashCodeTest>();
    }

    @AfterClass
    public static void finalizarClasse() {
        objeto0 = null;
        objeto1 = null;
    }

    @After
    public void finalizarTeste() {
        calculadora = null;
    }

    @Test(expected=NullPointerException.class)
    public void testarEqualsPrimeiroParametroNulo() {
        calculadora.calcularEquals(null, objeto1);
    }

    @Test(expected=NullPointerException.class)
    public void testarEqualsSegundoParametroNulo() {
        calculadora.calcularEquals(objeto0, null);
    }

    @Test
    public void testarEqualsObjetosDiferentes() {
        boolean resultado = calculadora.calcularEquals(objeto0, objeto1);
        Assert.assertFalse(resultado);
    }

    @Test
    public void testarEqualsObjetosIguais() {
        boolean resultado = calculadora.calcularEquals(objeto0, objeto0);
        Assert.assertTrue(resultado);
    }

    @Test(expected=NullPointerException.class)
    public void testarHashCodeParametroNulo() {
        calculadora.calcularHashCode(null);
    }

    @Test
    public void testarHashCodeObjetosDiferentes() {
        int hashCode0 = calculadora.calcularHashCode(objeto0);
        int hashCode1 = calculadora.calcularHashCode(objeto1);
        Assert.assertFalse(hashCode0 == hashCode1);
    }

    @Test
    public void testarHashCodeObjetosIguais() {
        int hashCode0 = calculadora.calcularHashCode(objeto0);
        int hashCode1 = calculadora.calcularHashCode(objeto0);
        Assert.assertTrue(hashCode0 == hashCode1);
    }

    @Override
    public String toString() {
        return new StringBuilder(atributo0).append(atributo1).toString();
    }

}
