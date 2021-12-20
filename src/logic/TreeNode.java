package logic;

/**
 * Clase que permite crear el nodo que se utilizara en la clase {@link BinaryTree}
 * @param <T>
 */
public class TreeNode <T>{
    private T info;
    private int height;
    private TreeNode<T> left;
    private TreeNode<T> right;

    /**
     * Constructor de la clase, inicializando ciertos atributos de esta
     * @param info
     */
    public TreeNode(T info) {
        this.info = info;
        height = 0;
        left = null;
        right = null;
    }

    /**
     * Metodo que obtiene el valor de la informacion
     * @return info
     */
    public T getInfo() {
        return info;
    }

    /**
     * Metodo que trae la informacion del nodo para modificarla
     * @param info
     */
    public void setInfo(T info) {
        this.info = info;
    }

    /**
     * Metodo que obtiene el valor la izquierda del arbol
     * @return
     */
    public TreeNode<T> getLeft() {
        return left;
    }

    /**
     * Metodo que trae el valor izquierdo del arbol para modificarse
     * @param left
     */
    public void setLeft(TreeNode<T> left) {
        this.left = left;
    }

    /**
     * Metodo que obtiene el valor de la derecha del arbol
     * @return right
     */
    public TreeNode<T> getRight() {
        return right;
    }

    /**
     * Metodo que trae el valor derecho del arbol para modificarse
     * @param right
     */
    public void setRight(TreeNode<T> right) {
        this.right = right;
    }

    /**
     * Metodo que obtiene el valor de la altura con un contador
     * @return height
     */
    public int getHeight() {
        return height;
    }

    /**
     * Metodo que trae el valor de la altura para modificarse
     * @param height
     */
    public void setHeight(int height) {
        this.height = height;
    }
}