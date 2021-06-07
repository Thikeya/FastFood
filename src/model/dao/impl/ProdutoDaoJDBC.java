package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.DB;
import db.DbException;
import model.dao.ProdutoDao;
import model.entities.Categoria;
import model.entities.Produto;

public class ProdutoDaoJDBC implements ProdutoDao{

	private Connection conn;
	
	public ProdutoDaoJDBC(Connection conn) {
		this.conn = conn;
	}
	
	@Override
	public void insert(Produto obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Produto obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Produto findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Produto> findAll() {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement("SELECT * FROM produto");
			rs = st.executeQuery();
			List<Produto> list = new ArrayList<>();
			while (rs.next()) {
				Produto produto = new Produto();
				Categoria categoria = new Categoria();
				produto.setProduto_id(rs.getInt("produto_id"));
				produto.setNome(rs.getString("nome"));
				produto.setValor(rs.getDouble("valor"));
				produto.setDescricao(rs.getString("descricao"));
				produto.setQtdEstoque(rs.getInt("qtd_estoque"));
				produto.setDataProducao(rs.getDate("data_fabricacao"));
				categoria.setCategoria_id(rs.getInt("categoria_id"));
				produto.setCategoria(categoria);
				list.add(produto);
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
