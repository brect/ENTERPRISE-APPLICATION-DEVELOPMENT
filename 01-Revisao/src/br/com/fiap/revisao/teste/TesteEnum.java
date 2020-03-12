package br.com.fiap.revisao.teste;

import br.com.fiap.revisao.bean.Carro;
import br.com.fiap.revisao.bean.Combustivel;

public class TesteEnum {

	public static void main(String[] args) {
		Carro carro = new Carro(2);
		//Atribuir o combustivel para o carro (Enum)
		carro.setCombustivel(Combustivel.FLEX);
		
		//Validar se o carro é flex
		if (carro.getCombustivel() == Combustivel.FLEX) {
			System.out.println("Carro flex");
		}
	}
	
}





