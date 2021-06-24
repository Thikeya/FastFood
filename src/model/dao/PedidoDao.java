package model.dao;

import java.util.List;

import model.entities.Pedido;

public interface PedidoDao {
	int insert(Pedido obj);
	void update(Pedido obj);
	void updateAtendente(Pedido obj);
	void updateStatus(Pedido obj);
	void deleteById(Integer id);
	double findPrecoById(Integer id);
	Pedido findById(Integer id);
	List<Pedido> findAll();
}
