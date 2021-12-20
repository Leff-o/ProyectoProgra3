package logic;

/**
 * Clase que define los atributos del producto a usar
 */
public class Product {
    private long id;
    private String description;
    private double value;
    private String supplier;
    private int stock;

    /**
     * Define el Constructor con sus parametros
     * @param id
     * @param description
     * @param value
     * @param proveedor
     * @param stock
     */
    public Product(long id, String description, double value, String proveedor, int stock) {
        this.id = id;
        this.description = description;
        this.value = value;
        this.supplier = proveedor;
        this.stock = stock;
    }

    /**
     * Metodo get del id
     * @return id
     */
    public long getId() {
        return id;
    }

    /**
     * Metodo set Id
     * @param id
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * Metodo get de la descripcion del producto
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Metodo set de la descripcion
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Metodo que trae el valor del producto
     * @return value
     */
    public double getValue() {
        return value;
    }

    /**
     * Metodo que trae el valor para cambiarlo
     * @param value
     */
    public void setValue(double value) {
        this.value = value;
    }

    /**
     * Metodo que trae el valor del proveedor
     * @return supplier
     */
    public String getSupplier() {
        return supplier;
    }

    /**
     * Metodo que trae el valor del proveedor para modificarlo
     * @param supplier
     */
    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    /**
     * Metodo que trae el valor del stock del inventario
     * @return stock
     */
    public int getStock() {
        return stock;
    }

    /**
     * Metodo que trae el stock del inventario para modificarlo
     * @param stock
     */
    public void setStock(int stock) {
        this.stock = stock;
    }
}
