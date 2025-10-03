package isp.lab6.exercise3;

import java.util.Map;

public class ActiveSession {
    private String username;
    private Map<Product,Integer> shoppingCart;

    public ActiveSession(Map<Product, Integer> shoppingCart, String username) {
        this.shoppingCart = shoppingCart;
        this.username = username;
    }

    public ActiveSession() {
        this.username = null;
        this.shoppingCart = null;
    }

    public ActiveSession(String username) {
        this.username = username;
        this.shoppingCart = null;
    }

    public String getUsername() {
        return username;
    }

    public Map<Product, Integer> getShoppingCart() {
        return shoppingCart;
    }

    public void addToCart(Product product, int quantity){
        if (product.getQuantity() > quantity){
            throw new IllegalArgumentException("Not enough quantity for the purchase of " + product);
        }else {
            shoppingCart.put(product,quantity);
            System.out.println(product+" added to shopping cart ");
        }
    }

    public String listCart(){
        int total = 0;
        for (Map.Entry<Product, Integer> entry : shoppingCart.entrySet()) {
            Product product = entry.getKey();
            int quantity = entry.getValue();
            int itemTotal = product.getPrice() * quantity;
             total += itemTotal;
        }
        return String.valueOf(total);
    }
}
