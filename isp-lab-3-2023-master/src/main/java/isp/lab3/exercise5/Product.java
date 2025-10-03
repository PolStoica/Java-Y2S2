package isp.lab3.exercise5;

public class Product {
    String name;
    int id;
    int price;
    int quantity;

    public  Product(String name,int id,int price,int quantity){
        this.name = name;
        this.id = id;
        this.price = price;
        this.quantity = quantity;
    }
    public String getName() {
        return name;
    }
    public int getId() {
        return id;
    }
    public int getPrice() {
        return price;
   }
    public int getQuantity() {
        return quantity;
   }
    public void sold(){
        if (quantity > 0){
        this.quantity--;
        }else {
            throw new IllegalArgumentException("We are out of stock!");
        }
    }

}