package br.com.fiap.revisao.teste;

import br.com.fiap.revisao.bean.Automovel;
import br.com.fiap.revisao.bean.Carro;

public class TesteMetodos {

	public static void main(String[] args) {
		
//		Automovel a = new Automovel(2);
//		a.acelerar(10); //método do automovel
		
		Carro c = new Carro(2);
		c.acelerar(10); //método do carro
		
		//Carro c1 = new Automovel(); não é possível
		
//		Automovel a1 = new Carro(2);
//		a1.acelerar(5); //método carro		
	}
	
}



