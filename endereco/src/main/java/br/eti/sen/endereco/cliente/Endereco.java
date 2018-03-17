package br.eti.sen.endereco.cliente;

import br.eti.sen.endereco.Enderecavel;

/**
 * Classe responsável por representar um endereço brasileiro obtido por meio de pesquisa à base de dados da Empresa Brasileira de Correios e Telégrafos.
 *
 * @author Samuel Evangelista do Nascimento
 * @since 1.0
 */
public class Endereco implements Enderecavel {
	
	private String bairro;
	private String cep;
	private String cidade;
	private String complemento;
	private String logradouro;
	private String uf;
	
	// MÉTODOS PÚBLICOS
	
	/**
	 * Método responsável por determinar se o objeto informado é igual à instância da classe.
	 * Este método foi sobreescrito para que esta classe possa ser utilizada pela classe de testes unitários.
	 *
	 * @param object Object do tipo {@link Endereco}
	 * @return True se object é igual à instância da classe, do contrário false
	 * @since 1.0
	 */
	@Override
	public boolean equals(Object object) {
		boolean equals = false;
		
		if (object instanceof Endereco) {
			Endereco endereco = (Endereco) object;
			equals = toString().equals(endereco.toString());
		}
		
		return equals;
	}
	
	/**
	 * Método responsável por calcular o código hash da instância da classe.
	 * Este método foi sobreescrito para que esta classe possa ser utilizada pela classe de testes unitários.
	 *
	 * @return O código hash da instância da classe
	 * @since 1.0
	 */
	@Override
	public int hashCode() {
		return toString().hashCode();
	}
	
	/**
	 * Método responsável por gerar uma string que represente uma instância da classe.
	 * Este método foi sobreescrito para que esta classe possa ser utilizada pela classe de testes unitários.
	 *
	 * @return A representação de uma instância da classe
	 * @since 1.0
	 */
	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append(logradouro);
		str.append(complemento);
		str.append(bairro);
		str.append(cidade);
		str.append(uf);
		str.append(cep);
		return str.toString();
	}
	
	public String getBairro() {
		return bairro;
	}
	
	@Override
	public void setBairro(String bairro){
		this.bairro = bairro;
	}
	
	public String getCep() {
		return cep;
	}
	
	@Override
	public void setCep(String cep){
		this.cep = cep;
	}
	
	public String getCidade() {
		return cidade;
	}
	
	@Override
	public void setCidade(String cidade){
		this.cidade = cidade;
	}
	
	public String getComplemento() {
		return complemento;
	}
	
	@Override
	public void setComplemento(String complemento){
		this.complemento = complemento;
	}
	
	public String getLogradouro() {
		return logradouro;
	}
	
	@Override
	public void setLogradouro(String logradouro){
		this.logradouro = logradouro;
	}
	
	public String getUf() {
		return uf;
	}
	
	@Override
	public void setUf(String uf){
		this.uf = uf;
	}
	
}