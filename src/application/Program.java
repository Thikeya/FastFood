package application;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

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
import model.entities.Item_Pedido;
import model.entities.Pedido;

public class Program {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		String timeStamp = new SimpleDateFormat("yyyy/MM/dd - HH:mm:ss").format(Calendar.getInstance().getTime());
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
		
		int menu = 1;
		
		while(menu == 1) {
			System.out.println("Deseja realizar um pedido?");
			System.out.println("1- Sim // 2- Não");
			String es1 = sc.nextLine();
			if(es1.equals("1")) {
				System.out.println("informe seu nome: ");
				String nomeCliente = sc.nextLine();
				Pedido pedido = new Pedido();
				pedido.setAtendente(atendenteDao.findById(1));
				pedido.setDescricao(nomeCliente);
				pedido.setHorarioPedido(timeStamp);
				pedido.setStatusPedido("a espera");
				int id_pedido = pedidoDao.insert(pedido);
				int con = 1;
				while(con == 1) {
					System.out.println("1- adicionar produtos");
					System.out.println("2- adicionar ingredientes");
					int pedidomenu = sc.nextInt();sc.nextLine();
					int id_item_pedido = 0;
					if(pedidomenu == 1) {
						System.out.println(produtoDao.findAll());
						int continuar = 1;
						while(continuar==1) {
							System.out.println("escolha um produto:");
							int escolhaProduto = sc.nextInt();sc.nextLine();
							System.out.println("digite a quantidade:");
							int quantidadeProduto = sc.nextInt();sc.nextLine();
							Item_Pedido item_pedido = new Item_Pedido();
							item_pedido.setQtdeProdutos(quantidadeProduto);
							item_pedido.setProduto(produtoDao.findById(escolhaProduto));
							item_pedido.setIngrediente(null);
							item_pedido.setQtdeIngredientes(0);
							
							id_item_pedido = item_pedidoDao.insert(item_pedido);
							pedido_itemDao.insert(pedidoDao.findById(id_pedido), item_pedidoDao.findByProduto(id_item_pedido));
							System.out.println("adicionar mais algum produto?");
							System.out.println("1-Sim // 2- Não");
							continuar=sc.nextInt();sc.nextLine();
						}
					}
					if(pedidomenu == 2) {
						System.out.println(ingredienteDao.findAll());
						int continuar = 1;
						while(continuar==1) {
							System.out.println("escolha um ingrediente:");
							int escolhaIngrediente = sc.nextInt();sc.nextLine();
							System.out.println("digite um ingrediente:");
							int quantidadeIngrediente = sc.nextInt();sc.nextLine();
							Item_Pedido item_pedido = new Item_Pedido();
							item_pedido.setQtdeProdutos(0);
							item_pedido.setProduto(null);
							item_pedido.setIngrediente(ingredienteDao.findById(escolhaIngrediente));
							item_pedido.setQtdeIngredientes(quantidadeIngrediente);
							
							id_item_pedido = item_pedidoDao.insert(item_pedido);
							pedido_itemDao.insert(pedidoDao.findById(id_pedido), item_pedidoDao.findByIngrediente(id_item_pedido));
							System.out.println("adicionar mais algum produto?");
							System.out.println("1-Sim // 2- Não");
							continuar=sc.nextInt();sc.nextLine();
						}
					}
					System.out.println("Deseja inserir mais algo?");
					System.out.println("1- Sim // 2- Nao");
					con = sc.nextInt(); sc.nextLine();
				}
				System.out.println("Finalizando pedido");
				
				
				
			}
			else if(es1.equals("2")){
				System.out.println("É uma pena, quem sabe em outro momento...");
				System.out.println("Encerrando sistema...");
			}
			else if(es1.equals("funcionario")) {
				System.out.println("=== Login === ");
				System.out.println("Insira seu login: ");
				String login = sc.nextLine();
				System.out.println("Insira sua senha: ");
				String senha = sc.nextLine();
				Atendente atendente = new Atendente();
				if(atendente.verificarAdmin(login, senha)) {
					atendente.listarAdminOpcoes();
				}
				else if(atendenteDao.findLogin(login, senha)) {
					System.out.println("login efetuado com sucesso");
					int atendenteEscolha = atendente.listarAtendenteOpcoes();
					switch(atendenteEscolha) {
						case 1:
							pedidoDao.findAll();
							int escolherPedido = sc.nextInt();sc.nextLine();
							if(pedidoDao.findById(escolherPedido).getAtendente().getAtendente_id() == 1) {
								pedidoDao.update(pedidoDao.findById(escolherPedido));
							}
							else {
								System.out.println("Esse pedido já possui uma atendente cadastrado");
							}
							break;
						case 2:
							pedidoDao.findAll();
							Pedido pedido = new Pedido();
							escolherPedido = sc.nextInt();sc.nextLine();
							pedido = pedidoDao.findById(escolherPedido);
							if(!pedido.getStatusPedido().equals("finalizado")) {
								System.out.println("informe o novo status:");
								String novoStatus = sc.nextLine();
								pedido.setStatusPedido(novoStatus);
								pedidoDao.update(pedido);
							}
							break;
						case 3:
							break;
						default:
							System.out.println("escolha invalida");
							System.out.println("sistema finalizado...");
							break;
					}
				}
				else {
					System.out.println("login não efetuado");
					System.out.println("Encerrando sistema...");
					break;
					}
			}else {
				System.out.println("Opcao invalida");
			}
		}
	}
}
