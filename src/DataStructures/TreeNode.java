package DataStructures;

/**
 * The Class TreeNode.
 *
 * @param <T> the generic type
 */
public class TreeNode<T> {
	
	/** The info. */
	private T info;
	
	/** The height. */
	private int height;
	
	/** The left. */
	private TreeNode<T> left;
	
	/** The right. */
	private TreeNode<T> right;
	
	/**
	 * Instantiates a new tree node.
	 *
	 * @param info the info
	 */
	public TreeNode(T info) {
		this.info = info;
		height = 0;
		left = null;
		right = null;
	}
	
	/**
	 * Gets the info.
	 *
	 * @return the info
	 */
	public T getInfo() {
		return info;
	}
	
	/**
	 * Sets the info.
	 *
	 * @param info the new info
	 */
	public void setInfo(T info) {
		this.info = info;
	}
	
	/**
	 * Gets the height.
	 *
	 * @return the height
	 */
	public int getHeight() {
		return height;
	}
	
	/**
	 * Sets the height.
	 *
	 * @param height the new height
	 */
	public void setHeight(int height) {
		this.height = height;
	}
	
	/**
	 * Gets the left.
	 *
	 * @return the left
	 */
	public TreeNode<T> getLeft() {
		return left;
	}
	
	/**
	 * Sets the left.
	 *
	 * @param left the new left
	 */
	public void setLeft(TreeNode<T> left) {
		this.left = left;
	}
	
	/**
	 * Gets the right.
	 *
	 * @return the right
	 */
	public TreeNode<T> getRight() {
		return right;
	}
	
	/**
	 * Sets the right.
	 *
	 * @param right the new right
	 */
	public void setRight(TreeNode<T> right) {
		this.right = right;
	}
	
	

}
