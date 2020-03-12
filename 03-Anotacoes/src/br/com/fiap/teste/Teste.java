package br.com.fiap.teste;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import br.com.fiap.anotacao.Coluna;
import br.com.fiap.entity.Carro;

public class Teste {

	public static void main(String[] args) {
		//Instanciar uma classe Carro
		Carro carro = new Carro();
		
		//Recuperar os atributos do carro
		Field[] atributos = carro.getClass().getDeclaredFields();
		//Exibir o nome dos atributos
		for (Field f : atributos) {
			//Recuperar as configurações da anotação @Coluna
			Coluna anotacao = f.getAnnotation(Coluna.class);
			System.out.println(f.getName() + " - " 
					+ anotacao.nome() + " - " + anotacao.obrigatorio());
		}
		
		//Recuperar os métodos do carro
		Method[] metodos = carro.getClass().getDeclaredMethods();
		//Exibir o nome dos métodos
		for (Method m : metodos) {
			System.out.println(m.getName());
		}
		
	}
	
}



