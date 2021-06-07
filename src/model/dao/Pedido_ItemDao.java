package model.dao;

import java.util.List;

import model.entities.Pedido_Item;

public interface Pedido_ItemDao {
	void insert(Pedido_Item obj);
	void update(Pedido_Item obj);
	void deleteById(Integer id);
	Pedido_Item findById(Integer id);
	List<Pedido_Item> findAll();
}
