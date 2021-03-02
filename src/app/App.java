package app;

import java.util.Random;
import java.util.Scanner;

public class App {

		public static void start(Scanner input){
			System.out.println("\n1. Entrar\n2. Criar nova conta");
			int number = input.nextInt();

			if(number == 1) {
				System.out.println("Logado");
			} else if( number == 2) {
				createAccount(input);
				start(input);
			}
		}

		public static void createAccount(Scanner input) {
			System.out.println("\n\nCriar sua conta\n");
			System.out.println("Você é: \n  1. Gerente de Estoque\n  2. Auxiliar de Estoque");
			int job = input.nextInt();

			if(job == 1) {
				Manager manager = new Manager();

				registerEmployee(input, manager);
			} else if( job == 2) {
				// a função recebe objeto assistente
				System.out.println("Assistente");
			}
		}

		public static void registerEmployee(Scanner input, Employee employee) {
				System.out.println("\n\n===== Cadastro =====");
				
				System.out.println("\nDigite seu nome: ");
				employee.setName(input.next());
				
				System.out.println("\nDigite seu cargo: ");
				employee.setPosition(input.next());
				
				int id = createID();

				employee.setId(id);

				System.out.println("\n\nSeu ID para entrar na plataforma: " + employee.getId());

				System.out.println("\nCadastro realizado com sucesso!\n\n");

				System.out.println("\nVocê será redirecionado para tela inicial.\n");

				// System.out.println(employee.getName() + " " + employee.getId() + " "+ employee.getPosition());
		}

		public static int createID() {
			Random rand = new Random();

			return rand.nextInt(10000);
		}

    public static void main(String[] args) throws Exception {
			Scanner input = new Scanner(System.in);
			
			System.out.println("\n========== LogStock ==========");

			start(input);
    }
}
