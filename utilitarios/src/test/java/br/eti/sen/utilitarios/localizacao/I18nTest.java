package br.eti.sen.utilitarios.localizacao;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class I18nTest {

    private I18n brasil;
    private I18n dataBrasileira;
    private I18n dataHoraBrasileira;
    private I18n horaBrasileira;
    private I18n portuguesBrasileiro;
    private String padraoBrasil;
    private String padraoDataBrasileira;
    private String padraoDataHoraBrasileira;
    private String padraoHoraBrasileira;
    private String padraoPortuguesBrasileiro;

    // MÉTODOS PÚBLICOS

    @BeforeClass
    public static void inicializarClasse() {}

    @Before
    public void inicializarTeste() {
        brasil = I18n.BRASIL;
        dataBrasileira = I18n.DATA_BRASILEIRA;
        dataHoraBrasileira = I18n.DATA_HORA_BRASILEIRA;
        horaBrasileira = I18n.HORA_BRASILEIRA;
        portuguesBrasileiro = I18n.PORTUGUES_BRASILEIRO;
        padraoBrasil = "BR";
        padraoDataBrasileira = "dd/MM/yyyy";
        padraoDataHoraBrasileira = "dd/MM/yyyy HH:mm";
        padraoHoraBrasileira = "HH:mm";
        padraoPortuguesBrasileiro = "bzs";
    }

    @AfterClass
    public static void finalizarClasse() {}

    @After
    public void finalizarTeste() {
        brasil = null;
        dataBrasileira = null;
        dataHoraBrasileira = null;
        horaBrasileira = null;
        portuguesBrasileiro = null;
        padraoBrasil = null;
        padraoDataBrasileira = null;
        padraoDataHoraBrasileira = null;
        padraoHoraBrasileira = null;
        padraoPortuguesBrasileiro = null;
    }

    @Test
    public void testarBrasil() {
        Assert.assertEquals(brasil.getValor(), padraoBrasil);
    }

    @Test
    public void testarDataBrasileira() {
        Assert.assertEquals(dataBrasileira.getValor(), padraoDataBrasileira);
    }

    @Test
    public void testarDataHoraBrasileira() {
        Assert.assertEquals(dataHoraBrasileira.getValor(), padraoDataHoraBrasileira);
    }

    @Test
    public void testarHoraBrasileira() {
        Assert.assertEquals(horaBrasileira.getValor(), padraoHoraBrasileira);
    }

    @Test
    public void testarPortuguesBrasileiro() {
        Assert.assertEquals(portuguesBrasileiro.getValor(), padraoPortuguesBrasileiro);
    }

}
