import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

import org.json.JSONException;
import org.json.JSONObject;

public class Login {
	private int cargo;
	private String nome;

	public Login() {
	}

	public boolean getIn(Scanner input) {
		System.out.print("\nSeu ID: ");
		int userId = input.nextInt();

		return validation(userId);
	}

	public boolean validation(int userId) {
		File file = new File("userData.json");
		if (file.exists()) {
			return getUserData(userId);
		} else {
			System.out.println("\nOpss... Não temos nenhum usuário cadastrado no LogStock.");
			return false;
		}
	}

	public boolean getUserData(int userId) {
		try {
			String data = new String(Files.readAllBytes(Paths.get("userData.json")));
			JSONObject userData = new JSONObject(data);
			String idString = Integer.toString(userId);
			JSONObject idData = userData.getJSONObject(idString);

			this.cargo = idData.getInt("cargo");
			this.nome = idData.getString("nome");

			showUser();
			return true;
		} catch (IOException err) {
			err.printStackTrace();
			return false;
		} catch (JSONException err) {
			System.out.println("\nID não encontrado, tente novamente!");
			return false;
		}
	}

	public int getCargo() {
		return this.cargo;
	}

	public void showUser() {
		System.out.println("\nNome: " + this.nome);

		if (this.cargo == 1) {
			System.out.println("Cargo: Gerente\n");
		} else if (this.cargo == 2) {
			System.out.println("Cargo: Assistente\n");
		}
	}
}