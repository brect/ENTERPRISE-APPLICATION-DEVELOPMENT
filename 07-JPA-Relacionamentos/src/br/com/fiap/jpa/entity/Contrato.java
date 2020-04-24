package br.com.fiap.jpa.entity;

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
@Table(name="TB_CONTRATO")
@SequenceGenerator(name="contrato", sequenceName = "SQ_TB_CONTRATO", allocationSize = 1)
public class Contrato {

	@Id
	@Column(name="cd_contrato")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "contrato")
	private int codigo;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dt_inicio", nullable = false)
	private Calendar dataInicio;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dt_termino", nullable = false)
	private Calendar dataFim;
	
	//Mapear o relacionamento um-para-um 
	//cascade -> reflete as ações (Cadastro, Atualização e remoção) no relacionamento
	//fetch -> determina o momento que a relação será carregada
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name="cd_locacao", nullable = false, unique = true)
	private Locacao locacao;
	
	public Contrato(Calendar dataInicio, Calendar dataFim, Locacao locacao) {
		super();
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
		this.locacao = locacao;
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

	public Calendar getDataFim() {
		return dataFim;
	}

	public void setDataFim(Calendar dataFim) {
		this.dataFim = dataFim;
	}

	public Locacao getLocacao() {
		return locacao;
	}

	public void setLocacao(Locacao locacao) {
		this.locacao = locacao;
	}
	
}
