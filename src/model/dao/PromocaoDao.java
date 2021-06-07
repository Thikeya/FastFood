package model.dao;

import java.util.List;

import model.entities.Promocao;

public interface PromocaoDao {
	void insert(Promocao obj);
	void update(Promocao obj);
	void deleteById(Integer id);
	Promocao findById(Integer id);
	List<Promocao> findAll();
}
