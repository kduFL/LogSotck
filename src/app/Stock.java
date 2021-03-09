import java.util.ArrayList;
import java.util.Scanner;

public class Stock {

    ArrayList<Item> stock = new ArrayList<Item>();

    public void stock() {
        
        getItems();

    }

    public void addItem(Scanner input) {
        Item item = new Item();
        
        System.out.print("ID: ");
        int id = input.nextInt();

        System.out.print("Marca: ");
        String brand = input.next();

        System.out.print("Quantidade: ");
        int quantity = input.nextInt();

        System.out.print("Data de Validade: ");
        String validity = input.next();

        System.out.print("Descrição: ");
        String description = input.next();

        System.out.print("Estado: ");
        String estado = input.next();

        item.createItem(id, brand, quantity, validity, description, estado);
        stock.add(item);
    }

    public void getItems() {
        System.out.println("");
        for (int i = 0; i < stock.size(); i++) {
            int id = stock.get(i).getId();
            String marca = stock.get(i).getBrand();
            int quantity = stock.get(i).getQuantity();
            String validity = stock.get(i).getValidity();
            String description = stock.get(i).getDescription();
            String estado = stock.get(i).getEstado();

            System.out.println("ID: " +id + " | Marca: " + marca + " | Quantidade: " + quantity + "x | Validade: " + validity + " | Descrição: " + description + " | Estado: " + estado + "\n");
        }
    }

    public void removeItem(Scanner input){
        System.out.print("\nID: ");
        int index = input.nextInt();

        for (int i = 0; i < stock.size(); i++) {
            int id = stock.get(i).getId();

            if (id == index) {
                stock.remove(i);
            }
        }
    }
}