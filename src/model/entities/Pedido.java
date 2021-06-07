package model.entities;

import java.sql.Date;

public class Pedido {
	private int pedido_id;
	private  Date horarioPedido;
	private String descricao;
	private String statusPedido;
	private Atendente atendente;
	private Item_Pedido item_pedido;
	
	public Atendente getAtendente() {
		return atendente;
	}

	public void setAtendente(Atendente atendente) {
		this.atendente = atendente;
	}

	public Item_Pedido getItem_pedido() {
		return item_pedido;
	}

	public void setItem_pedido(Item_Pedido item_pedido) {
		this.item_pedido = item_pedido;
	}

	public int getPedido_id() {
		return pedido_id;
	}
	
	public void setPedido_id(int pedido_id) {
		this.pedido_id = pedido_id;
	}
	
	public Date getHorarioPedido() {
		return horarioPedido;
	}
	
	public void setHorarioPedido(Date horarioPedido) {
		this.horarioPedido = horarioPedido;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public String getStatusPedido() {
		return statusPedido;
	}
	
	public void setStatusPedido(String statusPedido) {
		this.statusPedido = statusPedido;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + pedido_id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pedido other = (Pedido) obj;
		if (pedido_id != other.pedido_id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Pedido [pedido_id=" + pedido_id + ", horarioPedido=" + horarioPedido + ", statusPedido=" + statusPedido
				+ "]";
	}

	public Pedido() {
		
	}
}
