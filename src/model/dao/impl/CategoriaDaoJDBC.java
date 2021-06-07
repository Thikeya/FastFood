package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.DB;
import db.DbException;
import model.dao.CategoriaDao;
import model.entities.Categoria;

public class CategoriaDaoJDBC implements CategoriaDao{

	private Connection conn;
	
	public CategoriaDaoJDBC(Connection conn) {
		this.conn = conn;
	}
	
	@Override
	public void insert(Categoria obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Categoria obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Categoria findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Categoria> findAll() {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement("SELECT * FROM categoria");
			rs = st.executeQuery();
			List<Categoria> list = new ArrayList<>();
			while (rs.next()) {
				Categoria categoria = new Categoria();
				categoria.setCategoria_id(rs.getInt("categoria_id"));
				categoria.setDescricao(rs.getString("descricao"));
				categoria.setNome(rs.getString("nome"));
				list.add(categoria);
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
