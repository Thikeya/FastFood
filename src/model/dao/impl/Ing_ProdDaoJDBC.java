package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.DB;
import db.DbException;
import model.dao.Ing_ProdDao;
import model.entities.Ing_Prod;
import model.entities.Ingrediente;
import model.entities.Produto;

public class Ing_ProdDaoJDBC implements Ing_ProdDao{

	private Connection conn;
	
	public Ing_ProdDaoJDBC(Connection conn) {
		this.conn = conn;
	}
	
	
	@Override
	public void insert(Ing_Prod obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Ing_Prod obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Ing_Prod findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Ing_Prod> findAll() {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement("SELECT * FROM ing_prod");
			rs = st.executeQuery();
			List<Ing_Prod> list = new ArrayList<>();
			while (rs.next()) {
				Ing_Prod ing_prod = new Ing_Prod();
				Ingrediente ingrediente = new Ingrediente();
				Produto produto = new Produto();
				ingrediente.setIngrediente_id(rs.getInt("ingrediente_id"));
				produto.setProduto_id(rs.getInt("produto_id"));
				ing_prod.setQtdeIng(rs.getInt("qtd_ingrediente"));
				ing_prod.setProduto(produto);
				ing_prod.setIngrediente(ingrediente);
				list.add(ing_prod);
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
	public void atualizaIngredientes(Integer id, int quantidade) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement("update ingrediente, ing_prod set ingrediente.qtd_estoque = (ingrediente.qtd_estoque - ing_prod.qtd_ingrediente*?) where ingrediente.ingrediente_id = ing_prod.ingrediente_id AND produto_id = ?");
			st.setInt(1, quantidade);
			st.setInt(2, id);
			st.executeUpdate();
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
		}
	}

}
