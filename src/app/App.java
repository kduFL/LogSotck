// package app;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.InputMismatchException;
import java.io.IOException;

import java.io.File;

import java.nio.file.Files;
import java.nio.file.Paths;

import java.util.Scanner;

public class App {
	public static int position;

	public static void start(Scanner input) {
		try {
			System.out.println("\n1. Entrar\n2. Criar nova conta\n0. Sair");
			System.out.print("> ");
			int number = input.nextInt();

			if (number == 1) {
				login(input);

				// Stock stock = new Stock();

				// stock.addItem(input);
				// stock.getItems();

				// stock.removeItem(input);
				// stock.getItems();
			} else if (number == 2) {
				Account account = new Account();
				account.createAccount(input);
				start(input);

			} else if (number == 0) {
				System.out.println("\nSaindo...");
				System.exit(0);
			} else {
				System.out.println("Você digitou um número inválido. Tente novamente.\n");
				start(input);
			}
		} catch (InputMismatchException err) {
			System.out.println("Opss... Você digitou caractere.\n");
			input.nextLine(); // Limpa cache
			start(input);
		}
	}

	public static void login(Scanner input) {
		System.out.print("\nID: ");
		int userId = input.nextInt();

		checkUserDataExists(input, userId);
	}

	public static void menu(Scanner input) {
		Stock stock = new Stock();
		stock.verificar();

		while (true) {
			stock.getItens();

			if (position == 1) {
				System.out.println("\n1. Adicionar");
				System.out.println("2. Remover");
				System.out.println("3. Sair");
				System.out.print("> ");
				int i = input.nextInt();
				if (i == 1) {
					stock.addItem(input);
				} else if (i == 2) {
					stock.removeItem(input);
				} else if (i == 3) {
					System.out.println("\nSaindo...");
					System.exit(0);
				}
			} else if (position == 2) {
				System.out.println("\n1. Remover");
				System.out.println("2. Sair");
				System.out.print("> ");
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

	public static void checkUserDataExists(Scanner input, int id) {
		File file = new File("userData.json");

		if (file.exists()) {
			getUserData(input, id);
		} else {
			System.out.println(
					"\nOpss... Não temos nenhum usuário cadastrado no LogStock. \nVocê será redirecionado para tela inicial para realizar o cadastro.\n");
			start(input);
		}
	}

	public static void getUserData(Scanner input, int id) {
		try {
			String data = new String(Files.readAllBytes(Paths.get("userData.json")));

			JSONObject userData = new JSONObject(data);

			String idString = Integer.toString(id);

			JSONObject idData = userData.getJSONObject(idString);

			showUser(idData);

			menu(input);

		} catch (IOException err) {
			err.printStackTrace();
		} catch (JSONException err) {
			System.out.println("\nID não encontrado. \nVocê será redirecionado para tela inicial para realizar o cadastro.");
			start(input);
		}
	}

	public static void showUser(JSONObject idData) {
		System.out.println("\n\nUsuário: " + idData.getString("nome"));
		position = idData.getInt("cargo");

		if (position == 1) {
			System.out.println("Cargo: Gerente de Estoque\n");
		} else {
			System.out.println("Cargo: Auxiliar de Estoque\n");
		}

	}

	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);

		System.out.println("\n========== LogStock ==========");

		start(input);
	}
}
