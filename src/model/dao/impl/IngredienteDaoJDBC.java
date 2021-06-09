package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.DB;
import db.DbException;
import model.dao.IngredienteDao;
import model.entities.Categoria;
import model.entities.Ingrediente;
import model.entities.Produto;

public class IngredienteDaoJDBC implements IngredienteDao{

	private Connection conn;
	
	public IngredienteDaoJDBC(Connection conn) {
		this.conn = conn;
	}
	
	@Override
	public void insert(Ingrediente obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Ingrediente obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Ingrediente findById(Integer id) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement("SELECT ingrediente_id, nome, unidade_medida, validade, valor_porcao, qtd_estoque FROM ingrediente WHERE ingrediente_id>1 AND ingrediente_id = ?");
			st.setInt(1, id);
			rs = st.executeQuery();
			if (rs.next()) {
				Ingrediente ing = new Ingrediente();
				ing.setIngrediente_id(rs.getInt("ingrediente_id"));
				ing.setNome(rs.getString("nome"));
				ing.setUnidadeMedida(rs.getString("unidade_medida"));
				ing.setValidade(rs.getDate("validade"));
				ing.setValorPorcao(rs.getDouble("valor_porcao"));
				ing.setQtdeEstoque(rs.getInt("qtd_estoque"));
				return ing;
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
	public List<Ingrediente> findAll() {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement("SELECT * FROM ingrediente WHERE ingrediente_id > 1");
			rs = st.executeQuery();
			List<Ingrediente> list = new ArrayList<>();
			while (rs.next()) {
				Ingrediente ingrediente = new Ingrediente();
				ingrediente.setIngrediente_id(rs.getInt("ingrediente_id"));
				ingrediente.setNome(rs.getString("nome"));
				ingrediente.setUnidadeMedida(rs.getString("unidade_medida"));
				ingrediente.setValidade(rs.getDate("validade"));
				ingrediente.setValorPorcao(rs.getDouble("valor_porcao"));
				ingrediente.setQtdeEstoque(rs.getInt("qtd_estoque"));
				list.add(ingrediente);
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
