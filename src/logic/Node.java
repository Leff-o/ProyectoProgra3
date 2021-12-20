package logic;

/**
 * Clase que permite crear un nodo para una lista circular
 * @param <T>
 */
public class Node<T> {
    private T info;
    private Node nextNode;

    /**
     * Constructor que define el nodo
     */
    public Node() {
        this.info = info;
        this.nextNode = null;
    }

    /**
     * Metodo que obtiene la informacion del nodo
     * @return info
     */
    public T getInfo() {
        return info;
    }

    /**
     * Metodo que trae la informacion del nodo para modificarse
     * @param info
     */
    public void setInfo(T info) {
        this.info = info;
    }

    /**
     * Metodo que obtiene el nodo siguiente
     * @return nextNode
     */
    public Node getNextNode() {
        return nextNode;
    }

    /**
     * Metodo que trae el nodo siguiente para modificarse
     * @param nextNode
     */
    public void setNextNode(Node nextNode) {
        this.nextNode = nextNode;
    }
}
