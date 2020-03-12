package br.com.fiap.teste;

import br.com.fiap.entity.Aluno;
import br.com.fiap.entity.Carro;
import br.com.fiap.orm.Orm;

public class Exercicio {

	public static void main(String[] args) {
		//Instanciar as classes carro e aluno
		Carro carro = new Carro();
		Aluno aluno = new Aluno();

		//Instanciar a classe Orm
		Orm orm = new Orm();
		
		//Chamar o método de gerar sql e exibir o resultado
		System.out.println(orm.gerarPesquisa(aluno));
		System.out.println(orm.gerarPesquisa(carro));
		
	}
	
}




