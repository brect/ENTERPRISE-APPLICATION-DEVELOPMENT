package br.com.fiap.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "TB_PAGAMENTO")
@SequenceGenerator(name = "pagamento", sequenceName = "SQ_TB_PAGAMENTO", allocationSize = 1)
public class Pagamento {

	@Id
	@Column(name = "cd_pagamento", nullable = false)
	@GeneratedValue(generator = "pagamento", strategy = GenerationType.SEQUENCE)
	private int id;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dt_pagamento", nullable = false)
	private Calendar data;
	
	@Column(name = "vl_pagamento", nullable = false)
	private double pagamento;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "ds_forma_pagamento", nullable = false)
	private FormaPagamento formaPagamento;

	public Pagamento() {
		super();
	}

	public Pagamento(Calendar data, double pagamento, FormaPagamento formaPagamento) {
		super();
		this.data = data;
		this.pagamento = pagamento;
		this.formaPagamento = formaPagamento;
	}
	

}
