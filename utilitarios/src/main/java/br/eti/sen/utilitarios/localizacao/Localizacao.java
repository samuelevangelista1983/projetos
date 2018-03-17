package br.eti.sen.utilitarios.localizacao;

import java.util.Locale;

/**
 * Classe responsável por disponibilizar métodos que auxiliam a obtenção de objetos que representem diferentes localidades.
 *
 * @author Samuel Evangelista do Nascimento
 * @since 1.0
 */
public class Localizacao {

    /**
     * Método responsável por instanciar um objeto do tipo {@link java.util.Locale Locale} que represente a localidade brasileira.
     *
     * @return {@link java.util.Locale Locale} que represente a localidade brasileira
     * @since 1.0
     */
    public static Locale getLocalidadeBrasileira() {
	return Locale.forLanguageTag(I18n.PORTUGUES_BRASILEIRO.getValor());
    }

}
