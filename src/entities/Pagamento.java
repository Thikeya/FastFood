package entities;

public class Pagamento {
	
	private double pagamentoAutorizado;
	private String tipoDePag;

	public Pagamento() {
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
