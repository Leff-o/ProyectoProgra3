package logic;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeTest {
    private BinaryTree<Product> bts;

    void setup2(){
        Product product = new Product(1234l, "Biotina Gomas", 50_000, "EPA colombia", 115);
        Product product1 = new Product(2345l, "Biotina Moradas", 50_000, "EPA colombia", 110);
        Product product2 = new Product(3456l, "Iluminador", 15_000, "EPA colombia", 2);
        Product product3 = new Product(4567l, "Acondicionador verde", 50_000, "EPA colombia", 34);
        Product product4 = new Product(5678l, "Shampoo Verde", 50_000, "EPA colombia", 3);
        Product product5 = new Product(6789l, "Termoprotector", 50_000, "EPA colombia", 5);
        Product product6 = new Product(7890l, "Shampoo Morado", 50_000, "EPA colombia", 12);
        Product product7 = new Product(8901l, "Iluminador Corporal", 25_000, "VIDAN", 4);
        bts = new BinaryTree<Product>(Product.compareHash);
        bts.addNode(product);
        bts.addNode(product1);
        bts.addNode(product2);
        bts.addNode(product3);
        bts.addNode(product4);
        bts.addNode(product5);
        bts.addNode(product6);
        bts.addNode(product7);
    }


    @Test
    void isEmpty() {
        setup2();
        assertTrue(true, bts.findNode(1234l));
    }

    @Test
    void getRoot() {
    }

    @Test
    void findNode() {
    }

    @Test
    void listPresort() {
    }

    @Test
    void listInsort() {
    }

    @Test
    void listPosort() {
    }

    @Test
    void listAmplitude() {
    }

    @Test
    void isLeaf() {
    }
    @Test
    void weightTree() {
    }

    @Test
    void getBalance() {
    }

    @Test
    void findFather() {
    }

    @Test
    void levelNode() {
        //assertEquals();
    }

    @Test
    void heigthTree() {
    }

    @Test
    void getGradeNode() {
    }

    @Test
    void deleteNode() {
    }

    @Test
    void testDeleteNode() {
    }
}