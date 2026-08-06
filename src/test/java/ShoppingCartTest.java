import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import e8_2.ShoppingCart;
public class ShoppingCartTest {

    @Test
    void testAddItem() {
        ShoppingCart cart = new ShoppingCart();
        cart.addItem("Apple", 1.0);
        cart.addItem("Banana", 0.5);
        assertEquals(2, cart.getItemCount());
    }

    @Test
    void testRemoveItem() {
        ShoppingCart cart = new ShoppingCart();
        cart.addItem("Apple", 1.0);
        cart.addItem("Banana", 0.5);
        cart.removeItem("Apple");
        assertEquals(1, cart.getItemCount());
    }

    @Test
    void testCalculateTotal() {
        ShoppingCart cart = new ShoppingCart();
        cart.addItem("Apple", 1.0);
        cart.addItem("Banana", 0.5);
        cart.addItem("Orange", 0.75);
        assertEquals(2.25, cart.calculateTotal(), 0.01);
    }
}
