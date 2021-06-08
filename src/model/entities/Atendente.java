package model.entities;

import java.util.Scanner;

public class Atendente {
	Scanner sc = new Scanner(System.in);
	private Integer atendente_id;
	private String turno;
	private String status;
	private String login;
	private String senha;
	private String nome;
	
	public String getNome() {
		return nome;
	}
	
	public int listarAtendenteOpcoes() {
		System.out.println("1- adicionar pedido");
		System.out.println("2- alterar status do pedido");
		System.out.println("3- sair do sistema");
		int escolha = sc.nextInt();
		return escolha;
	}
	
	public boolean verificarAdmin(String login, String senha) {
		if(login.equals("admin")) {
			if(senha.equals("admin")) {
				return true;
			}
		}
		return false;
	}
	
	public void listarAdminOpcoes() {
		System.out.println("1- cadastrar um atendente");
		System.out.println("2- cadastrar uma categoria");
		System.out.println("3- cadastrar um ingrediente");
		System.out.println("4- cadastrar um produto");
		System.out.println("5- cadastrar uma promocao");
		System.out.println("6- cadastrar uma categoria");
		System.out.println("7- vincular produto <-> ingrediente");
		System.out.println("8- atualizar um atendente");
		System.out.println("9- atualizar uma categoria");
		System.out.println("10- atualizar um ingrediente");
		System.out.println("11- atualizar um produto");
		System.out.println("12- atualizar uma promocao");
		System.out.println("13- atualizar uma categoria");
		System.out.println("14- atualzar produto <-> ingrediente");
		
		int escolha = sc.nextInt();
		switch(escolha) {
		case 1:
			break;
		case 2:
			break;
		case 3:
			break;
		case 4:
			break;
		case 5:
			break;
		case 6:
			break;
		case 7:
			break;
		case 8:
			break;
		case 9:
			break;
		case 10:
			break;
		case 11:
			break;
		case 12:
			break;
		case 13:
			break;
		case 14:
			break;
		default:
			break;
		}
	}
	
	public Atendente(Integer atendente_id, String turno, String status, String login, String senha, String nome) {
		this.atendente_id = atendente_id;
		this.turno = turno;
		this.status = status;
		this.login = login;
		this.senha = senha;
		this.nome = nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getAtendente_id() {
		return atendente_id;
	}

	public void setAtendente_id(int atendente_id) {
		this.atendente_id = atendente_id;
	}

	public String getTurno() {
		return turno;
	}

	public void setTurno(String turno) {
		this.turno = turno;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + atendente_id;
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
		Atendente other = (Atendente) obj;
		if (atendente_id != other.atendente_id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Atendente [atendente_id=" + atendente_id + ", nome=" + nome + ", turno=" + turno + ", status=" + status
				+ "]";
	}

	public Atendente() {
		
	}
}
