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
import model.dao.Pedido_ItemDao;
import model.entities.Item_Pedido;
import model.entities.Pedido;
import model.entities.Pedido_Item;

public class Pedido_ItemDaoJDBC implements Pedido_ItemDao {

	private Connection conn;
	
	public Pedido_ItemDaoJDBC(Connection conn) {
		this.conn = conn;
	}
	
	@Override
	public void insert(Pedido ped, Item_Pedido it_ped) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(
					"INSERT INTO pedido_item "
					+ "(pedido_id, item_pedido_id) "
					+ "VALUES "
					+ "(?, ?)",
					Statement.RETURN_GENERATED_KEYS);
			
			st.setInt(1, ped.getPedido_id());
			st.setInt(2, it_ped.getItem_pedido_id());
			
			int rowsAffected = st.executeUpdate();
			
			if (rowsAffected > 0) {
				ResultSet rs = st.getGeneratedKeys();
				if (rs.next()) {
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
	public void update(Pedido_Item obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Pedido_Item findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Pedido_Item> findAll() {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement("SELECT * FROM pedido_Item");
			rs = st.executeQuery();
			List<Pedido_Item> list = new ArrayList<>();
			while (rs.next()) {
				Pedido_Item pedido_Item = new Pedido_Item();
				Pedido pedido = new Pedido();
				Item_Pedido item_pedido = new Item_Pedido();
				pedido.setPedido_id(rs.getInt("pedido_id"));
				item_pedido.setItem_pedido_id(rs.getInt("item_pedido_id"));
				pedido_Item.setItem_pedido(item_pedido);
				pedido_Item.setPedido(pedido);
				list.add(pedido_Item);
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
