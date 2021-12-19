package logic;

public class Node<T> {
    private T info;
    private Node nextNode;

    public Node() {
        this.info = info;
        this.nextNode = null;
    }

    public T getInfo() {
        return info;
    }

    public void setInfo(T info) {
        this.info = info;
    }

    public Node getNextNode() {
        return nextNode;
    }

    public void setNextNode(Node nextNode) {
        this.nextNode = nextNode;
    }
}
