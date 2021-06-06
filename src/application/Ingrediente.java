package application;

import java.sql.Date;

public class Ingrediente {
	private int codigo;
	private String nome;
	private String unidadeMedida;
	private Date validade;
	private double valorPorcao;
	private int qtdeEstoque;
	
	public Ingrediente() {
		
	}
	
	public void adicionarProduto() {
		
	}
	
	public void removerProduto() {
		
	}
	
	public void buscarIngrediente() {
		
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getUnidadeMedida() {
		return unidadeMedida;
	}

	public void setUnidadeMedida(String unidadeMedida) {
		this.unidadeMedida = unidadeMedida;
	}

	public Date getValidade() {
		return validade;
	}

	public void setValidade(Date validade) {
		this.validade = validade;
	}

	public double getValorPorcao() {
		return valorPorcao;
	}

	public void setValorPorcao(double valorPorcao) {
		this.valorPorcao = valorPorcao;
	}

	public int getQtdeEstoque() {
		return qtdeEstoque;
	}

	public void setQtdeEstoque(int qtdeEstoque) {
		this.qtdeEstoque = qtdeEstoque;
	}
	
}
