package model.entities;

public class Pedido_Item {
	private Pedido pedido;
	private Item_Pedido item_pedido;
	
	public Pedido getPedido() {
		return pedido;
	}
	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
	public Item_Pedido getItem_pedido() {
		return item_pedido;
	}
	public void setItem_pedido(Item_Pedido item_pedido) {
		this.item_pedido = item_pedido;
	}
	@Override
	public String toString() {
		return "Pedido_Item [codigo do pedido=" + pedido.getPedido_id()+ ", codigo do item_pedido=" + item_pedido.getItem_pedido_id() + "]";
	}
	public Pedido_Item() {
	}
	
}
