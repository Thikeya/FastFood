package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
		
	}

	@Override
	public void update(Atendente obj) {
		
	}

	@Override
	public void deleteById(Integer id) {
		
	}

	@Override
	public Atendente findById(Integer id) {
		return null;
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
	
}
