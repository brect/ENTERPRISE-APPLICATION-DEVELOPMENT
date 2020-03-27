package br.com.fiap.entity;
/*

 * TB_PEDIDO
 *  *cd_pedido NUMBER PK
 * *ds_produto VARCHAR(50)
 *   *vl_total FLOAT
 *   *qt_item NUMBER
 *   *dt_pedido DATE
 */

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity()
@Table(name="TB_PEDIDO")
@SequenceGenerator(name = "pedido", sequenceName = "SQ_TB_PEDIDO", allocationSize = 1)
public class Pedido {

	@Id
	@Column(name = "cd_pedido")
	@GeneratedValue(generator = "pedido", strategy = GenerationType.SEQUENCE)
	private int codigo;
	
	@Column(name = "ds_produto", nullable = false, length = 50)
	private String produto;
	
	@Column(name = "vl_total", nullable = false)
	private double valorTotal;
	
	@Column(name = "qt_item", nullable = false)
	private int quantidadeItens;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dt_pedido", nullable = false)
	private Calendar data;

	public Pedido() {
		super();
	}

	public Pedido(String produto, double valorTotal, int quantidadeItens, Calendar data) {
		super();
		this.produto = produto;
		this.valorTotal = valorTotal;
		this.quantidadeItens = quantidadeItens;
		this.data = data;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getProduto() {
		return produto;
	}

	public void setProduto(String produto) {
		this.produto = produto;
	}

	public double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public int getQuantidadeItens() {
		return quantidadeItens;
	}

	public void setQuantidadeItens(int quantidadeItens) {
		this.quantidadeItens = quantidadeItens;
	}

	public Calendar getData() {
		return data;
	}

	public void setData(Calendar data) {
		this.data = data;
	}
}
