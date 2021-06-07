package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.DB;
import db.DbException;
import model.dao.PagamentoDao;
import model.entities.Pagamento;
import model.entities.Pedido;

public class PagamentoDaoJDBC implements PagamentoDao {

	private Connection conn;
	
	public PagamentoDaoJDBC(Connection conn) {
		this.conn = conn;
	}
	@Override
	public void insert(Pagamento obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Pagamento obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Pagamento findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Pagamento> findAll() {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement("SELECT * FROM pagamento");
			rs = st.executeQuery();
			List<Pagamento> list = new ArrayList<>();
			while (rs.next()) {
				Pagamento pagamento = new Pagamento();
				Pedido pedido = new Pedido();
				pagamento.setPagamento_id(rs.getInt("pagamento_id"));
				pagamento.setPagamentoAutorizado(rs.getString("status_pagamento"));
				pagamento.setTipoDePag(rs.getString("tipo_pagamento"));
				pedido.setPedido_id(rs.getInt("pedido_id"));
				pagamento.setPedido(pedido);
				list.add(pagamento);
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
