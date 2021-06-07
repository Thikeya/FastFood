package entities;

import java.sql.Date;

public class Promocao {
	private int promocao_id;
	private String tipo;
	private Date duracao;
	private String descriacao;
	private double preco;
	
	public int getPromocao_id() {
		return promocao_id;
	}
	
	public void setPromocao_id(int promocao_id) {
		this.promocao_id = promocao_id;
	}
	
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
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + promocao_id;
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
		Promocao other = (Promocao) obj;
		if (promocao_id != other.promocao_id)
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Promocao [promocao_id=" + promocao_id + ", tipo=" + tipo + ", duracao=" + duracao + ", descriacao="
				+ descriacao + ", preco=" + preco + "]";
	}
	
	public Promocao() {
		
	}
	
	
}
