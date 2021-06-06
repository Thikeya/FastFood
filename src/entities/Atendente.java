package entities;

public class Atendente {
	private int atendente_id;
	private String turno;
	private String status;
	private String login;
	private String senha;
	
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
		return "Atendente [atendente_id=" + atendente_id + ", turno=" + turno + ", status=" + status + "]";
	}
	

	public Atendente() {
		
	}
}
