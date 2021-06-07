package model.dao;

import java.util.List;

import model.entities.Ing_Prod;

public interface Ing_ProdDao {
	void insert(Ing_Prod obj);
	void update(Ing_Prod obj);
	void deleteById(Integer id);
	Ing_Prod findById(Integer id);
	List<Ing_Prod> findAll();
}
