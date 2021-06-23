package application;

import java.util.Scanner;

import model.entities.Pedido;

public class Face {
	static Scanner sc = new Scanner(System.in);
	static Program program = new Program();
	public static void main(String args[]) {
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
	
	public static boolean listaAdministrador() {
		System.out.println("1- Cadastrar um atendente");
		System.out.println("2- Cadastrar uma categoria");
		System.out.println("3- Cadastrar um ingrediente");
		System.out.println("4- Cadastrar um produto");
		System.out.println("5- Cadastrar uma promocao");
		System.out.println("6- Cadastrar uma categoria");
		System.out.println("7- Vincular produto <-> ingrediente");
		System.out.println("8- Atualizar um atendente");
		System.out.println("9- Atualizar uma categoria");
		System.out.println("10- Atualizar um ingrediente");
		System.out.println("11- Atualizar um produto");
		System.out.println("12- Atualizar uma promocao");
		System.out.println("13- Atualizar uma categoria");
		System.out.println("14- Atualzar produto <-> ingrediente");
		System.out.println("15- Sair");
		int escolha = sc.nextInt();
		switch(escolha) {
		case 1:
			System.out.println("Informe o nome: ");
			String nome = sc.nextLine();
			System.out.println("Informe o status: ");
			String status = sc.nextLine();
			System.out.println("Informe o turno: ");
			String turno = sc.nextLine()
			System.out.println("Informe o login: ");
			String login = sc.nextLine();
			System.out.println("Informe a senha: ");
			String senha = sc.nextLine();
			return true;
		case 2:
			return true;
		case 3:
			return true;
		case 4:
			return true;
		case 5:
			return true;
		case 6:
			return true;
		case 7:
			return true;
		case 8:
			return true;
		case 9:
			return true;
		case 10:
			return true;
		case 11:
			return true;
		case 12:
			return true;
		case 13:
			return true;
		case 14:
			return true;
		case 15:
			return false;
		default:
			return false;
		}
	}
}
