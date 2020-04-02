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
@Table(name = "TB_PASSAGEIRO")
@SequenceGenerator(name = "passageiro", sequenceName = "SQ_TB_PASSAGEIRO", allocationSize = 1)
public class Passageiro {

	@Id
	@Column(name = "cd_passageiro", nullable = false)
	@GeneratedValue(generator = "passageiro", strategy = GenerationType.SEQUENCE)
	private int id;
	
	@Column(name = "nm_passageiro", nullable = false, length = 150)
	private String nome;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "dt_nascimento", nullable = false)
	private Calendar nascimento;
	
	@Column(name = "ds_genero", nullable = false)
	@Enumerated(EnumType.STRING)
	private Enum genero;
}
