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

    void setup(){
        Product product = new Product(12L,"1",200,"nokia",2);
        Product product1 = new Product(21L,"2",300,"asus",1);
        Product product2 = new Product(44L,"3",400,"ouashf",9);
        Product product3 = new Product(55L,"4",500,"ñññ",7);
        Product product4 = new Product(66L,"5",500,"ñññ",7);
        Product product5 = new Product(77L,"6",500,"ñññ",7);
        Product product6 = new Product(88L,"7",500,"ñññ",7);
        Product product7 = new Product(99L,"8",500,"ñññ",7);
        Product product8 = new Product(11L,"9",500,"ñññ",7);
        Product product9 = new Product(13L,"10",500,"ñññ",7);
        Product product10 = new Product(15L,"11",500,"ñññ",7);
        bts = new BinaryTree<Product>(Product.compareHash);
        bts.addNode((product));
        bts.addNode((product1));
        bts.addNode((product2));
        bts.addNode((product3));
        bts.addNode((product4));
        bts.addNode((product5));
        bts.addNode((product6));
        bts.addNode((product7));
        bts.addNode((product8));
        bts.addNode((product9));
        bts.addNode((product10));
    }

    @Test
    void isEmpty() {
        setup2();
        assertNotNull(bts.findNode(new Product(1234l, "", 0.0, "", 0)));
        assertNull(bts.findNode(new Product(23l, "", 0.0, "", 0)));
        assertNotNull(bts.findNode(new Product(2345l, "", 0.0, "", 0)));
        assertNotNull(bts.findNode(new Product(3456l, "", 0.0, "", 0)));
        assertNotNull(bts.findNode(new Product(4567l, "", 0.0, "", 0)));
    }

    @Test
    void findNode() {
        setup2();
        assertNotNull(bts.findNode(new Product(1234l, "", 0.0, "", 0)));
        assertNotNull(bts.findNode(new Product(2345l, "", 0.0, "", 0)));
        assertNotNull(bts.findNode(new Product(4567l, "", 0.0, "", 0)));
        assertEquals(8901l, bts.findNode(new Product(8901l, "", 0.0, "", 0)).getInfo().getId());
        assertNull(bts.findNode(new Product(23l, "", 0.0, "", 0)));
    }

    @Test
    void listPresort() {
        setup();
        assertEquals(55L,bts.listPresort().get(0).getId());
        assertEquals(13L,bts.listPresort().get(1).getId());
        assertEquals(12L,bts.listPresort().get(2).getId());
        assertEquals(11L,bts.listPresort().get(3).getId());
        assertEquals(21L,bts.listPresort().get(4).getId());
        assertEquals(15L,bts.listPresort().get(5).getId());
        assertEquals(44L,bts.listPresort().get(6).getId());
        assertEquals(77L,bts.listPresort().get(7).getId());
        assertEquals(66L,bts.listPresort().get(8).getId());
        assertEquals(88L,bts.listPresort().get(9).getId());
        assertEquals(99L,bts.listPresort().get(10).getId());

    }

    @Test
    void listInsort() {
        setup();
        assertEquals(11L,bts.listInsort().get(0).getId());
        assertEquals(12L,bts.listInsort().get(1).getId());
        assertEquals(13L,bts.listInsort().get(2).getId());
        assertEquals(15L,bts.listInsort().get(3).getId());
        assertEquals(21L,bts.listInsort().get(4).getId());
        assertEquals(44L,bts.listInsort().get(5).getId());
        assertEquals(55L,bts.listInsort().get(6).getId());
        assertEquals(66L,bts.listInsort().get(7).getId());
        assertEquals(77L,bts.listInsort().get(8).getId());
        assertEquals(88L,bts.listInsort().get(9).getId());
        assertEquals(99L,bts.listInsort().get(10).getId());
    }

    @Test
    void listPosort() {
        setup();
        assertEquals(11L,bts.listPosort().get(0).getId());
        assertEquals(12L,bts.listPosort().get(1).getId());
        assertEquals(15L,bts.listPosort().get(2).getId());
        assertEquals(44L,bts.listPosort().get(3).getId());
        assertEquals(21L,bts.listPosort().get(4).getId());
        assertEquals(13L,bts.listPosort().get(5).getId());
        assertEquals(66L,bts.listPosort().get(6).getId());
        assertEquals(99L,bts.listPosort().get(7).getId());
        assertEquals(88L,bts.listPosort().get(8).getId());
        assertEquals(77L,bts.listPosort().get(9).getId());
        assertEquals(55L,bts.listPosort().get(10).getId());
    }

    @Test
    void listAmplitude() {
        setup();
        for (Product aux : bts.listAmplitude()){
            System.out.println(aux);
        }
    }

    @Test
    void isLeaf() {
     setup();
     assertTrue(bts.isLeaf(bts.findNode(new Product(11L,"",0.0,"",0))));
     assertTrue(bts.isLeaf(bts.findNode(new Product(15L,"",0.0,"",0))));
     assertTrue(bts.isLeaf(bts.findNode(new Product(44L,"",0.0,"",0))));
     assertTrue(bts.isLeaf(bts.findNode(new Product(66L,"",0.0,"",0))));
     assertTrue(bts.isLeaf(bts.findNode(new Product(99L,"",0.0,"",0))));
    }
    @Test
    void weightTree() {
    }

    @Test
    void heigthTree() {
    }

    @Test
    void deleteNode() {
    }
}