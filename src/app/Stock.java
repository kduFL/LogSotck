public class Stock {
    private int id;
    private String brand;
    private int quantity;
    private String validity;
    private String description;
    private String estado;

    public Stock() {
    }

    public Stock(int id, String brand, int quantity, String validity, String description, String estado) {
        this.id = id;
        this.brand = brand;
        this.quantity = quantity;
        this.validity = validity;
        this.description = description;
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getValidity() {
        return validity;
    }

    public void setValidity(String validity) {
        this.validity = validity;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}