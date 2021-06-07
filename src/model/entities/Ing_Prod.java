package model.entities;

public class Ing_Prod {
	private int qtdeIng;
	
	private Produto produto;
	private Ingrediente ingrediente;
	
	public int getQtdeIng() {
		return qtdeIng;
	}

	public void setQtdeIng(int qtdeIng) {
		this.qtdeIng = qtdeIng;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Ingrediente getIngrediente() {
		return ingrediente;
	}

	public void setIngrediente(Ingrediente ingrediente) {
		this.ingrediente = ingrediente;
	}

	@Override
	public String toString() {
		return "Ing_Prod [qtdeIng=" + qtdeIng + ", produto=" + produto.getProduto_id() + ", ingrediente=" + ingrediente.getIngrediente_id() + "]";
	}

	public Ing_Prod() {
	}
	
}
