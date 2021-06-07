package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
		// TODO Auto-generated method stub
		
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
