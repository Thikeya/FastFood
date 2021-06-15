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
		if(item_pedido.getIngrediente() != null) {
			return "\n" +  "Código item_pedido:" + item_pedido.getItem_pedido_id() 
			+ ", Nome:" + item_pedido.getIngrediente().getNome()
			+ ", Quantidade adicionada:" + item_pedido.getQtdeIngredientes() + "\n";
		}else if(item_pedido.getProduto() != null) {
			return "\n" +  "Código item_pedido:" + item_pedido.getItem_pedido_id() 
			+ ", Nome:" + item_pedido.getProduto().getNome()
			+ ", Quantidade adicionada:" + item_pedido.getQtdeProdutos() + "\n";
		}else {
			return null;
		}
		
	}
	
	public Pedido_Item() {
	}
	
}
