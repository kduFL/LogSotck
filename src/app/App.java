// package app;

import java.util.InputMismatchException;

import java.util.Scanner;

public class App {
	public static void menu(Scanner input, int cargo) {
		Stock stock = new Stock();
		stock.verificar();
		while (true) {
			stock.getItens();

			if (cargo == 1) {
				System.out.println("\n1. Adicionar");
				System.out.println("2. Remover");
				System.out.println("3. Sair");
				System.out.print("\n> ");
				int i = input.nextInt();
				if (i == 1) {
					stock.addItem(input);
				} else if (i == 2) {
					stock.removeItem(input);
				} else if (i == 3) {
					System.out.println("\nSaindo...");
					System.exit(0);
				}
			} else if (cargo == 2) {
				System.out.println("\n1. Remover");
				System.out.println("2. Sair");
				System.out.print("\n> ");
				int i = input.nextInt();
				if (i == 1) {
					stock.removeItem(input);
				} else if (i == 2) {
					System.out.println("\nSaindo...");
					System.exit(0);
				}
			}
		}
	}

	public static void start(Scanner input) {
		try {
			System.out.println("\n1. Entrar \n2. Criar nova conta \n0. Sair");
			System.out.print("\n> ");
			int number = input.nextInt();

			if (number == 1) {
				Login login = new Login();
				while (true) {
					boolean access = login.getIn(input);
					int cargo = login.getCargo();
					if (access) {
						menu(input, cargo);
					}
				}
			} else if (number == 2) {
				Account account = new Account();
				account.createAccount(input);
				start(input);
			} else if (number == 0) {
				System.out.println("\nSaindo...");
				System.exit(0);
			} else {
				System.out.println("\nVocê digitou um número inválido. Tente novamente.\n");
				start(input);
			}
		} catch (InputMismatchException err) {
			System.out.println("\nOpss... Você digitou caractere, digite um número.\n");
			input.nextLine();
			start(input);
		}

	}

	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		System.out.println("\n========== LogStock ==========");

		start(input);
	}
}