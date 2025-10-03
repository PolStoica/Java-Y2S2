package isp.lab5.exercise1;
import java.time.LocalDate;
import java.util.UUID;

public class Order extends Product {
    private Costumer costumer;
    private Product[] products= new Product[10];

    private String orderId;
    private LocalDate Date;
    private Double totalPrice;

    public Order(){
        this.costumer = new Costumer();
        this.products= new Product[10];
        this.orderId= UUID.randomUUID().toString();
        this.Date= LocalDate.now();
        this.totalPrice= 0.0;
    }
    public Order(Costumer costumer, Product[] products, String orderId, LocalDate Date, double totalPrice){
        this.products= products;
        this.costumer= costumer;
        this.orderId= orderId;
        this.Date= Date;
        this.totalPrice= totalPrice;
    }
}