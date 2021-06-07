package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.DB;
import db.DbException;
import model.dao.PedidoDao;
import model.entities.Atendente;
import model.entities.Pedido;

public class PedidoDaoJDBC implements PedidoDao {

	private Connection conn;
	
	public PedidoDaoJDBC(Connection conn) {
		this.conn = conn;
	}
	
	@Override
	public void insert(Pedido obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Pedido obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Pedido findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Pedido> findAll() {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement("SELECT * FROM pedido");
			rs = st.executeQuery();
			List<Pedido> list = new ArrayList<>();
			while (rs.next()) {
				Pedido pedido = new Pedido();
				Atendente atendente = new Atendente();
				pedido.setPedido_id(rs.getInt("pedido_id"));
				pedido.setHorarioPedido(rs.getTimestamp("hora_pedido"));
				pedido.setDescricao(rs.getString("descricao"));
				pedido.setStatusPedido(rs.getString("status_pedido"));
				atendente.setAtendente_id(rs.getInt("atendente_id"));
				pedido.setAtendente(atendente);
				list.add(pedido);
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
