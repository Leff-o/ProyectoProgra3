package logic;

/**
 * Clase que permite crear una lista circular sencilla
 * @param <T>
 */
public class CircleLinkedList<T> {
    private Node head;
    private Node tail;

    /**
     * Constructor que permite crear e inicializar algunos atributos
     * @param info
     */
    public CircleLinkedList(T info) {
        this.head = head;
        this.tail = tail;
    }

    /**
     * Este metodo permite saber si la lista esta vacia o no
     * @return head == null
     */
    private boolean isEmpty(){
        return head == null;
    }

    /**
     * Metodo que obtiene el valor de la cabeza de la lista
     * @return head
     */
    public Node getHead() {
        return head;
    }

    /**
     * Metodo que trae el valor de la cabeza de la lista para modificarlo
     * @param head
     */
    public void setHead(Node head) {
        this.head = head;
    }

    /**
     * Metodo que obtiene el valor del ultimo en la lista
     * @return tail
     */
    public Node getTail() {
        return tail;
    }

    /**
     * Metodo que trae el valor del ultimo en la lista para modificarse
     * @param tail
     */
    public void setTail(Node tail) {
        this.tail = tail;
    }
}
