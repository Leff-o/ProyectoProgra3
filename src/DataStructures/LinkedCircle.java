package DataStructures;

import java.util.Comparator;

public class LinkedCircle<T>{
	
	private Node<T> head;
	private Node<T> tail;
	

	private Comparator<T> comparator;
	
	public LinkedCircle(Comparator<T> comparator) {
		this.comparator = comparator;
	    head = null;
	    tail = null;
	}
	
	private boolean isEmpty() {
		return head == null;
	}
	
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
	
	public T getHead() {
		return head.getInfo();
	}
	
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
