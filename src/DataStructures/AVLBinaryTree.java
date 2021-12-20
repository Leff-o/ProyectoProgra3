package DataStructures;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * The Class AVLBinaryTree.
 *
 * @param <T> the generic type
 */
public class AVLBinaryTree<T> {
	
	/** The comparator. */
	private Comparator<T> comparator;
	
	/** The root. */
	private TreeNode<T> root;
	
	/**
	 * Instantiates a new AVL binary tree.
	 *
	 * @param comparator the comparator
	 */
	public AVLBinaryTree(Comparator<T> comparator) {
		this.comparator = comparator;
	}
	
	/**
	 * Gets the list.
	 *
	 * @return the list
	 */
	public ArrayList<T> getList(){
		if (!isEmpty()) {
			return inorder(root);
		}
		
		return new ArrayList<T>();
	}
	
	/**
	 * Inorder.
	 *
	 * @param node the node
	 * @return the array list
	 */
	private ArrayList<T> inorder(TreeNode<T> node) {
		ArrayList<T> data = new ArrayList<T>();
		ArrayList<T> miniData;
		if (node.getLeft()!=null) {
			miniData = inorder(node.getLeft());
			data.addAll(miniData);
		}
		data.add(node.getInfo());
		if (node.getRight()!=null) {
			miniData = inorder(node.getRight());
			data.addAll(miniData);
		}
	    return data;
	}
	
	/**
	 * Gets the draw map.
	 *
	 * @return the draw map
	 */
	public ArrayList<ArrayList<T>> getDrawMap(){
		ArrayList<ArrayList<T>> data = new ArrayList<ArrayList<T>>();
		for (int i = 0; i < root.getHeight()+1; i++) {//la altura de la raiz es 0 por ello se le suma 1
			data.add(new ArrayList<T>());
			for (int j = 0; j < weightTree(); j++) {//cuantos nodos tiene el arbol
				data.get(i).add(null);
			}
		}
		return createDawMap(root, 0, data, 1);
	}
	
	
	/**
	 * Creates the daw map.
	 *
	 * @param node  the node
	 * @param extra the extra
	 * @param map   the map
	 * @param lvl   the lvl
	 * @return the array list
	 */
	private ArrayList<ArrayList<T>> createDawMap(TreeNode<T> node, int extra, ArrayList<ArrayList<T>> map, int lvl){
		if (node != null) {
			int j = weight(node.getLeft())+extra;//peso
			int i = lvl-1;//altura/nivel
			ArrayList<T> row = map.get(i);
			row.add(j, node.getInfo());
			row.remove(j+1);
			map.add(i, row);
			map.remove(i+1);
			map = createDawMap(node.getLeft(), extra, map, lvl+1);
			map = createDawMap(node.getRight(), weight(node.getLeft())+1+extra, map, lvl+1);//el peso de un nodo en especifico no incliye
																								//a si mismo por ende +1
			
		}
		return map;
	}
	
	/**
	 * Gets the root.
	 *
	 * @return the root
	 */
	public TreeNode<T> getRoot() {
        return root;
    }
	
	/**
	 * Checks if is empty.
	 *
	 * @return true, if is empty
	 */
	public boolean isEmpty() {
		return root==null;
	}
	
	/**
	 * Adds the node.
	 *
	 * @param info the info
	 */
	public void addNode(T info) {
        root = insert(root, info);
    }
	
	/**
	 * Insert.
	 *
	 * @param node the node
	 * @param info the info
	 * @return the tree node
	 */
	private TreeNode<T> insert(TreeNode<T> node, T info) {
        if (node == null) {
            return new TreeNode<T>(info);
        } else if (comparator.compare((T) node.getInfo(), (T) info) > 0) {
            node.setLeft(insert(node.getLeft(), info));
        } else if (comparator.compare((T) node.getInfo(), (T) info) < 0) {
            node.setRight(insert(node.getRight(), info));
        } else {
            throw new RuntimeException("duplicate info!");
        }
        return rebalance(node);
    }

    /**
	 * Find node.
	 *
	 * @param info the info
	 * @return the tree node
	 */
    public TreeNode<T> findNode(T info) {
        TreeNode<T> current = root;
        while (current != null) {
            if (comparator.compare((T)current.getInfo(),(T) info)==0) {
               break;
            }
            current =  comparator.compare((T)current.getInfo(), (T)info) < 0  ? current.getRight() : current.getLeft();
        }
        return current;
    }
    
    /**
	 * Height tree.
	 *
	 * @return the int
	 */
    public int heightTree() {
        return isEmpty() ? -1 : root.getHeight();
    }
    
    /**
	 * Height node.
	 *
	 * @param node the node
	 * @return the int
	 */
    private int heightNode(TreeNode<T> node) {
        return node == null ? -1 : node.getHeight();
    }
    
    /**
	 * Weight tree.
	 *
	 * @return the int
	 */
    public int weightTree() {
    	return weight(root);
    }
    
    /**
	 * Weight.
	 *
	 * @param node the node
	 * @return the int
	 */
    private int weight(TreeNode<T> node) {
    	int counter = 0;
    	if (node != null) {
    		if (node.getLeft()!=null) {
    			counter += weight(node.getLeft());
    		}
    		counter++;
    		if (node.getRight()!=null) {
    			counter += weight(node.getRight());
    		}
		}
	    return counter;
    }

    /**
	 * Delete node.
	 *
	 * @param info the info
	 */
    public void deleteNode(T info) {
    	
        root = delete(root, info);
    }

    /**
	 * Delete.
	 *
	 * @param node the node
	 * @param info the info
	 * @return the tree node
	 */
    private TreeNode<T> delete(TreeNode<T> node, T info) {
        if ((node == null)) {												  // case 0 no hay raiz o no hya sub arbol
            return node;
        } else if (comparator.compare((T) node.getInfo(), (T) info) > 0) {// desplazamiento por izquierda + recursividad
            node.setLeft(delete(node.getLeft(), info));
        } else if (comparator.compare((T) node.getInfo(), (T) info) < 0) {// desplazamiento por derecha + recursividad
            node.setRight(delete(node.getRight(), info));
        } else if (node.getLeft() == null || node.getRight() == null) {	  // case 1 no hay hijos(es hoja) || case 2 un solo hijo
            node = (node.getLeft() == null) ? node.getRight() : node.getLeft();
        } else {														  // case 3 2 hijos
            TreeNode<T> mostLeftChild = mostLeftChild(node.getRight());
            node.setInfo(mostLeftChild.getInfo());
            node.setRight(delete(node.getRight(), node.getInfo()));
        }
        
        if (node != null) {
            node = rebalance(node);
        }
        return node;
    }

    /**
	 * Most left child.
	 *
	 * @param node the node
	 * @return the tree node
	 */
    private TreeNode<T> mostLeftChild(TreeNode<T> node) {
        TreeNode<T> current = node;
        /* loop down to find the leftmost leaf */
        while (current.getLeft() != null) {
            current = current.getLeft();
        }
        return current;
    }

    /**
	 * Rebalance.
	 *
	 * @param node the node
	 * @return the tree node
	 */
    private TreeNode<T> rebalance(TreeNode<T> node) {
        updateHeight(node);
        int balance = getBalance(node);
        if (balance > 1) {
            if (heightNode(node.getRight().getRight()) > heightNode(node.getRight().getLeft())) {
                node = rotateLeft(node);
            } else {
                node.setRight(rotateRight(node.getRight()));
                node = rotateLeft(node);
            }
        } else if (balance < -1) {
            if (heightNode(node.getLeft().getLeft()) > heightNode(node.getLeft().getRight())) {
                node = rotateRight(node);
            } else {
                node.setLeft(rotateLeft(node.getLeft()));
                node = rotateRight(node);
            }
        }
        return node;
    }

    /**
	 * Rotate right.
	 *
	 * @param y the y
	 * @return the tree node
	 */
    private TreeNode<T> rotateRight(TreeNode<T> y) {
        TreeNode<T> x = y.getLeft();
        TreeNode<T> z = x.getRight();
        x.setRight(y);
        y.setLeft(z);
        updateHeight(y);
        updateHeight(x);
        return x;
    }

    /**
	 * Rotate left.
	 *
	 * @param y the y
	 * @return the tree node
	 */
    private TreeNode<T> rotateLeft(TreeNode<T> y) {
        TreeNode<T> x = y.getRight();
        TreeNode<T> z = x.getLeft();
        x.setLeft(y);
        y.setRight(z);
        updateHeight(y);
        updateHeight(x);
        return x;
    }

    /**
	 * Update height.
	 *
	 * @param node the node
	 */
    private void updateHeight(TreeNode<T> node) {
        node.setHeight(1 + Math.max(heightNode(node.getLeft()), heightNode(node.getRight())));
    }
    
    /**
	 * Gets the balance.
	 *
	 * @param node the node
	 * @return the balance
	 */
    public int getBalance(TreeNode<T> node) {
        return (node == null) ? 0 : heightNode(node.getRight()) - heightNode(node.getLeft());
    }
	
}
