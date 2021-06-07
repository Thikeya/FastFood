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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ingrediente == null) ? 0 : ingrediente.hashCode());
		result = prime * result + ((produto == null) ? 0 : produto.hashCode());
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
		Ing_Prod other = (Ing_Prod) obj;
		if (ingrediente == null) {
			if (other.ingrediente != null)
				return false;
		} else if (!ingrediente.equals(other.ingrediente))
			return false;
		if (produto == null) {
			if (other.produto != null)
				return false;
		} else if (!produto.equals(other.produto))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Ing_Prod [qtdeIng=" + qtdeIng + ", produto=" + produto + ", ingrediente=" + ingrediente + "]";
	}

	public Ing_Prod() {
	}
	
}
