package application;

import java.util.List;

import model.dao.AtendenteDao;
import model.dao.CategoriaDao;
import model.dao.DaoFactory;
import model.dao.Ing_ProdDao;
import model.dao.IngredienteDao;
import model.dao.Item_PedidoDao;
import model.dao.PagamentoDao;
import model.dao.PedidoDao;
import model.dao.Pedido_ItemDao;
import model.dao.ProdutoDao;
import model.dao.PromocaoDao;
import model.entities.Atendente;
import model.entities.Categoria;
import model.entities.Ing_Prod;
import model.entities.Ingrediente;
import model.entities.Item_Pedido;
import model.entities.Pagamento;
import model.entities.Pedido;
import model.entities.Pedido_Item;
import model.entities.Produto;
import model.entities.Promocao;

public class Program {
	public static void main(String args[]) {
		AtendenteDao atendenteDao = DaoFactory.createAtendenteDao();
		CategoriaDao categoriaDao = DaoFactory.createCategoriaDao();
		Ing_ProdDao ing_prodDao = DaoFactory.createIng_ProdDao();
		IngredienteDao ingredienteDao = DaoFactory.createIngredienteDao();
		Item_PedidoDao item_pedidoDao = DaoFactory.createItem_PedidoDao();
		PagamentoDao pagamentoDao = DaoFactory.createPagamentoDao();
		PedidoDao pedidoDao = DaoFactory.createPedidoDao();
		Pedido_ItemDao pedido_itemDao = DaoFactory.createPedido_ItemDao();
		ProdutoDao produtoDao = DaoFactory.createProdutoDao();
		PromocaoDao promocaoDao = DaoFactory.createPromocaoDao();
		
		/*
		System.out.println("\n=== Listando todos os atendentes =====");
		List<Atendente> listAtendente = atendenteDao.findAll();
		for (Atendente obj : listAtendente) {
			System.out.println(obj);
		}
		
		System.out.println("\n=== Listando todos as categorias =====");
		List<Categoria> listCategoria = categoriaDao.findAll();
		for (Categoria obj : listCategoria) {
			System.out.println(obj);
		}
		
		System.out.println("\n=== Listando todos as ingrediente / produto =====");
		List<Ing_Prod> listIng_Prod = ing_prodDao.findAll();
		for (Ing_Prod obj : listIng_Prod) {
			System.out.println(obj);
		}
		
		System.out.println("\n=== Listando todos os ingredientes =====");
		List<Ingrediente> listIngrediente = ingredienteDao.findAll();
		for (Ingrediente obj : listIngrediente) {
			System.out.println(obj);
		}
		
		System.out.println("\n=== Listando todos os item / pedido =====");
		List<Item_Pedido> listItem_Pedido = item_pedidoDao.findAll();
		for (Item_Pedido obj : listItem_Pedido) {
			System.out.println(obj);
		}
		
		System.out.println("\n=== Listando todos os pagamentos =====");
		List<Pagamento> listPagamento = pagamentoDao.findAll();
		for (Pagamento obj : listPagamento) {
			System.out.println(obj);
		}
		
		System.out.println("\n=== Listando todos os pedido / item_pedido =====");
		List<Pedido_Item> listPedido_Item = pedido_itemDao.findAll();
		for (Pedido_Item obj : listPedido_Item) {
			System.out.println(obj);
		}
		
		System.out.println("\n=== Listando todos os pedidos =====");
		List<Pedido> listPedido = pedidoDao.findAll();
		for (Pedido obj : listPedido) {
			System.out.println(obj);
		}
		
		System.out.println("\n=== Listando todos os produtos =====");
		List<Produto> listProduto = produtoDao.findAll();
		for (Produto obj : listProduto) {
			System.out.println(obj);
		}
		
		System.out.println("\n=== Listando todos os promocao =====");
		List<Promocao> listPromocao = promocaoDao.findAll();
		for (Promocao obj : listPromocao) {
			System.out.println(obj);
		}
		
		System.out.println("\n=== TEST 4: atendente insert =====");
		Atendente novoAtendente = new Atendente(null, "ativo", "vespertino", "eric123", "eric", "Eric");
		atendenteDao.insert(novoAtendente);
		*/
		
		
	}
}
