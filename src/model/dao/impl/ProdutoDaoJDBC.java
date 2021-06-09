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
import model.entities.Atendente;
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
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement("SELECT produto_id, nome, valor, descricao, qtd_estoque, data_fabricacao, categoria_id FROM produto WHERE produto_id>1 AND produto_id = ?");
			st.setInt(1, id);
			rs = st.executeQuery();
			if (rs.next()) {
				Produto prod = new Produto();
				Categoria cat = new Categoria();
				prod.setProduto_id(rs.getInt("produto_id"));
				prod.setNome(rs.getString("nome"));
				prod.setValor(rs.getDouble("valor"));
				prod.setDescricao(rs.getString("descricao"));
				prod.setQtdEstoque(rs.getInt("qtd_estoque"));
				prod.setDataProducao(rs.getDate("data_fabricacao"));
				cat.setCategoria_id(rs.getInt("categoria_id"));
				cat.setNome(rs.getString("nome"));
				cat.setDescricao(rs.getString("descricao"));
				prod.setCategoria(cat);
				return prod;
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
	public List<Produto> findAll() {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement("SELECT * FROM produto where produto_id>1");
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
