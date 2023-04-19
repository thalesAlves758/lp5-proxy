import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ProductProxyTest {
    @Test
    void shouldReturnProductName() {
        User user = new User("Admin", true);
        IProduct product = new ProductProxy("Camisa", 29f, "Shein", user);

        assertEquals("Camisa", product.getName());
    }

    @Test
    void shouldSetProductName() {
        User user = new User("Admin", true);
        IProduct product = new ProductProxy("Camisa", 29f, "Shein", user);

        product.setName("Calça");

        assertEquals("Calça", product.getName());
    }

    @Test
    void shouldNotSetProductName() {
        try {
            User user = new User("Admin", false);
            IProduct product = new ProductProxy("Camisa", 29f, "Shein", user);

            product.setName("Calça");
            fail();
        } catch (UnsupportedOperationException e) {
            assertEquals("Only adm users can set an attribute in Product", e.getMessage());
        }
    }

    @Test
    void shouldReturnProductPrice() {
        User user = new User("Admin", true);
        IProduct product = new ProductProxy("Camisa", 29f, "Shein", user);

        assertEquals(29f, product.getPrice());
    }

    @Test
    void shouldSetProductPrice() {
        User user = new User("Admin", true);
        IProduct product = new ProductProxy("Camisa", 29f, "Shein", user);

        product.setPrice(39f);

        assertEquals(39f, product.getPrice());
    }

    @Test
    void shouldNotSetProductPrice() {
        try {
            User user = new User("Admin", false);
            IProduct product = new ProductProxy("Camisa", 29f, "Shein", user);

            product.setPrice(39f);
            fail();
        } catch (UnsupportedOperationException e) {
            assertEquals("Only adm users can set an attribute in Product", e.getMessage());
        }
    }

    @Test
    void shouldReturnProductProvider() {
        User user = new User("Admin", true);
        IProduct product = new ProductProxy("Camisa", 29f, "Shein", user);

        assertEquals("Shein", product.getProvider().getName());
    }

    @Test
    void shouldSetProductProvider() {
        User user = new User("Admin", true);
        IProduct product = new ProductProxy("Camisa", 29f, "Shein", user);

        product.setProvider(new Provider("Shein"));

        assertEquals("Shein", product.getProvider().getName());
    }

    @Test
    void shouldNotSetProductProvider() {
        try {
            User user = new User("Admin", false);
            IProduct product = new ProductProxy("Camisa", 29f, "Shein", user);

            product.setProvider(new Provider("Shein"));
            fail();
        } catch (UnsupportedOperationException e) {
            assertEquals("Only adm users can set an attribute in Product", e.getMessage());
        }
    }
}
