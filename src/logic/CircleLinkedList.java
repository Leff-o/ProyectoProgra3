package logic;

/**
 * Clase que permite crear una lista circular sencilla
 * @param <T>
 */
public class CircleLinkedList<T> {
    private Node<T> head;
    private Node<T> tail;

    /**
     * Constructor que permite crear e inicializar algunos atributos
     * @param info
     */
    public CircleLinkedList() {
        this.head = null;
        this.tail = null;
    }

    /**
     * Este metodo permite saber si la lista esta vacia o no
     * @return head == null
     */
    public boolean isEmpty(){
        return head == null;
    }
    
    /**
	 * Este metodo permite agregar nodos a la lista circular
	 * @param info
	 */
    public void addNode(T info) {
	    Node<T> newNode = new Node<T>(info);
	    if (head == null) {
	        head = newNode;
	        tail.setNextNode(head);
	    } else {
	        tail.setNextNode(newNode);
	        tail = newNode;
	    }
	}
    
    /**
	 * Este metodo permite borrar un nodo, de acuerdo a la informacion obtenida
	 * @param info
	 */
	public void deleteNode(T info) {
	    Node<T> currentNode = head;
	    if (head == null) { // the list is empty
	        return;
	    }
	    do {
	        Node<T> nextNode = currentNode.getNextNode();
	        if (nextNode.getInfo() == info) {
	            if (tail == head) { // the list has only one single element
	                head = null;
	                tail = null;
	            } else {
	                currentNode.setNextNode(nextNode.getNextNode());
	                if (head == nextNode) { //we're deleting the head
	                    head = head.getNextNode();
	                }
	                if (tail == nextNode) { //we're deleting the tail
	                    tail = currentNode;
	                }
	            }
	            break;
	        }
	        currentNode = nextNode;
	    } while (currentNode != head);
	}
    
    /**
     * Metodo que obtiene el valor de la cabeza de la lista
     * @return head
     */
    public Node<T> getHead() {
        return head;
    }

    /**
     * Metodo que trae el valor de la cabeza de la lista para modificarlo
     * @param head
     */
    public void setHead(Node<T> head) {
        this.head = head;
    }

    /**
     * Metodo que obtiene el valor del ultimo en la lista
     * @return tail
     */
    public Node<T> getTail() {
        return tail;
    }

    /**
     * Metodo que trae el valor del ultimo en la lista para modificarse
     * @param tail
     */
    public void setTail(Node<T> tail) {
        this.tail = tail;
    }
}
