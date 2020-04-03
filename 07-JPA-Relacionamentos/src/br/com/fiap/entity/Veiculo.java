package br.com.fiap.entity;

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
@Table(name = "TB_VEICULO")
@SequenceGenerator(name="veiculo", sequenceName = "SQ_TB_VEICULO", allocationSize=1)
public class Veiculo {

	@Id
	@Column(name = "cd_veiculo", nullable = false)
	@GeneratedValue(generator = "veiculo", strategy = GenerationType.SEQUENCE)
	private int id;
	
	@Column(name = "ds_modelo", nullable = false, length = 60)
	private String modelo;
	
	@Column(name = "nr_chassi", nullable = false, length = 30)
	private String chassi;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "ds_combustivel")
	private Combustivel combustivel;
	
	
	
	
}
