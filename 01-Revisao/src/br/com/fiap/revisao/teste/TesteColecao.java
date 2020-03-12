package br.com.fiap.revisao.teste;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.fiap.revisao.bean.Carro;

public class TesteColecao {

	public static void main(String[] args) {
		//Criar uma lista de carro
		List<Carro> carros = new ArrayList<Carro>();
		carros.add(new Carro(2));
		carros.add(new Carro(5));
		
		//Exibir a pontecia dos carros
		for (Carro c : carros) {
			System.out.println(c.getPotencia());
		}
		
		for (int x = 0; x < carros.size(); x++) {
			System.out.println(carros.get(x).getPotencia());
		}
		
		//Mapa<Chave,Valor>
		Map<String, Carro> mapa = new HashMap<String, Carro>();
		mapa.put("gol", new Carro(2));
		
		//Recuperar o carro do mapa
		Carro c = mapa.get("gol");
		System.out.println(c.getPotencia());
		
	}
	
}





