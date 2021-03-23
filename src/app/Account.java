import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import java.nio.file.Files;
import java.nio.file.Paths;

import java.util.InputMismatchException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

import org.json.*;

public class Account {
  private int job;
  private int id;

  public Account() {}

  public void createAccount(Scanner input) {
    System.out.println("\nCriar sua conta\n");
		System.out.print("Você é: \n  1. Gerente de Estoque\n  2. Auxiliar de Estoque \n\n> ");

    try {
			this.job = input.nextInt();

			if (job == 1) {
				Employee manager = new Employee();

				registerEmployee(input, manager, job);
			} else if (job == 2) {
				Employee auxiliary = new Employee();

				registerEmployee(input, auxiliary, job);
			} else {
				System.out.println("\nOps... Você digitu o número errado. Digite apenas 1. Gerente ou 2. Assistente.\n");
			}
		} catch (InputMismatchException err) {
			System.out.println("\nOps... Você digitou um caractere. Digite apenas 1. Gerente ou 2. Assistente.");
			input.nextLine(); // Esvazia buffer do input
		}

  }

  public void registerEmployee(Scanner input, Employee employee, int job) {
		input.nextLine(); // Esvazia buffer do teclado para usar o nextLine nos próximos inputs

		System.out.println("\n\n===== Cadastro =====");

		System.out.print("\nDigite seu nome: ");
		employee.setName(input.nextLine());

		employee.setPosition(job);

		this.id = createID();

		employee.setId(id);

		saveDate(employee);

		System.out.println("\nCadastro realizado com sucesso!\n");

		System.out.println("\nGuarde seu ID para entrar na plataforma: " + employee.getId());
	}

  public static int createID() {
		Random rand = new Random();

		return rand.nextInt(10000);
	}

  public static void saveDate(Employee employee) {
		File dataFile = new File("userData.json");

		if (dataFile.exists()) {
			try {
				String jsonFile = new String(Files.readAllBytes(Paths.get("userData.json")));

				JSONObject userData = new JSONObject(jsonFile);

				addDataToFile(userData, employee);

			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			JSONObject userData = new JSONObject();

			addDataToFile(userData, employee);
		}
  }

  public static void addDataToFile(JSONObject userData, Employee employee) {

		try {
			Map data = new LinkedHashMap<>(2);

			data.put("nome", employee.getName());
			data.put("cargo", employee.getPosition());

			userData.put(Integer.toString(employee.getId()), data);

			FileWriter file = new FileWriter("userData.json");

			file.write(userData.toString(2));
			file.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
