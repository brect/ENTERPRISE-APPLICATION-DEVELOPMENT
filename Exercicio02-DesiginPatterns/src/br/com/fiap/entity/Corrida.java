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

@Entity
@Table(name = "TB_CORRIDA")
@SequenceGenerator(name = "corrida", sequenceName = "SQ_TB_CORRIDA", allocationSize = 1)
public class Corrida {
	
	@Id
	@Column(name = "cd_corrida", nullable = false)
	@GeneratedValue(generator = "corrida", strategy = GenerationType.SEQUENCE)
	private int id;
	
	@Column(name = "ds_origem", length = 150)
	private String origem;
	
	@Column(name = "ds_destino", length = 150)
	private String destino;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "dt_corrida")
	private Calendar data;
	
	@Column(name = "vl_corrida", nullable = false)
	private double corrida;
}
