package br.com.fiap.revisao.bean;

//Classe abstrata -> n�o pode ser instanciada,
//pode conter m�todos abstratos (n�o tem conte�do)
public abstract class Automovel {
	
	private float potencia;
	
	private Combustivel combustivel;
	
	//construtor
	public Automovel(float potencia) {
		this.potencia = potencia;
	}
	
	//m�todo abstrato
	public abstract void locomover();
	
	public void acelerar(double velocidade) {
		System.out.println("Autom�vel acelerando");
	}

	public float getPotencia() {
		return potencia;
	}

	public void setPotencia(float potencia) {
		this.potencia = potencia;
	}

	public Combustivel getCombustivel() {
		return combustivel;
	}

	public void setCombustivel(Combustivel combustivel) {
		this.combustivel = combustivel;
	}
	
}