package DataStructures;

import java.util.Comparator;

/**
 * Clase que permite crear una lista circular sencilla
 * @param <T>
 */
public class LinkedCircle<T>{
	private Node<T> head;
	private Node<T> tail;
	private Comparator<T> comparator;

	/**
	 * Constructor que permite crear e inicializar algunos atributos
	 * @param comparator
	 */
	public LinkedCircle(Comparator<T> comparator) {
		this.comparator = comparator;
	    head = null;
	    tail = null;
	}

	/**
	 * Este metodo permite saber si la lista esta vacia o no
	 * @return head == null
	 */
	private boolean isEmpty() {
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
	        tail.setNext(head);
	    } else {
	        tail.setNext(newNode);
	        tail = newNode;
	    }
	}

	/**
	 * Metodo que obtiene el valor de la cabeza de la lista
	 * @return head
	 */
	public T getHead() {
		return head.getInfo();
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
	        Node<T> nextNode = currentNode.getNext();
	        if (nextNode.getInfo() == info) {
	            if (tail == head) { // the list has only one single element
	                head = null;
	                tail = null;
	            } else {
	                currentNode.setNext(nextNode.getNext());
	                if (head == nextNode) { //we're deleting the head
	                    head = head.getNext();
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
}
