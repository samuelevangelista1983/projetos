package br.eti.sen.utilitarios.localizacao;

/**
 * Enum responsável por representar os códigos de formatação das diversas localidades.
 *
 * @author Samuel Evangelista do Nascimento
 * @since 1.0
 */
public enum I18n {

    /**
     * Instância singleton para o formato de data brasileira
     */
    DATA_BRASILEIRA("dd/MM/yyyy"),
    /**
     * Instância singleton para o formato de data e hora brasileira
     */
    DATA_HORA_BRASILEIRA("dd/MM/yyyy HH:mm"),
    /**
     * Instância singleton para o formato de hora brasileira
     */
    HORA_BRASILEIRA("HH:mm"),
    /**
     * Instância singleton para o código do país Brasil
     */
    BRASIL("BR"),
    /**
     * Instância singleton para o código do idioma Português falado no Brasil
     */
    PORTUGUES_BRASILEIRO("bzs");

    private final String conteudo;

    private I18n(String conteudo) {
        this.conteudo = conteudo;
    }

    // MÉTODOS PÚBLICOS

    /**
     * Método responsável por gerar uma string que represente uma instância da classe.
     *
     * @return O código do país ou do seu respectivo idioma
     * @since 1.0
     */
    public String getValor() {
        return conteudo;
    }

}
