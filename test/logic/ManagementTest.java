package logic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ManagementTest {
    CircleLinkedList<Product> list;
    BinaryTree<Product> bts;
    Management mng;

    void setup(){

        Product product = new Product(12L,"1",200,"nokia",2);
        Product product1 = new Product(21L,"2",300,"asus",1);
        Product product2 = new Product(44L,"3",400,"ouashf",9);
        Product product3 = new Product(55L,"4",500,"Paris",2);
        Product product4 = new Product(66L,"5",700,"Nivea",3);
        Product product5 = new Product(77L,"6",111,"Bayer",5);
        Product product6 = new Product(88L,"7",490,"Vic",9);
        Product product7 = new Product(99L,"8",340,"Big",11);
        Product product8 = new Product(11L,"9",225,"Loreal",0);
        Product product9 = new Product(13L,"10",963,"Vuiton",3);
        Product product10 = new Product(15L,"11",176,"Caprica",9);
        Product product11 = new Product(1l, "Biotina Gomas", 50_000, "EPA colombia", 115);
        Product product12 = new Product(23l, "Biotina Moradas", 50_000, "EPA colombia", 110);
        Product product13 = new Product(34l, "Iluminador", 15_000, "EPA colombia", 2);
        Product product14 = new Product(45l, "Acondicionador verde", 50_000, "EPA colombia", 34);
        Product product15 = new Product(56l, "Shampoo Verde", 50_000, "EPA colombia", 3);
        Product product16 = new Product(67l, "Termoprotector", 50_000, "EPA colombia", 5);
        Product product17 = new Product(78l, "Shampoo Morado", 50_000, "EPA colombia", 12);
        Product product18= new Product(89l, "Iluminador Corporal", 25_000, "VIDAN", 4);

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
        bts.addNode((product11));
        bts.addNode((product12));
        bts.addNode((product13));
        bts.addNode((product14));
        bts.addNode((product15));
        bts.addNode((product16));
        bts.addNode((product17));
        bts.addNode((product18));
    }

    @Test
    void addProduct() {
        setup();
        bts.addNode(new Product(97L,"",0.0,"",0));
        bts.addNode(new Product(96L,"",0.0,"",0));
        assertEquals(21, bts.weightTree());
        assertEquals(4, bts.heightTree());
        bts.addNode(new Product(94L,"",0.0,"",0));
        bts.addNode(new Product(95L,"",0.0,"",0));
        assertEquals(23, bts.weightTree());
        assertEquals(4, bts.heightTree());
    }

    @Test
    void removeProduct() {
        setup();
        bts.deleteNode(new Product(89l, "", 0.0, "", 0));
        assertEquals(18, bts.weightTree());
        bts.deleteNode(new Product(1l, "", 0.0, "", 0));
        assertEquals(17, bts.weightTree());
        assertEquals(4, bts.heightTree());
        bts.addNode(new Product(14l, "", 0.0, "", 0));
        bts.addNode(new Product(90l, "", 0.0, "", 0));
        assertEquals(19, bts.weightTree());
        assertEquals(4, bts.heightTree());
        bts.addNode(new Product(8l, "", 0.0, "", 0));
        bts.addNode(new Product(9l, "", 0.0, "", 0));
        assertEquals(21, bts.weightTree());
        assertEquals(5, bts.heightTree());
        bts.deleteNode(new Product(14L,"",0.0,"",0));
        assertEquals(20, bts.weightTree());
        assertEquals(4, bts.heightTree());
    }

    @Test
    void seeProducts() {
        setup();
        for (Product aux : bts.listAmplitude()){
            System.out.println(aux);
        }
    }
}