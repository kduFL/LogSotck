package app;

public class Manager extends Employee {
  
  public Manager() {}

  public Manager(String name, String position, int id) {
    super();
  }
  
  public void add() {
    System.out.println("Adicionou produto");
  }
  
  public void edit() {
    System.out.println("Editou o produto");
  }

  public void remove() {
    System.out.println("Removeu produto");
  }

  public void view() {
    System.out.println("Visualizou produto");
  }


}
