package model.dao;

import java.util.List;

import model.entities.Item_Pedido;

public interface Item_PedidoDao {
	void insert(Item_Pedido obj);
	void update(Item_Pedido obj);
	void deleteById(Integer id);
	Item_Pedido findById(Integer id);
	List<Item_Pedido> findAll();
}
