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
import model.entities.Pagamento;
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
							item_pedido.setIngrediente(ingredienteDao.findById(1));
							item_pedido.setQtdeIngredientes(0);
							id_item_pedido = item_pedidoDao.insert(item_pedido);
							pedido_itemDao.insert(pedidoDao.findById(id_pedido), item_pedidoDao.findByProduto(id_item_pedido));
							produtoDao.atualizaQuantidade(item_pedidoDao.findByProduto(id_item_pedido).getProduto(),quantidadeProduto);
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
							System.out.println("digite a quantidade:");
							int quantidadeIngrediente = sc.nextInt();sc.nextLine();
							Item_Pedido item_pedido = new Item_Pedido();
							item_pedido.setQtdeProdutos(0);
							item_pedido.setProduto(produtoDao.findById(1));
							item_pedido.setIngrediente(ingredienteDao.findById(escolhaIngrediente));
							item_pedido.setQtdeIngredientes(quantidadeIngrediente);
							id_item_pedido = item_pedidoDao.insert(item_pedido);
							pedido_itemDao.insert(pedidoDao.findById(id_pedido), item_pedidoDao.findByIngrediente(id_item_pedido));
							ingredienteDao.atualizaQuantidade(item_pedidoDao.findByIngrediente(id_item_pedido).getIngrediente(), quantidadeIngrediente);
							System.out.println("adicionar mais algum ingrediente?");
							System.out.println("1-Sim // 2- Não");
							continuar=sc.nextInt();sc.nextLine();
						}
					}
					System.out.println("Deseja inserir mais algum produto/ingrediente?");
					System.out.println("1- Sim // 2- Nao");
					System.out.println("\n");
					con = sc.nextInt(); sc.nextLine();
				}
				System.out.println("Realizar pagamento");
				Pedido ped = pedidoDao.findById(id_pedido);
				System.out.println("Numero do pedido: " + ped.getPedido_id());
				System.out.println("Cliente: " + ped.getDescricao());
				System.out.println("Horario do pedido: " + ped.getHorarioPedido());
				System.out.println("Valor a ser pago R$:" + pedidoDao.findPrecoById(id_pedido));
				System.out.println("\n");
				System.out.println("Escolha o método de pagamento:\n1- Cartao de credito // 2-QR Code");
				int mtdpagamento = sc.nextInt();sc.nextLine();
				int codigoPagamento = 0;
				if(mtdpagamento == 1) {
					Pagamento pag = new Pagamento();
					pag.setTipoDePag("Cartao de credito");
					pag.setStatus("Pagamento confirmado");
					pag.setPedido(pedidoDao.findById(id_pedido));
					codigoPagamento = pagamentoDao.insert(pag);
					System.out.println("Numero do seu pedido: "+ id_pedido);
					System.out.println("Numero do seu pagamento: "+codigoPagamento);
					System.out.println("\n\n");
				}else if(mtdpagamento == 2) {
					Pagamento pag = new Pagamento();
					pag.setTipoDePag("QR Code");
					pag.setStatus("Pagamento confirmado");
					pag.setPedido(pedidoDao.findById(id_pedido));
					codigoPagamento = pagamentoDao.insert(pag);
					System.out.println("Numero do seu pedido: "+ id_pedido);
					System.out.println("Numero do seu pagamento: "+codigoPagamento);
					System.out.println("\n\n");
				}else {
					System.out.println("metodo nao aceito");
					System.out.println("\n\n");
				}
			}
			else if(es1.equals("2")){
				System.out.println("Obrigado, até a proxima vez!");
			}
			else if(es1.equals("funcionario")) {
				boolean funcionarioTrue = true;
				while(funcionarioTrue) {
					System.out.println("=== Login === ");
					System.out.println("Insira seu login: ");
					String login = sc.nextLine();
					System.out.println("Insira sua senha: ");
					String senha = sc.nextLine();
					Atendente atende = new Atendente();
					atende = atendenteDao.findLogin(login, senha);
					
					if(atende!=null) {
						if(atende.verificarAdmin(login, senha)) {
							atende.listarAdminOpcoes();
						}else {
							System.out.println("login efetuado com sucesso");
							int atendenteEscolha = atende.listarAtendenteOpcoes();
							switch(atendenteEscolha) {
								case 1:
									System.out.println(pedidoDao.findAll());
									System.out.println("Escolha um codigo do pedido que deseja adicionar");
									int escolherPedido = sc.nextInt();sc.nextLine();
									if(pedidoDao.findById(escolherPedido).getAtendente().getAtendente_id() == 1) {
										Pedido pedido = pedidoDao.findById(escolherPedido);
										pedido.setAtendente(atende);
										pedidoDao.updateAtendente(pedido);
									}
									else {
										System.out.println("Esse pedido já possui um atendente cadastrado");
										break;
									}
									break;
								case 2:
									System.out.println(pedidoDao.findAll());
									Pedido pedido = new Pedido();
									System.out.println("Escolha o pedido que deseja alterar o status");
									escolherPedido = sc.nextInt();sc.nextLine();
									pedido = pedidoDao.findById(escolherPedido);
									if(!pedido.getStatusPedido().equals("Pedido finalizado")) {
										System.out.println("informe o novo status:");
										String novoStatus = sc.nextLine();
										pedidoDao.updateStatus(pedido, novoStatus);
									}else {
										System.out.println("Nao foi possivel alterar o status");
									}
									break;
								case 3:
									System.out.println("Saindo do login");
									funcionarioTrue = false;
									break;
								default:
									System.out.println("escolha invalida");
									System.out.println("sistema finalizado...");
									funcionarioTrue = false;
									break;
							}
						}
					}else {
						System.out.println("Login não efetuado");
						System.out.println("Deseja tentar novamente?");
						System.out.println("1-Sim // 2-Nao");
						int resp = sc.nextInt();sc.nextLine();
						if(resp == 2) {
							funcionarioTrue = false;
						}
					}
				}
			}
		}
	}
}
