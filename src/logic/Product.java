package logic;

import java.util.Comparator;

/**
 * Clase que define los atributos del producto a usar
 */
public class Product {
    private Long id;
    private String description;
    private double value;
    private String supplier;
    private int stock;

    /**
     * Define el Constructor con sus parametros
     * @param id
     * @param description
     * @param value
     * @param stock
     */
    public Product(Long id, String description, double value, String supplier, int stock) {
        this.id = id;
        this.description = description;
        this.value = value;
        this.supplier = supplier;
        this.stock = stock;
    }

    /**
     * Metodo get del id
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * Metodo set Id
     * @param id
     */
    public void setId(Long id) {
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
    
    public static Comparator<Product> compareHash = (product1, product2) ->  product1.getId().compareTo(product2.getId());
    /*
		si product1.hashCode() esta a la izquierda de product2.hashCode() retorna un numero negativo 
		si product1.hashCode() es igual a product2.hashCode() retorna 0
		si product1.hashCode() esta a la derecha de product2.hashCode() retorna un numero positivo
     */

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", value=" + value +
                ", supplier='" + supplier + '\'' +
                ", stock=" + stock +
                '}';
    }
}
