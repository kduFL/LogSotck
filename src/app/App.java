// package app;

import java.util.Random;
import java.util.Scanner;

public class App {

		public static void start(Scanner input){
			System.out.println("\n1. Entrar\n2. Criar nova conta");
			int number = input.nextInt();

			if(number == 1) {
				login(input);
			} else if( number == 2) {
				createAccount(input);
				start(input);
			}
		}

		public static void login(Scanner input) {
			int login = 123;
			String pass = "123";

			System.out.print("ID: ");
			int id = input.nextInt();

			System.out.print("Senha: ");
			String password = input.next();
			

			if ((id == login) && (password.equals(pass))) {
				System.out.print("Logado");
			} else {
				System.out.println("Senha errada!");
				login(input);
			}
		}

		public static void createAccount(Scanner input) {
			System.out.println("\n\nCriar sua conta\n");
			System.out.println("Você é: \n  1. Gerente de Estoque\n  2. Auxiliar de Estoque");
			int job = input.nextInt();

			if(job == 1) {
				Manager manager = new Manager();

				registerEmployee(input, manager, job);
			} else if( job == 2) {
				System.out.println("Assistente");
			}
		}

		public static void registerEmployee(Scanner input, Employee employee, int job) {
				input.nextLine(); //Esvazia buffer do teclado para usar o nextLine nas próximos inputs

				System.out.println("\n\n===== Cadastro =====");
				
				System.out.println("\nDigite seu nome: ");
				employee.setName(input.nextLine());
				
				employee.setPosition(job);
				
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
