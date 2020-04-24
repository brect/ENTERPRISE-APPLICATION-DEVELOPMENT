package br.com.fiap.jpa.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="TB_VEICULO")
@SequenceGenerator(name="veiculo", sequenceName = "SQ_TB_VEICULO", allocationSize = 1)
public class Veiculo {

	@Id
	@Column(name="cd_veiculo")
	@GeneratedValue(generator = "veiculo", strategy = GenerationType.SEQUENCE)
	private int codigo;
	
	@Column(name="ds_modelo", nullable = false, length = 60)
	private String modelo;
	
	@Column(name="nr_chassi", length = 30)
	private String chassi;
	
	@Enumerated(EnumType.STRING)
	@Column(name="ds_combustivel")
	private Combustivel combustivel;
	
	@ManyToMany(mappedBy = "veiculos")
	private List<Locacao> locacoes;
	
	public Veiculo(String modelo, String chassi, Combustivel combustivel) {
		super();
		this.modelo = modelo;
		this.chassi = chassi;
		this.combustivel = combustivel;
	}

	public Veiculo() {
		super();
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getChassi() {
		return chassi;
	}

	public void setChassi(String chassi) {
		this.chassi = chassi;
	}

	public Combustivel getCombustive() {
		return combustivel;
	}

	public void setCombustive(Combustivel combustivel) {
		this.combustivel = combustivel;
	}

	public List<Locacao> getLocacoes() {
		return locacoes;
	}

	public void setLocacoes(List<Locacao> locacoes) {
		this.locacoes = locacoes;
	}

	
	
}
