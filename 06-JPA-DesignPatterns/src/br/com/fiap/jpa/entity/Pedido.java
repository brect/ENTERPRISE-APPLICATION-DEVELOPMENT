package br.com.fiap.jpa.entity;

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

/*
 * TB_PEDIDO
 * 	 *cd_pedido NUMBER PK
 *	 *ds_produto VARCHAR(50)
 *   *vl_total FLOAT
 *   *qt_item NUMBER
 *   *dt_pedido DATE
 *   
 *   
 * TB_ENTREGA
 * 	*cd_entrega NUMBER PK
 *  *dt_entrega DATETIME
 *  *ds_responsavel VARCHAR(50)
 *  *ds_status VARCHAR (Enum no Java)
 *     
 *   Códigos gerado por sequences SQ_TB_PEDIDO e SQ_TB_ENTREGA
 */
@Entity
@Table(name="TB_PEDIDO")
@SequenceGenerator(name="pedido", sequenceName = "SQ_TB_PEDIDO", allocationSize = 1)
public class Pedido {

	@Id
	@Column(name="cd_pedido")
	@GeneratedValue(generator = "pedido", strategy = GenerationType.SEQUENCE)
	private int codigo;
	
	@Column(name="ds_produto", nullable = false, length = 50)
	private String produto;
	
	@Column(name="vl_total", nullable = false )
	private double valorTotal;
	
	@Column(name="qt_item", nullable = false)
	private int quantidadeItem;
	
	@Temporal(TemporalType.TIMESTAMP) //Data e hora
	@Column(name="dt_pedido", nullable = false)
	private Calendar data;
	
	public Pedido() {
		super();
	}

	public Pedido(String produto, double valorTotal, int quantidadeItem, Calendar data) {
		super();
		this.produto = produto;
		this.valorTotal = valorTotal;
		this.quantidadeItem = quantidadeItem;
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

	public int getQuantidadeItem() {
		return quantidadeItem;
	}

	public void setQuantidadeItem(int quantidadeItem) {
		this.quantidadeItem = quantidadeItem;
	}

	public Calendar getData() {
		return data;
	}

	public void setData(Calendar data) {
		this.data = data;
	}
	
	
	
}
