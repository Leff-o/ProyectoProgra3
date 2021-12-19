package logic;

public class TreeNode <T>{
    private T info;
    private int height;
    private TreeNode<T> left;
    private TreeNode<T> right;

    public TreeNode(T info) {
        this.info = info;
        height = 0;
        left = null;
        right = null;
    }

    public T getInfo() {
        return info;
    }

    public void setInfo(T info) {
        this.info = info;
    }

    public TreeNode<T> getLeft() {
        return left;
    }

    public void setLeft(TreeNode<T> left) {
        this.left = left;
    }

    public TreeNode<T> getRight() {
        return right;
    }

    public void setRight(TreeNode<T> right) {
        this.right = right;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}