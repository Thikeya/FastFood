package model.entities;

public class Pagamento {
	private int pagamento_id;
	private double pagamentoAutorizado;
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


	public double getPagamentoAutorizado() {
		return pagamentoAutorizado;
	}

	public void setPagamentoAutorizado(double pagamentoAutorizado) {
		this.pagamentoAutorizado = pagamentoAutorizado;
	}

	public String getTipoDePag() {
		return tipoDePag;
	}

	public void setTipoDepag(String tipoDepag) {
		if (tipoDepag.equals("Cartão") || tipoDepag.equals("QrCode") )
			this.tipoDePag = tipoDepag;
		else 
			System.out.println("tipo inválido");
	}
	
	public boolean pagComCartao() {
		if (this.getTipoDePag().equals("Cartão"))
			return true;
		else 
		return false;
	}
	
	public boolean pagComQrCode() {
		if (this.getTipoDePag().equals("QrCode"))
			return true;
		else 
		return false;
	}
}
