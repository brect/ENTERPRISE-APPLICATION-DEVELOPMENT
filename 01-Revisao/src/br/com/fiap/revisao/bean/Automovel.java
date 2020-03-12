package br.com.fiap.revisao.bean;

//Classe abstrata -> não pode ser instanciada,
//pode conter métodos abstratos (não tem conteúdo)
public abstract class Automovel {
	
	private float potencia;
	
	private Combustivel combustivel;
	
	//construtor
	public Automovel(float potencia) {
		this.potencia = potencia;
	}
	
	//método abstrato
	public abstract void locomover();
	
	public void acelerar(double velocidade) {
		System.out.println("Automóvel acelerando");
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