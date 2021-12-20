package logic;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Comparator;

/**
 * BinaryTree
 * Esta es la clase que define el árbol binario junto a sus respectivos métodos de búsqueda y balanceo
 */
public class BinaryTree<T> {
    private TreeNode<T> root;
    private Comparator<T> comparator;
    private ArrayList<T> out;
    private int cont;

    public BinaryTree(Comparator<T> comparator) {
        this.comparator = comparator;
        root = null;
    }

    /**
     * Checks if is empty.
     *
     * @return true, if is empty
     */

    public boolean isEmpty() {
        return root == null;
    }

    /**
     *  addNode
     * @param info
     * Esta clase se encarga de agregar nodos al árbol binario
     */

    public void addNode(T info) {
        TreeNode<T> node = new TreeNode<>(info);
        if (isEmpty()) {
            root = node;
        } else {
            TreeNode<T> aux = root;
            TreeNode<T> previuos = null;
            while (aux != null) {
                previuos = aux;
                aux = comparator.compare(info, aux.getInfo()) < 0 ? aux.getLeft() : aux.getRight();
            }
            if (comparator.compare(info, previuos.getInfo()) < 0) {
                previuos.setLeft(node);
            } else {
                previuos.setRight(node);
            }
        }
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
     * Adds the node.
     *
     * @param info the info
     */
    public void addNode2(T info) {
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
        TreeNode<T> aux = root;
        while (aux != null) {
            if (comparator.compare(info, aux.getInfo()) == 0) {
                return aux;
            }
            aux = comparator.compare(info, aux.getInfo()) < 0 ? aux.getLeft() : aux.getRight();
        }
        return null;
    }

    /**
     * listPresort
     * Este método retorna un arraylist con la lista en preorden
     * @return out
     */

    public ArrayList<T> listPresort() {
        out = new ArrayList<>();
        presort(root);

        return out;
    }

    /**
     * presort
     * @param root
     * método que se encarga de realizar el ordenamiento en pre ordene
     */
    private void presort(TreeNode<T> root) {
        if (root != null) {
            out.add(root.getInfo());
            presort(root.getLeft());
            presort(root.getRight());
        }
    }

    /**
     * listInsort
     * Método que retorna la lista de los nodos en orden inorden
     * @return out
     */
    public ArrayList<T> listInsort() {
        out = new ArrayList<>();
        insort(root);

        return out;
    }

    /**
     * insort
     * @param root
     * Método encargado
     */
    private void insort(TreeNode<T> root) {
        if (root != null) {
            insort(root.getLeft());
            out.add(root.getInfo());
            insort(root.getRight());
        }
    }

    /**
     *listPosort
     * Este método se encarga de mostrar un arrayList con los nodos puestos en Posort
     *
     * @return out
     */
    public ArrayList<T> listPosort() {
        out = new ArrayList<>();
        posort(root);

        return out;
    }

    /**
     * posort
     * @param root
     * Esta funcion se encarga de ordenar el arbol en posort
     */
    private void posort(TreeNode<T> root) {
        if (root != null) {
            posort(root.getLeft());
            posort(root.getRight());
            out.add(root.getInfo());
        }
    }

    /**
     * listAmplitude
     * Este método se encarga de mostrar un arrayList con la amplitud de la lista
     * @return out
     */
    public ArrayList<T> listAmplitude() {
        out = new ArrayList<>();
        ArrayDeque<TreeNode> tail = new ArrayDeque<>();
        tail.addLast(root);
        while (!tail.isEmpty()) {
            TreeNode<T> aux = tail.pop();
            if (aux.getLeft() != null) {
                tail.addLast(aux.getLeft());
            }
            if (aux.getRight() != null) {
                tail.addLast(aux.getRight());
            }
            out.add(aux.getInfo());
        }
        return out;
    }

    /**
     *
     * @param node
     * Este metodo se encarga rectificar si un nodo es una hoja.
     * @return node
     */
    public boolean isLeaf(TreeNode<T> node) {
        return node.getRight() == null && node.getLeft() == null;
    }


    /**
     * findFather
     * @param node
     *
     * El método se encarga de encontrar el nodo padre
     * @return
     */
    public TreeNode<T> findFather(TreeNode<T> node) {
        if (node == root) {
            return null;
        } else {
            TreeNode<T> aux = root;
            while (aux.getLeft() != node && aux.getRight() != node) {
                aux = comparator.compare(node.getInfo(), aux.getInfo()) < 0 ? aux.getLeft() : aux.getRight();
            }
            return aux;
        }
    }

    /**
     * levelNode.
     *
     * @param node the node
     * Este método se encarga de devolvernos un entero con el nivel del Nodo
     * @return node
     */
    public int levelNode(TreeNode<T> node) {
        return node == root ? 0 : levelNode(findFather(node)) + 1;
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
     * heigth
     *
     * @param node
     * @param i
     * Esté método se encarga de encontrar la altura de un determinado nodo
     *
     */
    private void heigth(TreeNode<T> node, int i) {
        if (node != null) {
            heigth(node.getLeft(), i + 1);
            cont = i > cont ? i : cont;
            heigth(node.getRight(), i + 1);
        }
    }

    /**
     * Height tree.
     *
     * @return the int
     */
    public int heigthTree() {
        return heightNode(root);
    }

    /**
     * getGradeNode
     *
     * @param node the node
     * Este método devuelve un entero con el grado del nodo
     * @return int grade
     */
    public int getGradeNode(TreeNode<T> node) {
        if (node.getRight() != null && node.getLeft() != null)
            return 2;
        else if (node.getRight() != null || node.getLeft() != null)
            return 1;
        else
            return 0;
    }

    /**
     * Update height.
     * Este método actualiza la altura del nodo
     * @param node the node
     */
    private void updateHeight(TreeNode<T> node) {
        node.setHeight(1 + Math.max(heightNode(node.getLeft()), heightNode(node.getRight())));
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
     * deleteNode.
     * @param node the node
     *
     * @return
     */
    public T deleteNode(TreeNode<T> node) {
        switch (getGradeNode(node)) {
            case 0:
                return deleteLeaf(node);
            case 1:
                return deleteWithSon(node);

            default:
                return deleteWithSons(node);
        }
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
     * Delete.
     *
     * @param node the node
     * @param info the info
     * @return the tree node
     */
    private TreeNode<T> delete(TreeNode<T> node, T info) {
        if ((node == null)) {
            return node;
        } else if (comparator.compare((T) node.getInfo(), (T) info) > 0) {
            node.setLeft(delete(node.getLeft(), info));
        } else if (comparator.compare((T) node.getInfo(), (T) info) < 0) {
            node.setRight(delete(node.getRight(), info));
        } else if (node.getLeft() == null || node.getRight() == null) {
            node = (node.getLeft() == null) ? node.getRight() : node.getLeft();
        } else {
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
     * deleteWithSons
     * @param node
     * Este metodo se encarga de eliminar un nodo con sus respectivos hijos
     * @return out
     */
    private T deleteWithSons(TreeNode<T> node) {
        T out = node.getInfo();
        if (node == root) {
            root = root.getLeft() != null ? root.getLeft() : root.getRight();
        } else {
            TreeNode<T> father = findFather(node);
            if (father.getLeft() == node) {
                father.setLeft(node.getLeft() != null ? node.getLeft() : node.getRight());
            } else {
                father.setRight(node.getLeft() != null ? node.getLeft() : node.getRight());
            }
        }
        return out;
    }

    /**
     * deleteWithSon.
     * @param node the node
     * Se encarga de eliminar el nodo con su hijo.
     * @return out
     */

    private T deleteWithSon(TreeNode<T> node) {
        T out = node.getInfo();
        if (node == root) {
            root = root.getLeft() != null ? root.getLeft() : root.getRight();
        } else {
            TreeNode<T> father = findFather(node);
            if (father.getLeft() == node) {
                father.setLeft(node.getLeft() != null ? node.getLeft() : node.getRight());
            } else {
                father.setRight(node.getLeft() != null ? node.getLeft() : node.getRight());
            }
        }
        return out;
    }

    /**
     * deleteLeaf.
     * @param node the node
     * Este método se encarga de borrar las hojas del árbol, para ello recibe como parámetro un nodo
     * @return out
     */

    private T deleteLeaf(TreeNode<T> node) {
        T out = node.getInfo();
        if (node == root) {
            root = null;
        } else {
            TreeNode<T> father = findFather(node);
            if (father.getLeft() == node) {
                father.setLeft(null);
            } else {
                father.setRight(null);
            }
        }

        return out;
    }


    /**
     * WeightTree.
     * Este método retorna un entero referente al peso del árbol
    * @return weight
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
     * Gets the balance.
     *
     * @param node the node
     * @return the balance
     */
    public int getBalance(TreeNode<T> node) {
        return (node == null) ? 0 : heightNode(node.getRight()) - heightNode(node.getLeft());
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
}
