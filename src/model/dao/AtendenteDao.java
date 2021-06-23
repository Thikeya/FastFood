package model.dao;

import java.util.List;

import model.entities.Atendente;

public interface AtendenteDao {
	boolean insert(Atendente obj);
	void update(Atendente obj);
	void deleteById(Integer id);
	Atendente findById(Integer id);
	List<Atendente> findAll();
	Atendente findLogin(String login, String senha);
}
