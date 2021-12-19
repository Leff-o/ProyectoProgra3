package logic;

public class Product {
    private long id;
    private String description;
    private double value;
    private String supplier;
    private int stock;

    public Product(long id, String description, double value, String proveedor, int stock) {
        this.id = id;
        this.description = description;
        this.value = value;
        this.supplier = proveedor;
        this.stock = stock;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
