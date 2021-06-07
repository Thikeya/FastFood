package model.entities;

public class Pedido_Item {
	private Pedido pedido_id;
	private Item_Pedido item_pedido_id;
	
	public Pedido getPedido_id() {
		return pedido_id;
	}
	public void setPedido_id(Pedido pedido_id) {
		this.pedido_id = pedido_id;
	}
	public Item_Pedido getItem_pedido_id() {
		return item_pedido_id;
	}
	public void setItem_pedido_id(Item_Pedido item_pedido_id) {
		this.item_pedido_id = item_pedido_id;
	}
	
	@Override
	public String toString() {
		return "Pedido_Item [pedido_id=" + pedido_id + ", item_pedido_id=" + item_pedido_id + "]";
	}
	public Pedido_Item() {
	}
	
}
