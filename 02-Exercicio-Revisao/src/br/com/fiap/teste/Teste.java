package br.com.fiap.teste;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import br.com.fiap.bean.Conta;
import br.com.fiap.bean.ContaCorrente;
import br.com.fiap.bean.ContaPoupanca;
import br.com.fiap.bean.TipoConta;
import br.com.fiap.exception.SaldoInsuficienteException;

public class Teste {

	public static void main(String[] args) {
		
		//Instanciar as contas corrente e poupança
		ContaCorrente cc = new ContaCorrente(1, 2, 
				Calendar.getInstance(), 100, TipoConta.COMUM);
		
		ContaPoupanca cp = new ContaPoupanca(1, 21, 
				new GregorianCalendar(2019, Calendar.FEBRUARY, 20), 500, 1);
		
		//Criar uma lista de conta
		List<Conta> contas = new ArrayList<Conta>();
		//Adicionar 3 contas
		contas.add(cc);
		contas.add(cp);
		contas.add(new ContaPoupanca(1, 4, Calendar.getInstance(), 150, 1));
		
		//Exibir o saldo das contas da lista
		for (Conta c : contas) {
			System.out.println(c.getSaldo());
		}	
		
		//Retirar 
		try {
			cc.retirar(1000);
		} catch (SaldoInsuficienteException e) {
			System.err.println(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}





