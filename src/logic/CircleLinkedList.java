package logic;

public class CircleLinkedList<T> {
    private Node head;
    private Node tail;

    public CircleLinkedList(T info) {
        this.head = head;
        this.tail = tail;
    }

    private boolean isEmpty(){
        return head == null;
    }

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public Node getTail() {
        return tail;
    }

    public void setTail(Node tail) {
        this.tail = tail;
    }
}
