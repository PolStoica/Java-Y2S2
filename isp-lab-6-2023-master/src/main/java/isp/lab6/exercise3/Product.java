package isp.lab6.exercise3;

import java.util.Objects;

public class Product {
    public String name;
    public int price;
    public int quantity;

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Product(String name, int price,int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean equals(Object product) {
        if (product instanceof Product) {
            return true;
        }else{
            return false;
        }
    }

    @Override
    public int hashCode(){
        return Objects.hash(name + price);
    }
}