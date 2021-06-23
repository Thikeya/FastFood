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
import model.dao.PromocaoDao;
import model.entities.Produto;
import model.entities.Promocao;

public class PromocaoDaoJDBC implements PromocaoDao {

	private Connection conn;
	
	public PromocaoDaoJDBC(Connection conn) {
		this.conn = conn;
	}
	
	@Override
	public boolean insert(Promocao obj) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(
					"INSERT INTO promocao "
					+ "(tipo, validade, preco, descricao, produto_id) "
					+ "VALUES "
					+ "(?, ?, ?, ?, ?)",
					Statement.RETURN_GENERATED_KEYS);
			
			st.setString(1, obj.getTipo());
			st.setString(2, obj.getDuracao());
			st.setDouble(3, obj.getPreco());
			st.setString(4, obj.getDescricao());
			st.setInt(5, obj.getProduto().getProduto_id());
			
			int rowsAffected = st.executeUpdate();
			
			if (rowsAffected > 0) {
				ResultSet rs = st.getGeneratedKeys();
				if (rs.next()) {
					int id = rs.getInt(1);
					obj.setPromocao_id(id);
					return true;
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
		return false;
	}

	@Override
	public void update(Promocao obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Promocao findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Promocao> findAll() {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement("SELECT * FROM promocao");
			rs = st.executeQuery();
			List<Promocao> list = new ArrayList<>();
			while (rs.next()) {
				Promocao promocao = new Promocao();
				Produto produto = new Produto();
				promocao.setPromocao_id(rs.getInt("promocao_id"));
				promocao.setTipo(rs.getString("tipo"));
				promocao.setDuracao(rs.getString("validade"));
				promocao.setPreco(rs.getDouble("preco"));
				promocao.setDescricao(rs.getString("descricao"));
				produto.setProduto_id(rs.getInt("produto_id"));
				promocao.setProduto(produto);
				list.add(promocao);
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
