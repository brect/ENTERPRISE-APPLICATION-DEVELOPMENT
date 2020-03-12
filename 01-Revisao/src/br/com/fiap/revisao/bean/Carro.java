package br.com.fiap.revisao.bean;

public class Carro extends Automovel {

	/*
	 * private(só a classe), public(todos), protected(pacote e filhas), 
	 * default/package (pacote)
	 * */
	
	private String placa;
	
	private double largura;
	
	//Construtor que chama o construtor do pai
	public Carro(float potencia) {
		super(potencia);
	}
	
	//sobrescrita (métodos com a mesma assinatura no pai e filho)
	@Override
	public void acelerar(double velocidade) {
		System.out.println("Carro acelerando");
	}
	
	//sobrecarga - overload (métodos com mesmo nome e parametros diferentes)
	public void acelerar(double velocidade, int marcha) {
		
	}
	
	public void setPlaca(String placa) {
		this.placa = placa;				
	}
	
	public String getPlaca() {
		return this.placa;
	}

	public double getLargura() {
		return largura;
	}

	public void setLargura(double largura) {
		this.largura = largura;
	}

	@Override
	public void locomover() {
				
	}
	
}


