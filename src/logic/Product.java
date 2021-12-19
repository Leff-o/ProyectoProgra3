package logic;

public class Product {
    private long id;
    private String descripition;
    private double value;
    private String proveedor;
    private int stock;

    public Product(long id, String descripition, double value, String proveedor, int stock) {
        this.id = id;
        this.descripition = descripition;
        this.value = value;
        this.proveedor = proveedor;
        this.stock = stock;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescripition() {
        return descripition;
    }

    public void setDescripition(String descripition) {
        this.descripition = descripition;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
