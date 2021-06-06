package entities;

import java.sql.Date;
//implementar
//implementar regras nos setters and getters
public class Produto {
	
	private int codigo;
	private String name;
	private double valor;
	private String descricao;
	private Date dataProducao;
	private int qtdeEstoque;
	
	
	public void adicionarProd(int coding) {
		
	}
	
	public void removeringProd(int coding) {
		
	}
	public Promocao adicionarPromo(String duracao, Date duaracao, String descricao, double preco) {
		return null;
		
	}
	
	public void removerPromo(int idPromo) {
		
	}
	
	public void adicionarPrduto() {
		
	}
	
	public void removeProduto() {
		
	}
	
	public void buscarProduto() {
		
	}
	
	public void buscarPromocao() {
		
	}
	
	public Produto[] buscarProdutos(int idCategoria) {
		return null;
		
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getDataProducao() {
		return dataProducao;
	}

	public void setDataProducao(Date dataProducao) {
		this.dataProducao = dataProducao;
	}

	public int getQtdeEstoque() {
		return qtdeEstoque;
	}

	public void setQtdeEstoque(int qtdeEstoque) {
		this.qtdeEstoque = qtdeEstoque;
	}
}
