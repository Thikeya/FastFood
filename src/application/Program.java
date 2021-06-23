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
	static Scanner sc = new Scanner(System.in);
	static String timeStamp = new SimpleDateFormat("yyyy/MM/dd - HH:mm:ss").format(Calendar.getInstance().getTime());
	static AtendenteDao atendenteDao = DaoFactory.createAtendenteDao();
	static CategoriaDao categoriaDao = DaoFactory.createCategoriaDao();
	static Ing_ProdDao ing_prodDao = DaoFactory.createIng_ProdDao();
	static IngredienteDao ingredienteDao = DaoFactory.createIngredienteDao();
	static Item_PedidoDao item_pedidoDao = DaoFactory.createItem_PedidoDao();
	static PagamentoDao pagamentoDao = DaoFactory.createPagamentoDao();
	static PedidoDao pedidoDao = DaoFactory.createPedidoDao();
	static Pedido_ItemDao pedido_itemDao = DaoFactory.createPedido_ItemDao();
	static ProdutoDao produtoDao = DaoFactory.createProdutoDao();
	static PromocaoDao promocaoDao = DaoFactory.createPromocaoDao();
	
	public int cadastrarVenda(String nomeCliente) {
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
					item_pedido.setStatus("ativo");
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
					item_pedido.setStatus("ativo");
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
			con = sc.nextInt(); sc.nextLine();
		}
		System.out.println("Deseja remover algum produto/ingrediente?");
		System.out.println("1- Sim // 2- Nao");
		int opRemocao = sc.nextInt();sc.nextLine();
		if(opRemocao == 1) {
			int remover = 1;
			while(remover == 1) {
				System.out.println(pedido_itemDao.carrinho(id_pedido));
				System.out.println("Código que deseja remover");
				int codRemover = sc.nextInt();sc.nextLine();
				Item_Pedido remove = item_pedidoDao.findById(codRemover);
				if(remove.getQtdeProdutos()>0) {
					pedido_itemDao.deleteById(codRemover);
					produtoDao.atualizaQuantidade(remove.getProduto(), (remove.getQtdeProdutos()*(-1)));
					item_pedidoDao.removerCarrinho(codRemover);
				}else if(remove.getQtdeIngredientes()>0) {
					pedido_itemDao.deleteById(codRemover);
					ingredienteDao.atualizaQuantidade(remove.getIngrediente(), (remove.getQtdeIngredientes()*(-1)));
					item_pedidoDao.removerCarrinho(codRemover);
				}
				System.out.println("Continuar a remover?");
				System.out.println("1- Sim // 2- Nao");
				remover = sc.nextInt();sc.nextLine();
			}
		}
		return id_pedido;
	}
	
	public int pagamentoCartao(int id_pedido, String num) {
		if(num.length() == 16) {
			Pagamento pag = new Pagamento();
			pag.setTipoDePag("Cartao de credito/debito");
			pag.setStatus("Pagamento confirmado");
			pag.setPedido(pedidoDao.findById(id_pedido));
			int codigoPagamento = pagamentoDao.insert(pag);
			return codigoPagamento;
		}else {
			return 0;
		}
	}
	
	public int pagamentoQRCode(int id_pedido, String num) {
		System.out.println("Informe o código de 4 digitos:");
		num = sc.nextLine();
		if(num.length() == 4) {
			Pagamento pag = new Pagamento();
			pag.setTipoDePag("QR Code");
			pag.setStatus("Pagamento confirmado");
			pag.setPedido(pedidoDao.findById(id_pedido));
			int codigoPagamento = pagamentoDao.insert(pag);
			return codigoPagamento;
		}else {
			return 0;
		}
	}
	
	public boolean verificaPedido(int pedido) {
		if(pedidoDao.findPrecoById(pedido) > 0) {
			return true;
		}
		return false;
	}
	
	public void dadosPedido(int pedido) {
		Pedido ped = new Pedido();
		ped = pedidoDao.findById(pedido);
		System.out.println("Realizar pagamento");
		System.out.println("Numero do pedido: " + ped.getPedido_id());
		System.out.println("Cliente: " + ped.getDescricao());
		System.out.println("Horario do pedido: " + ped.getHorarioPedido());
		System.out.println("Valor a ser pago R$:" + pedidoDao.findPrecoById(pedido));
	}
	
	public int verificaFuncionario(String login, String senha) {
		Atendente atendende = new Atendente();
		atendende = atendenteDao.findLogin(login, senha);
		if(atendende.getLogin().equals("admin") && atendende.getSenha().equals("admin")) {
			return 2;
		}else if(atendende!=null) {
			return 1;
		}
		return 0;
	}
	
	public String nomeFuncionario(String login, String senha) {
		Atendente atendende = new Atendente();
		atendende = atendenteDao.findLogin(login, senha);
		return atendende.getNome();
	}
	
	public int idFuncionario(String login, String senha) {
		Atendente atendende = new Atendente();
		atendende = atendenteDao.findLogin(login, senha);
		return atendende.getAtendente_id();
	}
	
	public void exibirPedidos() {
		System.out.println(pedidoDao.findAll());
	}
	
	public void vincularPedido(int numPedido, int funcionario) {
		Atendente atendente = new Atendente();
		atendente = atendenteDao.findById(funcionario);
		Pedido pedido = pedidoDao.findById(numPedido);
		if(pedidoDao.findById(numPedido).getAtendente().getAtendente_id() == 1) {
			pedido.setAtendente(atendente);
			pedidoDao.updateAtendente(pedido);
			System.out.println("Atendente vinculado com sucesso");
		}else if(pedidoDao.findById(numPedido).getAtendente().getAtendente_id() == funcionario) {
			System.out.println("Esse pedido ja estava vinculado a voce");
		}else {
			System.out.println("Esse pedido já possui um atendente cadastrado");
		}
	}
	
	public void alterarStatusPedido(int numPedido) {
		Pedido pedido = new Pedido();
		pedido = pedidoDao.findById(numPedido);
		if(!pedido.getStatusPedido().equals("finalizado")) {
			System.out.println("Informe o novo status:");
			String novoStatus = sc.nextLine();
			pedidoDao.updateStatus(pedido, novoStatus);
		}else {
			System.out.println("Nao foi possivel alterar o status");
		}
	}
	
	public boolean verificarAdmin(String login, String senha) {
		if(login.equals("admin")) {
			if(senha.equals("admin")) {
				return true;
			}
		}
		return false;
	}
}
