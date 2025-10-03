package isp.lab6.exercise3;

import java.util.*;

public class OnlineStore {
    private List<Product> products;
    private Map<ActiveSession,Integer> sessions;

    public OnlineStore(List<Product> products, Map<ActiveSession, Integer> sessions) {
        this.products = products;
        this.sessions = sessions;
    }
    public OnlineStore() {
        this.products = new ArrayList<Product>();
        this.sessions = new HashMap<ActiveSession, Integer>();
    }
    public void setProducts(List<Product> products) {
        this.products = products;
    }
    public Map<ActiveSession, Integer> getSessions() {
        return sessions;
    }
    public void setSessions(Map<ActiveSession, Integer> sessions) {
        this.sessions = sessions;
    }
    public List<Product> getProducts() {
        return products;
    }

    public List<Product> getProductsSorted(Comparator<Product> sortCriteria ) {
        List<Product> sortedProducts = new ArrayList<>(this.products); /* deep copy, not shallow as : this.products; */
        sortedProducts.sort(sortCriteria);
        return sortedProducts;
    }

    private void addSession(String username) {
        for (ActiveSession session : sessions.keySet()) {
            if (session.getUsername().equals(username)) {
                System.out.println("Session already exists");
                return;
            }
        }
        ActiveSession newSession = new ActiveSession(username);
        sessions.put(newSession, 1);
        System.out.println("Session created for " + username);
    }

    public void publicSession(String username) {
        addSession(username);
    }

    private void removeSession(String username){
        ActiveSession sessionToRemove = null;
        for (ActiveSession session : sessions.keySet()) {
            if (session.getUsername().equals(username)) {
                sessionToRemove = session;
                break;
            }
        }
        if (sessionToRemove == null) {
            System.out.println("No active session found for " + username);
        } else {
            sessions.remove(sessionToRemove);
            System.out.println("Session removed for " + username);
        }
    }

    public void addToCart(String username, Product product, int quantity) {
        ActiveSession session = null;
        for (ActiveSession s : sessions.keySet()) {
            if (s.getUsername().equals(username)) {
                session = s;
                break;
            }
        }
        if (session == null) {
            throw new IllegalArgumentException("The user does not exist");
        }
        if (product.getQuantity() < quantity && product.getQuantity() > 0) {
            System.out.println("Product does not have enough stock to fulfill the order. The quantity is only:" + product.getQuantity());
            return;
        }else{
            System.out.println("Out of stock");
        }
        session.addToCart(product, quantity);
        product.setQuantity(product.getQuantity() - quantity);
        System.out.println( String.valueOf(quantity) +product  +"added to cart");
    }

    public String checkout(String username) {
        ActiveSession session = null;
        for (ActiveSession s : sessions.keySet()) {
            if (s.getUsername().equals(username)) {
                session = s;
                break;
            }
        }
        if (session == null) {
            return "The user does not exist";
        }

        Map<Product,Integer> cart= session.getShoppingCart();
        if (cart == null || cart.isEmpty()) {
            return "The shopping cart is empty";
        }

        return session.listCart();
    }

}