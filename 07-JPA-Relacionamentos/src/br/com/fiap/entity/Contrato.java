package br.com.fiap.entity;

import java.util.Calendar;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name = "TB_CONTRATO")
@SequenceGenerator(name="contrato", sequenceName = "SQ_TB_CONTRATO", allocationSize=1)
public class Contrato {

	@Id
	@Column(name = "cd_contrato", nullable = false)
	@GeneratedValue(generator = "contrato", strategy = GenerationType.SEQUENCE)
	private int id;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "cd_locacao", nullable = false, unique = true)
	private Locacao locacao;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "", nullable = false)
	private Calendar dataInicio;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "", nullable = false)
	private Calendar dataFim;
	
	public Contrato() {
		super();
	}

	public Contrato(Locacao locacao, Calendar dataInicio, Calendar dataFim) {
		super();
		this.locacao = locacao;
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Locacao getLocacao() {
		return locacao;
	}

	public void setLocacao(Locacao locacao) {
		this.locacao = locacao;
	}

	public Calendar getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Calendar dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Calendar getDataFim() {
		return dataFim;
	}

	public void setDataFim(Calendar dataFim) {
		this.dataFim = dataFim;
	}
	
}
