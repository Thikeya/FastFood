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
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(
					"INSERT INTO pedido "
					+ "(hora_pedido, descricao, status_pedido, atendente_id) "
					+ "VALUES "
					+ "(?, ?, ?, ?)",
					Statement.RETURN_GENERATED_KEYS);
			
			st.setString(1, obj.getHorarioPedido());
			st.setString(2, obj.getDescricao());
			st.setString(3, obj.getStatusPedido());
			st.setInt(4, obj.getAtendente().getAtendente_id());
			
			int rowsAffected = st.executeUpdate();
			
			if (rowsAffected > 0) {
				ResultSet rs = st.getGeneratedKeys();
				
				if (rs.next()) {
					int id = rs.getInt(1);
					obj.setPedido_id(id);
					System.out.println("Pedido Criado nº:" + id);
					System.out.println("Adicionar ");
				}
				DB.closeResultSet(rs);
			}
			else {
				throw new DbException("Erro, nenhuma linha afetada");
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
				pedido.setHorarioPedido(rs.getString("hora_pedido"));
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
