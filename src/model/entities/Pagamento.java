package model.entities;

public class Pagamento {
	private int pagamento_id;
	private String pagamentoAutorizado;
	private String tipoDePag;
	private Pedido pedido;
	
	public Pagamento() {
	}

	
	public int getPagamento_id() {
		return pagamento_id;
	}

	public void setPagamento_id(int pagamento_id) {
		this.pagamento_id = pagamento_id;
	}


	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}


	public void setTipoDePag(String tipoDePag) {
		this.tipoDePag = tipoDePag;
	}

	public String getPagamentoAutorizado() {
		return pagamentoAutorizado;
	}


	public void setPagamentoAutorizado(String pagamentoAutorizado) {
		this.pagamentoAutorizado = pagamentoAutorizado;
	}


	public String getTipoDePag() {
		return tipoDePag;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + pagamento_id;
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
		Pagamento other = (Pagamento) obj;
		if (pagamento_id != other.pagamento_id)
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Pagamento [pagamento_id=" + pagamento_id + ", pagamentoAutorizado=" + pagamentoAutorizado
				+ ", tipoDePag=" + tipoDePag + ", codigo do pedido=" + pedido.getPedido_id() + "]";
	}
	
	
}
