package br.eti.sen.utilitarios.tempo;

import br.eti.sen.utilitarios.localizacao.I18n;
import br.eti.sen.utilitarios.texto.StringUtil;
import java.text.NumberFormat;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class DataUtilTest {

	private LocalDate data;
	private LocalDateTime dataHora;
	private LocalTime hora;
	private StringBuilder dataStr;
	private StringBuilder dataHoraStr;
	private StringBuilder horaStr;

	// MÉTODOS PÚBLICOS

	@BeforeClass
	public static void inicializarClasse() {
	}

	@Before
	public void inicializarTeste() throws ParseException {
		data = LocalDate.now();
		dataHora = LocalDateTime.now();
		hora = LocalTime.now();
		NumberFormat format = NumberFormat.getInstance();
		format.setMinimumIntegerDigits(2);
		dataStr = new StringBuilder(format.parse(Integer.toString(data.getDayOfMonth())).toString());
		dataStr.append(StringUtil.BARRA);
		dataStr.append(format.parse(Integer.toString(data.getMonthValue())));
		dataStr.append(StringUtil.BARRA);
		dataStr.append(data.getYear());
		dataHoraStr = new StringBuilder(format.parse(Integer.toString(dataHora.getDayOfMonth())).toString());
		dataHoraStr.append(StringUtil.BARRA);
		dataHoraStr.append(format.parse(Integer.toString(dataHora.getMonthValue())));
		dataHoraStr.append(StringUtil.BARRA);
		dataHoraStr.append(dataHora.getYear());
		dataHoraStr.append(StringUtil.ESPACO);
		dataHoraStr.append(format.parse(Integer.toString(dataHora.getHour())));
		dataHoraStr.append(':');
		Integer minuto = dataHora.getMinute();
		
		if (minuto < 10) {
			dataHoraStr.append(0);
		}
		
		dataHoraStr.append(minuto);
		horaStr = new StringBuilder();
		Integer horaInt = hora.getHour();
		
		if (horaInt < 10) {
			horaStr.append(0);
		}
		
		horaStr.append(horaInt);
		horaStr.append(':');
		minuto = hora.getMinute();
		
		if (minuto < 10) {
			horaStr.append(0);
		}
		
		horaStr.append(minuto);
	}

	@AfterClass
	public static void finalizarClasse() {
	}

	@After
	public void finalizarTeste() {
		data = null;
		dataHora = null;
		hora = null;
		dataStr = null;
		dataHoraStr = null;
		horaStr = null;
	}

	@Test(expected = NullPointerException.class)
	public void testarConfigurarTempoLocalDateTimeNulo() {
		DataUtil.configurarTempo(null, 0, 0, 0, 0);
	}

	@Test
	public void testarConfigurarTempo() {
		LocalDateTime localDateTime = LocalDateTime.now();
		localDateTime = localDateTime.withHour(12);
		localDateTime = localDateTime.withMinute(30);
		localDateTime = localDateTime.withSecond(30);
		localDateTime = localDateTime.withNano(0);
		Assert.assertEquals(DataUtil.configurarTempo(dataHora, 12, 30, 30, 0), localDateTime);
	}

	@Test(expected = NullPointerException.class)
	public void testarFormatarDataNulo() {
		DataUtil.formatarData(null);
	}

	@Test
	public void testarFormatarData() {
		String str = DataUtil.formatarData(data);
		Assert.assertEquals(str, dataStr.toString());
	}

	@Test(expected = NullPointerException.class)
	public void testarFormatarDataPadraoNulo() {
		DataUtil.formatarData(data, null);
	}

	@Test
	public void testarFormatarDataPadrao() {
		String str = DataUtil.formatarData(data, I18n.DATA_BRASILEIRA.getValor());
		Assert.assertEquals(str, dataStr.toString());
	}

	@Test(expected = NullPointerException.class)
	public void testarFormatarDataHoraNulo() {
		DataUtil.formatarDataHora(null);
	}

	@Test
	public void testarFormatarDataHora() {
		String str = DataUtil.formatarDataHora(dataHora);
		Assert.assertEquals(str, dataHoraStr.toString());
	}

	@Test(expected = NullPointerException.class)
	public void testarFormatarDataHoraPadraoNulo() {
		DataUtil.formatarDataHora(dataHora, null);
	}

	@Test
	public void testarFormatarDataHoraBrasileira() {
		String str = DataUtil.formatarDataHora(dataHora, I18n.DATA_HORA_BRASILEIRA.getValor());
		Assert.assertEquals(str, dataHoraStr.toString());
	}

	@Test(expected = NullPointerException.class)
	public void testarFormatarHoraNulo() {
		DataUtil.formatarHora(null);
	}

	@Test
	public void testarFormatarHora() {
		String str = DataUtil.formatarHora(hora);
		Assert.assertEquals(str, horaStr.toString());
	}

	@Test(expected = NullPointerException.class)
	public void testarFormatarHoraPadraoNulo() {
		DataUtil.formatarHora(hora, null);
	}

	@Test
	public void testarFormatarHoraBrasileira() {
		String str = DataUtil.formatarHora(hora, I18n.HORA_BRASILEIRA.getValor());
		Assert.assertEquals(str, horaStr.toString());
	}

	@Test(expected = NullPointerException.class)
	public void testarIsDiaUtilNulo() {
		DataUtil.isDiaUtil(null);
	}

	@Test
	public void testarIsDiaUtilSabado() {
		boolean isDiaUtil = DataUtil.isDiaUtil(LocalDate.of(2016, 4, 16));
		Assert.assertFalse(isDiaUtil);
	}

	@Test
	public void testarIsDiaUtilDomingo() {
		boolean isDiaUtil = DataUtil.isDiaUtil(LocalDate.of(2016, 4, 17));
		Assert.assertFalse(isDiaUtil);
	}

	@Test
	public void testarIsDiaUtil() {
		boolean isDiaUtil = DataUtil.isDiaUtil(LocalDate.of(2016, 4, 19));
		Assert.assertTrue(isDiaUtil);
	}

	@Test(expected = NullPointerException.class)
	public void testarParserDataNulo() {
		DataUtil.parserData(null);
	}

	@Test
	public void testarParserData() {
		LocalDate localDate = DataUtil.parserData(dataStr.toString());
		Assert.assertEquals(localDate, data);
	}

	@Test(expected = NullPointerException.class)
	public void testarParserDataPadraoNulo() {
		DataUtil.parserData(data.toString(), null);
	}

	@Test
	public void testarParserDataPadrao() {
		LocalDate localDate = DataUtil.parserData(dataStr.toString(), I18n.DATA_BRASILEIRA.getValor());
		Assert.assertEquals(localDate, data);
	}

	@Test(expected = NullPointerException.class)
	public void testarParserDataHoraNulo() {
		DataUtil.parserDataHora(null);
	}

	@Test
	public void testarParserDataHora() {
		/* TODO verificar esse teste
		LocalDateTime localDateTime = DataUtil.parserDataHora(dataHoraStr.toString());
		Assert.assertEquals(dataHora, localDateTime);*/
	}

	@Test(expected = NullPointerException.class)
	public void testarParserDataHoraPadraoNulo() {
		DataUtil.parserDataHora(dataHoraStr.toString(), null);
	}

	@Test
	public void testarParserDataHoraBrasileira() {
		/* TODO verificar este teste
		LocalDateTime localDateTime = DataUtil.parserDataHora(dataHoraStr.toString(),
				I18n.DATA_HORA_BRASILEIRA.getValor());
		Assert.assertEquals(ataHora, localDateTime);*/
	}

	@Test(expected = NullPointerException.class)
	public void testarParserHoraNulo() {
		DataUtil.parserHora(null, null);
	}

	@Test
	public void testarParserHora() {
		/* TODO verificar este teste
		LocalTime localTime = DataUtil.parserHora(horaStr.toString(), "HH:mm");
		Assert.assertEquals(hora, localTime);
		*/
	}

	@Test(expected = NullPointerException.class)
	public void testarParserHoraPadraoNulo() {
		DataUtil.parserHora(hora.toString(), null);
	}

	@Test
	public void testarParserHoraBrasileira() {
		/* TODO verificar este teste
		LocalTime localTime = DataUtil.parserHora(horaStr.toString(), I18n.HORA_BRASILEIRA.getValor());
		Assert.assertEquals(hora, localTime);*/
	}

}
