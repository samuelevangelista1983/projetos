package br.eti.sen.utilitarios.documento;

import br.eti.sen.utilitarios.texto.StringUtil;

public class CPF {
	
	private static final int[] peso = { 11, 10, 9, 8, 7, 6, 5, 4, 3, 2 };
	
	// MÉTODOS PRIVADOS
	
	private static int calcularDigito(String str) {
		int soma = 0;
		
		for (int indice = str.length() - 1, digito; indice >= 0; indice--) {
			digito = Integer.parseInt(str.substring(indice, indice + 1));
			soma += digito * peso[peso.length - str.length() + indice];
		}
		
		soma = 11 - soma % 11;
		return soma > 9 ? 0 : soma;
	}
	
	// MÉTODOS PÚBLICOS
	
	public static boolean validar(String cpfInformado) {
		boolean valido = false;
		
		if (StringUtil.stringNaoNulaENaoVazia(cpfInformado)) {
			String cpf = cpfInformado.replace(".", "");
			cpf = cpf.replace("-", "");
			
			if (cpf.length() == 11 && StringUtil.valorNumerico(cpf) && !cpf.equals("00000000000") && !cpf.equals("99999999999")) {
				Integer digito1 = calcularDigito(cpf.substring(0, 9));
				Integer digito2 = calcularDigito(cpf.substring(0, 9) + digito1);
				valido = cpf.equals(cpf.substring(0, 9) + digito1.toString() + digito2.toString());
			}
		}
		
		return valido;
	}

}
