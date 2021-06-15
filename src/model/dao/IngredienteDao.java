package model.dao;

import java.util.List;

import model.entities.Ingrediente;
import model.entities.Produto;

public interface IngredienteDao {
	void insert(Ingrediente obj);
	void update(Ingrediente obj);
	void deleteById(Integer id);
	Ingrediente findById(Integer id);
	List<Ingrediente> findAll();
	void atualizaQuantidade(Ingrediente ingrediente,Integer quantidade);
}
