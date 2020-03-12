package br.com.fiap.bean;

import java.util.Calendar;

import br.com.fiap.exception.SaldoInsuficienteException;

public class ContaPoupanca extends Conta implements ContaInvestimento {

	private float taxa;
	
	public static final float RENDIMENTO = 0.02f;
	
	public ContaPoupanca() {}

	public ContaPoupanca(int agencia, int numero, Calendar dataAbertura, double saldo, float taxa) {
		super(agencia, numero, dataAbertura, saldo);
		this.taxa = taxa;
	}

	@Override
	public double calculaRetornoInvestimento() {
		return RENDIMENTO * saldo;
	}

	@Override
	public void retirar(double valor) throws Exception {
		if (saldo > valor + taxa) {
			saldo -= valor + taxa;
		}else {
			throw new SaldoInsuficienteException("Saldo insuficiente");
		}
	}

	public float getTaxa() {
		return taxa;
	}

	public void setTaxa(float taxa) {
		this.taxa = taxa;
	}

}
