package br.com.fiap.jpa.entity;

import java.util.Calendar;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="TB_CONTRATO")
@SequenceGenerator(name="contrato", sequenceName = "SQ_TB_CONTRATO", allocationSize = 1)
public class Contrato {

	@Id
	@Column(name="cd_contrato")
	@GeneratedValue(generator = "contrato", strategy = GenerationType.SEQUENCE)
	private int codigo;
	
	@Temporal(TemporalType.DATE)
	@Column(name="dt_inicio", nullable = false)
	private Calendar dataInicio;
	
	@Column(name="vl_contrato", nullable = false)
	private float valor;
	
	@OneToOne(mappedBy = "contrato", cascade = CascadeType.PERSIST)
	private Dependente dependente;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name="cd_plano", nullable = false)
	private Plano plano;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name="cd_cliente", nullable = false)
	private Cliente cliente;
	
	public Contrato(Calendar dataInicio, float valor, Dependente dependente, Plano plano, Cliente cliente) {
		super();
		this.dataInicio = dataInicio;
		this.valor = valor;
		this.dependente = dependente;
		this.plano = plano;
		this.cliente = cliente;
	}

	public Contrato() {
		super();
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Calendar getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Calendar dataInicio) {
		this.dataInicio = dataInicio;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	public Dependente getDependente() {
		return dependente;
	}

	public void setDependente(Dependente dependente) {
		this.dependente = dependente;
	}

	public Plano getPlano() {
		return plano;
	}

	public void setPlano(Plano plano) {
		this.plano = plano;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	
}
