package br.com.fiap.bean;

import java.util.Calendar;

/**
 * classe abstrata -> não pode ser instanciada e pode conter
 * métodos abstratos (sem implementação)
 */
public abstract class Conta {

	private int agencia;
	private int numero;
	private Calendar dataAbertura;
	protected double saldo; //as filhas tem acesso e as classes do pacote
	
	public Conta(int agencia, int numero, Calendar dataAbertura, double saldo) {
		this.agencia = agencia;
		this.numero = numero;
		this.dataAbertura = dataAbertura;
		this.saldo = saldo;
	}
	
	public Conta() {}
	
	public abstract void retirar(double valor) throws Exception;
	
	public void depositar(double valor) {
		saldo += valor;
	}
	
	public int getAgencia() {
		return agencia;
	}
	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public Calendar getDataAbertura() {
		return dataAbertura;
	}
	public void setDataAbertura(Calendar dataAbertura) {
		this.dataAbertura = dataAbertura;
	}
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
}