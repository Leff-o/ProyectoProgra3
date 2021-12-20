package logic;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class BinaryTreeTest {

   private BinaryTree<Product> bts;

    void setup(){
        Product product = new Product(123L,"asifuasfn",200,"nokia",2);
        bts = new BinaryTree<Product>(Product.compareHash);
        bts.addNode((product));
    }

    @Test
    void isEmpty() {
        setup();
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
}