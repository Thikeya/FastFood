package model.entities;

public class Item_Pedido {
	private int item_pedido_id;
	private int qtdeProdutos;
	private int qtdeIngredientes;
	
	public int getItem_pedido_id() {
		return item_pedido_id;
	}

	public void setItem_pedido_id(int item_pedido_id) {
		this.item_pedido_id = item_pedido_id;
	}

	public int getQtdeProdutos() {
		return qtdeProdutos;
	}

	public void setQtdeProdutos(int qtdeProdutos) {
		this.qtdeProdutos = qtdeProdutos;
	}

	public int getQtdeIngredientes() {
		return qtdeIngredientes;
	}

	public void setQtdeIngredientes(int qtdeIngredientes) {
		this.qtdeIngredientes = qtdeIngredientes;
	}
}
