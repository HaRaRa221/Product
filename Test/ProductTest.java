import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {
    Product p1, p2, p3, p4, p5, p6;


    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        p1 = new Product("00000A", "Gas", "Made of fossil fuel", 74.45);
        p2 = new Product("00000B", "Silk", "Made from insect larvae", 15.00);
        Product.setIDseed(0);
        p3 = new Product("Toyota", "Bought on Ebay", 4000.00);
        p4 = new Product("Shirt", "Bought from Amazon", 10.00);

    }

    @org.junit.jupiter.api.Test
    void getIDseed() {
        assertEquals(2, Product.getIDseed());
    }

    @org.junit.jupiter.api.Test
    void getName() {
        assertEquals("Gas", p1.getpName());
    }

    @org.junit.jupiter.api.Test
    void setpName() {
        p1.setpName("Silk");
        assertEquals("Silk", p1.getpName());
    }

    @org.junit.jupiter.api.Test
    void getDescription() {
        assertEquals("Made of fossil fuel", p1.getDescription());
    }

    @org.junit.jupiter.api.Test
    void setDescription() {
        p1.setDescription("Made from insect larvae");
        assertEquals("Made from insect larvae", p1.getDescription());
    }

    @org.junit.jupiter.api.Test
    void getID() {
        assertEquals("00000A", p1.getID());
    }



    @org.junit.jupiter.api.Test
    void setId() {
        p1.setId("00000B");
        assertEquals("00000B", p1.getID());
    }

    @org.junit.jupiter.api.Test
    void getCost() {
        assertEquals(74.45, p1.getCost());
    }

    @org.junit.jupiter.api.Test
    void setCost() {
        p1.setCost(15.00);
        assertEquals(15.00, p1.getCost());
    }


    @org.junit.jupiter.api.Test
    void testEquals() {
        p1.setId("00000B");
        p1.setpName("Silk");
        p1.setDescription("Made from insect larvae");
    }
}