import org.json.*;
import java.io.File;
import java.util.Scanner;
import java.util.Random;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Stock {
    JSONArray jsonList = new JSONArray();
    FileWriter writeFile = null;

    public void verificar() {
        File dataFile = new File("data.json");
        if (dataFile.exists()) {
            try {
                String testeList = new String(Files.readAllBytes(Paths.get("data.json")));
                JSONArray teste = new JSONArray(testeList);

                int size = teste.length();

                for (int i = 0; i < size; i++) {
                    jsonList.put(teste.getJSONObject(i));
                }

            } catch (Exception e) {
            }
        }
    }

    public void getItens() {
        int size = jsonList.length();
        for (int i = 0; i < size; i++) {
            JSONObject objeto = jsonList.getJSONObject(i);

            String marca = objeto.getString("marca");
            String estado = objeto.getString("estado");
            String id = objeto.getString("id");
            String quantidade = objeto.getString("quantidade");
            String validade = objeto.getString("validade");
            String descricao = objeto.getString("descricao");

            System.out.println("ID: " + id + "  |  Marca: " + marca + "  |  Descrição: " + descricao
                    + "  |  Quantidade: " + quantidade + "  |  Validade: " + validade + "  |  Estado: " + estado);
        }
    }

    public void addItem(Scanner input) {
        JSONObject item = new JSONObject();

        Random rand = new Random();
        int id = rand.nextInt(10000);

        System.out.println("\nDADOS DO ITEM\n");
        System.out.print("Marca: ");
        String brand = input.next();

        System.out.print("Quantidade: ");
        String quantity = input.next();

        System.out.print("Data de Validade: ");
        String validity = input.next();

        System.out.print("Descrição: ");
        String description = input.next();

        System.out.print("Estado: ");
        String estado = input.next();

        item.put("id", String.valueOf(id));
        item.put("marca", brand);
        item.put("quantidade", quantity);
        item.put("validade", validity);
        item.put("descricao", description);
        item.put("estado", estado);

        jsonList.put(item);

        try {
            writeFile = new FileWriter("data.json");
            writeFile.write(jsonList.toString(2));
            writeFile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void removeItem(Scanner input) {
        System.out.print("\nID: ");
        String id = input.next();

        int size = jsonList.length();
        Number index = null;
        for (int i = 0; i < size; i++) {
            JSONObject objeto = jsonList.getJSONObject(i);
            String idData = objeto.getString("id");
            System.out.println(idData);
            if (id.equals(idData)) {
                System.out.println("i: " + i);
                index = i;
            }
        }
        if (index != null) {
            jsonList.remove(index.intValue());
        }
    }
}
