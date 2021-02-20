package app;

public class Employee {
  private String name;
  private String position;
  private int id;

  public Employee() {}

  public Employee(String name, String position, int id) {
    this.name = name;
    this.position = position;
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPosition() {
    return position;
  }

  public void setPosition(String position) {
    this.position = position;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public void view() {
    System.out.println("Visualizando estoque");
  }

}
