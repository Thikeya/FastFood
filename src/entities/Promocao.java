package entities;

import java.sql.Date;

public class Promocao {
	private String tipo;
	private Date duracao;
	private String descriacao;
	private double preco;
	private int idPromo;
	
	

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Date getDuracao() {
		return duracao;
	}

	public void setDuracao(Date duracao) {
		this.duracao = duracao;
	}

	public String getDescriacao() {
		return descriacao;
	}

	public void setDescriacao(String descriacao) {
		this.descriacao = descriacao;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public int getIdPromo() {
		return idPromo;
	}

	public void setIdPromo(int idPromo) {
		this.idPromo = idPromo;
	}

}
