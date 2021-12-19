package logic;


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Comparator;
/*
+ Peso del árbol
+Número de nodos
* Altura del nodo
* Número de enlaces en el camino más largo.
* Entre ese nodo y una hoja descendente.
+ Nivel de un nodo
+ Distancia del nodo hasta la raiz.
* Altura o profundidad del arbol
* Nivel de la hoja del camino más largo
+ Grado de un Nodo
+ Numero de hijos de un nodo
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

    public ArrayList<T> listPresort() {
        out = new ArrayList<>();
        presort(root);

        return out;
    }

    private void presort(TreeNode<T> root) {
        if (root != null) {
            out.add(root.getInfo());
            presort(root.getLeft());
            presort(root.getRight());
        }
    }

    public ArrayList<T> listInsort() {
        out = new ArrayList<>();
        insort(root);

        return out;
    }

    private void insort(TreeNode<T> root) {
        if (root != null) {
            insort(root.getLeft());
            out.add(root.getInfo());
            insort(root.getRight());
        }
    }

    //+ listPosort()

    public ArrayList<T> listPosort() {
        out = new ArrayList<>();
        posort(root);

        return out;
    }

    private void posort(TreeNode<T> root) {
        if (root != null) {
            posort(root.getLeft());
            posort(root.getRight());
            out.add(root.getInfo());
        }
    }

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

    public boolean isLeaf(TreeNode<T> node) {
        return node.getRight() == null && node.getLeft() == null;
    }

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
     *
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

    private T deleteWithSons2(TreeNode<T> node) {
        T out = node.getInfo();
        TreeNode<T> sustitute = node.getRight();
        TreeNode<T> fatherSustitute = null;
        while (sustitute.getLeft() != null) {
            fatherSustitute = sustitute;
            sustitute = sustitute.getLeft();
        }
        if (fatherSustitute != null) {
            fatherSustitute.setLeft(node.getRight());
            sustitute.setRight(node.getRight());
        }
        sustitute.setLeft(node.getLeft());

        //+Buscar padre del nodo o Eliminar
        TreeNode<T> father = findFather(node);
        if (father == null) {
            root = sustitute;
        } else if (father.getLeft() == node) {
            father.setLeft(sustitute);
        } else {
            father.setRight(sustitute);
        }
        return out;
    }

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
