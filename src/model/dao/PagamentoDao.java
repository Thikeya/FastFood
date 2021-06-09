package model.dao;

import java.util.List;

import model.entities.Pagamento;

public interface PagamentoDao {
	int insert(Pagamento obj);
	void update(Pagamento obj);
	void deleteById(Integer id);
	Pagamento findById(Integer id);
	List<Pagamento> findAll();
}
