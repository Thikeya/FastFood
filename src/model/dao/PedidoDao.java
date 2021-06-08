package model.dao;

import java.sql.Timestamp;
import java.util.List;

import model.entities.Atendente;
import model.entities.Pedido;

public interface PedidoDao {
	void insert(Pedido obj);
	void update(Pedido obj);
	void deleteById(Integer id);
	Pedido findById(Integer id);
	List<Pedido> findAll();
}
