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
import model.dao.Item_PedidoDao;
import model.entities.Ingrediente;
import model.entities.Item_Pedido;
import model.entities.Produto;

public class Item_PedidoDaoJDBC implements Item_PedidoDao {

	private Connection conn;
	
	public Item_PedidoDaoJDBC(Connection conn) {
		this.conn = conn;
	}
	
	@Override
	public void insert(Item_Pedido obj) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(
					"INSERT INTO item_pedido "
					+ "(produto_id, qtd_produto, ingrediente_id, qtd_ingrediente) "
					+ "VALUES "
					+ "(?, ?, ?, ?)",
					Statement.RETURN_GENERATED_KEYS);
			
			st.setInt(1, obj.getProduto().getProduto_id());
			st.setInt(2, obj.getQtdeProdutos());
			st.setInt(3, obj.getIngrediente().getIngrediente_id());
			st.setInt(4, obj.getQtdeIngredientes());
			
			int rowsAffected = st.executeUpdate();
			
			if (rowsAffected > 0) {
				ResultSet rs = st.getGeneratedKeys();
				if (rs.next()) {
					int id = rs.getInt(1);
					obj.setItem_pedido_id(id);
					System.out.println("O código do seus itens é nº: " + id);
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
	public void update(Item_Pedido obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Item_Pedido findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Item_Pedido> findAll() {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement("SELECT * FROM item_pedido");
			rs = st.executeQuery();
			List<Item_Pedido> list = new ArrayList<>();
			while (rs.next()) {
				Item_Pedido item_pedido = new Item_Pedido();
				Produto produto = new Produto();
				Ingrediente ingrediente = new Ingrediente();
				item_pedido.setItem_pedido_id(rs.getInt("item_pedido_id"));
				item_pedido.setQtdeProdutos(rs.getInt("qtd_produto"));
				item_pedido.setQtdeIngredientes(rs.getInt("qtd_ingrediente"));
				produto.setProduto_id(rs.getInt("produto_id"));
				ingrediente.setIngrediente_id(rs.getInt("ingrediente_id"));
				item_pedido.setProduto(produto);
				item_pedido.setIngrediente(ingrediente);
				list.add(item_pedido);
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
