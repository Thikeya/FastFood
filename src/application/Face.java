package application;

import java.util.Scanner;
import java.text.ParseException;
import java.util.Date;

import model.entities.Pedido;

public class Face {
	static Scanner sc = new Scanner(System.in);
	static Program program = new Program();
	public static void main(String args[]) throws ParseException {
		int pedido, mtd_pagamento, pagamento, menu = 0;
		String num;
		while(menu == 0) {
			System.out.println("Deseja realizar um pedido?");
			System.out.println("1- Sim // 2- Não");
			String resposta = sc.nextLine();
			if(resposta.equals("1")) {
				System.out.println("Informe seu nome: ");
				String nomeCliente = sc.nextLine();
				pedido = program.cadastrarVenda(nomeCliente);
				boolean pedidoValido = program.verificaPedido(pedido);
				program.dadosPedido(pedido);
				System.out.println("\n");
				System.out.println("Escolha o metodo de pagamento:");
				System.out.println("1- Cartão de credito/debito // 2- QR Code");
				mtd_pagamento = sc.nextInt(); sc.nextLine();
				if(mtd_pagamento==1) {
					System.out.println("Insira o cartão");
					num = sc.nextLine();
					pagamento = program.pagamentoCartao(pedido, num);
					if(pagamento!=0) {
						System.out.println("Codigo do pagamento: " + pagamento);
						System.out.println("Pagamento efetuado com sucesso");
					}else{
						System.out.println("Cartão não aceito");
					}
				}else if(mtd_pagamento==2) {
					System.out.println("Insira o QR Code");
					num = sc.nextLine();
					pagamento = program.pagamentoCartao(pedido, num);
					if(pagamento!=0) {
						System.out.println("Codigo do pagamento: " + pagamento);
						System.out.println("Pagamento efetuado com sucesso");
					}else {
						System.out.println("QR Code não aceito");
					}
				}else {
					System.out.println("Pedido sem itens adicionados");
				}
			}else if(resposta.equals("2")) {
				System.out.println("Obrigado, até a proxima vez!");
			}else if(resposta.equals("funcionario")) {
				System.out.println("=== Login === ");
				System.out.println("Insira seu login: ");
				String login = sc.nextLine();
				System.out.println("Insira sua senha: ");
				String senha = sc.nextLine();
				boolean processeguir = true;
				int funcionario = program.verificaFuncionario(login, senha);
				if(funcionario == 1) {
					System.out.println("Login efetuado com sucesso");
					System.out.println("Bem vindo de volta " + program.nomeFuncionario(login, senha));
					while(processeguir == true) {
						processeguir = listaAtendente(program.idFuncionario(login, senha));
					}
				}else if(funcionario == 2) {
					System.out.println("Login efetuado com sucesso");
					System.out.println("Bem vindo de volta " + program.nomeFuncionario(login, senha));
					while(processeguir == true) {
						processeguir = listaAdministrador();
					}
				}else {
					System.out.println("Login não efetuado");
				}
			}
		}
	}
	
	public static boolean listaAtendente (int funcionario) {
		System.out.println("Selecione uma opcao: ");
		System.out.println("1- Vincular-se a um pedido");
		System.out.println("2- Alterar status do pedido");
		System.out.println("3- Sair");
		int escolha = sc.nextInt(); sc.nextLine();
		int numPedido = 0;
		if(escolha == 1) {
			program.exibirPedidos();
			System.out.println("Escolha o nº do pedido:");
			numPedido = sc.nextInt(); sc.nextLine();
			program.vincularPedido(numPedido, funcionario);
			return true;
		}else if(escolha == 2) {
			program.exibirPedidos();
			numPedido = sc.nextInt(); sc.nextLine();
			return true;
		}else {
			System.out.println("Saindo...");
			return false;
		}
	}
	
	public static boolean listaAdministrador() throws ParseException {
		System.out.println("1- Cadastrar um atendente");
		System.out.println("2- Cadastrar uma categoria");
		System.out.println("3- Cadastrar um ingrediente");
		System.out.println("4- Cadastrar um produto");
		System.out.println("5- Cadastrar uma promocao");
		System.out.println("6- Vincular produto <-> ingrediente");
		System.out.println("7- Vincular produto -> categoria");
		System.out.println("8- Atualizar um atendente");
		System.out.println("9- Atualizar uma categoria");
		System.out.println("10- Atualizar um ingrediente");
		System.out.println("11- Atualizar um produto");
		System.out.println("12- Atualizar uma promocao");
		System.out.println("13- Atualzar produto <-> ingrediente");
		System.out.println("14- Atualizar produto -> categoria");
		System.out.println("15- Sair");
		int escolha = sc.nextInt(); sc.nextLine();
		switch(escolha) {
		case 1:
			System.out.println("Cadastrando um atendente");
			System.out.println("Informe o nome: ");
			String nome_atendente = sc.nextLine();
			System.out.println("Informe o status: ");
			String status_atendente = sc.nextLine();
			System.out.println("Informe o turno: ");
			String turno_atendente = sc.nextLine();
			System.out.println("Informe o login: ");
			String login_atendente = sc.nextLine();
			System.out.println("Informe a senha: ");
			String senha_atendente = sc.nextLine();
			program.cadastrarAtendente(nome_atendente, status_atendente, turno_atendente, login_atendente, senha_atendente);
			return true;
		case 2:
			System.out.println("Cadastrando uma categoria");
			System.out.println("Informe o nome: ");
			String nome_categoria = sc.nextLine();
			System.out.println("Informe a descricao: ");
			String descricao_categoria = sc.nextLine();
			program.cadastrarCategoria(nome_categoria, descricao_categoria);
			return true;
		case 3:
			System.out.println("Cadastrando um ingrediente");
			System.out.println("Informe o nome: ");
			String nome_ingrediente = sc.nextLine();
			System.out.println("Informe a unidade de medida: ");
			String unidade_ingrediente = sc.nextLine();
			System.out.println("Informe a validade: ");
			String validade_ingrediente = sc.nextLine();
			System.out.println("Informe o valor unitario: ");
			double valor_ingrediente = sc.nextDouble(); sc.nextLine();
			System.out.println("Informe a quantidade: ");
			int quantidade_ingrediente = sc.nextInt(); sc.nextLine();
			program.cadastrarIngrediente(nome_ingrediente, unidade_ingrediente, validade_ingrediente, valor_ingrediente, quantidade_ingrediente);
			return true;
		case 4:
			System.out.println("Cadastrando um produto");
			System.out.println("Informe o nome");
			String nome_produto = sc.nextLine();
			System.out.println("Informe o valor");
			double valor_produto = sc.nextDouble(); sc.nextLine();
			System.out.println("Informe o descricao");
			String descricao_produto = sc.nextLine();
			System.out.println("Informe o quantidade");
			int quantidade_produto = sc.nextInt(); sc.nextLine();
			System.out.println("Informe o data de fabricacao");
			String fabricacao_produto = sc.nextLine();
			program.exibirCategorias();
			System.out.println("Informe o ID da categoria");
			int categoria_produto = sc.nextInt(); sc.nextLine();
			program.cadastrarProduto(nome_produto, valor_produto, descricao_produto, quantidade_produto, fabricacao_produto, categoria_produto);
			return true;
		case 5:
			System.out.println("Cadastrando uma promocao");
			System.out.println("Informe o tipo: ");
			String tipo_promocao = sc.nextLine();
			System.out.println("Informe a validade: ");
			String validade_promocao = sc.nextLine();
			System.out.println("Informe o preco: ");
			double valor_promocao = sc.nextDouble(); sc.nextLine();
			System.out.println("Informe a descricao: ");
			String descricao_promocao = sc.nextLine();
			program.exibirProdutos();
			System.out.println("Informe o ID do produto: ");
			int produto_promocao = sc.nextInt(); sc.nextLine();
			program.cadastrarPromocao(tipo_promocao, validade_promocao, valor_promocao, descricao_promocao, produto_promocao);
			return true;
		case 6:
			System.out.println("Vinculando produto com ingrediente");
			return true;
		case 7:
			System.out.println("Vinculando produto com categoria");
			return true;
		case 8:
			System.out.println("Atualizando o atendente");
			return true;
		case 9:
			System.out.println("Atualizando a categoria");
			return true;
		case 10:
			System.out.println("Atualizando o ingrediente");
			return true;
		case 11:
			System.out.println("Atualizando o produto");
			return true;
		case 12:
			System.out.println("Atualizando a promocao");
			return true;
		case 13:
			System.out.println("Atualizando produto <-> ingrediente");
			return true;
		case 14:
			System.out.println("Atualizando produto <-> categoria");
			return true;
		case 15:
			return false;
		default:
			return false;
		}
	}
}
