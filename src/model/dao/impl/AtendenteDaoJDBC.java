package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import db.DB;
import db.DbException;
import model.dao.AtendenteDao;
import model.entities.Atendente;

public class AtendenteDaoJDBC implements AtendenteDao {
	
	private Connection conn;
	
	public AtendenteDaoJDBC(Connection conn) {
		this.conn = conn;
	}
	
	@Override
	public void insert(Atendente obj) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(
					"INSERT INTO atendente "
					+ "(status, turno, senha, login, nome) "
					+ "VALUES "
					+ "(?, ?, ?, ?, ?)",
					Statement.RETURN_GENERATED_KEYS);
			
			st.setString(1, obj.getStatus());
			st.setString(2, obj.getTurno());
			st.setString(3, obj.getSenha());
			st.setString(4, obj.getLogin());
			st.setString(5, obj.getNome());
			
			int rowsAffected = st.executeUpdate();
			
			if (rowsAffected > 0) {
				ResultSet rs = st.getGeneratedKeys();
				if (rs.next()) {
					int id = rs.getInt(1);
					obj.setAtendente_id(id);
				}
				DB.closeResultSet(rs);
			}
			else {
				throw new DbException("Unexpected error! No rows affected!");
			}
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
		}
	}

	@Override
	public void update(Atendente obj) {
		
	}

	@Override
	public void deleteById(Integer id) {
		
	}

	@Override
	public Atendente findById(Integer id) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement("SELECT atendente_id, nome, status, turno FROM atendente WHERE atendente_id = ?");
			st.setInt(1, id);
			rs = st.executeQuery();
			if (rs.next()) {
				Atendente atend = new Atendente();
				atend.setAtendente_id(rs.getInt("atendente_id"));
				atend.setNome(rs.getString("nome"));
				atend.setStatus(rs.getString("status"));
				atend.setTurno(rs.getString("turno"));
				return atend;
			}
			return null;
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
	}

	@Override
	public List<Atendente> findAll() {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement("SELECT * FROM atendente");
			rs = st.executeQuery();
			List<Atendente> list = new ArrayList<>();
			while (rs.next()) {
				Atendente atendente = new Atendente();
				atendente.setAtendente_id(rs.getInt("atendente_id"));
				atendente.setNome(rs.getString("nome"));
				atendente.setStatus(rs.getString("status"));
				atendente.setTurno(rs.getString("turno"));
				list.add(atendente);
			}
			return list;
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
	}

	@Override
	public boolean findLogin(String login, String senha) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement("SELECT atendente_id, login, senha FROM atendente WHERE login = ? AND senha = ?");
			st.setString(1, login);
			st.setString(2, senha);
			rs = st.executeQuery();
			if (rs.next()) {
				Atendente atend = new Atendente();
				atend.setAtendente_id(rs.getInt("atendente_id"));
				atend.setLogin(rs.getString("login"));
				atend.setSenha(rs.getString("senha"));
				return true;
			}
			return false;
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
	}
	
}
