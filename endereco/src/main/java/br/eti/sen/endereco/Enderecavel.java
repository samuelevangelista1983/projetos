package br.eti.sen.endereco;

/**
 * Interface responsável por definir os métodos responsáveis por atribuir as propriedades relativas à um endereço.
 *
 * @author Samuel Evangelista do Nascimento
 * @since 1.0
 */
public interface Enderecavel {
	
	/**
	 * Método responsável por definir o bairro relativo à um endereço.
	 *
	 * @param bairro String com o bairro a ser atribuído
	 * @since 1.0
	 */
	public abstract void setBairro(String bairro);
	
	/**
	 * Método responsável por definir o CEP relativo à um endereço.
	 *
	 * @param cep String com o CEP a ser atribuído
	 * @since 1.0
	 */
	public abstract void setCep(String cep);
	
	/**
	 * Método responsável por definir a cidade relativa à um endereço.
	 *
	 * @param cidade String com a cidade a ser atribuída
	 * @since 1.0
	 */
	public abstract void setCidade(String cidade);
	
	/**
	 * Método responsável por definir o complemento relativo à um endereço.
	 *
	 * @param complemento String com o complemento a ser atribuído
	 * @since 1.0
	 */
	public abstract void setComplemento(String complemento);
	
	/**
	 * Método responsável por definir o logradouro relativo à um endereço.
	 *
	 * @param logradouro String com o logradouro a ser atribuído
	 * @since 1.0
	 */
	public abstract void setLogradouro(String logradouro);
	
	/**
	 * Método responsável por definir a UF relativa à um endereço.
	 *
	 * @param uf String com a UF a ser atribuída
	 * @since 1.0
	 */
	public abstract void setUf(String uf);
	
}