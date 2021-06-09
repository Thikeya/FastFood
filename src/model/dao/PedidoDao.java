package model.dao;

import java.util.List;

import model.entities.Pedido;

public interface PedidoDao {
	int insert(Pedido obj);
	void update(Pedido obj);
	void deleteById(Integer id);
	Pedido findById(Integer id);
	List<Pedido> findAll();
}
