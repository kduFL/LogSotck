// package app;

public abstract class Employee {
  private String name;
  private int position;
  private int id;

  public Employee() {}

  public Employee(String name, int position, int id) {
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

  public int getPosition() {
    return position;
  }

  public void setPosition(int position) {
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
