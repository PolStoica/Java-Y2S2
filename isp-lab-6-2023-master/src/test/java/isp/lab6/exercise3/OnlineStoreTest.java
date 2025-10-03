package isp.lab6.exercise3;

import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class OnlineStoreTest extends TestCase {

    public void testGetProductsSorted() {
        Product p1 = new Product("Mouse", 500,2);
        Product p2 = new Product("Keyboard", 10, 10);
        List<Product> products = Arrays.asList(p1, p2);
        OnlineStore store = new OnlineStore();
        store.setProducts(products);
        List<Product> sorted = store.getProductsSorted(Comparator.comparing(Product::getPrice));

        assertEquals(p2, sorted.get(0));
        assertEquals(p1, sorted.get(1));
    }

    public void testAddToCart() {
        OnlineStore store = new OnlineStore();
        Product p1 = new Product("Mouse", 500,2);
        Product p2 = new Product("Keyboard", 10, 10);
        List<Product> products = Arrays.asList(p1, p2);
        store.setProducts(products);

        store.publicSession("Pol");
        store.addToCart("Pol" ,p1,2);


       // assertEquals(p1, cart.get(0));
    }

    public void testCheckout() {
        OnlineStore store = new OnlineStore();
        Product p1 = new Product("Mouse", 500,2);
        store.setProducts(Arrays.asList(p1));

        store.publicSession("Ana");
        store.addToCart("Ana", p1, 1);

        String receipt = store.checkout("Ana");
        System.out.println(receipt);

    }
}