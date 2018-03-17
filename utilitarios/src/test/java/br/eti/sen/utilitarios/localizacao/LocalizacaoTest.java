package br.eti.sen.utilitarios.localizacao;

import java.util.Locale;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class LocalizacaoTest {

	@BeforeClass
	public static void inicializarClasse() {
	}

	@Before
	public void inicializarTeste() {
	}

	@AfterClass
	public static void finalizarClasse() {
	}

	@After
	public void finalizarTeste() {
	}

	@Test
	public void testarLocalidadeBrasileira() {
		/*
		 *  TODO a localidade brasileira está sendo instanciada de acordo com o código do idioma e não do país
		 *  isso leva à classe a retornar o código do país como bzs e não BR
		 */
		/*Locale localizacaoBrasileira = Localizacao.getLocalidadeBrasileira();
		System.out.println(localizacaoBrasileira.getISO3Country());
		boolean codigoPais = I18n.BRASIL.getValor().equals(localizacaoBrasileira.getCountry());
		boolean codigoIdioma = I18n.PORTUGUES_BRASILEIRO.getValor().equals(localizacaoBrasileira.getISO3Language());
		System.out.println(localizacaoBrasileira.getISO3Language());
		Assert.assertTrue(codigoPais);
		Assert.assertTrue(codigoIdioma);*/
	}

}
