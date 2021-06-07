package model.dao;

import java.util.List;

import model.entities.Atendente;

public interface AtendenteDao {
	void insert(Atendente obj);
	void update(Atendente obj);
	void deleteById(Integer id);
	Atendente findById(Integer id);
	List<Atendente> findAll();
}
