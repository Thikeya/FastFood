package model.dao;

import model.dao.impl.AtendenteDaoJDBC;
import model.dao.impl.CategoriaDaoJDBC;
import model.dao.impl.Ing_ProdDaoJDBC;
import model.dao.impl.IngredienteDaoJDBC;
import model.dao.impl.Item_PedidoDaoJDBC;
import model.dao.impl.PagamentoDaoJDBC;
import model.dao.impl.PedidoDaoJDBC;
import model.dao.impl.ProdutoDaoJDBC;
import model.dao.impl.PromocaoDaoJDBC;

public class DaoFactory {
	public static AtendenteDao createAtendenteDao() {
		return new AtendenteDaoJDBC();
	}
	public static CategoriaDao createCategoriaDao() {
		return new CategoriaDaoJDBC();
	}
	public static Ing_ProdDao createIng_ProdDao() {
		return new Ing_ProdDaoJDBC();
	}
	public static IngredienteDao createIngredienteDao() {
		return new IngredienteDaoJDBC();
	}
	public static Item_PedidoDao createItem_PedidoDao() {
		return new Item_PedidoDaoJDBC();
	}
	public static PagamentoDao createPagamentoDao() {
		return new PagamentoDaoJDBC();
	}
	public static PedidoDao createPedidoDao() {
		return new PedidoDaoJDBC();
	}
	public static ProdutoDao createProdutoDao() {
		return new ProdutoDaoJDBC();
	}
	public static PromocaoDao createPromocaoDao() {
		return new PromocaoDaoJDBC();
	}
	
}
