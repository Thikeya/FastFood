package model.entities;

public class Pedido {
	private int pedido_id;
	private String horarioPedido;
	private String descricao;
	private String statusPedido;
	private int valor;
	
	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	private Atendente atendente;
	
	public Atendente getAtendente() {
		return atendente;
	}

	public void setAtendente(Atendente atendente) {
		this.atendente = atendente;
	}

	public int getPedido_id() {
		return pedido_id;
	}
	
	public void setPedido_id(int pedido_id) {
		this.pedido_id = pedido_id;
	}
	
	public String getHorarioPedido() {
		return horarioPedido;
	}

	public void setHorarioPedido(String horarioPedido) {
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
		return "Pedido [pedido id=" + pedido_id + ", horario do Pedido=" + horarioPedido + ", descricao=" + descricao
				+ ", status do Pedido=" + statusPedido + ", codigo do atendente=" + atendente.getAtendente_id() + "]";
	}

	public Pedido() {
		
	}
}
